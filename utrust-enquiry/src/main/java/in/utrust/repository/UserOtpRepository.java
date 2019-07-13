package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.utrust.model.UserOtp;

@Repository("UserOtpRepository")
public interface UserOtpRepository extends JpaRepository<UserOtp, Integer> {
 
	@Query(value="SELECT otp FROM user_otp WHERE  type=:type AND enq_number=:enquiryNumber",nativeQuery=true)
	public String getOtp(@Param("enquiryNumber") String enquiryNumber, @Param("type") Integer type);
	
	@Query("FROM UserOtp WHERE  type=:type AND enquiryNumber=:enquiryNumber AND mobileNumber=:mobileNumber  "
			+ "AND    alternateMobileNumber is null")
	
	public UserOtp getUserOtpByEnquiry(@Param("type") Integer type,
									   @Param("enquiryNumber") String enquiryNumber, 
			                           @Param("mobileNumber") String mobileNumber);
	
	
	
	@Query("FROM UserOtp WHERE  type=:type AND mobileNumber=:mobileNumber AND alternateMobileNumber is null ")
	public UserOtp getUserOtpByMobile(@Param("mobileNumber") String mobileNumber, @Param("type") Integer type);
	
	@Query(value="FROM UserOtp WHERE  type=:type AND alternateMobileNumber=:alternateMobileNumber ")
	public UserOtp getUserOtpByAlternateMobile(@Param("alternateMobileNumber") String alternateMobileNumber, @Param("type") Integer type);

}