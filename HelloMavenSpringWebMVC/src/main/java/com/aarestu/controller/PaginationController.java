package com.aarestu.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aarestu.form.HelloForm;
import com.aarestu.form.PagingForm;
import com.aarestu.manager.Manager;
import com.aarestu.valueobject.UserVO;
import com.arrestu.util.CommonUtil;

@Controller
@SessionAttributes({ "pagingForm" })
public class PaginationController {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaginationController.class);

	@Autowired
	Manager manager;

	@RequestMapping(value = "/userPagination")
	public ModelAndView template1() {
		ModelAndView modelAndView = new ModelAndView();
		PagingForm pagingForm = new PagingForm();
		int total = 5; // no. of rows to be displayed ie. page limit
		
		//when the page loads for the first time
		List<UserVO> userList = manager.fetchUserList(pagingForm.getSelectedPageNo(), total);
		pagingForm.setUserList(userList);

		int tot = manager.fetchUserListCount();// to get the total size of the list
		float ftot = tot;
		float ftotal = total;
		float f = ftot / ftotal;
		logger.debug("f:" + f);
		logger.debug("even-true/odd-false::" + (ftot % ftotal == 0));
		if (ftot % ftotal != 0) {
			f = f + 1;//if its 4.2 then the size has to be 5
		}
		int finalCount = (int) f;// to get 5 from 5.2
		logger.debug("final value: " + finalCount);

		List<Integer> pageNoList = CommonUtil.getPageNoList(finalCount); // to get the page numbers as a list
		pagingForm.setPageNoList(pageNoList);
		modelAndView.addObject("pagingForm", pagingForm);
		modelAndView.setViewName("Paginaton");
		return modelAndView;
	}

	@RequestMapping(value = "/selectedPage")
	// ,method = RequestMethod.POST
	public String result(@ModelAttribute("pagingForm") PagingForm pagingForm) {
		logger.info("Entering /selectedPage");

		int pageid = pagingForm.getSelectedPageNo();
		int total = 5; // no. of rows to be displayed ie. page limit

		if (pageid == 1) {
			pageid = 0;
		} else {
			pageid = (pageid - 1) * total;
		}
		List<UserVO> userList = manager.fetchUserList(pageid, total);
		pagingForm.setUserList(userList);

		return "Paginaton";
	}

}
