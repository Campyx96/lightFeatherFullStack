package fullStack.com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import fullStack.com.model.EmployeeModel;
import fullStack.com.model.SupervisorModel;
import fullStack.com.service.FormService;

@Controller
public class FormController {
	
	private String baseUri = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com";
	
	@Autowired
	FormService service;

	@GetMapping("/")
	public String showNotificationForm(Model model) {
		EmployeeModel employee = new EmployeeModel();
		model.addAttribute("employee", employee);
		String uri = baseUri + "/api/managers";
		//Get List of Supervisors from provided API
		RestTemplate getSupervisors = new RestTemplate();
		List<SupervisorModel> supervisors = Arrays.asList(getSupervisors.getForObject(uri, SupervisorModel[].class));
		//Transform the API response to a list of strings properly sorted and filtered
		List<String> supervisorList = service.getSupervisorList(supervisors);
		//Add the supervisor list to the model
		model.addAttribute("supervisorList", supervisorList);
		return "notificationForm";
	}
	
	@PostMapping("/submitted")
	public String submit(@ModelAttribute EmployeeModel employee, Model model) {
		//Validate whether the required forms are populated
		if(!service.validateForm(employee)) {
			System.out.println("First Name, Last Name, and Supervisor are required fields.");
			return "redirect:/";
		}
		String uri = baseUri + "/api/submit";
		RestTemplate sendInfo = new RestTemplate();
		//Format the payload
		String info = service.createPayload(employee);
		//Send Payload to the endpoint
		sendInfo.postForObject(uri, info, String.class);
		model.addAttribute("employee", employee);
		return "displayResults";
	}
	
}
