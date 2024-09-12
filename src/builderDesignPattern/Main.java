package builderDesignPattern;

import builderDesignPattern.Employee.EmployeeBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new EmployeeBuilder().setName("Abhay").setEmail("email.com").setEmpId(1001).build();
	}

}
