package tests.practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class P01 {
    @Test(priority = -1)
    @Ignore
    public void Gulnur() {
        System.out.println("Gulnur Methodu Çalıştı");
    }


    @Test
    public void Nevfel() {
        System.out.println("Nevfel metodu çalıştı");
    }


    @Test(priority = -1)
    public void EsraYilmaz() {
        System.out.println("EsraYilmaz methodu Çalıştı");
    }

    @Test(dependsOnMethods = "Nevfel")
    public void FikretZeybek() {
        System.out.println("FikretZeybek methodu Çalıştı");
    }
}