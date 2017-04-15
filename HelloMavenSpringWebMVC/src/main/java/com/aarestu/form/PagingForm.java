package com.aarestu.form;

import java.util.ArrayList;
import java.util.List;

import com.aarestu.valueobject.UserVO;

public class PagingForm {
	List<UserVO> userList = new ArrayList<UserVO>();
	private int pageId;
	private List<Integer> pageNoList;
	private int selectedPageNo;

	public int getSelectedPageNo() {
		return selectedPageNo;
	}

	public void setSelectedPageNo(int selectedPageNo) {
		this.selectedPageNo = selectedPageNo;
	}

	public List<Integer> getPageNoList() {
		return pageNoList;
	}

	public void setPageNoList(List<Integer> pageNoList) {
		this.pageNoList = pageNoList;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public List<UserVO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}

}
