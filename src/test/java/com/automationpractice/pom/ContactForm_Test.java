package com.automationpractice.pom;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Yari Mejia -- 03/15/2020
 *
 */

public class ContactForm_Test {

	private WebDriver driver;
	ContactFormPage contactFormPage;

	@Before
	public void setUp() throws Exception {
		contactFormPage = new ContactFormPage(driver);
		driver = contactFormPage.chromeDriverConnection();
		driver.manage().window().maximize();
		contactFormPage.visit("http://automationpractice.com");
		
		
	}

	@After
	public void tearDown() throws Exception {
		 driver.quit();
	}

	@Test
	public void testContactForm() {
		contactFormPage.contactForm();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// assertEquals("Your message has been successfully sent to our team.",
		// contactFormPage.sentMessageLocator);
		assertTrue(contactFormPage.isMessageSent());

	}
}
