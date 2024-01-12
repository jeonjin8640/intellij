package dto;

public class Buseo {
	private String buseo_code;
	private String buseo_name;
	private int cnt;	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getBuseo_code() {
		return buseo_code;
	}
	public void setBuseo_code(String buseo_code) {
		this.buseo_code = buseo_code;
	}
	public String getBuseo_name() {
		return buseo_name;
	}
	public void setBuseo_name(String buseo_name) {
		this.buseo_name = buseo_name;
	}
	
	@Override
	public String toString() {
		return "Buseo [buseo_code=" + buseo_code + ", buseo_name=" + buseo_name + "]";
	}
	
	
}
