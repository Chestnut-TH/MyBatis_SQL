package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.form.ShainInfoForm;

@Mapper
public interface ShainMapper {
	/*c--- 全検索の場合 ---c*/
	List<ShainInfoForm> selectAll();
	/*c--- 検索の場合 ---c*/
	List<ShainInfoForm> select(@Param("id") String id, @Param("name") String name, @Param("sex") String sex,
			@Param("position") String position);
	/*c--- 追加の場合 ---c*/
	List<ShainInfoForm> insert(@Param("id") String id, @Param("name") String name, @Param("sex") String sex,
			@Param("position") String position);
	
	/*c--- 更新の場合 ---c*/
	
	/*c--- 検索削除の場合 ---c*/
}