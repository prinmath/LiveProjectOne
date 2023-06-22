package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseProjOneClass;

public class PomLogin extends BaseProjOneClass{
	
	//object repository
      @FindBy(name="username")     
      WebElement Username;
      @FindBy(name="password")
      WebElement Password;
      @FindBy(id="btnLogin")
      WebElement Loginbtn;
      
      
    //initiate page elements
public PomLogin() {
	PageFactory.initElements(driver, this);
}

public void typeusername(String name) {
	Username.sendKeys(name);
}
public void typepassword(String pass) { 
	Password.sendKeys(pass);
}
public void clickbtn() {
	Loginbtn.click();
}
public String verify() {
	return driver.getTitle(); 
	
}

}
