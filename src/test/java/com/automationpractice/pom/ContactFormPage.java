package com.automationpractice.pom;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Yari Mejia -- 03/15/2020
 *
 */

public class ContactFormPage extends Base{

	By contactLinkLocator = By.xpath("//a[@title='Contact Us']");
	By contactPageLocator = By.xpath("//h1[contains(text(),'Customer service - Contact us')]");
	By selectLocator = By.id("id_contact");
	By emailLocator = By.id("email");
	By orderRefLocator = By.id("id_order");
	By attachFileLocator = By.id("fileUpload");
	By messageBoxLocator = By.id("message");
	By sendButtonLocator = By.xpath("//span[contains(text(),'Send')]");
	By sentMessageLocator = By.xpath("//p[contains(text(),'Your message has been successfully sent to our team.')]");
	
	public ContactFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void contactForm() {
		click(contactLinkLocator);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File file2 = new File("src/test/resources/files/Factura_tennis.JPG");
		
		if(isDisplayed(contactPageLocator)){
			selectOption(selectLocator, "2");
			type("yamechi@hotmail.com", emailLocator);
			type("OVVNOPQXV",orderRefLocator);
			inputFilePath(file2, attachFileLocator);
			type("Test message", messageBoxLocator );
			click(sendButtonLocator);
			
		}else {
			System.out.println("Page not found!");
		}

		
	}
	
	public boolean isMessageSent() {
		return isDisplayed(sentMessageLocator);
	}
	
	
}
