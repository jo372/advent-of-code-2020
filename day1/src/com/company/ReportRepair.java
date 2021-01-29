package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportRepair {
    private static List<Integer> inputData = new ArrayList<>();
    public static void partOne() {
        int value1, value2;
        for(int i=0; i < inputData.size(); i++) {
            value1 = inputData.get(i);
            for(int i2=i+1; i2 < inputData.size(); i2++) {
                value2 = inputData.get(i2);
                if(2020 - value1 - value2 == 0) {
                    System.out.printf("Part One: %d * %d = %d\n", value1, value2, value1 * value2);
                }
            }
        }
    }
    public static void partTwo() {
        int value1, value2, value3;
        for(int i=0; i < inputData.size(); i++) {
            value1 = inputData.get(i);
            for(int i2=i+1; i2 < inputData.size(); i2++) {
                value2 = inputData.get(i2);
                for(int i3=i2+1; i3 < inputData.size(); i3++) {
                    value3 = inputData.get(i3);
                    if(2020 - value1 - value2 - value3 == 0) {
                        System.out.printf("Part Two: %d * %d * %d = %d\n", value1, value2, value3, value1 * value2 * value3);
                    }
                }
            }
        }
    }
    
    public static void loadData() {
        try {
            File file = new File("data/input.txt");
            Scanner fileReader = new Scanner(file);
            int number;
            while(fileReader.hasNextLine()) {
                number = Integer.valueOf(fileReader.nextLine());
                inputData.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
	    loadData();
	    // data has loaded when the inputData size is greater than zero.
	    if(inputData.size() > 0) {
            partOne();
            partTwo();
        }
    }
}
