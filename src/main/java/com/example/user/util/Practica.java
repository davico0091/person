package com.example.user.util;

import java.util.List;
import java.util.stream.Collectors;

public class Practica {

    static List <Integer> integers = List.of(1,9,0,3,8,2);
    static List<String> stringList = List.of("Alba","Noel","Pablo","Alejandro");

    public static void main(String[] args) {
        /*integers.stream()
                .sorted()
                .forEach(System.out::println);*/
        List<String> sortedList =   stringList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }
}
