package com.learnbycoding.springHibername.service;

import java.util.List;

import com.learnbycoding.springHibername.model.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> findAllStudents();

	void deleteStudentByUniqueID(String uniqueID);

	Student findByUniqueID(String uniqueID);

	void updateStudent(Student student);
}
