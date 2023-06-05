package com.led.trainingautomation.demo.home_screen;

import com.led.trainingautomation.demo.women_tab.WomenTabPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HomeScreenPage {
	private static final By SEARCH_ELEMENT = By.id("search_query_top");

	private static final By SEARCH_BUTTON_ELEMENT = By.name("submit_search");

	private static final By SEARCH_TITLE_ELEMENT = By.className("lighter");

	private static final By SEARCH_RESULTS_COUNT_ELEMENT = By.className("heading-counter");

	private static final By VERIFY_LOGIN_HEADER_ELEMENT = By.className("page-heading");

	public String verifyLogin() {
		return $(VERIFY_LOGIN_HEADER_ELEMENT).getText();
	}

	public static HomeScreenPage openURL() {
		open("http://e8b.sap.labs.epiuse.com:8000/sap/bc/ui5_ui5/use/qm_fiori_2/index.html?sap-client=800");//, AuthenticationType.BASIC, "CFORTE", "sap@MIA_!");
		return page(HomeScreenPage.class);
	}

	public void searchSomething(SearchProperties searchProperties) { // groups methods
		enterSearchCriteria(searchProperties.searchCriteria);
		clickSearch();
	}

	public WomenTabPage womenTabPage() {
		return page(WomenTabPage.class);
	}

	private void enterSearchCriteria(String text) {
		$(SEARCH_ELEMENT).sendKeys(text);
	}

	private void clickSearch() {
		$(SEARCH_BUTTON_ELEMENT).click();
	}

	public String verifySearchCriteriaText() {
		return $(SEARCH_TITLE_ELEMENT).waitUntil(appear, 6000)
				.getText();
	}

	public String verifySearchCount() {
		return $(SEARCH_RESULTS_COUNT_ELEMENT).waitUntil(appear, 6000)
				.getText();
	}

}
