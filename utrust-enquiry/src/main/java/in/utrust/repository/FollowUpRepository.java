package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.Enquiry;
import in.utrust.model.FollowUp;

public interface FollowUpRepository extends JpaRepository<FollowUp, Long>{
	@Query("from FollowUp where enquiryNumber=:enquiryNumber order by id desc")
	public List<FollowUp> getFollowUp(@Param("enquiryNumber") String enquiryNumber);
	
	@Query(value="select * from enquiry_followup  where enq_number=:enquiryNumber order by id desc limit 1 ",nativeQuery=true)
	public FollowUp getLatestFollowUp(@Param("enquiryNumber") String enquiryNumber);
	
	@Query(value="select e.enq_status, ef.* from enquiry_followup ef, enquiry e  where e.enq_number=:enquiryNumber and ef.enq_number=e.enq_number order by ef.id desc limit 1",nativeQuery=true)
	public List<Object[]> getLatestFollowUpByEnquiry(@Param("enquiryNumber") String enquiryNumber);
	
	@Query(value="SELECT en.* FROM enquiry_followup  ef JOIN  enquiry en WHERE TIMESTAMPDIFF(MINUTE, NOW(),next_date) < 60 AND"
			+ "  TIMESTAMPDIFF(MINUTE, NOW(),next_date) > 1 AND en.enq_number=ef.enq_number order by en.created_at desc",nativeQuery=true)
	public List<Enquiry> getFollowUpReminders();
}
