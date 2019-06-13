import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;
    static WebDriverWait wait;
    static WidgetForm currentForm;
    static WidgetList currentList;
    static PickList currentPickList;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\delistratov\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/#/");
//        driver.get("http://192.168.238.191/dossier/ui/#/");
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("Operator_DNPS_2");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("q12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Проверка наличия виджетов на рабочес столе");
        currentList = new WidgetList(driver,"Список субъектов НПС");
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
        System.out.println("Проверка ввиджета Надзорные факты");
        currentList.findWidgetList("Надзорные факты");
        System.out.println("Проверка ввиджета Нарушения");
        currentList.findWidgetList("Нарушения");

        System.out.println("Проверка отсутствия кнопок \"Журнал куратора\" и \"Сформировать заключение\"");
        waitWidgetSpinner(1000);
        currentList.findWidgetList("Список субъектов НПС");
        currentList.Operations("Операции");
        List<WebElement> buttons = driver.findElements(By.xpath("//i[@title='Операции']/parent::div//button"));
        for(WebElement button: buttons){
            String name = button.getText();
            if(!name.equals("Журнал куратора") && !name.equals("Сформировать заключение")){
                System.out.println("Лишних кнопок нет");
            }
        }
        currentList.drillDown("Банк \"Возрождение\" (ПАО)");
        currentForm = new WidgetForm(driver,"Банк \"Возрождение\" (ПАО)");
        currentForm.Click();
        if(currentForm.CheckBox("КО")){
            System.out.println("Галочка КО проставлена");
        }
        System.out.println("Добавление записей в виджет \"Агенты\"");
        currentList =currentList.findWidgetList("Агенты");
        //currentList.Click();
        currentList.Operations("Операции");
        currentList.Operations("Добавить");
        System.out.println("Выбор Агентов из пиклиста");
        currentPickList = new PickList(driver);
        waitWidgetSpinner(4000);
        currentPickList.checkRow(1);
        currentPickList.checkRow(2);
        currentPickList.Ok();
        waitWidgetSpinner(2000);
        currentList.drillDown("НКО \"ПОВС застройщиков\"");

        System.out.println("Проверка ввиджета Реестр юридических лиц");
                  currentList.findWidgetList("Реестр юридических лиц");
        System.out.println("Проверка ввиджета Контактная информация");
        currentForm = new WidgetForm(driver,"Контактная информация");
        System.out.println("Проверка ввиджета Связанные лица");
                  currentList.findWidgetList("Связанные лица");
        System.out.println("Проверка ввиджета Является банковским платежным агентом для");
                  currentList.findWidgetList("Является банковским платежным агентом для");
        System.out.println("Проверка ввиджета Является банковским платежным субагентом для");
                  currentList.findWidgetList("Является банковским платежным субагентом для");
        System.out.println("Проверка ввиджета Финансовые группы организации");
                  currentList.findWidgetList("Финансовые группы организации");
        currentList = new WidgetList(driver,"Является банковским платежным агентом для");
        currentList.Click();
        waitWidgetSpinner(3000);
        currentList.drillDown("Банк \"Возрождение\" (ПАО)");



        currentList = currentList.findWidgetList("Субагенты");
        currentList.Operations("Операции");
        waitWidgetSpinner(1000);
        currentList.Operations("Добавить");
        System.out.println("Выбор Субагентов из пиклиста");
        currentPickList = new PickList(driver);
        waitWidgetSpinner(4000);
        currentPickList.checkRow(1);
        currentPickList.checkRow(2);
        currentPickList.Ok();
        System.out.println("Добавлены Субагенты");
        waitWidgetSpinner(2000);
        currentList.findWidgetList("Субагенты");
        currentList.Click();
        waitWidgetSpinner(2000);
        currentList.drillDown("НО ОВС \"Народные кассы\"");

        System.out.println("Проверка ввиджета Реестр юридических лиц");
        currentList.findWidgetList("Реестр юридических лиц");
        System.out.println("Проверка ввиджета Контактная информация");
        currentForm = new WidgetForm(driver,"Контактная информация");
        System.out.println("Проверка ввиджета Связанные лица");
        currentList.findWidgetList("Связанные лица");
        System.out.println("Проверка ввиджета Является банковским платежным агентом для");
        currentList.findWidgetList("Является банковским платежным агентом для");
        System.out.println("Проверка ввиджета Является банковским платежным субагентом для");
        currentList.findWidgetList("Является банковским платежным субагентом для");
        System.out.println("Проверка ввиджета Финансовые группы организации");
        currentList.findWidgetList("Финансовые группы организации");
        currentList = new WidgetList(driver,"Является банковским платежным субагентом для");
        waitWidgetSpinner(2000);
        currentList.drillDown("Банк \"Возрождение\" (ПАО)");
        System.out.println("Возвращение из субагентов на субъект НПС");
        waitWidgetSpinner(3000);
        driver.findElement(By.xpath("//span[text()='Режим надзора']/parent::a")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class,'DataGridHeader')]//th//span/span"));
        List<String> names = new ArrayList<String>();
        names.add("Раздел");
        names.add("Код");
        names.add("Наименование");
        names.add("Значение");
        names.add("Оценка");
        names.add("Балл");
        for(int i = 0; i < elements.size(); i++){
            if(names.get(i).equals(elements.get(i).getText()))
            {
                System.out.println("Найден показатель \"" + names.get(i) + "\" на виджете \"Показатели расчета\"");
            }
            else {
                System.out.println("Не найден показатель \"" + names.get(i) + "\" на виджете \"Показатели расчета\"");
            }
        }
        driver.findElement(By.xpath("//span[text()='Рабочий стол']/parent::a")).click();
        System.out.println("Переход на рабочий стол");
        //currentList = new WidgetList(driver,"Список субъектов НПС");
        currentList = currentList.findWidgetList("Список субъектов НПС");
        currentList.chooseOrg("Банк \"Возрождение\" (ПАО)");
        currentList = currentList.findWidgetList("Участие в платежных системах");
        //currentList.Click();
        System.out.println("Переход в платежную систему");
        waitWidgetSpinner(1000);
        currentList.drillDown("\"Мультисервисная платежная система\"");
        waitWidgetSpinner(1000);
        currentList = currentList.findWidgetList("Инфраструктура ПС");
        if(currentList.size()==0)
        {
            System.out.println("Инфраструктура ПС пустая");
        }
        currentList = currentList.findWidgetList("Значимость ПС");
        currentList.Click();
        if(currentList.checkBox("Наличие гарантийного фонда")){
            System.out.println("Галка \"Наличие гарантийного фонда\" проставлена");
        }
        else
            System.out.println("Галка \"Наличие гарантийного фонда\" не проставлена");
        waitWidgetSpinner(2000);
        currentList.pressCheckbox("Наличие гарантийного фонда");
        driver.findElement(By.xpath("//div[@title='Субъекты НПС']")).click();
        System.out.println("Переход на экран Субъекты НПС");
        driver.findElement(By.xpath("//span[text()='Субъекты НПС']/parent::a")).click();
        currentList = currentList.findWidgetList("Список Субъектов НПС");
        currentList.Click();
        System.out.println("Переход в Банк \"Возрождение\" (ПАО)");
        currentList.drillDown("Банк \"Возрождение\" (ПАО)");
        waitWidgetSpinner(3000);
        driver.findElement(By.xpath("//span[text()='Платежные системы']/parent::a")).click();
        System.out.println("Переход на список платежных систем");
        currentList = currentList.findWidgetList("Список платежных систем");
        currentList.Click();
        currentList.newFilter("Платежная система");
        currentList.searchWithFilter("Платежная система", "Мультисервисная ПлаТежная система");
        waitWidgetSpinner(3000);
        currentList.drillDown("\"Мультисервисная платежная система\"");
        currentList = currentList.findWidgetList("Значимость ПС");
        //currentList.Click();
        if(currentList.checkBox("Наличие гарантийного фонда")){
            System.out.println("Галка \"Наличие гарантийного фонда\" проставлена");
        }
        else
            System.out.println("Галка \"Наличие гарантийного фонда\" не проставлена");
        currentList.Click();
        waitWidgetSpinner(3000);
        currentList.pressCheckbox("Наличие гарантийного фонда");
        long endTime = System.nanoTime()-startTime;
        //Date d = new Date((endTime-startTime)/1000);
        System.out.println("Время в миллисекундах = " + (endTime));
        System.out.println("Тест шел " + ((endTime/1000000000)/60) + ":"+ ((endTime/1000000000)%60));
        driver.quit();

    }

    public static void waitWidgetSpinner(int ms) {
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-spin-container']/div[contains(@class,'CardWrapper')]//*[text()='Список субъектов НПС']"))));
        List<WebElement> spinners = driver.findElements(By.xpath("//div[contains(@class,'ant-spin-spinning')]"
                + "|//div[contains(@class,'ant-spin-blur')]"
                + "|//div[contains(@class,'ant-skeleton-active')]"));
        if (spinners.size() > 0) {
            try {
                Thread.sleep(ms);
            } catch (Exception e) {
            }

        }

    }
}
