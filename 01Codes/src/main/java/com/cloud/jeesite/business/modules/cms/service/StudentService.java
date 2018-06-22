package com.cloud.jeesite.business.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.service.CrudService;
import com.cloud.jeesite.business.modules.cms.entity.Student;
import com.cloud.jeesite.business.modules.cms.dao.StudentDao;


@Service
@Transactional(readOnly = true)
public class StudentService extends CrudService<StudentDao, Student> {

	public Student get(String id) {
		return super.get(id);
	}
	
	public List<Student> findList(Student student) {
		return super.findList(student);
	}
	
	public Page<Student> findPage(Page<Student> page, Student student) {
		return super.findPage(page, student);
	}
	
	@Transactional(readOnly = false)
	public void save(Student student) {
		super.save(student);
	}
	
	@Transactional(readOnly = false)
	public void delete(Student student) {
		super.delete(student);
	}
	@Transactional(readOnly = false)
	public void update(Student student) {
		dao.update(student);
	}
}