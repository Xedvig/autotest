import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WidgetForm {
    private String xpath;
    private WebDriver driver;
    public WidgetForm(WebDriver driver){
        this.driver=driver;
    }
    public WidgetForm(WebDriver driver, String widgetName) {
        this(driver);
        xpath = "//*[text()='" + widgetName+"']/ancestor::div[contains(@class,'CardWrapper__header')]/ancestor::div[contains(@class,'CardWrapper__card')]";
        this.xpath = xpath;
        this.driver.findElement(By.xpath(xpath));
    }

    public Boolean CheckBox(String header){
        return this.driver.findElement(By.xpath("//span[text()='" + header + "']/ancestor::label//input")).isSelected();
    }


    public void Click(){
        this.driver.findElement(By.xpath(this.xpath)).click();
    }
    public void Operations(String nameOperation){
        String path = "//i[@title='" + nameOperation + "']/parent::div";
        this.driver.findElement(By.xpath(this.xpath+path)).click();
    }

    public void checkButton(String buttonName){
        String path ="//span[text()='" + buttonName + "']/parent::button";
        if(this.driver.findElements(By.xpath(xpath+path)).isEmpty()){
            System.out.println("Кнопка "+ buttonName + " не найдена!");
        }
    }

    public void clickButton(String buttonName){
        Button button = new Button(driver,buttonName);
    }

    public WidgetForm findWidgetForm(String header){
        //String path = String.format("//*[text()='%s']/ancestor::div[contains(@class,'CardWrapper__header')]/ancestor::div[contains(@class,'CardWrapper__card')]",header);
        return new WidgetForm(driver,header);
    }
}
