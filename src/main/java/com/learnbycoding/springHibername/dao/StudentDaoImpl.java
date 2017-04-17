package com.learnbycoding.springHibername.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.learnbycoding.springHibername.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao implements StudentDao{

	@Override
	//Equivalent to 'Insert into Student ...'
	public void saveStudent(Student student) {
		persist(student);
	}

	@Override
	@SuppressWarnings("unchecked")
	//Equivalent to 'select * from Students'
	
	public List<Student> findAllStudents() {
		Criteria criteria= getSession().createCriteria(Student.class);
		return ((List<Student>) criteria.list());
	}

	@Override
	//Equivalent to 'delete from student where uniqueID='someID''
	public void deleteStudentByUniqueID(String uniqueID) {
		Query query = getSession().createQuery("delete from Student where uniqueID = :uniqueID");
		query.setString("uniqueID",uniqueID);
        query.executeUpdate();
	}

	@Override
	//Equivalent to 'select from student where uniqueID='someID''
	@Cacheable("studentCache")
	public Student findByUniqueID(String uniqueID) {
		Criteria criteria = getSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("uniqueID",uniqueID));
		return (Student) criteria.uniqueResult();
	}

	@Override
	//Equivalent to 'update student where id='someID''
	public void updateStudent(Student student) {
		getSession().update(student);
	}
}
