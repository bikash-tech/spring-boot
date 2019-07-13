package in.utrust.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification_list")
public class NotificationList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "uctdms_id")
	private Integer uctdmsId;

	@Column(name = "notification_msg")
	private String notificationMsg;

	@Column(name = "seen_at")
	private Date seen;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "status")
	private String status;

	@Column(name = "enq_number")
	private String enquiryNumber;

	@Column(name = "from_user")
	private Integer fromUser;

	@Column(name = "to_user")
	private Integer toUser;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "notification_master_id")
	private NotificationMaster notificationMaster;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUctdmsId() {
		return uctdmsId;
	}

	public void setUctdmsId(Integer uctdmsId) {
		this.uctdmsId = uctdmsId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public NotificationMaster getNotificationMaster() {
		return notificationMaster;
	}

	public void setNotificationMaster(NotificationMaster notificationMaster) {
		this.notificationMaster = notificationMaster;
	}

	public Integer getFromUser() {
		return fromUser;
	}

	public void setFromUser(Integer fromUser) {
		this.fromUser = fromUser;
	}

	public Integer getToUser() {
		return toUser;
	}

	public void setToUser(Integer toUser) {
		this.toUser = toUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificationList [id=");
		builder.append(id);
		builder.append(", uctdmsId=");
		builder.append(uctdmsId);
		builder.append(", notificationMsg=");
		builder.append(notificationMsg);
		builder.append(", seen=");
		builder.append(seen);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", status=");
		builder.append(status);
		builder.append(", enquiryNumber=");
		builder.append(enquiryNumber);
		builder.append(", fromUser=");
		builder.append(fromUser);
		builder.append(", toUser=");
		builder.append(toUser);
		builder.append(", notificationMaster=");
		builder.append(notificationMaster);
		builder.append("]");
		return builder.toString();
	}

}
