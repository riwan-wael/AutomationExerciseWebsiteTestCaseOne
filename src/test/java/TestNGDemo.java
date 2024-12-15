import org.testng.annotations.*;

public class TestNGDemo {
    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method to run before each test case");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method to run after each test case");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class (First thing to be excuted)");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class (Last thing to be excuted");
    }
}
