package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BseDataService {

	@Autowired
	private BseDataRepo bseDataRepo;

	public BseData save(BseData data) {
		return bseDataRepo.save(data);
	}

	public List<BseData> findAll() {
		return bseDataRepo.findAll();
	}

	public List<BseData> getDataFromExcel() {

		List<BseData> listOfData = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("src/main/resources/BseData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				BseData bse = new BseData();
				bse.setsId(new Double(row.getCell(0).toString()).intValue());
				bse.setName(row.getCell(1).toString());
				bse.setAddress(row.getCell(2).toString());
				row.getCell(3).setCellType(1);
				//bse.setPhoneNo(row.getCell(3).toString());//Phone no is String
				bse.setPhoneNo(new Long(row.getCell(3).toString()));//Phone No is Long
				bseDataRepo.save(bse);
				listOfData.add(bse);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfData;
	}

}