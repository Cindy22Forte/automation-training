package com.led.trainingautomation.demo.home_screen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchProperties {
	String searchCriteria;

	SortByOptions sortByOptions;
}
