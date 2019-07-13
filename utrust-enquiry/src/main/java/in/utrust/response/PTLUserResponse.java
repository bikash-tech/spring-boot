package in.utrust.response;
import java.util.List;

public class PTLUserResponse {
	
	private Integer id; 
	private String name;
	List<UserResponse> poList; 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserResponse> getPoList() {
		return poList;
	}
	public void setPoList(List<UserResponse> poList) {
		this.poList = poList;
	}
	 
}

class ReporteeResponse{
	private Integer id; 
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}