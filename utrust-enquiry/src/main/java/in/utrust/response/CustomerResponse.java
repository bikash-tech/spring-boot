package in.utrust.response;

import java.util.List;

public class CustomerResponse {
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String sex;
	private String mobileNumber;
	private String email;
	private String customerType;
	private String telephone;
	private String corporateTitle;
	private String corporateName;
	private Boolean isVerified=false;
	private List<CustomerAddressResponse> customerAddressList;

	
	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<CustomerAddressResponse> getCustomerAddressList() {
		return customerAddressList;
	}

	public void setCustomerAddressList(List<CustomerAddressResponse> customerAddressList) {
		this.customerAddressList = customerAddressList;
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

}
