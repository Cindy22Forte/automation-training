package com.led.trainingautomation.demo;

import com.led.trainingautomation.demo.home_screen.HomeScreenPage;
import com.led.trainingautomation.demo.login.LoginPage;
import com.led.trainingautomation.demo.login.LoginProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
	@Test
	void passLoginCorrectDetail() {
		LoginProperties loginProperties = createDefault().build();

		HomeScreenPage homeScreenPage = LoginPage.URL().login(loginProperties);

		assertEquals("MY Account", homeScreenPage.verifyLogin(), "Incorrect text");

	}

	private LoginProperties.LoginPropertiesBuilder createDefault() {
		return LoginProperties.builder().email("cindy@labs.epiuse.com").password("password");
	}
}
