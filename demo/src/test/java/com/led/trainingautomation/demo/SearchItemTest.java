package com.led.trainingautomation.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.led.trainingautomation.demo.home_screen.DropdownOptions;
import com.led.trainingautomation.demo.home_screen.HomeScreenPage;
import com.led.trainingautomation.demo.home_screen.SearchProperties;
import com.led.trainingautomation.demo.home_screen.SortByOptions;
import com.led.trainingautomation.demo.login.LoginPage;
import com.led.trainingautomation.demo.login.LoginProperties;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchItemTest {

	@ParameterizedTest // Added
	@MethodSource("verifyAssertsProvider")
	void passSearchItem(List<AssertFunction> assertions) {
		HomeScreenPage homeScreenPage = LoginPage.URL().login(createDefault().build());

		// Method 1
//		SearchProperties properties = searchPropertiesBuilder().searchCriteria("....").build();
//		homeScreenPage.searchSomething(properties);

		// Method 2
		homeScreenPage.searchSomething(searchPropertiesBuilder().build());

		// Added
		assertAll(assertions.stream().map(a -> a.createAssert(homeScreenPage)));
	}

	@FunctionalInterface
	public interface AssertFunction {
		Executable createAssert(HomeScreenPage homeScreenPage);
	}

	private static Stream<Arguments> verifyAssertsProvider() {
		return Stream.of(
				Arguments.of(ImmutableList.<AssertFunction>of(homeScreenPage -> () -> assertEquals("\"PRINTED CHIFFON DRESS\""
						, homeScreenPage.verifySearchCriteriaText(), "Incorrect Result"),

						homeScreenPage -> () -> assertEquals("2 results have been found."
								, homeScreenPage.verifySearchCount()
								, "Incorrect Result"))));
	}


	private SearchProperties.SearchPropertiesBuilder searchPropertiesBuilder() {
		return SearchProperties.builder().searchCriteria("Printed Chiffon Dress").sortByOptions(SortByOptions.HIGHEST_FIRST);
	}

	private LoginProperties.LoginPropertiesBuilder createDefault() {
		return LoginProperties.builder().email("cindy@labs.epiuse.com").password("password");
	}


	// Cartesian product
	private static List<List<Object>> statisticsTestArgumentsProvider() {
		return Lists.cartesianProduct(
				Arrays.asList(DropdownOptions.values()));
	}

	@ParameterizedTest // Added
	@MethodSource("verifyTestArgumentsProvider")
		// Added
		//@Test
	void passSearchItemWithCartesian(List<Object> objects, List<PageToAssertFunction> assertions) {
		HomeScreenPage homeScreenPage = LoginPage.URL().login(createDefault().build());

		homeScreenPage.searchSomething(searchPropertiesBuilder().build());


		// Added
		assertAll(assertions.stream().map(a -> a.createAssert(homeScreenPage)));
	}

}
