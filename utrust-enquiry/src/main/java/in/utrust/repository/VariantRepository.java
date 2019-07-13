package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.utrust.model.Variant;

public interface VariantRepository extends JpaRepository<Variant, Integer>{
	@Query("select v from Variant v where v.model=:modelId")
	public List<Variant> findByMakeId(Integer modelId);
}