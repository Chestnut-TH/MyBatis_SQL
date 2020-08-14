package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.ShainInfoForm;
import com.example.demo.mapper.ShainMapper;

@Controller
public class SqlController {
	
	/*c--- SELECT文のMapper ---c*/
	@Autowired
	ShainMapper shainMapper;
	
	@ModelAttribute
	public ShainInfoForm setUpForm() {
		// ShainInfoFormを初期化
		return new ShainInfoForm();
	}
	
	/*c------アプリが起動したらまずここから始まる-----/c*/
	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/result")
	public String result(@Validated ShainInfoForm shainInfoForm, BindingResult bindingResult, Model model) {
		/*c- 入力チェック等でエラーがあればindex.htmlに戻す -c*/
		if (bindingResult.hasErrors()) {
			return "index.html";
		}
		
		String id = shainInfoForm.getId();
		String name = shainInfoForm.getName();
		String sex = shainInfoForm.getSex();
		String position = shainInfoForm.getPosition();
		
		List<ShainInfoForm> list;
		/* c--- 全検索と指定検索の切り替え ---c*/
		if(!StringUtils.isEmpty(id)) {
			list = shainMapper.select(id,name,sex,position);
		}else {
			list = shainMapper.selectAll();
		}
		model.addAttribute("ksk",list);

		return "result.html";
	}
	
	@RequestMapping("/resultinsert")
	public String resultinsert(@Validated ShainInfoForm shainInfoForm, BindingResult bindingResult, Model model) {
		/*c- 入力チェック等でエラーがあればindex.htmlに戻す -c*/
		if (bindingResult.hasErrors()) {
			return "index.html";
		}
		
		String id = shainInfoForm.getId();
		String name = shainInfoForm.getName();
		String sex = shainInfoForm.getSex();
		String position = shainInfoForm.getPosition();
		
		
		/* c--- 追加件数 ---c*/
		shainMapper.insert(id,name,sex,position);
		//model.addAttribute("ksk",result);

		return "success.html";
	}
	
	@RequestMapping("/resultupdate")
	public String resultupdate(@Validated ShainInfoForm shainInfoForm, BindingResult bindingResult, Model model) {
		/*c- 入力チェック等でエラーがあればindex.htmlに戻す -c*/
		if (bindingResult.hasErrors()) {
			return "index.html";
		}
		
		String id = shainInfoForm.getId();
		String name = shainInfoForm.getName();
		String sex = shainInfoForm.getSex();
		String position = shainInfoForm.getPosition();
		
		
		/* c--- 更新 ---c*/
		shainMapper.update(id,name,sex,position);
		//model.addAttribute("ksk",result);

		return "success.html";
	}
	
	@RequestMapping("/resultdelete")
	public String resultdelete(@Validated ShainInfoForm shainInfoForm, BindingResult bindingResult, Model model) {
		/*c- 入力チェック等でエラーがあればindex.htmlに戻す -c*/
		if (bindingResult.hasErrors()) {
			return "index.html";
		}
		
		String id = shainInfoForm.getId();
		/* c--- 削除 ---c*/
		shainMapper.delete(id);
		

		return "success.html";
	}
	
	
	

}
