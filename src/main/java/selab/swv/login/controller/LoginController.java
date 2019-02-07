package selab.swv.login.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "selab.swv.mapper.loginMapper";
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() throws Exception{
		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("redmineid") String id, Locale locale, Model model) throws Exception{
		
		logger.info("login");
		
		int result = -1;
		String forward="login_fail"; // Login Fail page
		result = sqlSession.selectOne(Namespace + ".selectLogin", id);
		logger.info("result --> " + result);
		
		if(result ==1) {
			forward = "main";
		}
		
		return forward;
	}
		
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model) throws Exception{
			
		logger.info("logout");
			
		return "logout";
	}
	
}
