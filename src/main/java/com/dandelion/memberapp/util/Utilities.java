package com.dandelion.memberapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
	public static boolean checkEmailFormat(String email) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.find();
	}
}
