package edu.xalead.xatu.util;

import java.io.StringReader;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.parser.JSONParser;

import edu.xalead.xatu.vo.GamePackage;

public class JSONUtil {
	public static String toJson(Object o) {
		String str = null;
		try {
			str = JSONMapper.toJSON(o).render(false);
		} catch (MapperException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static Object toJava(String jsonStr) {
		Object o = null;
		try {
			o = JSONMapper.toJava(new JSONParser(new StringReader(jsonStr)).nextValue(),GamePackage.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return o;
	}
}
