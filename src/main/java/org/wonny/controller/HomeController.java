package org.wonny.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wonny.domain.MemberVO;
import org.wonny.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, Model model) throws Exception{
		HttpSession session = req.getSession();
		model.addAttribute("list", service.listAll());
		return "home";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createGET(HttpServletRequest req) throws Exception{
		return "create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPOST(MemberVO vo) throws Exception{
		String phoneRegex = "[0-9]*-[0-9]*-[0-9]*";
		String emailRegex =  "^[0-9a-zA-Z_\\-]+@[0-9a-zA-Z_-]+(\\.[0-9a-zA-Z_\\-]+)*$";
		
		Pattern phonePTN = Pattern.compile(phoneRegex);
		Matcher phonematch = phonePTN.matcher(vo.getPhone());
		Pattern emailPTN = Pattern.compile(emailRegex);
		Matcher emailmatch = emailPTN.matcher(vo.getEmail());
		
		List<MemberVO> memberlist = service.listAll();
		
		boolean checkNo = true;
		for(MemberVO member : memberlist){
			if(vo.getMemberNo() == member.getMemberNo()){
				checkNo = false;
			}
		}
		
		if(phonematch.find() && emailmatch.find() && checkNo){
			service.create(vo);
			return "redirect:/";
		}else{
			return "redirect:/fail";
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGET(@RequestParam("id")int id, Model model) throws Exception{
		model.addAttribute("member", service.read(id));
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(MemberVO vo) throws Exception{
		String phoneRegex = "[0-9]*-[0-9]*-[0-9]*";
		String emailRegex =  "^[0-9a-zA-Z_\\-]+@[0-9a-zA-Z_-]+(\\.[0-9a-zA-Z_\\-]+)*$";
		
		Pattern phonePTN = Pattern.compile(phoneRegex);
		Matcher phonematch = phonePTN.matcher(vo.getPhone());
		Pattern emailPTN = Pattern.compile(emailRegex);
		Matcher emailmatch = emailPTN.matcher(vo.getEmail());
		
		
		if(phonematch.find() && emailmatch.find()){
			service.update(vo);
			return "redirect:/";
		}else{
			return "redirect:/fail";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id")int id)throws Exception{
		service.delete(id);
		return "redirect:/";
	}
	@RequestMapping(value = "/fail", method = RequestMethod.GET)
	public String failGET(HttpServletRequest req) throws Exception{
		return "fail";
	}


}
