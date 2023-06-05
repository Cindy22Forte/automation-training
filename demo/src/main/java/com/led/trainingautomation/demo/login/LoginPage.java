package com.led.trainingautomation.demo.login;

import com.led.trainingautomation.demo.home_screen.HomeScreenPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
	private static final By EMAIL_ELEMENT = By.id("email");

	private static final By PASSWORD_ELEMENT = By.id("passwd");

	private static final By LOGIN_BUTTON_ELEMENT = By.id("SubmitLogin");


	public static LoginPage URL() {
		return open("http://automationpractice.com/index.php?controller=authentication&back=my-account"
				, LoginPage.class);
	}

	public HomeScreenPage login(LoginProperties loginProperties) {
		enterEmail(loginProperties.email);
		enterPassword(loginProperties.password);
		clickLogin();
		return page(HomeScreenPage.class);
	}

	private void enterEmail(String email) {
		$(EMAIL_ELEMENT).waitUntil(appear, 5000).sendKeys(email);
	}

	private void enterPassword(String password) {
		$(PASSWORD_ELEMENT).waitUntil(appear, 5000).sendKeys(password);
	}

	private void clickLogin() {
		$(LOGIN_BUTTON_ELEMENT).click();
	}

}
