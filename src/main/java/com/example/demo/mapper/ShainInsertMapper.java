package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.form.ShainInfoForm;

@Mapper
public interface ShainInsertMapper {
	/* c--- 追加の場合 ---c */
	List<ShainInfoForm> insert(@Param("id") String id, @Param("name") String name, @Param("sex") String sex,
			@Param("position") String position);
}
