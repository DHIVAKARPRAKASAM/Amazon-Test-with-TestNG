package com.amazon.qa.util;

import java.util.ArrayList;


public class ExcelImport{
	static  Xls_Reader reader;
	public static ArrayList<Object[]>  DataFromExcel() {
		ArrayList<Object[]> lst=new ArrayList<Object[]>();
		reader=new Xls_Reader("C:\\Users\\dhiva\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\amazon\\qa\\testdata\\testexcel.xlsx");
		
	

		for(int rowNum=2;rowNum<=reader.getRowCount("test");rowNum++)
		{
			String name=reader.getCellData("test","name", rowNum);
			
			String mobile=reader.getCellData("test","mobile", rowNum);
			
			String email=reader.getCellData("test","mail", rowNum);
			
			String password=reader.getCellData("test","password", rowNum);
			
			Object ob[] = {name,mobile,email,password};
			lst.add(ob);
			
		}
		return lst;
	
		 
	}
	
	
}