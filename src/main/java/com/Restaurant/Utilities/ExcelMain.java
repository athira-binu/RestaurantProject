package com.Restaurant.Utilities;

import java.io.IOException;

import com.Restaurant.BaseClass.BaseClass;

public class ExcelMain extends BaseClass{

	public static void main(String[] args) throws IOException {
		String s = ExcelRead.readStringData(1, 0);
		System.out.println(s);
		String n = ExcelRead.readIntegerData(1, 1);
		System.out.println(n);

	}

}
