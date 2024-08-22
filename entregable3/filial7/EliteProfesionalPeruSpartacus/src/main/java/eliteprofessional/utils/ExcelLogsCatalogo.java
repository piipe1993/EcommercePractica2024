package utils;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelLogsCatalogo {
    private static final Logger LOGGER = Logger.getLogger(ExcelLogsCatalogo.class.getName());

    private ExcelLogsCatalogo() {
    }

    public static void escribir(String texto, int fila, int columna, String producto) {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new FileInputStream("data/LogsCatalogo.xlsx"));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al abrir el archivo de Excel", e);
            return;
        }

        Sheet sheet = null;
        String descripcionCorta =producto.substring(0, Math.min(producto.length(), 15));
        descripcionCorta = descripcionCorta.replaceAll("\\s+", "");
        int sheetIndex = workbook.getSheetIndex(descripcionCorta);

        if (sheetIndex == -1) { // Sheet with the name "producto" doesn't exist
            int formatSheetIndex = workbook.getSheetIndex("Formato");
            if (formatSheetIndex != -1) {
                // Duplicate the "Formato" sheet to create a new sheet with the "producto" name
                sheet = workbook.cloneSheet(formatSheetIndex);
                workbook.setSheetName(workbook.getSheetIndex(sheet), descripcionCorta);
            } else {
                // If "Formato" sheet doesn't exist, create a new sheet
                sheet = workbook.createSheet(descripcionCorta);
            }
        } else {
            // Sheet with the name "producto" already exists
            sheet = workbook.getSheetAt(sheetIndex);
        }

        // Proceed with writing data to the sheet
        Row row = sheet.getRow(fila);
        if (row == null) {
            row = sheet.createRow(fila);
        }
        Cell cell = row.getCell(columna);
        if (cell == null) {
            cell = row.createCell(columna);
        }
        cell.setCellValue(texto);

        try (FileOutputStream outputStream = new FileOutputStream("data/LogsCatalogo.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al escribir en el archivo de Excel", e);
        }
    }
}