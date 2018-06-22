package com.cloud.jeesite.business.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.web.BaseController;
import com.cloud.jeesite.core.modules.sys.utils.DictUtils;
import com.cloud.jeesite.core.common.utils.StringUtils;
import com.cloud.jeesite.business.modules.cms.entity.Student;
import com.cloud.jeesite.business.modules.cms.service.StudentService;

@Controller
@RequestMapping(value = "${adminPath}/cms/student")
public class StudentController extends BaseController {

	@Autowired
	private StudentService studentService;
	
	@ModelAttribute
	public Student get(@RequestParam(required=false) String id) {
		Student entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = studentService.get(id);
		}
		if (entity == null){
			entity = new Student();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:student:view")
	@RequestMapping(value = {"list", ""})
	public String list(Student student, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Student> page = studentService.findPage(new Page<Student>(request, response), student); 
		model.addAttribute("page", page);
		return "modules/cms/studentList";
	}

	@RequiresPermissions("cms:student:view")
	@RequestMapping(value = "form")
	public String form(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/cms/studentForm";
	}

	@RequestMapping(value = "save")
	public String save(Student student, Model model, RedirectAttributes redirectAttributes) {
		studentService.update(student);
		addMessage(redirectAttributes, DictUtils.getDictLabel(student.getReContent(), "cms_student_statu", ""));
		return "redirect:"+Global.getAdminPath()+"/cms/student/?repage";
	}
	
	@RequiresPermissions("cms:student:edit")
	@RequestMapping(value = "delete")
	public String delete(Student student, RedirectAttributes redirectAttributes) {
		studentService.delete(student);
		addMessage(redirectAttributes, "删除招生成功");
		return "redirect:"+Global.getAdminPath()+"/cms/student/?repage";
	}
	
	@RequiresPermissions("cms:student:view")
	@RequestMapping(value = "inspect")
	public String inspect(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/cms/studentForm";
	}
	

}