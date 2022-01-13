package com.sikka.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sikka.utilities.CommonMethods;
import com.sikka.utilities.Constants;

public class LoginPage extends CommonMethods {

	@FindBy(xpath = "//div[@id='ddlSort1']//label/input")
	public static List<WebElement> Industries;

	@FindBy(xpath = "//div[@id='btnsearchCategory']//label/input")
	public static List<WebElement> AppTypes;

	@FindBy(xpath = "//div[@id='divapps']//a")
	public static List<WebElement> Tiles;

	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	
	/**
	 * This method clicks Industry and App Type, getting related Tiles and by
	 * calling WriteExel method writes the tiles into the excel.
	 * 
	 * @param actInds
	 * @param actApp
	 * @param sheetName
	 * @throws IOException
	 */
	public static void clickIndsAndAppGetTiles(String actInds, String actApp, String sheetName) {
		for (int i = 0; i < Industries.size(); i++) {
			if (Industries.get(i).getAttribute("value").equalsIgnoreCase(actInds)) {
				Industries.get(i).click();
				break;
			}
		}
		for (int i = 0; i < AppTypes.size(); i++) {
			if (AppTypes.get(i).getAttribute("value").equalsIgnoreCase(actApp)) {
				AppTypes.get(i).click();
				System.out.println(tilesName());
				System.out.println("Tiles size " + tilesName().size());
				try {
					writeExel(actInds, actApp, sheetName);
				} catch (IOException e) {

					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	

	/**
	 * This method getting and return all industry names
	 * 
	 * @param actInds
	 * @return industry names
	 */
	public static String indName(String actInds) {
		String ind = "";
		for (int i = 0; i < Industries.size(); i++) {
			if (Industries.get(i).getAttribute("value").equalsIgnoreCase(actInds)) {
				ind = actInds;
				break;
			}
		}
		return ind;
	}
	
	

	/**
	 * This method getting and return all app types
	 * 
	 * @param actApp
	 * @return app types
	 */
	public static String appName(String actApp) {
		String app = "";
		for (int i = 0; i < AppTypes.size(); i++) {
			if (AppTypes.get(i).getAttribute("value").equalsIgnoreCase(actApp)) {
				app = actApp;
				break;
			}
		}
		return app;
	}
	

	/**
	 * This methods getting tiles and return them
	 * 
	 * @return tiles
	 */
	public static List<String> tilesName() {
		List<String> tiles = new ArrayList<>();
		int tilesCount = Tiles.size();

		for (int i = 0; i < tilesCount; i++) {
			tiles.add(Tiles.get(i).getAttribute("data-name"));
		}

		return tiles;
	}
	

	/**
	 * This method taking industry name, app name and tiles name from related
	 * methods, creates an excel file and write them into the that excel file.
	 * 
	 * @param actInds
	 * @param actApp
	 * @param sheetName
	 * @throws IOException
	 */
	public static void writeExel(String actInds, String actApp, String sheetName) throws IOException {

		String fileLocation = Constants.TESTDATA_FILEPATH + "/Task_1.xlsx";

		File file = new File(fileLocation);
		Workbook workbook;

		if (file.exists()) {

			FileInputStream fis = new FileInputStream(fileLocation);

			workbook = new XSSFWorkbook(fis);
		} else {

			workbook = new XSSFWorkbook();
		}

		Sheet sheet = workbook.createSheet(sheetName);
		workbook.setActiveSheet(0);
		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		headerStyle.setFont(font);

		LinkedList<String> headers = new LinkedList<>();
		headers.add("Sr.No.");
		headers.add("Tiles name");
		headers.add("Industry");
		headers.add("App Name");

		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		for (int i = 0; i < 4; i++) {
			sheet.setColumnWidth(i, 6000);
			Cell headerCell = header.createCell(i);
			headerCell.setCellValue(headers.get(i));
			headerCell.setCellStyle(headerStyle);
		}

		int tilesCount = Tiles.size();

		for (int rw = 1; rw <= tilesCount; rw++) {

			Row row = sheet.createRow(rw);
			Cell cell = row.createCell(0);
			cell.setCellValue(rw);
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue(tilesName().get(rw - 1));

			cell = row.createCell(2);
			cell.setCellValue(indName(actInds));
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue(appName(actApp));

		}

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
