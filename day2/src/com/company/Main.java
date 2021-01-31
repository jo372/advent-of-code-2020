package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static List<String> policies = new ArrayList<>();
    
    public static boolean isValidPartOne(final String password, final String key, final int lowerBounds, final int higherBounds) {
        int occurrences = 0;
        String[] characters = password.split("");
        for(int i=0; i < characters.length; i++) {
            if(characters[i].equals(key)) {
                occurrences++;
            }
        }
        return occurrences >= lowerBounds && occurrences <= higherBounds;
    }
    public static boolean isValidPartTwo(final String password, final String key, int lowerBounds, int higherBounds) {
        int occurrences = 0;
        String[] characters = password.split("");
        lowerBounds -= 1;
        higherBounds -=1;
        for(int i=0; i < characters.length; i++) {
            if(i == lowerBounds || i == higherBounds) {
                if(characters[i].equals(key)) {
                    occurrences++;
                }
            }
        }
        return occurrences == 1;
    }
    public static void partOne() {
        int validPolicies = 0, lowerBounds, higherBounds;
        String key, password;
        String[] args;

        for(int i=0; i < policies.size(); i++) {
            args = policies.get(i).split(" ");
            lowerBounds = Integer.valueOf(args[0].split("-")[0]);
            higherBounds = Integer.valueOf(args[0].split("-")[1]);
            key = args[1].split(":")[0];
            password = args[2];
            if(isValidPartOne(password, key, lowerBounds, higherBounds)) {
                validPolicies++;
            }
        }
        System.out.printf("Part One: Valid Policies %d\n", validPolicies);
    }
    public static void partTwo() {
        int validPolicies = 0, lowerBounds, higherBounds;
        String key, password;
        String[] args;
    
        for(int i=0; i < policies.size(); i++) {
            args = policies.get(i).split(" ");
            lowerBounds = Integer.valueOf(args[0].split("-")[0]);
            higherBounds = Integer.valueOf(args[0].split("-")[1]);
            key = args[1].split(":")[0];
            password = args[2];
            if(isValidPartTwo(password, key, lowerBounds, higherBounds)) {
                validPolicies++;
            }
        }
        System.out.printf("Part Two: Valid Policies %d\n", validPolicies);
    }
    public static void loadData() {
        try {
            File file = new File("data/input.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                policies.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        loadData();
	    if(policies.size() > 0) {
	       partOne();
	       partTwo();
        }
    }
}
