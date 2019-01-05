package com.cct.jdbc.ddl;

public interface DbQueryConstants {	
	public static final String TABLE_NAME = "Tasks";
	public static final String DATABASE_NAME = "vkgtkyml";

	public static final String USE_DATABASE_QUERY = "USE vkgtkyml";

	// CREATE DDL COMMAND
	public static final String CREATE_DATABASE_QUERY = "CREATE DATABASE IF NOT EXISTS tutorialDb;";
	//public static final String CREATE_TABLE_QUERY = "CREATE TABLE tasks (id INT(11) NOT NULL AUTO_INCREMENT, emp_fname VARCHAR(20) DEFAULT NULL, emp_lname VARCHAR(20) DEFAULT NULL, PRIMARY KEY (emp_id));";
	public static final String CREATE_TABLE_QUERY_TASKS = "CREATE TABLE Tasks	("
			+ "taskid character varying NOT NULL,"
			+ "flowJoinURL character varying NOT NULL,"
			+ "flowStateID character varying,"
			+ "taskName  character varying,"
			+ "taskDescription  character varying,"
			+ "taskType  character varying,"
			+ "taskCategory  character varying,"			
			+ "referenceNumber character varying,"
			+ "status character varying,"	
			+ "assignedTo character varying,"
			+ "createdBy character varying,"
			+ "lastModifiedBy character varying,"
			+ "createdDate timestamp with time zone DEFAULT now(),"
			+ "updatedDate timestamp with time zone,"
			+ "CONSTRAINT pk_tasks PRIMARY KEY (taskid));";

	public static final String CREATE_TABLE_QUERY_TASKTYPES = "CREATE TABLE TaskTypes	("
			+ "taskid character varying NOT NULL,"
			+ "flowJoinURL character varying NOT NULL,"
			+ "flowStateID character varying,"
			+ "taskName  character varying,"
			+ "taskDescription  character varying,"
			+ "taskType  character varying,"
			+ "taskCategory  character varying,"			
			+ "referenceNumber character varying,"
			+ "status character varying,"	
			+ "assignedTo character varying,"
			+ "createdBy character varying,"
			+ "lastModifiedBy character varying,"
			+ "createdDate timestamp with time zone DEFAULT now(),"
			+ "updatedDate timestamp with time zone,"
			+ "CONSTRAINT pk_tasks PRIMARY KEY (taskid));";

	
	// ALTER DDL COMMAND
	public static final String ALTER_TABLE_QUERY = "ALTER TABLE employee ADD COLUMN  emp_joining_date VARCHAR(20) DEFAULT NULL;";
	public static final String ALTER_TABLE_WITH_AFTER_CLAUSE_QUERY = "ALTER TABLE employee ADD COLUMN  emp_dob date NULL AFTER  emp_lname;";

	// DROP DDL COMMAND
	public static final String DROP_TABLE = "DROP TABLE Tasks";
	public static final String DROP_DATABASE = "DROP DATABASE tutorialDb;";
	public static final String DROP_COLUMN = "ALTER TABLE employee DROP COLUMN emp_lname;";
}