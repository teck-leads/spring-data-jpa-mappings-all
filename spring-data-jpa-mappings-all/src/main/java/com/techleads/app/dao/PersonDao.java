package com.techleads.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.techleads.app.model.Person;

@Repository
public class PersonDao {

	private static String INSERT_PERSON = "INSERT INTO PERSON ( ID , NAME , LOCATION , BIRTH_DATE ) VALUES ( ?,?, ?,? )";
	private static String UPDATE_PERSON = "UPDATE PERSON SET NAME=? , LOCATION =?, BIRTH_DATE=? WHERE ID=?";
	private static String FIND_ALL="SELECT ID ,NAME ,LOCATION ,BIRTH_DATE  FROM PERSON ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		List<Person> persons = jdbcTemplate.query(FIND_ALL,
				new BeanPropertyRowMapper<>(Person.class));
		return persons;
	}

	public Person findById(Integer id) {
		Person person = jdbcTemplate.queryForObject("SELECT ID ,NAME ,LOCATION ,BIRTH_DATE  FROM PERSON WHERE ID=?",
				new Object[] { id }, new BeanPropertyRowMapper<>(Person.class));
		return person;
	}

	public int deleteById(Integer id) {
		int updateCount = jdbcTemplate.update("DELETE FROM PERSON WHERE ID=?", new Object[] { id });
		return updateCount;
	}

	public int save(Person person) {
		Object[] params = { person.getId(), person.getName(), person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()) };
		int updateCount = jdbcTemplate.update(INSERT_PERSON, params);
		return updateCount;
	}
	
	public int updatePerson(Person person) {
		Object[] params = {person.getName(), person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()), person.getId() };
		int updateCount = jdbcTemplate.update(UPDATE_PERSON, params);
		return updateCount;
	}
	
	public List<Person> findAllRowMapper() {
		return jdbcTemplate.query(FIND_ALL, new Object[] {}, new ResultSetExtractor<List<Person>>() {
			 List<Person> persons=new ArrayList<>();
			@Override
			public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Person p=new Person();
					p.setId(rs.getInt("ID"));
					p.setName(rs.getString("NAME"));
					p.setLocation(rs.getString("LOCATION"));
					p.setBirthDate(rs.getTimestamp("BIRTH_DATE"));
					persons.add(p);
				}
				return persons;
			}
		});
	}
	
	public List<Person> findAllRowMapperLamda() {
		 List<Person> persons=new ArrayList<>();
		
		return jdbcTemplate.query(FIND_ALL, new Object[] {},(rs)->{
			while (rs.next()) {
				Person p=new Person();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setLocation(rs.getString("LOCATION"));
				p.setBirthDate(rs.getTimestamp("BIRTH_DATE"));
				persons.add(p);
			}
			return persons;
			
		} );
	}

}
