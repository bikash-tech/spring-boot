package in.utrust.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "id")
	private Integer customerId;
 
	private String title;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
 
	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "corporate_title")
	private String corporateTitle;

	@Column(name = "corporate_name")
	private String corporateName;

	private String email;

	private String sex;

	private String telephone;

	@Column(name = "customer_type")
	private String customerType;
	
	@Column(name = "is_verified")
	private Boolean isVerified=false;
	
	@Column(name = "is_approved")
	private Boolean isApproved=false;
	
	@Column(name = "alternate_mobile_number")
	private String alternateMobileNumber;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
	private List<Enquiry> listEnquiry = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "customer")
	private List<CustomerAddress> customerAddrList = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
	private List<Vehicle> vehicleList = new ArrayList<>();

	
	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCorporateTitle() {
		return corporateTitle;
	}

	public void setCorporateTitle(String corporateTitle) {
		this.corporateTitle = corporateTitle;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public List<Enquiry> getListEnquiry() {
		return listEnquiry;
	}

	public void setListEnquiry(List<Enquiry> listEnquiry) {
		this.listEnquiry = listEnquiry;
	}

	public List<CustomerAddress> getCustomerAddrList() {
		return customerAddrList;
	}

	public void setCustomerAddrList(List<CustomerAddress> customerAddrList) {
		this.customerAddrList = customerAddrList;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}

	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", corporateTitle=");
		builder.append(corporateTitle);
		builder.append(", corporateName=");
		builder.append(corporateName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", customerType=");
		builder.append(customerType);
		builder.append(", isVerified=");
		builder.append(isVerified);
		builder.append(", isApproved=");
		builder.append(isApproved);
		builder.append(", alternateMobileNumber=");
		builder.append(alternateMobileNumber);
		builder.append(", listEnquiry=");
		builder.append(listEnquiry);
		builder.append(", customerAddrList=");
		builder.append(customerAddrList);
		builder.append(", vehicleList=");
		builder.append(vehicleList);
		builder.append("]");
		return builder.toString();
	}

}