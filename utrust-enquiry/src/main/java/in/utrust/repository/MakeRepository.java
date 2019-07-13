package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.Channel;
import in.utrust.model.DemandStructure;
import in.utrust.model.Enquiry;
import in.utrust.model.ExteriorColor;
import in.utrust.model.Make;
import in.utrust.model.Model;
import in.utrust.model.SellingReason;
import in.utrust.model.SourceName;
import in.utrust.model.SourceType;
import in.utrust.model.StatusReasoning;
import in.utrust.model.Variant;

public interface MakeRepository extends JpaRepository<Make, Integer>{
	public Make findByMakeId(Integer makeId);

	@Query(value="SELECT * FROM utrust.master_make ORDER BY display_order ASC", nativeQuery=true)
	public List<Make> findAllMakeInOrder();
	
}