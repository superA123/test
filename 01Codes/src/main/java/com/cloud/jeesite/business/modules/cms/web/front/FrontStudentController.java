package com.cloud.jeesite.business.modules.cms.web.front;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.web.BaseController;
import com.cloud.jeesite.core.common.utils.StringUtils;
import com.cloud.jeesite.business.modules.cms.entity.Guestbook;
import com.cloud.jeesite.business.modules.cms.entity.Site;
import com.cloud.jeesite.business.modules.cms.entity.Student;
import com.cloud.jeesite.business.modules.cms.service.StudentService;
import com.cloud.jeesite.business.modules.cms.utils.CmsUtils;


@Controller
@RequestMapping(value = "${frontPath}/student")
public class FrontStudentController extends BaseController {

	@Autowired
	private StudentService studentService;
	
	/**
	 *招生
	 */
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String student(@RequestParam(required=false, defaultValue="1") Integer pageNo,
			@RequestParam(required=false, defaultValue="30") Integer pageSize, Model model) {
		Site site = CmsUtils.getSite(Site.defaultSiteId());
		model.addAttribute("site", site);
		
		Page<Student> page = new Page<Student>(pageNo, pageSize);
		Student student = new Student();
		student.setDelFlag(Guestbook.DEL_FLAG_NORMAL);
		page = studentService.findPage(page, student);
		model.addAttribute("page", page);
		return "modules/cms/front/themes/"+site.getTheme()+"/frontstudent";
	}
	/**
	 * 保存招生信息
	 */
	@RequestMapping(value = "", method=RequestMethod.POST)
	public String studentSave(Student student, String validateCode, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		student.setCreateDate(new Date());
		student.setDelFlag("0");
		studentService.save(student);
		addMessage(redirectAttributes, "提交成功，请耐心等待老师与您的联系！");
		return "redirect:"+Global.getFrontPath()+"/student";
	}

}