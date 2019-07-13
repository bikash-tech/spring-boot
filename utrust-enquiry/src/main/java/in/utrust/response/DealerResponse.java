
package in.utrust.response;

public class DealerResponse {
	private Integer poId;
	private String poName;
	private Integer dealerId;
	private String dealerName;
	private String dealerLocation;
	private String dealerGroup;

	public Integer getPoId() {
		return poId;
	}
	public void setPoId(Integer poId) {
		this.poId = poId;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	
	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	} 

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerLocation() { 
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public String getDealerGroup() {
		return dealerGroup;
	}

	public void setDealerGroup(String dealerGroup) {
		this.dealerGroup = dealerGroup;
	}
}