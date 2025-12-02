package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.DemoWebShop_GenericUtility.Base_Test;
import com.DemoWebShop_POM.AddNewAddress_Page;
import com.DemoWebShop_POM.Addresses_Page;

public class Tc_001_Verify_User_Is_Able_to_Add__Address_or_Not_Test extends Base_Test {

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {

		webDriverUtility.javascriptScrollIntoView(driver, homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();

		Addresses_Page addressesPage = new Addresses_Page(driver);
		addressesPage.getAddNewBtn().click();

		AddNewAddress_Page addNewAddressPage = new AddNewAddress_Page(driver);

		addNewAddressPage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addNewAddressPage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addNewAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));

		webDriverUtility.selectByVisibleText(addNewAddressPage.getCountryDropDown(),
				fileUtility.readDataFromExcelFile("Sheet1", 1, 3));

		addNewAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addNewAddressPage.getAddress1TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addNewAddressPage.getZipCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		addNewAddressPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		addNewAddressPage.getSaveBtn().click();

		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);

	}

}
