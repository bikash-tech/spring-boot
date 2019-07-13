package in.utrust.response;

import java.util.List;

public class SubordinateResponse {
	
	List<PTLUserResponse> ptlList;
	public List<PTLUserResponse> getPtlList() {
		return ptlList;
	}
	public void setPtlList(List<PTLUserResponse> ptlList) {
		this.ptlList = ptlList;
	} 
}
