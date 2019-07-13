package in.utrust.response;

import java.util.List;

public class StockResponse {
	private List<VehicleResponseStock> stockMatchingResponse;

	private List<EnquiryResponse> buyerEnquiryResponse;

	private List<WantListResponse> wantListResponse;

	public List<WantListResponse> getWantListResponse() {
		return wantListResponse;
	}

	public void setWantListResponse(List<WantListResponse> wantListResponse) {
		this.wantListResponse = wantListResponse;
	}

	public List<VehicleResponseStock> getStockMatchingResponse() {
		return stockMatchingResponse;
	}

	public void setStockMatchingResponse(List<VehicleResponseStock> stockMatchingResponse) {
		this.stockMatchingResponse = stockMatchingResponse;
	}

	public List<EnquiryResponse> getBuyerEnquiryResponse() {
		return buyerEnquiryResponse;
	}

	public void setBuyerEnquiryResponse(List<EnquiryResponse> buyerEnquiryResponse) {
		this.buyerEnquiryResponse = buyerEnquiryResponse;
	}

}