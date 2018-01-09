package org.oraclejava.spring.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

	private static ApplicationContext context;
	private static JdbcTemplate jdbcTemplate;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = context.getBean(JdbcTemplate.class);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from members");
		
		for(Map<String, Object> map : list) {
			String memberid = map.get("memberid").toString();
			String password = map.get("passwd").toString();
			
			System.out.println(memberid + "," + password);
		}
	}
}

