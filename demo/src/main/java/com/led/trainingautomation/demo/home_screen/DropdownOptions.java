package com.led.trainingautomation.demo.home_screen;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DropdownOptions {

	LOWEST("price:asc"), HIGHEST("price:desc");

	public String value;
}
