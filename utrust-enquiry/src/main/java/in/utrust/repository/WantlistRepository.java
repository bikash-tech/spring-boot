package in.utrust.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.WantList;

public interface WantlistRepository extends JpaRepository<WantList, Integer> {
	@Query(value = "SELECT wan.id wantlist_id, wan.year wantlist_year,wan.count wantlist_count,wan.created_date wantlist_created_date,wan.updated_date wantlist_updated_date, "
			+ " mmo.id model_id,mmo.name model_name,mma.id make_id,mma.name make_name, mva.id variant_id,mva.name variant_name, mec.id color_id,mec.name color_name, "
			+ " dus.dealer_user_id dealer_user_id, concat(dus.first_name, ' ' ,dus.last_name) updated_by FROM wantlist wan,master_model mmo,master_make mma,master_variant mva, "
			+ " master_exterior_color mec,dealer_user dus where wan.model_id = mmo.id and wan.make_id = mma.id and wan.suffix = mva.id and wan.color = mec.id and "
			+ " wan.updated_by = dus.dealer_user_id and wan.model_id = IF(?1 = 0,wan.model_id,?1) and wan.make_id = IF(?2 = 0,wan.make_id,?2) and wan.suffix = IF(?3 = 0,wan.suffix,?3)"
			+ " and wan.year = IF(?4 = 0,wan.year,?4)", nativeQuery = true)
	List<Object[]> findByGivendata(Integer modelId, Integer makeId, Integer suffix, Integer year, Pageable pageable);
	
	
	@Query("from WantList  where branchCode in :ids order by createdDate desc")
	public List<WantList> getWantListByBranchCodeList(@Param("ids") List<String> branchCodeList);
}