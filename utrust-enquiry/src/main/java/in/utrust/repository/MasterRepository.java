package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.Channel;
import in.utrust.model.DemandStructure;
import in.utrust.model.Enquiry;
import in.utrust.model.EnquiryType;
import in.utrust.model.ExteriorColor;
import in.utrust.model.InsuranceType;
import in.utrust.model.Make;
import in.utrust.model.Model;
import in.utrust.model.SellingReason;
import in.utrust.model.SourceName;
import in.utrust.model.SourceType;
import in.utrust.model.StatusReasoning;
import in.utrust.model.Variant;

public interface MasterRepository extends JpaRepository<Enquiry, Integer> {
	
	@Query("from DemandStructure where demandStructureId=:demandStructureId ")
	public DemandStructure getDemandStructure(@Param("demandStructureId") Integer demandStructureId);
	
	@Query("from SourceName where sourceNameId=:sourceNameId ")
	public SourceName getSourceName(@Param("sourceNameId") Integer sourceNameId);
	
	@Query("from SourceType where sourceTypeId=:sourceTypeId ")
	public SourceType getSourceType(@Param("sourceTypeId") Integer sourceTypeId);
	
	@Query("from StatusReasoning where statusReasoningId=:statusReasoningId ")
	public StatusReasoning getStatusReasoning(@Param("statusReasoningId") Integer statusReasoningId);
	
	@Query("from Channel where channelId=:channelId")
	public Channel getChannel(@Param("channelId") Integer channelId);
	
	@Query("from ExteriorColor where exteriorColourId=:exteriorColourId")
	public ExteriorColor getExteriorColor(@Param("exteriorColourId") Integer exteriorColourId);
	
	@Query("from Variant where variantId=:variantId")
	public Variant getVariant(@Param("variantId") Integer variantId);
	
	@Query("from Make where makeId=:makeId")
	public Make getMake(@Param("makeId") Integer makeId);
	
	@Query("from Model where modelId=:modelId")
	public Model getModel(@Param("modelId") Integer modelId);
	
	@Query("from SellingReason where selllingReasonId=:selllingReasonId")
	public SellingReason getSellingReason(@Param("selllingReasonId") Integer selllingReasonId);

	@Query("from InsuranceType where insuranceTypeId=:insuranceTypeId")
	public InsuranceType getInsuranceType(@Param("insuranceTypeId") Integer insuranceTypeId);

	@Query("from EnquiryType where enquiryTypeId=:enquiryTypeId")
	public EnquiryType getEnquiryType(@Param("enquiryTypeId") Integer enquiryTypeId);

}
