package tests.day14_testNG;

import org.testng.annotations.Test;

public class C01_Priority {
    /*
    TestNG test methodlarini default olarak
    natural order ile calistirir

    Ama testlerimizi istedigimiz sirada calistirmak istersek
    priority ile siralama yapabiliriz

    -
    -
    -
     */

    @Test
    public void youtubeTesti(){
        System.out.println("Youtube Testi PASSED");
    }

    @Test
    public void testOtomasyonuTesti(){
        System.out.println("Testotomasyonu Testi PASSED");
    }
    @Test
    public void wisequarterTesti(){
        System.out.println("Wisequarter Testi PASSED");

    }


}
