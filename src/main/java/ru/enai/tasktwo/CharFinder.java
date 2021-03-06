package ru.enai.tasktwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Программа запускается в консольном режиме.
Ввод строки производится в консоль.
Вывод в консоль.
 */
public class CharFinder {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in))) {

            String line = reader.readLine();
            System.out.println(finderRepeatedChar(line));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String finderRepeatedChar(String line) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 0);
            }
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet())
            result.append("Chair: ")
                    .append("\"")
                    .append(pair.getKey())
                    .append("\"")
                    .append(" repeated: ")
                    .append(pair.getValue())
                    .append("\n");

        return result.toString();
    }
}
