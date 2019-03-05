package test.edu.xalead;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

import com.sdicons.json.helper.JSONMap;
import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.model.JSONValue;
import com.sdicons.json.parser.JSONParser;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import edu.xalead.xatu.util.JSONUtil;

public class TestJSON {
	@Test
	public void test1() {
		try {
			Address adr = new Address();
			adr.setBusiAddress("����");
			adr.setHomeAddress("����");
			adr.setPhone("1234324244");
			
			Student s = new Student();
			s.setId(1111);
			s.setName("����");
			s.setSex('��');
			s.setAddress(adr);
			
			Address adr1 = new Address();
			adr.setBusiAddress("����");
			adr.setHomeAddress("����");
			adr.setPhone("1234324244");
			
			Student s1 = new Student();
			s1.setId(1111);
			s1.setName("����");
			s1.setSex('��');
			s1.setAddress(adr1);
			
			JSONValue jsonValue = JSONMapper.toJSON(s);
			String jsonStr = jsonValue.render(true);
			String jsonStr1 = jsonValue.render(false);
			System.out.println(jsonStr);
			System.out.println(jsonStr1);
			
			Student[] ss = new Student[] {s,s1};
			
			System.out.println(JSONMapper.toJSON(ss).render(true));
//			
//			JSONUtil.toJson(ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			String jsonStr = "{\"address\":{\"busiAddress\":\"����\",\"homeAddress\":\"����\",\"phone\":\"1234324244\"},\"age\":0,\"id\":1111,\"name\":\"����\",\"sex\":\"��\"}";
			JSONValue jsonValue = new JSONParser(new StringReader(jsonStr)).nextValue();
			Student s = (Student)JSONMapper.toJava(jsonValue,Student.class);
			System.out.println(s.getName() + ":");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
