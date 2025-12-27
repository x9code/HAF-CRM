package com.vtigercrm.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.vtigercrm.constants.FrameworkConstants;

public class FileUtility {
	
	public String readCommonData(String key) throws IOException {
		FileInputStream file = new FileInputStream(FrameworkConstants.CONFIG_PATH);
		Properties p = new Properties();
		p.load(file);
		if(key.equals("url")) {
			return p.getProperty(key);
		}else if(key.equals("username")) {
			return p.getProperty(key);	
		}else if(key.equals("password")) {
			return p.getProperty(key);
		}else if(key.equals("browser")){
			return p.getProperty(key);
		}else {
			return "invalid key";
		}
		}
	public String excelReader(String sheet, int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(FrameworkConstants.EXCEL_PATH);
        Workbook wb  = WorkbookFactory.create(file);
        Sheet sh = wb.getSheet(sheet);
        String value = sh.getRow(row).getCell(col).toString();
        return value;
	}

}
