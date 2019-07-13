package in.utrust.response;

public class EnquiryResponse {
	
	private BasicDetailsResponse basicDetails;
	private NegotiationResponse negotiation;
	private VehicleResponse vehicle;
	private FollowUpResponse followUp;
    private EnquiryDetails enquiryDetails;
    private ProcurementResponse procurement;
    private ValuationInfoResponse valuation = new ValuationInfoResponse();
	
	public ValuationInfoResponse getValuation() {
		return valuation;
	}

	public void setValuation(ValuationInfoResponse valuation) {
		this.valuation = valuation;
	}

	public EnquiryDetails getEnquiryDetails() {
		return enquiryDetails;
	}

	public void setEnquiryDetails(EnquiryDetails enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}

	public BasicDetailsResponse getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(BasicDetailsResponse basicDetails) {
		this.basicDetails = basicDetails;
	}

	public NegotiationResponse getNegotiation() {
		return negotiation;
	}

	public void setNegotiation(NegotiationResponse negotiation) {
		this.negotiation = negotiation;
	}

	public VehicleResponse getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleResponse vehicle) {
		this.vehicle = vehicle;
	}

	public FollowUpResponse getFollowUp() {
		return followUp;
	}

	public void setFollowUp(FollowUpResponse followUp) {
		this.followUp = followUp;
	}

	public ProcurementResponse getProcurement() {
		return procurement;
	}

	public void setProcurement(ProcurementResponse procurement) {
		this.procurement = procurement;
	}

}
