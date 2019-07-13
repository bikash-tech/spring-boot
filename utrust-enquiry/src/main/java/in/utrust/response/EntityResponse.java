package in.utrust.response;

import java.util.List;
import java.util.Map;

public class EntityResponse {

	private List<SourceNameResponse> sourceNameList;
	private List<SourceTypeResponse> sourceTypeList;
	private List<EnquiryTypeResponse> enquiryTypeList;
	private List<StatusReasoningResponse> statusReasoningList;
	private List<ChannelResponse> channelList;
	private List<SellingReasonResponse> sellingReasonList;
	private List<ExteriorColorResponse> exteriorColorList;
	private List<DemandStructureResponse> demandStructureList;
	private List<MakeResponse> makeList;
	private List<InsuranceTypeResponse> insuranceTypeList;
	Map<String, List> valuationList;
	
	public Map<String, List> getValuationList() {
		return valuationList;
	}

	public void setValuationList(Map<String, List> valuationList) {
		this.valuationList = valuationList;
	}

	public List<EnquiryTypeResponse> getEnquiryTypeList() {
		return enquiryTypeList;
	}

	public void setEnquiryTypeList(List<EnquiryTypeResponse> enquiryTypeList) {
		this.enquiryTypeList = enquiryTypeList;
	}
	
	public List<SourceNameResponse> getSourceNameList() {
		return sourceNameList;
	}

	public void setSourceNameList(List<SourceNameResponse> sourceNameList) {
		this.sourceNameList = sourceNameList;
	}
	
	public List<SourceTypeResponse> getSourceTypeList() {
		return sourceTypeList;
	}

	public void setSourceTypeList(List<SourceTypeResponse> sourceTypeList) {
		this.sourceTypeList = sourceTypeList;
	}

	public List<StatusReasoningResponse> getStatusReasoningList() {
		return statusReasoningList;
	}

	public void setStatusReasoningList(List<StatusReasoningResponse> statusReasoningList) {
		this.statusReasoningList = statusReasoningList;
	}

	public List<ChannelResponse> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<ChannelResponse> channelList) {
		this.channelList = channelList;
	}

	public List<SellingReasonResponse> getSellingReasonList() {
		return sellingReasonList;
	}

	public void setSellingReasonList(List<SellingReasonResponse> sellingReasonList) {
		this.sellingReasonList = sellingReasonList;
	}

	public List<ExteriorColorResponse> getExteriorColorList() {
		return exteriorColorList;
	}

	public void setExteriorColorList(List<ExteriorColorResponse> exteriorColorList) {
		this.exteriorColorList = exteriorColorList;
	}

	public List<DemandStructureResponse> getDemandStructureList() {
		return demandStructureList;
	}

	public void setDemandStructureList(List<DemandStructureResponse> demandStructureList) {
		this.demandStructureList = demandStructureList;
	}

	public List<MakeResponse> getMakeList() {
		return makeList;
	}

	public void setMakeList(List<MakeResponse> makeList) {
		this.makeList = makeList;
	}

	public List<InsuranceTypeResponse> getInsuranceTypeList() {
		return insuranceTypeList;
	}

	public void setInsuranceTypeList(List<InsuranceTypeResponse> insuranceTypeList) {
		this.insuranceTypeList = insuranceTypeList;
	}
}
