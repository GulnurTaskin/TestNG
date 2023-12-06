package tests.day14_testNG;

import org.testng.annotations.Test;

public class C01_Priority {
    /*
    TestNG test methodlarini default olarak
    natural order (alfabetik siraya gore, sayi olursa kucukten buyuge dogru) ile calistirir

    Ama testlerimizi istedigimiz sirada calistirmak istersek
    priority ile siralama yapabiliriz

     - priority degeri kucuk olan once calisir
     - priority degeri ayni olanlar varsa, ayni olanlar natural order'a gore calisir
     - herhangi bir method'a priority atamazsak, priority degeri default olarak 0 olur

     */

    @Test(priority = 20)
    public void youtubeTesti(){

        System.out.println("Youtube Testi PASSED");
    }

    @Test(priority = 10)
    public void testOtomasyonuTesti(){

        System.out.println("Testotomasyonu Testi PASSED");
    }
    @Test(priority = 5)
    public void wisequarterTesti(){

        System.out.println("Wisequarter Testi PASSED");

    }


}
