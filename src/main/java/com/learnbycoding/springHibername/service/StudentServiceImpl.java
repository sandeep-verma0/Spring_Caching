package com.learnbycoding.springHibername.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnbycoding.springHibername.dao.StudentDao;
import com.learnbycoding.springHibername.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	

	@Autowired
	private StudentDao dao;
	
	@Override
	@Cacheable("studentCache")
	public List<Student> findAllStudents() {
		System.out.println("Called .." + " findAllStudents()" );
		return dao.findAllStudents();
	}

	@Override
	@CacheEvict("studentCache")
	//Delete studentCache for each delete
	public void deleteStudentByUniqueID(String uniqueID) {
		System.out.println("Called .." + " deleteStudentByUniqueID()" );
		dao.deleteStudentByUniqueID(uniqueID);
	}

	@Override
	@Cacheable("studentCache")
	public Student findByUniqueID(String uniqueID) {
		System.out.println("Called .." + " findByUniqueID()" );
	    return dao.findByUniqueID(uniqueID);
	}

	@Override
	@CachePut("studentCache")
	//Update studentCache for each update
	public void updateStudent(Student student) {
		dao.updateStudent(student);	
	}

	@Override
	@CachePut("studentCache")
	//Update studentCache for each call to save
	public void saveStudent(Student student) {
		System.out.println("Called .." + " saveStudent()" );
		dao.saveStudent(student);
	}
}
