package com.aarestu.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aarestu.form.HelloForm;
import com.aarestu.manager.Manager;
import com.aarestu.valueobject.CategoryPercentVO;
import com.aarestu.valueobject.EmailVO;
import com.aarestu.valueobject.Employee;
import com.aarestu.valueobject.HelloVO;
import com.aarestu.valueobject.UserVO;
import com.arrestu.util.CommonUtil;

@Controller
@SessionAttributes({"helloForm"})
@RequestMapping(value = "/admin")
public class ActualController {
	private static org.slf4j.Logger logger  =  LoggerFactory.getLogger(ActualController.class);
	
	@Autowired
	Manager manager;
	
	@RequestMapping(value = "/test")//,method = RequestMethod.GET
	public ModelAndView template1() {
		ModelAndView modelAndView = new ModelAndView();
		HelloForm helloForm = new HelloForm();
		modelAndView.addObject("helloForm", helloForm);
		modelAndView.setViewName("helloNew");
		return modelAndView;
	}
	
	@RequestMapping(value = "/result")//,method = RequestMethod.POST
	public String result(@ModelAttribute("helloForm") HelloForm helloForm) {
		logger.info("Entering /result");
		logger.info("helloForm.getHelloVO()::"+helloForm.getHelloVO()[0]);
		Double totAmt = manager.calculateTotal(helloForm.getHelloVO());
		logger.info("totAmt::"+totAmt);
		helloForm.setTotalAmt(totAmt.toString());
		return "helloNew";
	}
	
	@RequestMapping(value = "/itemDtlInsert")//,method = RequestMethod.POST
	public String insertItemDetails(@ModelAttribute("helloForm") HelloForm helloForm) throws Exception {
		logger.info("Entering /itemDtlInsert");
		logger.info("helloForm.getHelloVO()::"+helloForm.getHelloVO()[0]);
		HelloVO[] helloVO = helloForm.getHelloVO();
		int size = helloVO.length;
		boolean errIndc = false;
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if (helloVO[i].isCheckIndicator()) {
				if(CommonUtil.isEmpty(helloVO[i].getName()) || null == helloVO[i].getPrice() || 
						CommonUtil.isEmpty(helloVO[i].getCategory()) ){
					errIndc = true;
					helloVO[i].setErrIndicator(true);
					logger.info("inside true"+helloVO[i]);
				}else{
					errIndc = false;
					helloVO[i].setErrIndicator(false);
					logger.info("inside false"+helloVO[i]);
					index.add(i);
				}
			}
		}
		if(!CommonUtil.isEmpty(helloForm.getDateOfExpend())){
		helloForm.setErrorMsgDt(null);
		if(!errIndc){
		 manager.insertItemDetails(helloVO,helloForm.getDateOfExpend());
		 helloForm.setErrorMsg(null);
		}else{
			helloForm.setErrorMsg("* All fields of the checked rows are Mandatory");
		}
		for (Integer integer : index) {
			helloVO[integer]=null;
		}
		
		 helloForm.setHelloVO(helloVO);
		}else{
			helloForm.setErrorMsgDt("Please enter the date.");
		}
		return "helloNew";
	}
	
	@RequestMapping(value = "/ins")//,method = RequestMethod.GET
	public ModelAndView insrt() {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = new Employee();
		manager.insertEmployee(employee);
		
		HelloForm helloForm3 = new HelloForm();
		modelAndView.addObject("helloForm2", helloForm3);
		modelAndView.setViewName("test2");
		return modelAndView;
	}
	@RequestMapping(value = "/team")//,method = RequestMethod.GET
	public ModelAndView teams() {
		ModelAndView modelAndView = new ModelAndView();
		HelloForm helloForm2 = new HelloForm();
		modelAndView.addObject("helloForm2", helloForm2);
		modelAndView.setViewName("Team");
		return modelAndView;
	}
	
	@RequestMapping(value = "/dash")//,method = RequestMethod.GET
	public ModelAndView dashbrd() {
		ModelAndView modelAndView = new ModelAndView();
		HelloForm helloForm = new HelloForm();
		CategoryPercentVO categoryPercentVO =  manager.calculatStat();
		helloForm.setCategoryPercentVO(categoryPercentVO);
		modelAndView.addObject("helloForm", helloForm);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}
	
	@RequestMapping(value = "/statcalc")//,method = RequestMethod.POST
	public String statCalculation(@ModelAttribute("helloForm") HelloForm helloForm)  {
		logger.info("Entering /statcalc");
		return "dashboard";
	}
	
	@RequestMapping(value = "/search")//,method = RequestMethod.GET
	public ModelAndView search() {
		ModelAndView modelAndView = new ModelAndView();
		//HelloForm helloForm = new HelloForm();
		//modelAndView.addObject("helloForm", helloForm);
		modelAndView.setViewName("SearchWithAjax");
		return modelAndView;
	}
	
	@RequestMapping(value = "/searchItem")//,method = RequestMethod.POST
	public @ResponseBody List<HelloVO> serachItemByAjax(@RequestParam("CHARS") String chars)  {
		logger.info("Entering /statcalc");
		return manager.fetchItemNameAjax(chars);
	}
	
	@RequestMapping(value = "/emailSearch")//,method = RequestMethod.POST
	public @ResponseBody List<EmailVO> emailAjax(@RequestParam("EMAIL") String email,@ModelAttribute("helloForm") HelloForm helloForm)  {
		logger.info("Entering /emailSearch");
		logger.debug("helloForm.getSelectedDropList()::"+helloForm.getSelectedDropList());
		helloForm.setSelectedDropList("F10_FV2");
		logger.debug("AFTER helloForm.getSelectedDropList()::"+helloForm.getSelectedDropList());
		return manager.fetchEmailID(email);
	}
	
	@RequestMapping(value = "/email")//,method = RequestMethod.POST
	public String email(@ModelAttribute("helloForm") HelloForm helloForm)  {
		logger.info("Entering /email");
		
		List<EmailVO> lst = new ArrayList<EmailVO>();
		EmailVO emailVO = new EmailVO();
		emailVO.setId("F10_FV1");
		emailVO.setEmailId("Deal");
		lst.add(emailVO);
		EmailVO emailVO1 = new EmailVO();
		emailVO1.setId("F10_FV2");
		emailVO1.setEmailId("Across Deal");
		lst.add(emailVO1);
		helloForm.setDropList(lst);
		
		helloForm.setSelectedDropList("F10_FV1");
		
		List<String> tmp = new ArrayList<String>();
		tmp.add("choice 1");
		tmp.add("choice 2");
		tmp.add("choice 3");
		helloForm.setTestList(tmp);
		
		return "EmailAjaxDropdown";
	}
}
