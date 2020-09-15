package com.techproed.excelautomation;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class ReadExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "/Users/kemalgurler/IdeaProjects/TestNGProje/src/test/resources/ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //  // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //1.sayfaya gider. (index degeri 0'dan baslar)
        Sheet sheet  = workbook.getSheetAt(0);

        // 1.satira gidelim. (index degeri 0'dan baslar)
        Row row = sheet.getRow(0 );

        //1.hucreyi alalim.(index degeri 0'dan baslar)
        Cell ulkeler      = row.getCell(0);
        Cell baskentler   = row.getCell(1);
        Cell meshurlar    = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        //KISA YOLU ASAGIDAKI GIBIDIR.
        // Excel'e Git -> Sheet 0'a git -> 2. İndexteki Satıra git -> 1. İndexteki Hücre
        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(1));//Ankara
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));//peynir
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));//arjantin


        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() +1;
        System.out.println("Satır sayısı : " + satirSayisi);//aradaki bosluklarida sayar

        //Icersinde veri olan satirlari almak isterseniz;
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu satir sayisi: " + doluSatirSayisi);

        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum(); // 10
        for(int i = 0 ; i <= sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        // Tum baskenleri yazdiralim.
        int sonSatirinIndexii = workbook.getSheetAt(0).getLastRowNum(); // 10
        for(int i = 0 ; i <= sonSatirinIndexii ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }

         // bir satırın son sütunun indexini alma
        //1'den basliyor
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sütun İndex : " + sonSutunIndex);//3

        //4. satirdaki tum bilgileri alabilriz.
        for(int i =0 ; i<sonSutunIndex; i++){
            System.out.println("4.Satir TR: "+ workbook.getSheetAt(0).getRow(3).getCell(i));

        }
        //Tumunu yazdirmak icin icice for dongusu
//        for(int i=0;i<satirSayisi;i++){
//            for (int j = 0; j < sutunSayisi; j++) {
//                System.out.print(workbook.getSheetAt(0).getRow(i).getCell(j)+"-");
//            }
//            System.out.println("");
        //}






    }
}



