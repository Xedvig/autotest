import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetList {
    private String xpath;
    private WebDriver driver;
    public WidgetList(WebDriver driver){
        this.driver=driver;
    }
    public WidgetList(WebDriver driver, String widgetName) {
        this(driver);
        String path = "//*[text()='" + widgetName +"']//ancestor::div[contains(@class,'card')]//div[contains(@class,'content')]";
        this.xpath = path;
        this.driver.findElement(By.xpath(xpath));
    }
    public void Click(){
        this.driver.findElement(By.xpath(this.xpath)).click();
    }
    public void ClearFilter(){
        this.driver.findElement(By.xpath(this.xpath+"//i[@title='Фильтр/Поиск']/parent::span")).click();
        this.driver.findElement(By.xpath("//li[text()='Очистить']"));
    }

    public void newFilter(String filter){
        this.driver.findElement(By.xpath(this.xpath+"/parent::div//i[@title='Фильтр/Поиск']/parent::span")).click();
        this.driver.findElement(By.xpath("//li[text()='"+filter+"']")).click();
        this.driver.findElement(By.xpath(this.xpath+"/parent::div//i[@title='Фильтр/Поиск']/parent::span")).click();
    }
    public void searchWithFilter(String nameFilter, String key){
        this.driver.findElement(By.xpath("//label[text()='"+nameFilter+"']/parent::div/following-sibling::div//input")).clear();
        this.driver.findElement(By.xpath("//label[text()='"+ nameFilter+"']/parent::div/following-sibling::div//input")).sendKeys(key);
        Button button = new Button(this.driver, "Применить");
    }

    public WidgetList findWidgetList(String header){
        return new WidgetList(driver,header);
    }

    public void Operations(String nameOperation){
        String path = "/parent::div//i[@title='" + nameOperation + "']/parent::div";
        this.driver.findElement(By.xpath(xpath + path)).click();
    }

    public void checkButton(String buttonName){
        String path ="//span[text()='" + buttonName + "']/parent::button";
        if(this.driver.findElements(By.xpath(xpath+path)).isEmpty()){
            System.out.println("Кнопка "+ buttonName + " не найдена!");
        }
    }

    public void drillDown(String header){
        this.driver.findElement(By.xpath(this.xpath +
                        "//div[@title='" + header + "']/span/span"
                        +"|//input[@value='" + header + "']/parent::span/span/div")).click();
        //Банк "Возрождение" (ПАО)
    }

    public void chooseOrg(String header){
        this.driver.findElement(By.xpath(this.xpath +
                "//div[@title='" + header + "']/ancestor::td/following-sibling::td")).click();
                //+"|//input[@value='" + header + "']/parent::span/span/div"));
    }

    public int size(){
        return this.driver.findElements(By.xpath(this.xpath + "/parent::div//table/tbody/tr")).size();
    }
    public Boolean checkBox(String header){
        return this.driver.findElement(By.xpath(this.xpath + "//span[text()='" + header + "']/ancestor::label//input")).isSelected();
    }
    public void pressCheckbox(String header){
        this.driver.findElement(By.xpath("//span[text()='" + header + "']/ancestor::label//input")).click();
        this.Operations("Сохранить");
    }
}
