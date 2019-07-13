package in.utrust.response;

public class NegotiationResponse {
	private Double expectedOffer;
	private Double actualPrice;
	private Double suggestedPrice;
	private Double latestOfferPrice;
	private Double latestExpectedPrice;
	private String ptlRemarks;
	
	public Double getExpectedOffer() {
		return expectedOffer;
	}

	public void setExpectedOffer(Double expectedOffer) {
		this.expectedOffer = expectedOffer;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public Double getLatestOfferPrice() {
		return latestOfferPrice;
	}

	public void setLatestOfferPrice(Double latestOfferPrice) {
		this.latestOfferPrice = latestOfferPrice;
	}

	public Double getLatestExpectedPrice() {
		return latestExpectedPrice;
	}

	public void setLatestExpectedPrice(Double latestExpectedPrice) {
		this.latestExpectedPrice = latestExpectedPrice;
	}

	public String getPtlRemarks() {
		return ptlRemarks;
	}

	public void setPtlRemarks(String ptlRemarks) {
		this.ptlRemarks = ptlRemarks;
	}

}
