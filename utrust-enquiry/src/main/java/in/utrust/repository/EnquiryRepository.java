
package in.utrust.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.utrust.model.Customer;
import in.utrust.model.Enquiry;
import in.utrust.model.NegotiationHistory;
import in.utrust.model.PricingDataInfo;
import in.utrust.model.Vehicle;

@Repository("EnquiryRepository")
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
	@Query("from Enquiry where enquiryNumber=:enquiryNumber")
	public Enquiry getEnquiry(@Param("enquiryNumber") String enquiryNumber);

//	@Query("from Enquiry where enquiryType=:enquiryType order by createdAt desc")
//	public List<Enquiry> getEnquiryList(@Param("enquiryType") String enquiryType);

	@Query("from Enquiry where assignTo=:poId order by createdAt desc")
	public List<Enquiry> getFollowUpByPO(@Param("poId") Integer poId);

	@Query("from  Vehicle  WHERE  registrationNumber=:registrationNumber ")
	public Vehicle getEnquiryByRegNumber(@Param("registrationNumber") String registrationNumber);

	@Query("from  Vehicle  WHERE  registrationNumber like %:registrationNumber% ")
	public List<Vehicle> getEnquiryListByRegNumber(@Param("registrationNumber") String registrationNumber);

	@Query(" FROM Customer  WHERE  mobileNumber like :mobileNumber% ")
	public List<Customer>  getEnquiryListByMobile(@Param("mobileNumber") String mobileNumber);
	
	@Query(" FROM Customer  WHERE  mobileNumber =:mobileNumber")
	public Customer  getEnquiryByMobile(@Param("mobileNumber") String mobileNumber);

	@Query(" FROM Customer  WHERE  (firstName like %:firstName% AND  lastName like %:lastName%) OR (corporateName like %:corporateName%)")
	public List<Customer> getEnquiryListByFirstAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("corporateName") String corporateName);  

	@Query(" FROM Customer  WHERE  (firstName like %:name% OR  lastName like %:name% OR corporateName like %:name%)")
	public List<Customer> getEnquiryListByAnyName(@Param("name") String name);  

	@Modifying
	@Query("update Enquiry set newCarEnquiryNo=:newCarEnqNumber where enquiryNumber=:sellerEnqNumber")
	public int updateNewCarEnquiryNumber(@Param("sellerEnqNumber") String sellerEnqNumber,
			@Param("newCarEnqNumber") String newCarEnqNumber);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Enquiry e SET e.buyerEnquiryNo = :buyerEnquiryNumber WHERE e.enquiryNumber = :enquiryNumber")
	public int updateBuyerEnquiryNumber(@Param("buyerEnquiryNumber") String buyerEnquiryNumber,
			@Param("enquiryNumber") String enquiryNumber);

	@Query(" FROM Enquiry  WHERE enquiryCategory=:enquiryCategory and DATEDIFF(CURDATE(),created_at) < 90 ")
	public List<Enquiry> findByEnquiryCategoryInRange(String enquiryCategory, Pageable pageable);

	@Query("from Enquiry where assignTo=:poId ORDER BY createdBy DESC ")
	public List<Enquiry> getEnquiryListByPO(@Param("poId") Integer poId);

	@Query(" FROM Enquiry  WHERE enquiryNumber=:enquiryNumber and DATEDIFF(CURDATE(),created_at) < 90 ")
	public List<Enquiry> findByEnquiryNumberInRange(String enquiryNumber);

	@Query("from NegotiationHistory where enqNumber=:enquiryNumber order by id desc")
	List<NegotiationHistory> getNegotiationHistory(@Param("enquiryNumber") String enquiryNumber);

	@Query(" from PricingDataInfo where make=:make and model=:model and "
			+ " variant=:variant and color=:color and mileage=:mileage "
			+ " and city=:city and prevOwner=:prevOwner and quality=:quality "
			+ " and fuel=:fuel  and transmission=:transmission and " + " insuranceType=:insuranceType  and year=:year ")

	public PricingDataInfo getChartData(@Param("make") String make, @Param("model") String model,
			@Param("variant") String variant, @Param("color") String color, @Param("mileage") Integer mileage,
			@Param("city") String city, @Param("prevOwner") Integer prevOwner, @Param("quality") Integer quality,
			@Param("fuel") Integer fuel, @Param("transmission") Integer transmission,
			@Param("insuranceType") Integer insuranceType, @Param("year") String year);

	public Enquiry findByEnquiryNumberAndBuyerEnquiryNo(String buyerEnquiryNo, String enquiryNumber);
	
	@Query("from Vehicle where registrationNumber=:registrationNumber")
	public List<Vehicle> getParallelEnquiry(@Param("registrationNumber") String registrationNumber);
	
	
	@Modifying
	@Query("update Enquiry set isProcurementSaved=:isProcurementSaved where enquiryNumber=:enqNumber")
	public int updateProcFlagByEnquiryNumber(@Param("isProcurementSaved") boolean isProcurementSaved,
			@Param("enqNumber") String enqNumber);
	
