package com.cloud.jeesite.core.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.cloud.jeesite.core.common.persistence.DataEntity;

/**
 * 学生管理Entity
 * @author Li
 * @version 2018-05-17
 */
public class SysStudent extends DataEntity<SysStudent> {
	
	private static final long serialVersionUID = 1L;
	private String classid;		// 所在班级
	private String masterId;		// 所在班级
	private String code;		// 学号
	private String name;		// 学生姓名
	private String age;		// 学生年龄
	private String gender;		// 性别
	private String hobby;		// 爱好
	private String parentName;		// 父母姓名
	private String phone;		// 联系方式
	private String address;		// 家庭住址
	private Date addtime;		// 添加时间
	private Date createTime;		// 创建时间
	private Date updateTime;		// 修改时间
	private String className;    //班级名称
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public SysStudent() {
		super();
	}

	public SysStudent(String id){
		super(id);
	}

	@Length(min=1, max=64, message="所在班级长度必须介于 1 和 64 之间")
	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}
	
	@Length(min=0, max=50, message="学号长度必须介于 0 和 50 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=50, message="学生姓名长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=3, message="学生年龄长度必须介于 0 和 3 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=3, message="性别长度必须介于 0 和 3 之间")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Length(min=0, max=500, message="爱好长度必须介于 0 和 500 之间")
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Length(min=0, max=50, message="父母姓名长度必须介于 0 和 50 之间")
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	@Length(min=0, max=50, message="联系方式长度必须介于 0 和 50 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=64, message="家庭住址长度必须介于 0 和 64 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}