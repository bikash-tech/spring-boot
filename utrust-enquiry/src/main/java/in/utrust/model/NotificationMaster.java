package in.utrust.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "notification_master")
public class NotificationMaster implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer notificationMasterId;
	
	@Column(name="event_name")
	private String eventName;
	
 	private String title;
 	private String body;
 	private String type;
 	private String action;
 	
	@Column(name="action_items")
 	private String actionItems;
 	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "notificationMaster", fetch = FetchType.LAZY)
	private Set<NotificationList> notificationList;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getActionItems() {
		return actionItems;
	}
	public void setActionItems(String actionItems) {
		this.actionItems = actionItems;
	}
	public Integer getNotificationMasterId() {
		return notificationMasterId;
	}
	public void setNotificationMasterId(Integer notificationMasterId) {
		this.notificationMasterId = notificationMasterId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public Set<NotificationList> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(Set<NotificationList> notificationList) {
		this.notificationList = notificationList;
	}
	@Override
	public String toString() {
		return "NotificationMaster [notificationMasterId=" + notificationMasterId + ", eventName=" + eventName
				+ ", title=" + title + ", body=" + body + ", type=" + type + ", action=" + action + ", actionItems="
				+ actionItems + ", isActive=" + isActive + ", notificationList=" + notificationList + "]";
	}

}
