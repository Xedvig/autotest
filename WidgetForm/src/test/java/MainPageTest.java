import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WidgetForm currentForm;
    static WidgetList currentList;

    @Before
            public void setUp() {
        Date start = new Date();
        System.out.println(start.toString());
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\delistratov\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/#/");
//        driver.get("http://192.168.238.191/dossier/ui/#/");
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("Operator_DNPS_2");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("q12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

        @Test
        public void checkDashboardWidgets() {
            System.out.println("Проверка наличия виджетов на рабочес столе");
            System.out.println("Проверка ввиджета Список субъектов НПС");
            currentList.findWidgetList("Список субъектов НПС");
            System.out.println("Проверка ввиджета Участие в платежных системах");
            currentList.findWidgetList("Участие в платежных системах");
            System.out.println("Проверка ввиджета Отслеживаемые активности");
            currentList.findWidgetList("Отслеживаемые активности");
            System.out.println("Проверка ввиджета Выявленные события");
            currentList.findWidgetList("Выявленные события");
            System.out.println("Проверка ввиджета Мои инициативы");
            currentList.findWidgetList("Мои инициативы");
            System.out.println("Проверка ввиджета Поручения (на мне)");
            currentList.findWidgetList("Поручения (на мне)");
            System.out.println("Надзорные факты");
            currentList.findWidgetList("Надзорные факты");
            System.out.println("Проверка ввиджета Нарушения");
            currentList.findWidgetList("Нарушения");
            driver.quit();
        }



    public static void waitWidgetSpinner() {
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-spin-container']/div[contains(@class,'CardWrapper')]//*[text()='Список субъектов НПС']"))));
        List<WebElement> spinners = driver.findElements(By.xpath("//div[contains(@class,'ant-spin-spinning')]"
                + "|//div[contains(@class,'ant-spin-blur')]"
                + "|//div[contains(@class,'ant-skeleton-active')]"));
        if (spinners.size() > 0) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
            }

        }

    }
}
