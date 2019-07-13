package in.utrust.response;

import java.util.Date;

public class NotificationListResponse {
	private Integer notificationId;
	private Integer notificationFromUser;
	private Integer notificationToUser;
	private Integer notificationMasterId;
	private String enquiryNumber;
	private String notificationMsg;
	private Date seen;
	private Date createdAt;
	private int action;
	private String actionType;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getNotificationMsg() {
		return notificationMsg;
	}
	public void setNotificationMsg(String notificationMsg) {
		this.notificationMsg = notificationMsg;
	}
	public Date getSeen() {
		return seen;
	}
	public void setSeen(Date seen) {
		this.seen = seen;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getEnquiryNumber() {
		return enquiryNumber;
	}
	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	public Integer getNotificationFromUser() {
		return notificationFromUser;
	}
	public void setNotificationFromUser(Integer notificationFromUser) {
		this.notificationFromUser = notificationFromUser;
	}
	public Integer getNotificationToUser() {
		return notificationToUser;
	}
	public void setNotificationToUser(Integer notificationToUser) {
		this.notificationToUser = notificationToUser;
	}
	public Integer getNotificationMasterId() {
		return notificationMasterId;
	}
	public void setNotificationMasterId(Integer notificationMasterId) {
		this.notificationMasterId = notificationMasterId;
	}
	
}
