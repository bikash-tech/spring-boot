package in.utrust.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_device")
public class UserDevice  implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
  	@Column(name = "user_device_id")
	private Long userDeviceId;

	@Column(name = "uctdms_id")
	private int uctdmsId;

	@Column(name = "device_id")
	private String deviceId;
 
	@Column(name = "device_token")
	private String deviceToken;
	
	@Column(name = "auth_token")
	private String authToken;
	
	@Column(name = "refresh_token")
	private String refreshToken;
 
	@Column(name = "platform")
	private String platform;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "auth_token_created_time")
	private Date authTokenCreatedTime;
	
	@Column(name = "refresh_token_created_time")
	private Date refreshTokenCreatedTime;

	@Column(name = "modified_at")
	private Date modifiedAt;

	
	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getAuthTokenCreatedTime() {
		return authTokenCreatedTime;
	}

	public void setAuthTokenCreatedTime(Date authTokenCreatedTime) {
		this.authTokenCreatedTime = authTokenCreatedTime;
	}

	public Date getRefreshTokenCreatedTime() {
		return refreshTokenCreatedTime;
	}

	public void setRefreshTokenCreatedTime(Date refreshTokenCreatedTime) {
		this.refreshTokenCreatedTime = refreshTokenCreatedTime;
	}

	public Long getUserDeviceId() {
		return userDeviceId;
	}

	public void setUserDeviceId(Long userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	public int getUctdmsId() {
		return uctdmsId;
	}

	public void setUctdmsId(int uctdmsId) {
		this.uctdmsId = uctdmsId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
