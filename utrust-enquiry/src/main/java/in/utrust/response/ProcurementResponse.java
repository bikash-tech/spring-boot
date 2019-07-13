package in.utrust.response;

public class ProcurementResponse {
	private String aadhaarNumber;

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcurementResponse [aadhaarNumber=");
		builder.append(aadhaarNumber);
		builder.append("]");
		return builder.toString();
	}
}
