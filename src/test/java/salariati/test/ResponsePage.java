package salariati.test;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:8000/AddEmployee")
public class ResponsePage extends PageObject {
    @FindBy(className = "text")
    WebElement responseText;

    public String get_responseText(){
        return responseText.getText();
    }
}
