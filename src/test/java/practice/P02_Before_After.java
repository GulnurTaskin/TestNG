package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P02_Before_After {
    @BeforeClass
    public void setUp(){
        System.out.println("tum testler calistirilmaya basliyor");
    }
    @Test
    public void wise(){
        System.out.println("wise testi");

    }

    @AfterClass
    public void tearDown(){
        System.out.println("calistirilabilecek tum testler calistirildi");
    }

}
