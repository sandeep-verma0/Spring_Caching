package com.learnbycoding.springHibername.dao;

import java.util.List;

import com.learnbycoding.springHibername.model.Student;

public interface StudentDao {

	void saveStudent(Student student);
	
	List<Student> findAllStudents();
	
	void deleteStudentByUniqueID(String uniqueID);
	
	Student findByUniqueID(String uniqueID);
	
	void updateStudent(Student student);
}
