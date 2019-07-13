package in.utrust.notification;

import java.util.List;

public class NotificationsRequest {
	private String eventName;
	private String title;
	private String body;
	private String type;
	private String deviceToken;
	private List<String> actionItems;
	
	public List<String> getActionItems() {
		return actionItems;
	}
	public void setActionItems(List<String> actionItems) {
		this.actionItems = actionItems;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	@Override
	public String toString() {
		return "NotificationsRequest [eventName=" + eventName + ", title=" + title + ", body=" + body + ", type=" + type
				+ ", deviceToken=" + deviceToken + "]";
	}
}
