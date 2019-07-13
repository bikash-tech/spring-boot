package in.utrust.request;

import java.util.Date;

public class Assessment {
	private int currentCarId;
	private int currentCarUsageId;
	private Date purchaseDate;
	public int getCurrentCarId() {
		return currentCarId;
	}
	public void setCurrentCarId(int currentCarId) {
		this.currentCarId = currentCarId;
	}
	public int getCurrentCarUsageId() {
		return currentCarUsageId;
	}
	public void setCurrentCarUsageId(int currentCarUsageId) {
		this.currentCarUsageId = currentCarUsageId;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
