package com.srivastava.dao;

public interface QueryConstants {
public static final String PERSON_INSERT_SQL = "insert into person (name,age, city) values(?,?,?)";
final String PERSON_SELECT_SQL = "select name , age , city from person";
String PERSON_COLUMN_NAME = "name";
String PERSON_COLUMN_AGE="age";
String PERSON_COLUMN_CITY = "city";
}
