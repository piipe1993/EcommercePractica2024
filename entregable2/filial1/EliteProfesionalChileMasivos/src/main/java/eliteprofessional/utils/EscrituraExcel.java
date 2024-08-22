package eliteprofessional.utils;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EscrituraExcel {
    private static final Logger LOGGER = Logger.getLogger(EscrituraExcel.class.getName());

    private EscrituraExcel() {
    }

    public static void escrituraExcel(String texto, int fila, int columna) {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new FileInputStream("data/DataGenerada.xlsx"));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al abrir el archivo de Excel", e);
            return;
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(fila);
        if (row == null) {
            row = sheet.createRow(fila);
        }
        Cell cell = row.getCell(columna);
        if (cell == null) {
            cell = row.createCell(columna);
        }
        cell.setCellValue(texto);
        try (FileOutputStream outputStream = new FileOutputStream("data/DataGenerada.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al escribir en el archivo de Excel", e);
        }
    }
}