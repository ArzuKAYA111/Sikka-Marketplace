package com.sikke.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

public class LoginPage_Copy extends CommonMethods {
//
////	
////public static String indName(String actInds) {
////	String ind = "";
////	for (int i = 0; i < Industries.size(); i++) {
////		if (Industries.get(i).getAttribute("value").equalsIgnoreCase(actInds)) {
////			ind = actInds;
////			break;
////		}
////	}
////	return ind;
////}
////
////
////public static String appName(String actApp) {	
////	String app = "";
////	for (int i = 0; i < AppTypes.size(); i++) {
////		if (AppTypes.get(i).getAttribute("value").equalsIgnoreCase(actApp)) {
////			app = actApp;
////			break;
////		}
////	}
////	return app;
////}
////
////
////
/////**
//// * This methods return the tiles
//// * @return
//// */
//////public static List<String> getTiles() {
//////	List<String> tiles = new ArrayList<>();
//////	int tilesCount = Tiles.size();
//////
//////	for (int i = 0; i < tilesCount; i++) {
//////		tiles.add(Tiles.get(i).getAttribute("data-name"));
//////	}
//////
//////	return tiles;
//////}
//////
//LinkedList<String> headers = new LinkedList<>();
//headers.add("Sr.No.");
//headers.add("Tiles name");
//headers.add("Industry");
//headers.add("App Name");
//
//
//sira no               tiles           intdustry     app type
//
//for(int i=0 ; i<4;i++) {
//	
//	
//	Map<headers.get(i), String > excel=new Map<>();
//	
//}
////
////
////
////
////
////
////
////
////
////
////
////	public static void createExel(String actInds,String actApp,String sheetName) throws IOException {
////		
////		File currDir = new File(".");
////		String path = currDir.getAbsolutePath();
////		String fileLocation = path.substring(0, path.length() - 1) + "/src/test/resources/testData/Task1.xlsx";
////		
////		Workbook workbook = new XSSFWorkbook();
////		Sheet sheet = workbook.createSheet(sheetName);
////		Row header = sheet.createRow(0);
////
////		CellStyle headerStyle = workbook.createCellStyle();
////		headerStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
////		headerStyle.setFillPattern(FillPatternType.DIAMONDS);
////
////		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
////		font.setFontName("Arial");
////		font.setFontHeightInPoints((short) 12);
////		font.setBold(true);
////		headerStyle.setFont(font);
////
////		LinkedList<String> headers = new LinkedList<>();
////		headers.add("Sr.No.");
////		headers.add("Tiles name");
////		headers.add("Industry");
////		headers.add("App Name");
////
////		CellStyle style = workbook.createCellStyle();
////		style.setWrapText(true);
////		
////		for (int i = 0; i < 4; i++) {
////			sheet.setColumnWidth(i, 6000);
////			Cell headerCell = header.createCell(i);
////			headerCell.setCellValue(headers.get(i));
////			headerCell.setCellStyle(headerStyle);
////		}
////
////		
////		int tilesCount = Tiles.size();
////
////		for (int rw = 1; rw <= tilesCount; rw++) {
////
////			Row row = sheet.createRow(rw);
////			Cell cell = row.createCell(0);
////			cell.setCellValue(rw);
////			cell.setCellStyle(style);
////
////			cell = row.createCell(1);
////			cell.setCellValue(getTiles().get(rw - 1));
////			cell.setCellStyle(style);
////
////			cell = row.createCell(2);
////			cell.setCellValue(indName( actInds));
////			cell.setCellStyle(style);
////
////			cell = row.createCell(3);
////			cell.setCellValue(appName(actApp));
////			cell.setCellStyle(style);
////
////		}
////	
////		FileOutputStream outputStream = new FileOutputStream(fileLocation);
////		workbook.write(outputStream);
////		workbook.close();
////	}
////	
////		
////public static void WriteExistingFile(String actInds,String actApp,String sheetName) throws IOException {
////
////		 String filePath=System.getProperty("user.dir")+"/src/test/resources/testData/Task1.xlsx";
////			FileInputStream fis=new FileInputStream(filePath);
////			
////		Workbook workbook = new XSSFWorkbook();
////		Sheet sheet = workbook.createSheet(sheetName);
////		Row header = sheet.createRow(0);
////
////		CellStyle headerStyle = workbook.createCellStyle();
////		headerStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
////		headerStyle.setFillPattern(FillPatternType.DIAMONDS);
////
////		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
////		font.setFontName("Arial");
////		font.setFontHeightInPoints((short) 12);
////		font.setBold(true);
////		headerStyle.setFont(font);
////
////		CellStyle style = workbook.createCellStyle();
////		style.setWrapText(true);
////		
////		int tilesCount = Tiles.size();
////
////		for (int rw = 1; rw <= tilesCount; rw++) {
////
////			Row row = sheet.createRow(rw);
////			Cell cell = row.createCell(0);
////			cell.setCellValue(rw);
////			cell.setCellStyle(style);
////
////			cell = row.createCell(1);
////			cell.setCellValue(getTiles().get(rw - 1));
////			cell.setCellStyle(style);
////
////			cell = row.createCell(2);
////			cell.setCellValue(indName( actInds));
////			cell.setCellStyle(style);
////
////			cell = row.createCell(3);
////			cell.setCellValue(appName(actApp));
////			cell.setCellStyle(style);
////
////		}
////	
////		FileOutputStream outputStream = new FileOutputStream(filePath);
////		workbook.write(outputStream);
////		workbook.close();
////	}
////	
////
////	
////	
////	
////	
////	
////	
////	
////	
////	
////	
////	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/**
//	 * This method select app	
//	 * @param expectApp
//	 */
//		
//		public static void selectApp (String expectApp) {
//		for(WebElement appN: AppTypes) {
//			String actualApp = appN.getText();
//			if(actualApp.equals(expectApp)) {
//				((WebElement) AppTypes).click();
//				break;
//			}
//		}
//		}
//		
//	
//		
//		/**
//		 * This method select the industry
//		 * @param expectInds
//		 */
//		public static void selectInd (String expectInds) {
//		for(WebElement indN: Industries) {
//			String actualInds = indN.getText();
//			if(actualInds.equals(expectInds)) {
//				indN.click();
//				break;
//			}
//		}
//		}
//	
	                                                                  
	
	
	

	
	
	
}
