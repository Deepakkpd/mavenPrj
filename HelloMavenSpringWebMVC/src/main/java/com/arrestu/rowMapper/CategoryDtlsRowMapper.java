package com.arrestu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aarestu.valueobject.CategoryVO;
import com.arrestu.util.CommonUtil;


public class CategoryDtlsRowMapper implements RowMapper<Object> {
public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
		CategoryVO categoryVO = new CategoryVO();
		if (!CommonUtil.isEmpty(resultSet.getString("Item_Category"))) {
			categoryVO.setName(resultSet.getString("Item_Category").trim());
		}
			categoryVO.setTotPrice(resultSet.getDouble("Item_Price"));

		return categoryVO;
	}

}