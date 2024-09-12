package builderDesignPattern;

public class Employee {
	private String name;
	private String email;
	private long employeeId;
	
	public Employee(EmployeeBuilder builder) {
		this.name=builder.name;
		this.email=builder.email;
		this.employeeId=builder.empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	//Builder class
	public static class EmployeeBuilder {

		private String name;
		private String email;
		private long empId;
		
		public EmployeeBuilder() {
		}
		
		public EmployeeBuilder setName(String name) {
			this.name=name;
			return this;
		}
		
		public EmployeeBuilder setEmail(String email) {
			this.email=email;
			return this;
		}
		
		public EmployeeBuilder setEmpId(long empid) {
			this.empId=empid;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	}
}