/*	@Query(value="SELECT en.* FROM enquiry en, USER u WHERE u.uctdms_id= en.assigned_to AND en.assigned_to IN "
			+ " (SELECT u.uctdms_id FROM  `user` u WHERE  u.user_role_id= :userRoleId AND u.reporting_to= :uctdmsId)", nativeQuery=true)
	public List<Enquiry> getEnquiryListByUCM(@Param("uctdmsId") Integer uctdmsId,@Param("userRoleId") Integer userRoleId);
	*/
	
	@Query(value=" SELECT en.* FROM enquiry en, USER u  WHERE en.assigned_to =u.uctdms_id AND  en.assigned_to IN "
			+ " ( SELECT uctdms_id FROM USER WHERE  reporting_to IN(SELECT u.uctdms_id FROM  `user` u WHERE  u.user_role_id= :userRoleId AND u.reporting_to= :uctdmsId)) ORDER BY en.created_at DESC ", nativeQuery=true)
	public List<Enquiry> getEnquiryListByUCM(@Param("uctdmsId") Integer uctdmsId,@Param("userRoleId") Integer userRoleId);
	
	
	@Query(value="SELECT en.* FROM enquiry en, USER u WHERE u.uctdms_id= en.assigned_to AND en.assigned_to IN "
			+ " (SELECT u.uctdms_id FROM  `user` u WHERE  u.user_role_id= :userRoleId AND u.reporting_to= :uctdmsId) ORDER BY en.created_at DESC ", nativeQuery=true)
	public List<Enquiry> getEnquiryListByPTL(@Param("uctdmsId") Integer uctdmsId,@Param("userRoleId") Integer userRoleId);

	@Query(value="SELECT enq_number FROM enquiry ORDER BY id DESC LIMIT 1" ,nativeQuery=true)
 	public String getLatestEnquiry();
	
	@Query(value="SELECT max(purchase_number) FROM enquiry" ,nativeQuery=true)
	public String getLatestPurchaseNumber();
	
	@Query(value="SELECT c.mobile_number from enquiry e, customer c where e.enq_number=:enquiryNumber and e.customer_id=c.id " ,nativeQuery=true)
 	public String getCustomerMobileByEnqNumber(@Param("enquiryNumber") String enquiryNumber);

	@Query(value = "SELECT e.* FROM vehicle v, enquiry e where v.branch_code in (:branchCodeList) and v.make_id = IFNULL(:makeId,make_id) and v.model_id = IFNULL(:modelId,model_id) and v.variant_id = IFNULL(:vairentId,variant_id) and v.year = IFNULL(:year,year)"  
			 +"and v.vehicle_stage_id is not null and v.vehicle_stage_id not in(:soldId)and v.id=e.vehicle_id and e.enq_category in (:enqCategory) and e.enq_status not in (:statusDrop,:statusSuccess) ORDER BY e.created_at DESC", nativeQuery = true)
	public List<Enquiry> getBuyerEnquiry(@Param("branchCodeList")List<String> branchCodeList,@Param("makeId")Integer makeId, @Param("modelId")Integer modelId, @Param("vairentId")Integer vairentId, @Param("year")Integer year,@Param("soldId")Integer soldId, @Param("enqCategory")String enqCategory,@Param("statusDrop")String statusDrop,@Param("statusSuccess")String statusSuccess);
	
	@Query(value ="select en.* FROM enquiry en ,vehicle v ,  procurement_checklist_mapping cm "
			+ "WHERE v.id= en.vehicle_id and en.enq_number=cm.enquiry_number "
			+ " and cm.target_date  >=:fromDate  AND target_date <=:toDate AND  cm.document_urls IS NULL ORDER BY en.created_at DESC" ,nativeQuery=true)
	public List<Enquiry> getPendingDocuments(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);
	
	
	@Query(value ="SELECT en.* FROM enquiry en ,vehicle v  WHERE v.id= en.vehicle_id AND v.purchase_date  >=:fromDate   "
			+ "AND v.purchase_date <=:toDate and vehicle_stage_id =:stageId ORDER BY en.created_at DESC",nativeQuery=true)
	public List<Enquiry> getPurchasedDocuments(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate,@Param("stageId")Integer stageId);
	
	@Query(value ="SELECT en.* FROM enquiry en ,vehicle v  WHERE v.id= en.vehicle_id AND v.collected_date  >=:fromDate   "
			+ "AND v.collected_date <=:toDate and vehicle_stage_id =:stageId ORDER BY en.created_at DESC",nativeQuery=true)
	public List<Enquiry> getCollectedDocuments(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate,@Param("stageId")Integer stageId);

	@Query(value="select e.* from enquiry e, vehicle v, customer c where e.vehicle_id=v.id and c.id=e.customer_id and v.registration_number=:registrationNumber or  c.mobile_number=:mobileNumber order by id desc limit 1",nativeQuery=true)
	public Enquiry getDuplicateEnquiry(@Param("registrationNumber") String registrationNumber, @Param("mobileNumber") String mobileNumber);

	@Query(value="select e.* FROM Customer c, vehicle v,enquiry e where e.customer_id=c.id and e.vehicle_id=v.id and (v.registration_number like %:registrationNumber% and c.mobile_number like %:mobileNumber%)",nativeQuery=true)
	public List<Enquiry> getEnquiryListByMobileAndRegistrationNumber(String mobileNumber, String registrationNumber);
	
}