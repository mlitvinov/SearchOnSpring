package com.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Data {
    private static int previous;
    private static final HashMap<String, String> map = new HashMap<>();

    private static BufferedReader openFile() {
        String filePath = Data.class.getResource("/Russia.txt").getPath();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        return reader;
    }

    public static void parseData() {
        BufferedReader reader = openFile();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 6);
                if (parts.length >= 2) {
                    String number = parts[0];
                    String id = parts[1];
                    String fullName = parts[2] + " " + parts[3];
                    map.put(id, number + ":" + fullName);
                    getPercent(map);
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
            System.out.println("Чтение файла завершено!");
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
    }

    public static Person findPersonData(Person greeting) {
        String log;
        String personData = map.get(greeting.getId());
        if (personData == null) {
            personData = "not found:not found";
            log = "not found";
        } else {
            log = "Id " + greeting.getId() + " Данные: " + personData;
        }
        System.out.println("Ищу номер...");
        System.out.println(log);
        Person person = splitData(personData, greeting);
        return person;
    }

    private static Person splitData(String personData, Person person) {

        String[] personInfo = personData.split(":", 2);
        String fullName = personInfo[1];
        String number = personInfo[0];
        person.setName(fullName);
        person.setId(person.getId());
        person.setNumber(number);
        return person;
    }

    private static void getPercent(HashMap<String, String> map) {
        int size = 9996405;
        int percent = (map.size() * 100) / size;
        if (percent != previous) {
            System.out.println(percent + "%");
        }
        previous = percent;
    }
}
