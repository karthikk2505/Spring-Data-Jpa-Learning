package com.cognizant.ormlearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@Controller
@SessionAttributes("details")
public class CountryDetailsController {
		
		@Autowired
		private CountryService countryService;
		@RequestMapping("/")
		public String getHomePage(ModelMap map) {
			map.addAttribute("welcome", "Welcome to Country Code Finder");
			return "home";
		}
		@RequestMapping(value = "/getcountry",method = RequestMethod.GET)
		@ResponseBody
		public String getCountryDetailsByPattern(@RequestParam String pattern,ModelMap map)
		{
			pattern = "%"+pattern+"%";
			List<Country> result = countryService.findCountryByNamePattern(pattern);
			StringBuilder sb=new StringBuilder();
			for(Country c:result)
			{
				sb.append("<div>"+c.getCode()+"     "+c.getName()+"</div>");
			}
			map.addAttribute("details", sb.toString());
			System.out.println(map.get("details"));
			return sb.toString();
		}
		
		@RequestMapping(value = "/getcountrysw",method = RequestMethod.GET)
		@ResponseBody
		public String getCountryDetailsByStartsWith(@RequestParam String pattern,ModelMap map)
		{
			pattern = pattern+"%";
			List<Country> result = countryService.findCountryByNamePattern(pattern);
			StringBuilder sb=new StringBuilder();
			for(Country c:result)
			{
				sb.append("<div>"+c.getCode()+"     "+c.getName()+"</div>");
			}
			map.addAttribute("details", sb.toString());
			System.out.println(map.get("details"));
			return sb.toString();
		}
}
