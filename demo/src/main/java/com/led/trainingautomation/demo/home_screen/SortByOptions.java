package com.led.trainingautomation.demo.home_screen;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortByOptions {
	LOWEST_FIRST("price:asc"), HIGHEST_FIRST("price:desc");

	private String value;
}
