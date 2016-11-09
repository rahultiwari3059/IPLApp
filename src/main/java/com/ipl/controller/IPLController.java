package com.ipl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipl.dao.IplDaoImpl;
import com.ipl.model.UserTable;

@Controller // ("abc")
public class IPLController {
	@Autowired
	IplDaoImpl<UserTable> loginDaoImp;

	// redirect to login page from index
	@RequestMapping(value = "/loginp", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/registrationp")
	public ModelAndView register() {
		return new ModelAndView("registration");
	}

	// checking username and password
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView redirect(@Valid @ModelAttribute("validate") UserTable userTable, BindingResult result) {

		// validation
		if (result.hasErrors()) {
			System.out.println("errorfound");
			return new ModelAndView("login");
		} else {
			if (loginDaoImp.isValid(userTable.getmUsername(),
					userTable.getmPassword())) /*if username and password matched*/
				return new ModelAndView("success");
			else
				return new ModelAndView("error");
		}
	}

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public ModelAndView registerImp(@ModelAttribute("user")UserTable userTable, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("error");
		} else {
			if(loginDaoImp.add(userTable))
				return new ModelAndView("main");
			else
				return new ModelAndView("error");
		}
	}

	// displaying all users
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showList(Model model) {
		model.addAttribute("list", loginDaoImp.showList());
		model.addAttribute("login", new UserTable());
		return new ModelAndView("list");

	}

	// delete user by id
	@RequestMapping(value = "/list/delete/{mId}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("delete/{mId}") UserTable userTable, BindingResult result, Model model) {
		System.out.println("Id:" + userTable.getmId());
		List<UserTable> list = loginDaoImp.delete(userTable.getmId()); // user deleted
		if (list != null || list.size() > 0) {
			model.addAttribute("list", list);
			return new ModelAndView("list");
		} else
			return new ModelAndView("error");
	}
}
