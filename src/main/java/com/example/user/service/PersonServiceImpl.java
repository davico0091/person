package com.example.user.service;

import com.example.user.entity.PersonEntity;
import com.example.user.mapper.PersonMapper;
import com.example.user.model.*;
import com.example.user.model.Currency;
import com.example.user.repository.PersonRepository;
import com.example.user.util.Constants;
import com.example.user.util.UtilMethods;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class PersonServiceImpl  implements PersonService{

    private PersonRepository personRepository;

    @Override
    public Mono<Person> savePerson(Person person) {
        PersonEntity personEntity = PersonMapper.mapToPersonEntity(person);
        Mono<PersonEntity> savedPerson = personRepository.save(personEntity);
        return savedPerson
                .map(_personEntity ->  PersonMapper.mapToPerson(_personEntity));
    }

    @Override
    public Flux<Person> getAllPersons() {
        Flux<PersonEntity> personFlux = personRepository.findAll();
        return personFlux
                .map(_personFlux -> PersonMapper.mapToPerson(_personFlux))
                .switchIfEmpty(Flux.empty());
    }
    @Override
    public Mono<Person> getPerson(String personId) {
        Mono<PersonEntity> personEntity = personRepository.findById(personId);
        return personEntity
                .map(_personEntity -> PersonMapper.mapToPerson(_personEntity));
    }

    @Override
    public Mono<Person> updatePerson(Person person) {
        PersonEntity personEntity = PersonMapper.mapToPersonEntity(person);
        return personRepository
                .save(personEntity)
                .map(updatedEntity -> PersonMapper.mapToPerson(updatedEntity));
    }

    @Override
    public Mono<String> readXls(DocumentXls document) {
        String value;
        Gson gson = new Gson();
        List<Term> terms= new ArrayList<>();
        InputStream fis = UtilMethods.getDocument(document.getBase64());

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            //get rates soles
            terms.addAll(getTerms(workbook, Constants.SHEET_SOLES,
                    Constants.CELL_REFERENCE_RATES_SOLES, Constants.CURRENCY_DESCRIPTION_SOLES));
            terms.addAll(getTerms(workbook, Constants.SHEET_DOLARES,
                    Constants.CELL_REFERENCE_RATES_DOLARES, Constants.CURRENCY_DESCRIPTION_DOLARES));

            log.info(gson.toJson(terms));

        } catch (Exception e) {
            log.error(e.getMessage());
        }


        return  Mono.just(gson.toJson(terms));
    }

    private List<Term> getTerms(XSSFWorkbook workbook, String sheetCurrency, HashMap<String, String> cellReferenceRates, String currencyDescription) {

        XSSFSheet sheet = workbook.getSheet(sheetCurrency);

        Iterator <Map.Entry<String, String>> iterator = cellReferenceRates.entrySet().iterator();
        List<Term> terms = new ArrayList<>();

        while (iterator.hasNext()){

            Map.Entry<String, String> entry = iterator.next();
            String segmentTerm = entry.getKey();
            String cellReferenceString = entry.getValue();

            CellReference cellReference = new CellReference(cellReferenceString);

            Row row = sheet.getRow(cellReference.getRow());

            int contador = 0;
            while(contador < getLimit(currencyDescription)){

                Cell column2 = row.getCell(cellReference.getCol()+contador);
                String segmentCode = segmentTerm.substring(0,4);
                String termDays = segmentTerm.substring(5,segmentTerm.length());
                contador++;
                String rangeCode = currencyDescription + contador;
                Term term = new Term();
                term.setId(UtilMethods.generateUUID());
                term.setIdTerm(rangeCode+"-"+segmentTerm);
                term.setIdTermType(Constants.TYPE_TERM);

                Segment segment = new Segment();
                segment.setIdSegmentTerm(segmentCode);
                segment.setSegment(getSegmentName(segmentCode));
                segment.setSegmentCode(getSegmentCode(segmentCode));
                segment.setDescription(Constants.SEGMEMT_DESCRIPTION);
                term.setSegment(segment);
                term.setTermDays(termDays);
                Range range = new Range();
                range.setIdRange(rangeCode);
                range.setCoin(1);
                Currency currency = new Currency();
                currency.setCode("0001");
                currency.setDescription(currencyDescription);
                range.setCurrency(currency);
                range.setMinimum(getMinimunOrMaximun(rangeCode,0));
                range.setMaximum(getMinimunOrMaximun(rangeCode,1));
                term.setRange(range);
                term.setRate(column2.getNumericCellValue());
                term.setPenalty(getPenalty(termDays));
                terms.add(term);
            }
        }
    return terms;
    }

    private int getLimit(String currencyDescription) {
        if(currencyDescription.equals(Constants.CURRENCY_DESCRIPTION_SOLES)){
            return Constants.RANGE_SOLES.size();
        }
        else {
            return Constants.RANGE_DOLARES.size();
        }
    }

    private String getPenalty(String termDays) {

        if(termDays.equals("30") || termDays.equals("60")){
            return "30";
        }
        else if(termDays.equals("90")){
            return "45";
        }
        else if(termDays.equals("120")||termDays.equals("180")||termDays.equals("270")||termDays.equals("360")){
            return "90";
        }
        else if(termDays.equals("545")||termDays.equals("720")||termDays.equals("999")){
            return "90";
        }
        else {
            return "";
        }
    }

    private double getMinimunOrMaximun(String rangeCode,int minMax) {

        String[] valor;
        if(rangeCode.contains(Constants.CURRENCY_DESCRIPTION_SOLES)){
            valor = Constants.RANGE_SOLES.get(rangeCode).split(",");
        }
        else {
            valor = Constants.RANGE_DOLARES.get(rangeCode).split(",");
        }

        return Double.parseDouble(valor[minMax]);
    }

    private String getSegmentCode(String key) {
        return Constants.SEGMENT_CODES.get(key);
    }

    private String getSegmentName(String substring) {
        switch (substring){
            case "SEG1":
                return "ENALTA";
            case "SEG2":
                return "EXCLUSIVA";
            case "SEG3":
                return "PRIVADA";
            default:
                return "OTROS";
        }
    }
}
