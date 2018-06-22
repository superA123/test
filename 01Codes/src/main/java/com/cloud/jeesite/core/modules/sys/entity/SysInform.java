package com.cloud.jeesite.core.modules.sys.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.cloud.jeesite.core.common.persistence.DataEntity;

/**
 * 通知公告Entity
 * @author Li
 * @version 2018-04-26
 */
public class SysInform extends DataEntity<SysInform> {
	
	private static final long serialVersionUID = 1L;
	private Date addtime;		// addtime
	private String title;		// title
	private String content;		// content
	private String publisher;		// publisher
	
	public SysInform() {
		super();
	}

	public SysInform(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="addtime不能为空")
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	@Length(min=1, max=255, message="title长度必须介于 1 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=255, message="publisher长度必须介于 1 和 255 之间")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}