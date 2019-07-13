package in.utrust.request;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NewEnquiry implements Comparable<NewEnquiry> {
	private String registrationNumber;
	private String mobileNumber;
	private String title;
	private String firstName;
	private String lastName;
	private Date createdDate;
	private int createdBy;

	@Override
	public boolean equals(Object obj) {

		NewEnquiry newEnquiry = (NewEnquiry) obj;
		if (this == obj && TimeUnit.DAYS.convert((new Date().getTime() - newEnquiry.createdDate.getTime()),
				TimeUnit.MILLISECONDS) < 2) {
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (createdDate == null) {
			if (newEnquiry.createdDate != null)
				return false;
		}
		else if (TimeUnit.DAYS.convert((new Date().getTime() - newEnquiry.createdDate.getTime()),
				TimeUnit.MILLISECONDS) > 2) {
			System.out.println("newEnquiry 1:" + newEnquiry + "Diff :" + (TimeUnit.DAYS
					.convert((new Date().getTime() - newEnquiry.createdDate.getTime()), TimeUnit.MILLISECONDS)));
			return false;
		}
		// else if (!createdDate.equals(newEnquiry.createdDate))

		if (firstName == null) {
			if (newEnquiry.firstName != null)
				return false;
		} else if (!firstName.equals(newEnquiry.firstName))
			return false;
		if (lastName == null) {
			if (newEnquiry.lastName != null)
				return false;
		} else if (!lastName.equals(newEnquiry.lastName))
			return false;
		if (mobileNumber == null) {
			if (newEnquiry.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(newEnquiry.mobileNumber))
			return false;
		if (registrationNumber == null) {
			if (newEnquiry.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(newEnquiry.registrationNumber))
			return false;
		if (title == null) {
			if (newEnquiry.title != null)
				return false;
		} else if (!title.equals(newEnquiry.title))
			return false;

		if (newEnquiry.getMobileNumber().equals(this.getMobileNumber())
				&& newEnquiry.getRegistrationNumber().equals(this.getRegistrationNumber())
				&& newEnquiry.getFirstName().equals(this.getFirstName())
				&& newEnquiry.getLastName().equals(this.getLastName()) && newEnquiry.getTitle().equals(this.getTitle())
				&& TimeUnit.DAYS.convert((new Date().getTime() - newEnquiry.createdDate.getTime()),
						TimeUnit.MILLISECONDS) < 2) {

			// System.out.println("newEnquiry :"+newEnquiry+ "Diff2 :"
			// +TimeUnit.DAYS.convert((new
			// Date().getTime()-newEnquiry.createdDate.getTime()),
			// TimeUnit.MILLISECONDS));
			return true;

		}

		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public NewEnquiry(String registrationNumber, String mobileNumber, String title, String firstName, String lastName,
			Date createdDate) {
		super();
		this.registrationNumber = registrationNumber;
		this.mobileNumber = mobileNumber;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		
	}

	@Override
	public String toString() {
		return registrationNumber + "--------" + createdDate;
	}
 
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public int compareTo(NewEnquiry o) {
		return o.getCreatedDate().compareTo(getCreatedDate());
 	}

}
