package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {
        String dosyaYolu = "/Users/kemalgurler/IdeaProjects/TestNGProje/src/test/resources/ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Dosya uzerinde yazma islemi gerceklestirmek icin buraya
        //FileOutputStream class'inda bir tane nesne olusturmamiz gerekiyor
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);

    //ulkeler   baskenler meshurlar   nufus
        //0'inci indexteki satirin, 3. indexteki hucresine NUFUS hucresi ekleyelim.
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");


        //Ilk ulkenin nufusunu yazdiralim.
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80000000");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80000000");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10000000");



        // 0.indexteki satırın, 1. indexindeki hücreyi silelim (BAŞKENTLER)
        Cell silmekIstedigimizHucre = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(silmekIstedigimizHucre);

        //1/ indexteki satiri silelim.(Almanya satirini silelim)
        Row silmekIstedigimSatir = workbook.getSheetAt(0).getRow(2);
        workbook.getSheetAt(0).removeRow(silmekIstedigimSatir);


        //yaptigimiz degisiklikleri excel dosyasina aktatrir.
        workbook.write(fileOutputStream);
        //Dosya ile islemimiz bitince kapatabiliriz
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();





    }
}