package com.DemoWebShop_GenericUtility;

public interface FrameWorkConstants {

	JavaUtility javaUtility = new JavaUtility();

	static final String propertyPath = "./src/test/resources/testData/dataA2.properties";

	static final String excelPath = "./src/test/resources/testData/dataA2.xlsx";

	static final String screenShotPath = "./screenshots/" + javaUtility.localDateAndTime() + ".png";

	static final String reportsPath = "./reports/" + javaUtility.localDateAndTime() + ".html";

}
