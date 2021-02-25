package ru.quadrophenia.test.testshop.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public static String dateToStr(Date date) {
		String result = "";
		if (date != null)
			result = dateFormat.format(date);

		return result;
	}

	public static Date strToDate(String strDate) throws ParseException {
		return dateFormat.parse(strDate);
	}
}
