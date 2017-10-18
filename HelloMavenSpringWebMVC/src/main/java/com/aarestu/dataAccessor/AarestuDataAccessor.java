package com.aarestu.dataAccessor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aarestu.manager.Manager;
import com.aarestu.valueobject.CategoryVO;
import com.aarestu.valueobject.EmailVO;
import com.aarestu.valueobject.Employee;
import com.aarestu.valueobject.HelloVO;
import com.aarestu.valueobject.UserVO;
import com.arrestu.rowMapper.CategoryDtlsRowMapper;
import com.arrestu.rowMapper.EmailRowMapper;
import com.arrestu.rowMapper.ItemDetailsRowMapper;
import com.arrestu.rowMapper.UserListRowMapper;
import com.arrestu.util.CommonUtil;

@Repository
public class AarestuDataAccessor {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AarestuDataAccessor.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AarestuDataAccessor(DataSource dataSource) throws SQLException {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertEmployee(Employee emp) {

		String query = "insert into employee (id,name,role) values (?,?,?)";
		Object[] inputs = new Object[] { emp.getEmpId(), emp.getName(), emp.getRole() };
		jdbcTemplate.update(query, inputs);
	}

	public void insertItemDetails(HelloVO helloVO2, String dateOfExp) throws Exception {
		String query = "insert into item_dtls (Item_Name, Item_Price, Item_Category,Purchase_Date) values (?,?,?,?);";
		Object[] inputs = new Object[] { helloVO2.getName(), helloVO2.getPrice(), helloVO2.getCategory(), CommonUtil.stringToDate(dateOfExp, "MM/dd/yyyy") };
		jdbcTemplate.update(query, inputs);
	}

	public List<CategoryVO> fetchStatByCategory() {
		CategoryDtlsRowMapper categoryDtlsRowMapper = new CategoryDtlsRowMapper();
		List<Object> categoryList = new ArrayList<Object>();
		List<CategoryVO> categoryVOList = new ArrayList<CategoryVO>();
		String query = "select Item_Category,sum(Item_Price) as Item_Price from sys.item_dtls group by Item_Category;";
		categoryList = jdbcTemplate.query(query, categoryDtlsRowMapper);
		for (Object category : categoryList) {
			categoryVOList.add((CategoryVO) category);
		}
		return categoryVOList;
	}

	public List<HelloVO> fetchItemNameAjax() {
		List<Object> itemList = new ArrayList<Object>();
		List<HelloVO> helloVOList = new ArrayList<HelloVO>();
		String query = "select Item_Name, Item_Price, Item_Category, Purchase_Date from sys.item_dtls;";
		itemList = jdbcTemplate.query(query, new ItemDetailsRowMapper());
		for (Object item : itemList) {
			helloVOList.add((HelloVO) item);
		}
		return helloVOList;
	}

	public List<EmailVO> fetchEmailID(String email) {
		List<Object> itemList = new ArrayList<Object>();
		List<EmailVO> helloVOList = new ArrayList<EmailVO>();
		String query = "select * from user where id = ?;";
		Object[] inputs = new Object[] { email };
		itemList = jdbcTemplate.query(query, inputs, new EmailRowMapper());

		for (Object item : itemList) {
			helloVOList.add((EmailVO) item);
		}
		return helloVOList;
	}

	public List<UserVO> fetchUserList(int pageid,int total) {
		List<Object> itemList = new ArrayList<Object>();
		List<UserVO> userVOList = new ArrayList<UserVO>();
		String query = "select * from userstable limit "+pageid+","+total+";";
		itemList = jdbcTemplate.query(query, new UserListRowMapper());

		for (Object item : itemList) {
			userVOList.add((UserVO) item);
		}
		return userVOList;
	}

	public int fetchUserListCount() {
		String query = "select count(*) from userstable ;";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		logger.info("count::"+count);
		return count;
	}
}
