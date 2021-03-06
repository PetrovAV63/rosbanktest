package ru.enai.taskfour;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Программа использует дополнительную зависимость для работы с excel, Apache POI.
Файл test.xls содержит данные о Person.
Класс Person описывает сущности.
 */

public class ReadXLS {
    private static String PATH = "/home/enai/IdeaProjects/rosbanktest/src/main/java/ru/enai/taskfour/test.xlsx";
    public static void main(String[] args) {
        Integer id = null;
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in)))
        {
            System.out.println("Введите id");
            id = Integer.parseInt(reader.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(connectionExcel(id));
    }

    private static Person connectionExcel(Integer id) {
        Person person = null;

            try (XSSFWorkbook workbook = new XSSFWorkbook(new File(PATH))) {
                for (Sheet sheet : workbook) {
                    if (sheet.getRow(id) != null) {
                        Row row = sheet.getRow(id);
                        person = new Person(id, row.getCell(0).toString(), row.getCell(1).toString());
                    } else {
                        System.out.println("Id no such");
                        System.exit(1);
                    }
                }
            } catch (IOException | InvalidFormatException in) {
                in.printStackTrace();
            }
        return person;
    }
}
