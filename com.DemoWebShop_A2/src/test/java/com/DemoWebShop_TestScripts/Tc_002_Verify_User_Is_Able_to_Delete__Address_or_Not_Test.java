package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.DemoWebShop_GenericUtility.Base_Test;
import com.DemoWebShop_POM.Addresses_Page;

public class Tc_002_Verify_User_Is_Able_to_Delete__Address_or_Not_Test extends Base_Test {

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {

		webDriverUtility.javascriptScrollIntoView(driver, homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();

		Addresses_Page addressesPage = new Addresses_Page(driver);
		addressesPage.getDeleteBtn().click();

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);

	}

}
