package com.techproed.utilities;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigurationReader {
    // ConfigurationReader class'ını projemizin heryerinden
    // nesne üretmeden, miras almadan kullanabilecek şekilde tasarlayalım.
    // static : program çalışır çalışmaz, bellekte yer tutmaya yarayan keywordtur.
    //interviewSorusu: Frameworkunda static kavramini nerede kullaniyorsun?
    //Cevap: ConfigurationReader clasinda kullaniyorum. Nesne uretmeye gerek duymadan,
    //properties icerisindeki verilere ulasabilmek icin ConfigurationReader clasinda kullaniyorum.

    static Properties properties;
    static {//static blok java dersi
        // okumak istediğimiz configuration.properties file'ın dosya yolu
        // C:\Users\isimsiz\IdeaProjects\TestNGProje\configuration.properties
        String path = "configuration.properties";
        // dene - hata varsa yakala.
        // bu işlemi DENE eğer hata alırsan, PROGRAMI DURDURMA
        try {
            // okumak istediğiniz dosyanın path(adres)'ini yazıyorsun
            FileInputStream file = new FileInputStream(path);
            //Javada okumak istedeigimiz dosyayi acar.
            properties = new Properties();
            // fileInputStream'dan ürettiğim file dosyası burada, bunu kullanabilirsin
            properties.load(file);//properties clasindan nesne olusturduk.
            // Bu nesne ile file dosyasini okunur hale getirdik.
        } catch (Exception e) {
        }
    }
    //properties.getProperty("username") --> manager2
    public static String getProperty(String key) {
        return properties.getProperty(key);
        //Interview'de sifirdan framework olusturmamiz istenirse,
        // yukaridaki formulleri kullanmamiz gerekebilir.Ezberlememiz gerekiyor.
    }
    // // ConfigurationReader.getProperty("fb_email") --- >
    // hamza@techproed.com
}

