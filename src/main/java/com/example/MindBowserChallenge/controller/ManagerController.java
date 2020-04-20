package com.example.MindBowserChallenge.controller;

import com.example.*;
import com.example.MindBowserChallenge.dao.EmployeeRepository;
import com.example.MindBowserChallenge.dao.ManagerRepository;
import com.example.MindBowserChallenge.data.Employee;
import com.example.MindBowserChallenge.data.Manager;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ManagerController {

	@Autowired
	ManagerRepository managerrepo;

	@Autowired
	EmployeeRepository employeerepo;

	/*
	 * @GetMapping("/") public ModelAndView getIndex(Model model) {
	 * 
	 * ModelAndView index = new ModelAndView("index"); User user = new User();
	 * model.addAttribute("user", user);
	 * 
	 * return index; }
	 */

	@GetMapping("/register")
	public ModelAndView getRegister(Model model) {

		ModelAndView register = new ModelAndView("signup");
		Manager user = new Manager();
		model.addAttribute("manager", user);

		return register;
	}

	

	
	@GetMapping("/logout")
	public ModelAndView logoout(Model model,HttpSession session) {

		ModelAndView register = new ModelAndView("login");
		session.invalidate();
		Manager user = new Manager();
		model.addAttribute("manager", user);

		return register;
	}

	
	@PostMapping("/register")
	public ModelAndView setRegister(HttpSession session, @ModelAttribute("manager") Manager user, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes)

	{

		ModelAndView register = new ModelAndView("login");

		List<Manager> userlist = (List<Manager>) managerrepo.findAll();
		for (Manager u : userlist) {
			if (u.getEmail().equalsIgnoreCase(user.getEmail())) {

				redirectAttributes.addFlashAttribute("message",
						"Already registered email address kindly Login to Use Application");

				register.setViewName("redirect:/signup");
				return register;

			}

		}
		

		
		System.out.println(user);
		
		//user.setEmployeelist(null);

		managerrepo.save(user);
		redirectAttributes.addFlashAttribute("message1", "You have succesfully signed up.Kindly Login");
		//register.setViewName("index");

		

		return register;
	}

	

	@GetMapping("/")
	public ModelAndView getIndex(Model model) {

		ModelAndView index = new ModelAndView("login");
		Manager user = new Manager();
		model.addAttribute("manager", user);
	


		return index;
	}
	
	@PostMapping("/home")
	public ModelAndView login(Model model, @ModelAttribute("manager") Manager user,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) {

		ModelAndView login = new ModelAndView("employeeform");
		
		
		

		List<Manager> userlist = (List<Manager>) managerrepo.findAll();
		boolean flagfound = false;
		boolean flagpass = false;

		Long id = 0L;
		long id_og = 0;
		for (Manager u : userlist) {
			
						

			if (u.getEmail().equalsIgnoreCase(user.getEmail())) {

				flagfound = true;
				if (u.getPassword().equalsIgnoreCase(user.getPassword())) {

					id_og = u.getId();
					flagpass = true;
				}

			}

		}

		if (!flagfound || !flagpass) {

			redirectAttributes.addFlashAttribute("message", "Incorrect Email Address or password");
			login.addObject("message", "Incorrect Email Address or password");
			login.setViewName("login");
			return login;

		}

		HttpSession session = request.getSession(true);

		session.setAttribute("username", user.getEmail());
		session.setAttribute("id", id_og);
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		
		
	List<Employee>	listcandiateq = (List<Employee>) employeerepo.findAll();

	if(listcandiateq.size() > 0) {
		model.addAttribute("listofcandidate", listcandiateq);
	}		
		return login;

	}

	
	
	@PostMapping("/setprofile")
	public ModelAndView setCandidateProfile(Model model, HttpSession session,
			@ModelAttribute("employee") Employee emp,
			@RequestParam(value = "action", required = false) String action, RedirectAttributes redirectAttributes,
			@RequestParam(value = "candidate_id", required = false) Long candidate_id) {

		ModelAndView index = new ModelAndView("employeeform");
		List<Employee> listcandiateq = null;

		listcandiateq = (List<Employee>) employeerepo.findAll();

		if (action.equals("Reject")) {

			Optional<Employee> candidate = employeerepo.findById(candidate_id);

			Employee currentcandidate = null;
			if (candidate.isPresent()) {
				currentcandidate = candidate.get();
			}

		
			
			employeerepo.delete(currentcandidate);
			
			
			listcandiateq = (List<Employee>) employeerepo.findAll();

			model.addAttribute("listofcandidate", listcandiateq);

			redirectAttributes.addFlashAttribute("message", "Candidate deleted");

			return index;

		}


	
		
		
		
		
	

		if (action.equals("Add")) {

			
			for (Employee ca : listcandiateq) {
				if (ca.getEmailAddress().equalsIgnoreCase(emp.getEmailAddress())) {
					model.addAttribute("listofcandidate", listcandiateq);

					redirectAttributes.addFlashAttribute("message", "Already Present");
					return index;
				}
			}
			
			
			employeerepo.save(emp);

			listcandiateq.add(emp);

			model.addAttribute("listofcandidate", listcandiateq);

			redirectAttributes.addFlashAttribute("message", "Candidate Added");

		}
		

		if (action.equals("update")) {

			
			for (Employee ca : listcandiateq) {
				if (ca.getEmailAddress().equalsIgnoreCase(emp.getEmailAddress())) {
				
					listcandiateq.removeIf(obj -> obj.getEmailAddress() == emp.getEmailAddress());

					Optional<Employee> candidate = employeerepo.findById(ca.getId());
					
					Employee currentcandidate1 = null;
					if (candidate.isPresent()) {
						currentcandidate1 = candidate.get();
						employeerepo.delete(currentcandidate1);

					}
					Employee currentcandidate=new Employee();
					currentcandidate.setAddress(emp.getAddress());
					currentcandidate.setCity(emp.getCity());

					currentcandidate.setDob(emp.getDob());
					currentcandidate.setEmailAddress(emp.getEmailAddress());
					currentcandidate.setFirstName(emp.getFirstName());
					currentcandidate.setLastName(emp.getLastName());
					currentcandidate.setMobile(emp.getMobile());

					employeerepo.save(currentcandidate);
					
					listcandiateq.clear();
					listcandiateq=(List<Employee>) employeerepo.findAll();
					break;
				
					
					
				}
			}
			
			
			

			model.addAttribute("listofcandidate", listcandiateq);

			redirectAttributes.addFlashAttribute("message", "Candidate Updated");

		}
		
		
		
		
	

		if (action.equals("Accept")) {

		}
		// redirectAttributes.addFlashAttribute("message", "Row Added");

		return index;
	}
	
	
	
	@GetMapping("/set")
	@ResponseBody
	public Optional<Employee> findOne(long id) {
		
		return employeerepo.findById((long) id);	
	}
}