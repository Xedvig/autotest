import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private String xpath;
    private WebDriver driver;
    private String name;
    public Button(WebDriver driver){
        this.driver=driver;
    }

    public Button(WebDriver driver, String buttonName) {
        this(driver);
        String path = "//span[text()='%s']/parent::button";
        if(this.xpath==null || this.xpath=="null")
            this.xpath="";
        xpath+=String.format(path,buttonName);
        this.xpath = xpath;
        this.driver.findElement(By.xpath(xpath)).click();
    }
}
