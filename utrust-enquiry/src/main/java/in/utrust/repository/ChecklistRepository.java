package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.utrust.model.Checklist;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
	
	@Query(value = "SELECT proc.id,checklist_item,description,category,prom.id checklist_mapping_id,checklist_item_id,enquiry_number,IF(document_urls is null,'Pending','Collected') status,document_urls,target_date FROM procurement_checklist proc LEFT JOIN procurement_checklist_mapping prom ON proc.id = prom.checklist_item_id and enquiry_number = ?1 where exists (select 1 from  enquiry where enq_number = ?1)",nativeQuery = true)
	List<Object[]> findChecklistByEnuqiryNumber(String enqNumber);
}