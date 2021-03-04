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

public class ReadXLS {
    public static void main(String[] args) {
        String path = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            path = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(connectionExcel(path, 3));
    }

    private static Person connectionExcel(String path, Integer id) {
        Person person = null;
        if (path != null) {
            try (OPCPackage pkg = OPCPackage.open(new File(path));
                 XSSFWorkbook workbook = new XSSFWorkbook(pkg);) {
                for (Sheet sheet : workbook) {
                    if (sheet.getRow(id) != null) {
                        Row row = sheet.getRow(id);
                        person = new Person(id, row.getCell(0).toString(), row.getCell(1).toString()); }
                    else {
                        System.out.println("Id no such");
                        System.exit(1);
                    }
                }
            } catch (InvalidFormatException | IOException in) {
                in.printStackTrace();
            }
        }
        else {
            System.out.println("No path");
            System.exit(1);
        }
        return person;
    }
}
