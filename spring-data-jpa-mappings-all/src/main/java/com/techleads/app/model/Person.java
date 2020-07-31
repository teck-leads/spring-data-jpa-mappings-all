package com.techleads.app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private Integer id;
	private String name;
	private String location;
	private Date birthDate;
}
