package com.aarestu.form;

import com.aarestu.valueobject.CategoryPercentVO;
import com.aarestu.valueobject.HelloVO;

public class HelloForm {

	private HelloVO[] helloVO;
	private String totalAmt;
	private String dateOfExpend;
	private String errorMsg;
	private CategoryPercentVO categoryPercentVO;
	private String errorMsgDt;

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

	
}
