package in.utrust.request;


public class EnquiryRequest {
	private BasicDetailsRequest basicDetails;
	private NegotiationRequest negotiation;
	private VehicleRequest vehicle;
	private FollowUpRequest followUp;
	private ProcurementRequest procurement;
	private ValuationInfoRequest valuation=new ValuationInfoRequest();

	public ValuationInfoRequest getValuation() {
		return valuation;
	}

	public void setValuation(ValuationInfoRequest valuation) {
		this.valuation = valuation;
	}

	public ProcurementRequest getProcurement() {
		return procurement;
	}

	public void setProcurement(ProcurementRequest procurement) {
		this.procurement = procurement;
	}

	public BasicDetailsRequest getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(BasicDetailsRequest basicDetails) {
		this.basicDetails = basicDetails;
	}

	public NegotiationRequest getNegotiation() {
		return negotiation;
	}

	public void setNegotiation(NegotiationRequest negotiation) {
		this.negotiation = negotiation;
	}

	public VehicleRequest getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleRequest vehicle) {
		this.vehicle = vehicle;
	}

	public FollowUpRequest getFollowUp() {
		return followUp;
	}

	public void setFollowUp(FollowUpRequest followUp) {
		this.followUp = followUp;
	}
}