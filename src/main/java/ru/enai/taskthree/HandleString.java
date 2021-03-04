package ru.enai.taskthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandleString {
    public static void main(String[] args) throws IOException {
        String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println(handleString(line));

    }

    private static String handleString(String line) {
        return line.replace(" ", "");
    }
}
