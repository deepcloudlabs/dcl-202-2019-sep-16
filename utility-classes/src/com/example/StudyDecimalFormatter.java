package com.example;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyDecimalFormatter {

	public static void main(String[] args) {
		double myMoney = 12_345.67;
		Locale tr = new Locale("tr", "TR");
		DecimalFormat df = (DecimalFormat)
				DecimalFormat.getCurrencyInstance(tr);
		DecimalFormatSymbols dfs= DecimalFormatSymbols.getInstance(tr);
		dfs.setCurrencySymbol("\u20BA");
		df.setDecimalFormatSymbols(dfs);
		System.out.println(df.format(myMoney));
	}

}






