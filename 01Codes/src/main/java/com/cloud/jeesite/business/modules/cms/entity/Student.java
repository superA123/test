package com.cloud.jeesite.business.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.cloud.jeesite.core.common.persistence.DataEntity;


public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 班级分类
	private String stuname;		// 报名学生
	private String name;		// 家长姓名
	private String email;		// 邮箱
	private String phone;		// 电话
	private String address;		// 家庭住址
	private String content;		// 学生简介
	private String reUserId;		// 审核人
	private Date reDate;		// 审核时间
	private String reContent;		// 审核
	
	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Student() {
		super();
	}

	public Student(String id){
		this();
		this.id = id;
	}

	@Length(min=1, max=1, message="班级分类长度必须介于 1 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=1, max=100, message="报名学生长度必须介于 1 和 100 之间")
	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	
	@Length(min=1, max=100, message="家长姓名长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=100, message="邮箱长度必须介于 1 和 100 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=1, max=100, message="电话长度必须介于 1 和 100 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=1, max=100, message="家庭住址长度必须介于 1 和 100 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=1, max=100, message="学生简介长度必须介于 1 和 100 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=64, message="审核人长度必须介于 0 和 64 之间")
	public String getReUserId() {
		return reUserId;
	}

	public void setReUserId(String reUserId) {
		this.reUserId = reUserId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	
	@Length(min=0, max=100, message="回复内容长度必须介于 0 和 100 之间")
	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	
}