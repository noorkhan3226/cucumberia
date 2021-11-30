package UTILS;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReadingClass {

    public static Workbook book;
    public static Sheet sheet;
    public static void openExcel(String filePath){

        try {
            FileInputStream fis=new FileInputStream(filePath);
            book=new XSSFWorkbook(fis);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Getsheet(String sheetName){
        sheet= book.getSheet(sheetName);
    }

    public static  int GetRowCount(){
        return sheet.getPhysicalNumberOfRows();

    }
    public static int GetCellcount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }
    public static String getCellData(int rowIndex, int CellIndex){
        return sheet.getRow(rowIndex).getCell(CellIndex).toString();
    }

    public static List<Map<String,String>> excelInToMapList(String filePath,String sheetName){
        openExcel(filePath);
        Getsheet(sheetName);

        List<Map<String,String>> ListDataa=new ArrayList<>();

for (int row=1;row<GetRowCount();row++){

    Map<String,String>map=new LinkedHashMap<>();

    for (int col=0; col<GetCellcount(row);col++){
        map.put(getCellData(0,col),getCellData(row,col));
    }
    ListDataa.add(map);
}
return ListDataa;
    }
}
