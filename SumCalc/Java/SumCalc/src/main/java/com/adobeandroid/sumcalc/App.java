package com.adobeandroid.sumcalc;

import java.util.*;
import java.lang.System;

public class App {
    public static void main(String[] args) {
        int i;
        long IntSum = 0;
        List<Integer> integerList = new ArrayList<>();
        for (i = 1; i < 100000000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                integerList.add(i);
            }
        }
        for (int integer : integerList) {
            IntSum += integer;
        }
        System.out.println(IntSum + "\n");
    }
}