package selab.swv.project.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import selab.swv.project.dto.ProjectVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "selab.swv.mapper.projectMapper";
		
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String status(Locale locale, Model model) throws Exception{
		
		logger.info("project status");
		
		List<ProjectVO> projectVO = sqlSession.selectList(Namespace + ".selectProject");
		
		
		model.addAttribute("projectList", projectVO);
		
		return "status";
	}	
}
