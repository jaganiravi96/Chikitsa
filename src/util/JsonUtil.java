package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static ObjectMapper objectmapper;
	static{
		objectmapper = new ObjectMapper();
	}
	public static String convertToJson(Object obj) throws JsonProcessingException{
		String jsonString="";
		jsonString = objectmapper.writeValueAsString(obj);
		return jsonString;
	}
}
