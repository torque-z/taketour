import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class MergeExcelFiles {
    public static void main(String[] args) throws IOException {
        // Specify the folder containing the Excel files to be merged
        String folderPath = "C:/MyExcelFiles/";

        // Create a new workbook to store the merged data
        XSSFWorkbook mergedWorkbook = new XSSFWorkbook();

        // Iterate through all the Excel files in the folder
        File folder = new File(folderPath);
        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".xlsx")) {
                // Open the Excel file
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                fis.close();

                // Iterate through all the sheets in the workbook
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    // Get the current sheet
                    XSSFSheet sheet = workbook.getSheetAt(i);

                    // Create a new sheet in the merged workbook with the same name
                    XSSFSheet mergedSheet = mergedWorkbook.createSheet(sheet.getSheetName());

                    // Copy the data from the current sheet to the merged sheet
                    copySheet(sheet, mergedSheet);
                }
            }
        }

        // Save the merged workbook to a file
        FileOutputStream fos = new FileOutputStream("C:/MergedExcelFile.xlsx");
        mergedWorkbook.write(fos);
        fos.close();
    }

    private static void copySheet(XSSFSheet sheet, XSSFSheet mergedSheet) {
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i <= rowCount; i++) {
            // Get the current row from the source sheet
            XSSFRow row = sheet.getRow(i);

            if (row != null) {
                // Create a new row in the merged sheet with the same index
                XSSFRow mergedRow = mergedSheet.createRow(i);

                int cellCount = row.getLastCellNum();
                for (int j = 0; j < cellCount; j++) {
                    // Get the current cell from the source row
                    XSSFCell cell = row.getCell(j);

                    if (cell != null) {
                        // Create a new cell in the merged row with the same index and value
                        XSSFCell mergedCell = mergedRow.createCell(j, cell.getCellType());
                        mergedCell.setCellValue(cell.getStringCellValue());
                    }
                }
            }
        }
    }
}
