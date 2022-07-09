package org.base;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Adactin {

	public static void main(String[] args) throws IOException {
		BaseClass baseClass = new BaseClass();

		baseClass.launchBrowser();
		baseClass.implicitWait(30);
		baseClass.maximize();

		baseClass.launchUrl("http://adactinhotelapp.com/");

		WebElement txtUserName = baseClass.xPath("//input[@id='username']");

		String dataInExcel = baseClass.getDataInExcel("Adactin", 1, 0);
		baseClass.sendkeys(txtUserName, dataInExcel);

		WebElement txtPassword = baseClass.byId("password");
		String dataInExcel2 = baseClass.getDataInExcel("Adactin", 1, 1);
		baseClass.sendkeys(txtPassword, dataInExcel2);

		WebElement byId3 = baseClass.byId("login");
		baseClass.click(byId3);

		WebElement location = baseClass.byId("location");
		String dataInExcel3 = baseClass.getDataInExcel("Adactin", 1, 2);
		baseClass.dropDownSelectByVisibleText(location, dataInExcel3);

		WebElement hotel = baseClass.byId("hotels");
		String dataInExcel4 = baseClass.getDataInExcel("Adactin", 1, 3);
		baseClass.dropDownSelectByVisibleText(hotel, dataInExcel4);

		WebElement roomType = baseClass.byId("room_type");
		String dataInExcel5 = baseClass.getDataInExcel("Adactin", 1, 4);
		baseClass.dropDownSelectByVisibleText(roomType, dataInExcel5);

		WebElement NoOfRoom = baseClass.byId("room_nos");
		String dataInExcel6 = baseClass.getDataInExcel("Adactin", 1, 5);
		baseClass.dropDownSelectByVisibleText(NoOfRoom, dataInExcel6);

		WebElement dateIn = baseClass.byId("datepick_in");
		baseClass.clear(dateIn);
		String dataInExcel7 = baseClass.getDataInExcel("Adactin", 1, 6);
		baseClass.sendkeys(dateIn, dataInExcel7);

		WebElement dateOut = baseClass.byId("datepick_out");
		baseClass.clear(dateOut);
		String inExcel = baseClass.getDataInExcel("Adactin", 1, 7);
		baseClass.sendkeys(dateOut, inExcel);

		WebElement adultRoom = baseClass.byId("adult_room");
		String inExcel2 = baseClass.getDataInExcel("Adactin", 1, 8);
		baseClass.dropDownSelectByVisibleText(adultRoom, inExcel2);

		WebElement childRoom = baseClass.byId("child_room");
		String inExcel3 = baseClass.getDataInExcel("Adactin", 1, 9);
		baseClass.dropDownSelectByVisibleText(childRoom, inExcel3);

		WebElement btnSearch = baseClass.byId("Submit");
		baseClass.click(btnSearch);

		WebElement btnRadio = baseClass.byId("radiobutton_0");
		baseClass.click(btnRadio);

		WebElement clickContinue = baseClass.byId("continue");
		baseClass.click(clickContinue);

		WebElement firstName = baseClass.byId("first_name");
		String inExcel4 = baseClass.getDataInExcel("Adactin", 1, 10);
		baseClass.sendkeys(firstName, inExcel4);

		WebElement lastName = baseClass.byId("last_name");
		String inExcel5 = baseClass.getDataInExcel("Adactin", 1, 11);
		baseClass.sendkeys(lastName, inExcel5);

		WebElement adress = baseClass.byId("address");
		String inExcel6 = baseClass.getDataInExcel("Adactin", 1, 12);
		baseClass.sendkeys(adress, inExcel6);

		WebElement cardNumber = baseClass.byId("cc_num");
		String inExcel7 = baseClass.getDataInExcel("Adactin", 1, 13);
		baseClass.sendkeys(cardNumber, inExcel7);

		WebElement cardType = baseClass.byId("cc_type");
		String inExcel8 = baseClass.getDataInExcel("Adactin", 1, 14);
		baseClass.dropDownSelectByVisibleText(cardType, inExcel8);

		WebElement expMonth = baseClass.byId("cc_exp_month");
		String inExcel9 = baseClass.getDataInExcel("Adactin", 1, 15);
		baseClass.dropDownSelectByVisibleText(expMonth, inExcel9);

		WebElement expYear = baseClass.byId("cc_exp_year");
		String inExcel10 = baseClass.getDataInExcel("Adactin", 1, 16);
		baseClass.sendkeys(expYear, inExcel10);

		WebElement ccvNumber = baseClass.byId("cc_cvv");
		String inExcel11 = baseClass.getDataInExcel("Adactin", 1, 17);
		baseClass.sendkeys(ccvNumber, inExcel11);

		WebElement clickBookNow = baseClass.byId("book_now");
		baseClass.click(clickBookNow);

		WebElement orderId = baseClass.byId("order_no");
		String txt = orderId.getAttribute("value");
		System.out.println(txt);

		baseClass.createRowAndCellInExcel("Adactin", 2, 18, txt);

	}

}
