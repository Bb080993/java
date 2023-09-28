package com.brittanyfrancis.ninjagoldgame.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String game(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			// Use setAttribute to initialize the count in session
			session.setAttribute("gold", 0);
			}
			return "index.jsp";
	}
	@RequestMapping(value="/gold", method=RequestMethod.POST)
	public String gold(@RequestParam(value="number")String number, HttpSession session) {
		
		
		ArrayList<String> activities;
		System.out.println(session.getAttribute("activities"));
		if (session.getAttribute("activities") == null) {
			activities=new ArrayList<String>();
			System.out.println("Step 1");
			session.setAttribute("activities", activities);
			
			}
		else {
			activities= (ArrayList<String>) session.getAttribute("activities");
			System.out.println("Step 2");
			System.out.println(session.getAttribute("activities"));
		}
		
		
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("MMM. dd, yyyy, H:ma");
		String activityDate = dateTime.format(formattedDate);
		
		if(number.equals("1")) {
			System.out.println("Step 3");
			Random rand=new Random();
			int val=rand.nextInt(10,21);
			System.out.println("This is val");
			System.out.println(val);
			int gold=(int) session.getAttribute("gold");
			gold+=val;
			session.setAttribute("gold", gold);
			activities.add(0, "You entered a farm and gained "+ val +" gold. " + "(" + activityDate+ ")");
			session.setAttribute("activities", activities);
		}
		else if(number.equals("2")) {
			System.out.println("Step 4");
			Random rand=new Random();
			int val=rand.nextInt(5, 11);
			System.out.println("This is val");
			System.out.println(val);
			int gold=(int) session.getAttribute("gold");
			gold+=val;
			session.setAttribute("gold", gold);
			activities.add(0, "You entered a cave and gained "+ val +" gold. " + "(" + activityDate+ ")");
			session.setAttribute("activities", activities);
		}
		else if(number.equals("3")) {
			Random rand=new Random();
			int val=rand.nextInt(2, 5);
			System.out.println("This is val");
			System.out.println(val);
			int gold=(int) session.getAttribute("gold");
			gold+=val;
			session.setAttribute("gold", gold);
			activities.add(0, "You entered a house and gained "+ val +" gold. " + "(" + activityDate+ ")");
			session.setAttribute("activities", activities);
		}
		else if(number.equals("5")) {
			Random rand=new Random();
			int val=rand.nextInt(5, 21);
				System.out.println("This is val");
				System.out.println(val);
				int gold=(int) session.getAttribute("gold");
				gold-=val;
				session.setAttribute("gold", gold);
				activities.add(0, "You entered a spa and lost "+ val +" gold. " + "(" + activityDate+ ")");
				session.setAttribute("activities", activities);
			}
		else if(number.equals("4")) {
			Random rand=new Random();
			int val=rand.nextInt(0, 50);
			System.out.println("This is val");
			System.out.println(val);
			Random again=new Random();
			int value=again.nextInt(1,3);
			if(value%2==0) {
				int gold=(int) session.getAttribute("gold");
				gold+=val;
				session.setAttribute("gold", gold);
				activities.add(0, "You went on a quest and gained "+ val +" gold. " + "(" + activityDate+ ")");
				session.setAttribute("activities", activities);
			}
			if(value%2!=0) {
				int gold=(int) session.getAttribute("gold");
				gold-=val;
				session.setAttribute("gold", gold);
				activities.add(0, "You went on a quest and lost "+ val +" gold. " + "(" + activityDate+ ")");
				session.setAttribute("activities", activities);
			}
			
		} 
		System.out.println("Step 5");
		System.out.println(session.getAttribute("activities"));
		
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
