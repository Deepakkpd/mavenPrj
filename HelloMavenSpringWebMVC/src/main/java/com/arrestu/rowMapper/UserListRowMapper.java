package com.arrestu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aarestu.valueobject.UserVO;
import com.arrestu.util.CommonUtil;

public class UserListRowMapper implements RowMapper<Object> {
	public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
		UserVO userVO = new UserVO();
		userVO.setUserid(resultSet.getInt("userId"));
		if (!CommonUtil.isEmpty(resultSet.getString("userName"))) {
			userVO.setUserName(resultSet.getString("userName").trim());
		}

		return userVO;
	}

}