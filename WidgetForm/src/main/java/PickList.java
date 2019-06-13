import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PickList {
    private String xpath;
    private WebDriver driver;
    public PickList(WebDriver driver){
        this.driver=driver;
        xpath = "//div[@class='ant-modal-mask']/parent::div//div[@class='ant-modal-content']";
        this.xpath = xpath;
        this.driver.findElement(By.xpath(xpath));
    }

    public void checkAll(){
        this.driver.findElement(By.xpath(this.xpath + "//thead//input[@type='checkbox']")).click();
    }

    public void checkRow(int number){
        this.driver.findElement(By.xpath(this.xpath + "//tbody//tr["+number + "]/td//input")).click();
    }

    public void fullScreen(){
        this.driver.findElement(By.xpath(this.xpath + "//i[@title='На весь экран']/parent::div")).click();
    }
    public void viewScreen(){
        this.driver.findElement(By.xpath(this.xpath + "//i[@title='Перейти в окнонный режим']/parent::div")).click();
    }

    public void Ok(){
        this.driver.findElement(By.xpath(this.xpath + "//span[text()='OK']/parent::button")).click();
    }
    public void Cancel(){
        this.driver.findElement(By.xpath(this.xpath + "//span[text()='Отмена']/parent::button")).click();
    }

}