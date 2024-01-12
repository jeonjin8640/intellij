package dto;

public class Employee {
	private int emp_id;
	private String emp_name;
	private String emp_email;
	private String emp_addr;
	private String buseo_code;
	private String buseo_name;	
	
	public String getBuseo_name() {
		return buseo_name;
	}
	public void setBuseo_name(String buseo_name) {
		this.buseo_name = buseo_name;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_addr() {
		return emp_addr;
	}
	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}
	public String getBuseo_code() {
		return buseo_code;
	}
	public void setBuseo_code(String buseo_code) {
		this.buseo_code = buseo_code;
	}
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_addr="
				+ emp_addr + ", buseo_code=" + buseo_code + "]";
	}	
}
