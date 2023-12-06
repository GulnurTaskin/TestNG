package tests.day14_testNG;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {


    @Test(dependsOnMethods = "testOtomasyonuTesti")
    // depends=baglama, yani youtube testinden once testotomasyonu testi calismali
    // testptomasyonundan hemen sonra  youtube testi calismak zorunda degil ama
    // youtube testinin calisabilmesi icin testotomasyonu testi calismak zorunda
    public void youtubeTesti(){

        System.out.println("Youtube Testi PASSED");
    }

    @Test()
    // testOtomasyonu testi calismazsa ya da failed olursa bu teste bagli amazon testi calismaz,
    // daha dogrusu ignore edlir
    public void testOtomasyonuTesti(){
        //Assert.assertTrue(false); bu sekilde testi fail edebiliriz
        System.out.println("Testotomasyonu Testi PASSED");
    }
    @Test()
    public void wisequarterTesti(){
        System.out.println("Wisequarter Testi PASSED");

    }

     /*
        dependsOnMethods oncelik sirasina karismaz

        Eger sirasi gelen bir test dependsOnMethods ile baska bir method'a bagli ise
        once bagli olunan testin calisip, pass olmasini kontrol eder

        bagli olunan test calismazsa veya calisir ama FAILED olursa
        bu durumda bagli olan test method'u calismaz, ignore olarak isaretlenir

        Normalde her bir test method'u bagimsiz olarak calistirilabilir
        Ancak dependsOnMethods ile bagli olan iki method'dan
        bagli olan run edilirse, oncelikle bagli olunan test method'unun calismasini saglar
        bagli olunan method calisip PASSED olursa, bagli olan kendisi de calisir

     */


}