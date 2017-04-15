package com.arrestu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aarestu.valueobject.HelloVO;
import com.arrestu.util.CommonUtil;

public class ItemDetailsRowMapper implements RowMapper<Object> {
	public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
		HelloVO helloVO = new HelloVO();
		if (!CommonUtil.isEmpty(resultSet.getString("Item_Name"))) {
			helloVO.setName(resultSet.getString("Item_Name").trim());
		}
		helloVO.setPrice(resultSet.getDouble("Item_Price"));
		if (!CommonUtil.isEmpty(resultSet.getString("Item_Category"))) {
			helloVO.setCategory(resultSet.getString("Item_Category").trim());
		}

		helloVO.setPurchaseDate(resultSet.getDate("Purchase_Date"));
		return helloVO;
	}

}