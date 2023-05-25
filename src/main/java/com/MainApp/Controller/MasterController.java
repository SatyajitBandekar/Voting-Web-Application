package com.MainApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MainApp.Model.User;
import com.MainApp.Model.Vote;
import com.MainApp.Service.UserService;
import com.MainApp.Service.VoteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MasterController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private VoteService vService;
	
	
	// Login , Logout
	@RequestMapping("/LoginPage")
	public String loginPage()
	{
		return "LoginPage";
	}
	
	@RequestMapping(path = "/LoginProcess", method = RequestMethod.POST)
	public String loginProcess(@RequestParam String username, @RequestParam String password, HttpServletRequest req, Model model)
	{
		
		if(this.uService.getUsernameAndPassword(username, password)!=null)
		{
			model.addAttribute("username", username);
			HttpSession session = req.getSession();
			session.setAttribute("check", username);
			return "VottingPage";
		}
		else
		{
			return "LoginPage";
		}
	}
	
	@RequestMapping(path = "/logoutprocess", method = RequestMethod.POST)
	public String logoutProcess(HttpServletRequest req)
	{
		
			HttpSession session = req.getSession();
			session.removeAttribute("check");
			return "LoginPage";
	}
	
	
	
	// Register
	@RequestMapping(path = "/Register")
	public String registration()
	{
		return "Registration";
	}
	
	@RequestMapping(path = "/RegistrationProcess", method = RequestMethod.POST)
	public String registrationProcess(@ModelAttribute User user)
	{
		this.uService.saveUser(user);
		return "LoginPage";
	}
	
	
	//Voting
	@RequestMapping("/VottingPage")
	public String vottingPage()
	{
		return "VottingPage";
	}
	
	@RequestMapping(path = "/VottingProcess", method = RequestMethod.POST)
	public String vottingProcess(@RequestParam String vote, @RequestParam String username)
	{
		
		Vote v = new Vote();
		
		if(this.vService.getByUsername(username) != null)
		{
			return "LoginPage";
		}
		else
		{
			v.setVote(vote);
			v.setUsername(username);
			this.vService.saveVote(v);
			return "LoginPage";
		}
	}
	
	
	
	// Admin Login
	@RequestMapping("AdminHome")
	public String adminHome(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		session.removeAttribute("acheck");
		return "AdminHome";
	}
	
	@RequestMapping("/AdminLogin")
	public String adminLogin()
	{
		return "AdminLogin";
	}
	
	@RequestMapping(path = "/AdminLoginProcess", method = RequestMethod.POST)
	public String adminLoginProcess(@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest req)
	{
		
		if(username.equals("admin") && password.equals("admin"))
		{
			HttpSession session = req.getSession();
			session.setAttribute("acheck", "admin");
			String vote1 = "candidate_1";
			String vote2 = "candidate_2";
			String vote3 = "candidate_3";
			String vote4 = "candidate_4";
			
			model.addAttribute("c1", this.vService.countVotes(vote1));
			model.addAttribute("c2", this.vService.countVotes(vote2));
			model.addAttribute("c3", this.vService.countVotes(vote3));
			model.addAttribute("c4", this.vService.countVotes(vote4));
			
			
			return "AdminHome";
		}
		else
		{
			return "AdminLogin";
		}
	}

}
