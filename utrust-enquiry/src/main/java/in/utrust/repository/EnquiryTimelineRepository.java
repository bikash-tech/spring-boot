package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.utrust.model.EnquiryTimeline;

public interface EnquiryTimelineRepository extends JpaRepository<EnquiryTimeline, Integer> {
	@Query("from EnquiryTimeline where enquiryNumber=:enquiryNumber order by id desc")
	List<EnquiryTimeline> findByEnquiryNumber(String enquiryNumber);
}