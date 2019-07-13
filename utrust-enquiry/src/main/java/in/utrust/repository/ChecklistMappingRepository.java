package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.ChecklistMapping;
import in.utrust.model.Enquiry;

public interface ChecklistMappingRepository extends JpaRepository<ChecklistMapping, Integer> {

	List<ChecklistMapping> findByEnquiryNumber(String enquiryNumber);

	@Modifying
	@Query(value = "delete pcm.* FROM procurement_checklist_mapping pcm LEFT JOIN procurement_checklist pc ON pcm.checklist_item_id = pc.id WHERE pcm.enquiry_number = ?1", nativeQuery = true)
	public int deleteAllByEnquiryNoAndDocCategory(String enquiryNumber);

	@Query(value="select * from  procurement_checklist_mapping where enquiry_number=?1 and  checklist_item_id =?2",nativeQuery=true)
	public ChecklistMapping getChecklistMapping(String enquiryNumber, Integer checklistItemId);
	
	public ChecklistMapping findByChecklistAndEnquiryNumber(int id, String enquiryNumber);
	
	@Query(value=" SELECT COUNT(*) ,COUNT(document_urls) AS pending  FROM `procurement_checklist_mapping` WHERE enquiry_number=:enquiryNumber",nativeQuery=true)
	public List getDocumentsCount(@Param("enquiryNumber") String enquiryNumber);

	@Query(value="select document_urls from procurement_checklist_mapping  where enquiry_number=:enquiryNumber and checklist_item_id =:itemId order by id desc limit 1", nativeQuery=true)
	public String getSignOfUrls(@Param("enquiryNumber") String enquiryNumber,@Param("itemId") Integer itemId);

	@Query(value="SELECT e.* FROM utrust.procurement_checklist_mapping  m JOIN  enquiry e WHERE DATEDIFF(NOW(),target_date)=-1  AND e.enq_number=m.enquiry_number", nativeQuery=true)
	public List<Enquiry> getFollowUpReminders();
	
}