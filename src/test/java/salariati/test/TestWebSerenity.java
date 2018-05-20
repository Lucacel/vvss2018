package salariati.test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

@RunWith(SerenityRunner.class)
public class TestWebSerenity {
    @Managed(driver = "firefox", uniqueSession = true)
    private File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
    private FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    private FirefoxProfile firefoxProfile = new FirefoxProfile();
    WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);


    @Steps
    AdderSteps adder;

    @Test
    public void should_see_inputs(){
        //Given
        adder.opens_home_page();
        //insert inputs
        adder.set_input_name("RazvanL");
        adder.set_input_cnp("1960519125486");
        adder.set_input_salary("3500");
        adder.submit_btn();
        //Grab response
        String response = adder.get_response();
        System.out.println(response);
    }

}
