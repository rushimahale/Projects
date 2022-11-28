package com.firstproject.firstproj;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("apicall1")
	public String apicall() {
		return "apicall";
	}

	@RequestMapping("test")
	public ModelAndView test() {
		ArrayList<String> arrayList = new ArrayList();
		arrayList.add("jbk");
		arrayList.add("JavaByKiran");
		arrayList.add("KiranAcadey");
		String attribute;
		ArrayList value;
		ModelAndView modelAndView = new ModelAndView("test", attribute = "data", value = arrayList);
		return modelAndView;
	}

}
