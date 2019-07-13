package in.utrust.response;

import java.util.Date;

public class NegotiationHistResponse {

	private int id;
	private String enqNumber;
	private String poName;
    private String ptlName;
	private Double offerPrice;
	private Date date;
	private String ptlRemark;
	private Date seenON;
	private Date actionDate;	
	private String status;
	private Double latestExpectedPrice;
	private Double latestOfferPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnqNumber() {
		return enqNumber;
	}
	public void setEnqNumber(String enqNumber) {
		this.enqNumber = enqNumber;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getPtlName() {
		return ptlName;
	}
	public void setPtlName(String ptlName) {
		this.ptlName = ptlName;
	}
	public Double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPtlRemark() {
		return ptlRemark;
	}
	public void setPtlRemark(String ptlRemark) {
		this.ptlRemark = ptlRemark;
	}
	public Date getSeenON() {
		return seenON;
	}
	public void setSeenON(Date seenON) {
		this.seenON = seenON;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getLatestExpectedPrice() {
		return latestExpectedPrice;
	}
	public void setLatestExpectedPrice(Double latestExpectedPrice) {
		this.latestExpectedPrice = latestExpectedPrice;
	}
	public Double getLatestOfferPrice() {
		return latestOfferPrice;
	}
	public void setLatestOfferPrice(Double latestOfferPrice) {
		this.latestOfferPrice = latestOfferPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NegotiationHistResponse [id=");
		builder.append(id);
		builder.append(", enqNumber=");
		builder.append(enqNumber);
		builder.append(", poName=");
		builder.append(poName);
		builder.append(", ptlName=");
		builder.append(ptlName);
		builder.append(", offerPrice=");
		builder.append(offerPrice);
		builder.append(", date=");
		builder.append(date);
		builder.append(", ptlRemark=");
		builder.append(ptlRemark);
		builder.append(", seenON=");
		builder.append(seenON);
		builder.append(", actionDate=");
		builder.append(actionDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", latestExpectedPrice=");
		builder.append(latestExpectedPrice);
		builder.append(", latestOfferPrice=");
		builder.append(latestOfferPrice);
		builder.append("]");
		return builder.toString();
	}
}
