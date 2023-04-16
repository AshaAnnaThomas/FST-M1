package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity15 {

    private static String FILE_NAME = "src/main/resources/TestSheet.xlsx";

    public static void main (String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");

        //create the data to insert into the sheet
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

//        Iterator<Row> rowIterator = sheet.iterator();
//        List<List<String>> data = new ArrayList<>();
//        while (rowIterator.hasNext()) {
//
//            List<String> rowData = new ArrayList<>();
//            Row row  = rowIterator.next();
//
//            //for each row, iterate thru all cells
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while(cellIterator.hasNext()) {
//
//                Cell cell = cellIterator.next();
//                if(cell.getCellType() == CellType.STRING){
//                    System.out.println(cell.getStringCellValue());
//                    rowData.add(cell.getStringCellValue());
//                } else if (cell.getCellType() == CellType.NUMERIC){
//                    System.out.println(cell.getNumericCellValue());
//                    rowData.add(cell.getStringCellValue());
//                }
//            }
//
//            data.add(rowData);
//        }


        int rowNum = 0;
        System.out.println("Creating the xcel file");

        for (Object[] datatype : datatypes) {

            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if(field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof  Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (IOException e) {

            e.printStackTrace();


        }


        for (Row row : sheet) {

            for (Cell cell : row) {
                if(cell.getCellType().equals("STRING")) {
                    System.out.print(cell.getStringCellValue() + "\t\t");
                } else if (cell.getCellType().equals("INTEGER")) {
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                }
                System.out.println();
            }
        }



    }
}
