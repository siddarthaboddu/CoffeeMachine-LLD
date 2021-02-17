package com.example.coffemachine.helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Helper class to parse and traverse JsonString and JsonObject
 * @author siddu
 *
 */
public class JsonHelper {
	
	/**
	 * parses json String to JsonObject
	 * @param jsonInput is a {@link String} which is json data
	 * @return {@link JSONObject} of {@code jsonInput}
	 */
	public Object getJsonData(String jsonInput) {
		JSONParser parser = new JSONParser();
		
		try {
			return parser.parse(jsonInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * traverse {@link JSONObject} with provided {@code fields}
	 * @param jsonObject is instance of {@link JSONObject}
	 * @param fields is a {@code varargs} which is list of nested fields to traverse
	 * @return
	 */
	public JSONObject getJSONObject(JSONObject jsonObject, String... fields) {
		
		for(String field : fields) {
			jsonObject = (JSONObject) jsonObject.get(field);
		}
		
		return jsonObject;
	}
}
