package in.utrust.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import in.utrust.constants.Constants;


/**
 * @author RamPrasad
 *
 */
@Entity
@Table(name = "user")
@NamedStoredProcedureQuery(name = Constants.LOG_IN_PROCEDURE, procedureName =Constants.LOG_IN_PROCEDURE,

		parameters = { @StoredProcedureParameter(mode = ParameterMode.IN, name = "uctdmsId", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "auth_token", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "refresh_token", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "device_id", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "platform", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "device_token", type = String.class),  
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class) })

@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public User() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "uctdms_id")
	private int uctdmsId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	private String password;

	@Column(name = "invalid_login_attempts")
	private int invalidLoginAttempts;

	@Column(name = "reporting_to")
	private int reportingTo;
	
	@Column(name = "user_role_id")
	private int userRoleId;
	
	/*@Column(name = "dealer_id")
	private int dealerId;*/
	
 	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

 	@LastModifiedDate
	@Column(name = "modified_at")
	private Date modifiedAt;

 	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
 	Dealer dealer;
 	
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public int getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(int reportingTo) {
		this.reportingTo = reportingTo;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUctdmsId() {
		return uctdmsId;
	}

	public void setUctdmsId(int uctdmsId) {
		this.uctdmsId = uctdmsId;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInvalidLoginAttempts() {
		return invalidLoginAttempts;
	}

	public void setInvalidLoginAttempts(int invalidLoginAttempts) {
		this.invalidLoginAttempts = invalidLoginAttempts;
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
