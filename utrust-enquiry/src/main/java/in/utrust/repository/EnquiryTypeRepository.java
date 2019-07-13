package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.utrust.model.EnquiryType;

public interface EnquiryTypeRepository extends JpaRepository<EnquiryType, Integer> {
	public EnquiryType getEnquiryTypeByName(String name);
}