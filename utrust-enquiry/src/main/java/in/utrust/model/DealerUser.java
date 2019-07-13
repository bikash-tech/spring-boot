package in.utrust.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "DealerUser")
@EntityListeners(AuditingEntityListener.class)
public class DealerUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dealer_user_id")
	private Integer dealerUserId;

	@Column(name = "uctdms_id")
	private Long uctdmsId;

	@Column(name = "user_name")
	private String userName;

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

	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;

	@Column(name = "modified_at")
	@LastModifiedDate
	private Date modifiedAt;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealerUserSo", fetch = FetchType.LAZY)
	private List<Enquiry> enquiryListSo = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealerUserStl", fetch = FetchType.LAZY)
	private List<Enquiry> enquiryListStl = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dealer_id")
	private Dealer dealer;

	public List<Enquiry> getEnquiryListSo() {
		return enquiryListSo;
	}

	public void setEnquiryListSo(List<Enquiry> enquiryListSo) {
		this.enquiryListSo = enquiryListSo;
	}

	public List<Enquiry> getEnquiryListStl() {
		return enquiryListStl;
	}

	public void setEnquiryListStl(List<Enquiry> enquiryListStl) {
		this.enquiryListStl = enquiryListStl;
	}

	// created by dealer user -Many to One DealerUser to Customer

	public Integer getDealerUserId() {
		return dealerUserId;
	}

	public void setDealerUserId(Integer dealerUserId) {
		this.dealerUserId = dealerUserId;
	}

	public Long getUctdmsId() {
		return uctdmsId;
	}

	public void setUctdmsId(Long uctdmsId) {
		this.uctdmsId = uctdmsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

}