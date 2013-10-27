package com.dandelion.memberapp.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.dandelion.memberapp.exception.MemberAppException;

public class JSONUtilities {
	public static JSONObject getErrorJSON(MemberAppException ex) {
		try {
			JSONObject json = new JSONObject();
			json.put("errorCode", ex.getErrorCode());
			json.put("errorMessage", ex.getMessage());
			return json;
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
