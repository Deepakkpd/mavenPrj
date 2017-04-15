package com.arrestu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aarestu.valueobject.EmailVO;
import com.arrestu.util.CommonUtil;

public class EmailRowMapper implements RowMapper<Object> {
	public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmailVO helloVO = new EmailVO();
		helloVO.setId(resultSet.getInt("id"));
		if (!CommonUtil.isEmpty(resultSet.getString("emailId"))) {
			helloVO.setEmailId(resultSet.getString("emailId").trim());
		}

		return helloVO;
	}

}