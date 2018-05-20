package salariati.test;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:8000/Index")
public class HomePage extends PageObject {
    @FindBy(id = "Name")
    WebElement inputText;

    @FindBy(id = "CNP")
    WebElement inputCnp;

    @FindBy(id = "Salary")
    WebElement inputSalary;

    @FindBy(id = "add_button")
    WebElement submit_btn;

    public void set_input_name(String keywords){
        inputText.sendKeys(keywords);
    }

    public void set_input_cnp(String keywords){
        inputCnp.sendKeys(keywords);
    }

    public void setInputSalary(String keywords) {
        inputSalary.sendKeys(keywords);
    }

    public void set_submit(){
        submit_btn.click();
    }

}
