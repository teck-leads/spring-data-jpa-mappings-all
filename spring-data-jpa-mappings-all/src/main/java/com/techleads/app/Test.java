package com.techleads.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.techleads.app.model.Person;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons=new ArrayList<>();
		ResultSetExtractor<List<Person>> person=(rs)->{
			while (rs.next()) {
				Person p=new Person();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setLocation(rs.getString("LOCATION"));
				p.setBirthDate(rs.getTimestamp("BIRTH_DATE"));
				persons.add(p);
			}
			return persons;
			
		};

	}

}
