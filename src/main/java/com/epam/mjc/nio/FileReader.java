package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring("Name:".length()).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring("Age:".length()).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring("Email:".length()).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(line.substring("Phone:".length()).trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}


class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("C:\\Users\\GComp.ge\\Desktop\\stage1-module7-nio-task1\\src\\main\\resources\\Profile.txt");
        Profile profile = fileReader.getDataFromFile(file);
        System.out.println(profile);
    }
}