package com.sikke.pages;
import java.io.File;
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

import com.sikke.utilities.CommonMethods;

public class LoginPage extends CommonMethods {

	@FindBy(xpath = "//input[@value='dental']")
	public static WebElement DentalCheckBox;

	@FindBy(xpath = "//input[@value='business performance management']")
	public static WebElement BusPerfCheckBox;

	@FindBy(xpath = "//div[@id='ddlSort1']//label/input")
	public static List<WebElement> Industries;

	@FindBy(xpath = "//div[@id='btnsearchCategory']//label/input")
	public static List<WebElement> AppTypes;

	@FindBy(xpath = "//div[@id='divapps']//a")
	public static List<WebElement> Tiles;
	
	@FindBy(xpath = "//input[@value='patient marketing']")
	public static WebElement PetMarkCheckBox;
	
	
	@FindBy(xpath = "//input[@value='payments']")
	public static WebElement PAyCheckBox;	
	
	@FindBy(xpath = "//input[@value='manufacturers/labs']")
	public static WebElement ManfactCheckBox;	
	
	
	@FindBy(xpath = "//input[@value='revenue cycle']")
	public static WebElement RevnCycCheckBox;	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	

	
	public static void clickIndsAndApp(String actInds,String actApp,String sheetName) throws IOException {
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
				System.out.println("Tiles size "+tilesName().size());
				createExel(actInds, actApp, sheetName);
				
				break;
			}
		}
	}
	
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
 * This methods return the tiles
 * @return
 */
public static List<String> tilesName() {
	List<String> tiles = new ArrayList<>();
	int tilesCount = Tiles.size();

	for (int i = 0; i < tilesCount; i++) {
		tiles.add(Tiles.get(i).getAttribute("data-name"));
	}

	return tiles;
}

	public static void createExel(String actInds,String actApp,String sheetName) throws IOException {
	
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + "/src/test/resources/testData/Task1.xlsx";
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
		headerStyle.setFillPattern(FillPatternType.DIAMONDS);

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
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(indName( actInds));
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue(appName(actApp));
			cell.setCellStyle(style);

		}
	
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();
		
	}
	

	
}
