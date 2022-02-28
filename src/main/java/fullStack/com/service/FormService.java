package fullStack.com.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fullStack.com.model.EmployeeModel;
import fullStack.com.model.SupervisorModel;

@Service
public class FormService {
	
	public List getSupervisorList(List<SupervisorModel> supervisors) {
		Comparator<SupervisorModel> compare = Comparator.comparing(SupervisorModel::getJurisdiction)
				.thenComparing(SupervisorModel::getLastName).thenComparing(SupervisorModel::getFirstName);

		List<String> collect = supervisors.stream().sorted(compare)
				.filter(s -> s.getJurisdiction() < '0' || s.getJurisdiction() >'9')
				.map(s -> String.format("%s - %s, %s", s.getJurisdiction(), s.getLastName(), s.getFirstName()))
				.collect(Collectors.toList());
		collect.add(0, "Select a Supervisor");
		return collect;
	}
	
	public String createPayload(EmployeeModel employee) {
		String payload = "{firstName: " + employee.getFirstName() + ", lastName: " + employee.getLastName() + ", email: " + employee.getEmail() + ", phoneNumber: " + employee.getPhoneNumber() + ", supervisor: " + employee.getSupervisor() + "}";
		System.out.println(payload);
		return payload;
	}
	
	public Boolean validateForm(EmployeeModel employee) {
		if (employee.getFirstName() == "") {
			return false;
		}
		if (employee.getLastName() == "") {
			return false;
		}
		if (employee.getSupervisor() == "Select a Supervisor") {
			return false;
		}
		return true;
	}
}
