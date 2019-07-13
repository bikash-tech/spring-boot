package in.utrust.request;


public class CustomerRequest {

	private String title;
	private String firstName;
	private String lastName;
	private String middleName;
	private String mobileNumber;
	private String email;
	private String sex;
	private String telephone;
	private String customerType;
	private String corporateTitle;
	private String corporateName;
	private Boolean isUpdate =false;
	
	private CustomerAddressRequest customerAddress;
 
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

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public CustomerAddressRequest getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddressRequest customerAddress) {
		this.customerAddress = customerAddress;
	}
 
}
