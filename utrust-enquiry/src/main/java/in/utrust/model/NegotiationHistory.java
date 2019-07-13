package in.utrust.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "negotiation_history")
public class NegotiationHistory {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="enq_number")
	private String enqNumber;
	
	@Column(name="po_id")
	private int poId;
	
	@Column(name="ptl_id")
	private int ptlId;
	
	@Column(name="offered_price")
	private double offerPrice;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="ptl_remark")
	private String ptlRemark;
	
	@Column(name="seen_on")
	private Date seenON;
	
	@Column(name="action_date")
	private Date actionDate;
	
	@Column(name="ptl_status")
	private String status;
	
	@Column(name = "latest_expected_price")
	private Double latestExpectedPrice;

	@Column(name = "latest_offer_price")
	private Double latestOfferPrice;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getPtlId() {
		return ptlId;
	}

	public void setPtlId(int ptlId) {
		this.ptlId = ptlId;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(double offerPrice) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NegotiationHistory [id=");
		builder.append(id);
		builder.append(", enqNumber=");
		builder.append(enqNumber);
		builder.append(", poId=");
		builder.append(poId);
		builder.append(", ptlId=");
		builder.append(ptlId);
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
