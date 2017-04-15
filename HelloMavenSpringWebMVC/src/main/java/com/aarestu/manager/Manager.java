package com.aarestu.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarestu.dataAccessor.AarestuDataAccessor;
import com.aarestu.valueobject.CategoryPercentVO;
import com.aarestu.valueobject.CategoryVO;
import com.aarestu.valueobject.EmailVO;
import com.aarestu.valueobject.Employee;
import com.aarestu.valueobject.HelloVO;
import com.aarestu.valueobject.UserVO;
import com.arrestu.util.CommonUtil;

@Service(value = "manager")
public class Manager {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(Manager.class);

	@Autowired
	AarestuDataAccessor dataAccessor;

	public Double calculateTotal(HelloVO[] helloVO) {
		logger.info("Entering calculateTotal");
		try {
			Double total = 0.0;
			List<Double> priceList = new ArrayList<Double>();
			int size = helloVO.length;
			if (0 != size) {
				for (int i = 0; i < size; i++) {
					Double tmp = helloVO[i].getPrice();
					priceList.add(tmp);
				}
			}
			for (Double doubleValue : priceList) {
				logger.info("doubleValue:" + doubleValue);
				if (null == doubleValue) {
					doubleValue = 0.0;
				}
				total = total + doubleValue;
			}

			return total;
		} catch (Exception e) {
			logger.info("ERROR:", e);
		}
		return null;
	}

	public void insertEmployee(Employee emp) {

		emp.setEmpId(14);
		emp.setName("DILIP");
		emp.setRole("TA");
		dataAccessor.insertEmployee(emp);

	}

	public void insertItemDetails(HelloVO[] helloVO, String dateOfExp) throws Exception {
		logger.info("Entering calculateTotal");
		List<HelloVO> itemDtlList = new ArrayList<HelloVO>();
		int size = helloVO.length;
		if (0 != size) {
			for (int i = 0; i < size; i++) {
				if (helloVO[i].isCheckIndicator() && !helloVO[i].isErrIndicator()) {
					itemDtlList.add(helloVO[i]);
				}
			}
		}

		for (HelloVO helloVO2 : itemDtlList) {
			dataAccessor.insertItemDetails(helloVO2, dateOfExp);
		}

	}

	public CategoryPercentVO calculatStat() {
		List<CategoryVO> categoryVOs = new ArrayList<CategoryVO>();
		CategoryPercentVO categoryPercentVO = new CategoryPercentVO();
		categoryVOs = dataAccessor.fetchStatByCategory();
		for (CategoryVO categoryVO : categoryVOs) {
			categoryPercentVO = filteredValue(categoryVO, categoryPercentVO);
		}
		categoryPercentVO = calculatePercentage(categoryPercentVO);
		logger.info("categoryPercentVO::" + categoryPercentVO);

		/*
		 * ObjectMapper mapper = new ObjectMapper(); String json = mapper.writeValueAsString(categoryPercentVO);
		 */
		return categoryPercentVO;
	}

	public CategoryPercentVO filteredValue(CategoryVO categoryVO, CategoryPercentVO categoryPercentVO) {
		if (categoryVO.getName().equals("Vegetables")) {
			categoryPercentVO.setVegetables(categoryVO.getTotPrice());
		} else if (categoryVO.getName().equals("Grocery")) {
			categoryPercentVO.setGrocery(categoryVO.getTotPrice());
		} else if (categoryVO.getName().equals("Bakery")) {
			categoryPercentVO.setBakery(categoryVO.getTotPrice());
		} else if (categoryVO.getName().equals("Medecine")) {
			categoryPercentVO.setMedecine(categoryVO.getTotPrice());
		} else if (categoryVO.getName().equals("Entertainment")) {
			categoryPercentVO.setEntertainment(categoryVO.getTotPrice());
		} else if (categoryVO.getName().equals("Bills")) {
			categoryPercentVO.setBills(categoryVO.getTotPrice());
		} else if (categoryVO.getName().equals("Other Expenses")) {
			categoryPercentVO.setOtherExpenses(categoryVO.getTotPrice());
		}
		return categoryPercentVO;

	}

	public CategoryPercentVO calculatePercentage(CategoryPercentVO categoryPercentVO) {
		double total = categoryPercentVO.getVegetables() + categoryPercentVO.getGrocery() + categoryPercentVO.getBakery() + categoryPercentVO.getMedecine() + categoryPercentVO.getEntertainment() + categoryPercentVO.getBills()
				+ categoryPercentVO.getOtherExpenses();
		categoryPercentVO.setVegetables(CommonUtil.roundingTo2Decimals((categoryPercentVO.getVegetables() / total) * 100.0));
		categoryPercentVO.setGrocery(CommonUtil.roundingTo2Decimals((categoryPercentVO.getGrocery() / total) * 100.0));
		categoryPercentVO.setBakery(CommonUtil.roundingTo2Decimals((categoryPercentVO.getBakery() / total) * 100.0));
		categoryPercentVO.setMedecine(CommonUtil.roundingTo2Decimals((categoryPercentVO.getMedecine() / total) * 100.0));
		categoryPercentVO.setEntertainment(CommonUtil.roundingTo2Decimals((categoryPercentVO.getEntertainment() / total) * 100.0));
		categoryPercentVO.setBills(CommonUtil.roundingTo2Decimals((categoryPercentVO.getBills() / total) * 100.0));
		categoryPercentVO.setOtherExpenses(CommonUtil.roundingTo2Decimals((categoryPercentVO.getOtherExpenses() / total) * 100.0));
		return categoryPercentVO;

	}
	public List<HelloVO> fetchItemNameAjax(String chars) {
		logger.info("Looking for chars:"+chars);
		List<HelloVO> returnItemNamelist = new ArrayList<HelloVO>();
		List<HelloVO> list = dataAccessor.fetchItemNameAjax();
		if(chars.length()>2){
		for (HelloVO helloVO : list) {
			if(helloVO.getName().toUpperCase().contains(chars.toUpperCase())){
				returnItemNamelist.add(helloVO);
			}
		}
		Collections.sort(returnItemNamelist, new Comparator<HelloVO>() {

			public int compare(HelloVO h1, HelloVO h2) {
				// TODO Auto-generated method stub
				return h1.getName().compareTo(h2.getName());
			}
			
		});
		}
		return returnItemNamelist;
		
	}

	public List<EmailVO> fetchEmailID(String email) {
		return dataAccessor.fetchEmailID(email);
	}

	public List<UserVO> fetchUserList(int pageid,int total) {
		return dataAccessor.fetchUserList(pageid,total);
	}

	public int fetchUserListCount() {
		return dataAccessor.fetchUserListCount();
	}
}
