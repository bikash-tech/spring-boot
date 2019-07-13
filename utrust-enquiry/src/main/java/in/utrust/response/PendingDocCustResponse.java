package in.utrust.response;

public class PendingDocCustResponse {

	private String name;
	private String mobileNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PendingDocCustResponse [name=");
		builder.append(name);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append("]");
		return builder.toString();
	}
}
