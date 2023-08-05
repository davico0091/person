package com.example.user.util;

import java.util.HashMap;

public class Constants {

    public static final String SHEET_SOLES = "Tasas-Soles";
    public static final String SHEET_DOLARES = "Tasas-Dolares";
    public static final String SHEET_DATA = "Datos";
    public static final HashMap<String, String> CELL_REFERENCE_RATES_SOLES = new HashMap<>();
    public static final HashMap<String, String> CELL_REFERENCE_RATES_DOLARES = new HashMap<>();
    public static final int TYPE_TERM = 1;
    public static final HashMap<String, String> RANGE_SOLES = new HashMap<>();
    public static final HashMap<String, String> RANGE_DOLARES = new HashMap<>();
    public static final HashMap<String, String> SEGMENT_CODES = new HashMap<>();
    public static final String SEGMEMT_DESCRIPTION= "Se agrega el grupo Gremio para ofrecer mejor tasa";
    public static final String CURRENCY_CODE = "0001";
    public static final String CURRENCY_DESCRIPTION_SOLES = "PEN";
    public static final String CURRENCY_DESCRIPTION_DOLARES = "USD";


    static {
        CELL_REFERENCE_RATES_SOLES.put("SEG1-90","E24");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-120","E25");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-180","E26");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-270","E27");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-360","E28");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-545","E29");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-720","E30");
        CELL_REFERENCE_RATES_SOLES.put("SEG1-999","E31");

        CELL_REFERENCE_RATES_SOLES.put("SEG2-90","E39");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-120","E40");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-180","E41");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-270","E42");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-360","E43");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-545","E44");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-720","E45");
        CELL_REFERENCE_RATES_SOLES.put("SEG2-999","E46");

        CELL_REFERENCE_RATES_SOLES.put("SEG3-90","E9");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-120","E10");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-180","E11");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-270","E12");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-360","E13");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-545","E14");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-720","E15");
        CELL_REFERENCE_RATES_SOLES.put("SEG3-999","E16");

        CELL_REFERENCE_RATES_SOLES.put("SEG4-90","E54");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-120","E55");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-180","E56");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-270","E57");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-360","E58");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-545","E59");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-720","E60");
        CELL_REFERENCE_RATES_SOLES.put("SEG4-999","E61");
    }

    static {
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-30","E24");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-60","E25");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-90","E26");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-120","E27");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-180","E28");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-270","E29");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-360","E30");
        CELL_REFERENCE_RATES_DOLARES.put("SEG1-545","E31");

        CELL_REFERENCE_RATES_DOLARES.put("SEG2-30","E39");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-60","E40");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-90","E41");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-120","E42");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-180","E43");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-270","E44");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-360","E45");
        CELL_REFERENCE_RATES_DOLARES.put("SEG2-545","E46");

        CELL_REFERENCE_RATES_DOLARES.put("SEG3-30","E9");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-60","E10");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-90","E11");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-120","E12");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-180","E13");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-270","E14");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-360","E15");
        CELL_REFERENCE_RATES_DOLARES.put("SEG3-545","E16");

        CELL_REFERENCE_RATES_DOLARES.put("SEG4-30","E54");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-60","E55");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-90","E56");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-120","E57");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-180","E58");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-270","E59");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-360","E60");
        CELL_REFERENCE_RATES_DOLARES.put("SEG4-545","E61");

    }

    static {
        RANGE_SOLES.put("PEN1","500,9999.99");
        RANGE_SOLES.put("PEN2","10000,99999.99");
        RANGE_SOLES.put("PEN3","100000,249999.99");
        RANGE_SOLES.put("PEN4","250000,49999.99");
        RANGE_SOLES.put("PEN5","500000,999999.99");
        RANGE_SOLES.put("PEN6","1000000,1000000");
    }
    static {
        RANGE_DOLARES.put("USD1","500,19999.99");
        RANGE_DOLARES.put("USD2","20000,49999.99");
        RANGE_DOLARES.put("USD3","50000,1000000.00");
    }


    static {
        SEGMENT_CODES.put("SEG1","93-94");
        SEGMENT_CODES.put("SEG2","79-80");
        SEGMENT_CODES.put("SEG3","75-76-61-62");
        SEGMENT_CODES.put("SEG4","");
    }
}
