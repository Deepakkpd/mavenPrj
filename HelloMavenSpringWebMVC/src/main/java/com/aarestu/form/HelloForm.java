package com.aarestu.form;

import java.util.List;

import com.aarestu.valueobject.CategoryPercentVO;
import com.aarestu.valueobject.EmailVO;
import com.aarestu.valueobject.HelloVO;

public class HelloForm {

	private HelloVO[] helloVO;
	private String totalAmt;
	private String dateOfExpend;
	private String errorMsg;
	private CategoryPercentVO categoryPercentVO;
	private String errorMsgDt;
	
	private List<String> testList;//
	private String testIndicator;//
	private List<EmailVO> dropList;//
	private String selectedDropList;//
	private String selectedTestList;//

	public String getSelectedDropList() {
		return selectedDropList;
	}

	public void setSelectedDropList(String selectedDropList) {
		this.selectedDropList = selectedDropList;
	}

	public String getSelectedTestList() {
		return selectedTestList;
	}

	public void setSelectedTestList(String selectedTestList) {
		this.selectedTestList = selectedTestList;
	}

	public List<EmailVO> getDropList() {
		return dropList;
	}

	public void setDropList(List<EmailVO> dropList) {
		this.dropList = dropList;
	}

	public String getTestIndicator() {
		return testIndicator;
	}

	public void setTestIndicator(String testIndicator) {
		this.testIndicator = testIndicator;
	}

	public List<String> getTestList() {
		return testList;
	}

	public void setTestList(List<String> testList) {
		this.testList = testList;
	}

	public String getErrorMsgDt() {
		return errorMsgDt;
	}

	public void setErrorMsgDt(String errorMsgDt) {
		this.errorMsgDt = errorMsgDt;
	}

	public CategoryPercentVO getCategoryPercentVO() {
		return categoryPercentVO;
	}

	public void setCategoryPercentVO(CategoryPercentVO categoryPercentVO) {
		this.categoryPercentVO = categoryPercentVO;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDateOfExpend() {
		return dateOfExpend;
	}

	public void setDateOfExpend(String dateOfExpend) {
		this.dateOfExpend = dateOfExpend;
	}

	public HelloVO[] getHelloVO() {
		return helloVO;
	}

	public void setHelloVO(HelloVO[] helloVO) {
		this.helloVO = helloVO;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	} 

//test 1	
}
