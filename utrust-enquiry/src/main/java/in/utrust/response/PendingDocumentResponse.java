package in.utrust.response;

public class PendingDocumentResponse {

	private CollectedVehicleResponse collectedVehicleResponse;
	private PendingDocCustResponse pendingDocCustResponse;

	public CollectedVehicleResponse getCollectedVehicleResponse() {
		return collectedVehicleResponse;
	}

	public void setCollectedVehicleResponse(CollectedVehicleResponse collectedVehicleResponse) {
		this.collectedVehicleResponse = collectedVehicleResponse;
	}

	public PendingDocCustResponse getPendingDocCustResponse() {
		return pendingDocCustResponse;
	}

	public void setPendingDocCustResponse(PendingDocCustResponse pendingDocCustResponse) {
		this.pendingDocCustResponse = pendingDocCustResponse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PendingDocumentResponse [collectedVehicleResponse=");
		builder.append(collectedVehicleResponse);
		builder.append(", pendingDocCustResponse=");
		builder.append(pendingDocCustResponse);
		builder.append("]");
		return builder.toString();
	}

}
