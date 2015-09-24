package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Utilities {
	
	public static int lastCapitalIndex(String input) {
		Pattern pat = Pattern.compile("[A-Z][^A-Z]*$");
		Matcher match = pat.matcher(input);

		int lastCapitalIndex = -1;
		if(match.find())
		{
		    lastCapitalIndex = match.start();
		}
		return lastCapitalIndex;
	}

}
