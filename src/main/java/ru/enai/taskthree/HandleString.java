package ru.enai.taskthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Программа запускается в консольном режиме, ввод и вывод в консоли =)
 */
public class HandleString {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in))) {
            String line = reader.readLine();
            String lineCorrect = line.replace(" ", "");
            System.out.println(lineCorrect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
