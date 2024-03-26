package com.example.demo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
	public class EmployeeController {

		@Autowired
		private EmployeeServiceImpl employeeServiceImpl;

		//test new page 
		@GetMapping("/testt")
		public String test1(Model model) {
		
			return "test";
		}
		
		//get service page
		@GetMapping("/services")
		public String servicepage(Model model) {
		
			return "servicepage";
		}
	    
		//get about us page
		@GetMapping("/aboutuspage")
		public String aboutuspage(Model model) {
		
			return "aboutus";
		}
		//get about us page
				@GetMapping("/log-in")
				public String loginpage(Model model) {
				
					return "loginpage";
				}
			
		
		//get all employee details
		@GetMapping("/showrecord")
		public String viewHomePage(Model model) {
			model.addAttribute("allemplist", employeeServiceImpl.getAllEmployee());
			return "showrecord";
		}
		
		//add record employee details
		@GetMapping("/addrecord")
		public String viewHomePage2(Model model) {
			
			Employee employee = new Employee();
			model.addAttribute("employee", employee);
			
			return "addrecord";
		}

		//add new record employee details
		/*
		 * @GetMapping("/addnew") public String addNewEmployee(Model model) { Employee
		 * employee = new Employee(); model.addAttribute("employee", employee); return
		 * "newemployee"; }
		 */
		
		//add new record employee details
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee employee) {
			employeeServiceImpl.save(employee);
			return "redirect:/showrecord";
		}

		@GetMapping("/showFormForUpdate/{id}")
		public String updateForm(@PathVariable(value = "id") long id, Model model) {
			Employee employee = employeeServiceImpl.getById(id);
			model.addAttribute("employee", employee);
			return "update";
		}

		@GetMapping("/deleteEmployee/{id}")
		public String deleteThroughId(@PathVariable(value = "id") long id) {
			employeeServiceImpl.deleteViaId(id);
			return "redirect:/showrecord";

		}
	
		   @GetMapping("/export-to-excel")
		    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		        response.setContentType("application/octet-stream");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());

		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=employee" + currentDateTime + ".xlsx";
		        response.setHeader(headerKey, headerValue);

		        List<Employee> listofemployee = employeeServiceImpl.getAllEmployee();
		        ExcelGenerator generator = new ExcelGenerator(listofemployee);
		        generator.generateExcelFile(response);
		    }
   
}