package ru.enai.taskone;

/*
Программа запускается с аргументом коммандной строки.
Аргумент должен быть путем к файлу где содержится текст.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class UniqWordsCount {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(wordsCount(args[0]));
        } else {
            System.exit(1);
        }
    }

    private static String wordsCount(String arg) {
        Set<String> list = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arg));) {

            while (reader.ready()) {
                String fileIn = reader.readLine();
                String[] arrString = fileIn.replaceAll("\\p{Punct}", "")
                        .split("\\s+");
                list.addAll(Arrays.asList(arrString));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "В строке: " + list.size() + " уникальных слов. Слова: " + list;
    }
}