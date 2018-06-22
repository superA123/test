package com.cloud.jeesite.core.modules.sys.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.persistence.TreeEntity;
import com.cloud.jeesite.core.common.utils.StringUtils;

/**
 * 机构Entity
 * @author Clark
 * @version 2015-12-10
 */
public class Office extends TreeEntity<Office> {

	private static final long serialVersionUID = 1L;
	private String code; 	// 机构编码
	private String type; 	// 机构类型（1：总公司；2：分公司）
	private String address; // 联系地址
	private String zipCode; // 邮政编码
	private String master; 	// 负责人
	private String phone; 	// 电话
	private String fax; 	// 传真
	private String email; 	// 邮箱
	private String useable;//是否可用
	private List<String> childDeptList;//快速添加子部门
	
	public Office(){
		super();
//		this.sort = 30;
		this.type = "2";
	}

	public Office(String id){
		super(id);
	}
	
	public List<String> getChildDeptList() {
		return childDeptList;
	}

	public void setChildDeptList(List<String> childDeptList) {
		this.childDeptList = childDeptList;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

//	@JsonBackReference
//	@NotNull
	public Office getParent() {
		return parent;
	}

	public void setParent(Office parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min=0, max=255)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Length(min=0, max=6)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Length(min=0, max=5)
	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Length(min=0, max=200)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min=0, max=200)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Length(min=0, max=200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(min=0, max=8)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @author Clark
	 * @version 2015年12月11日
	 * 
	 * 是否为顶级机构
	 * @return
	 */
	public boolean isRoot() {
		String topId = Global.getConfig("top.id");

		if (StringUtils.isNotBlank(topId) && topId.equals(this.id)) {
			return true;
		}
		return false;
	}

//	public String getParentId() {
//		return parent != null && parent.getId() != null ? parent.getId() : "0";
//	}
	
//	@Override
//	public String toString() {
//		return name;
//	}
}