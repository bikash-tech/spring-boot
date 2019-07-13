package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.PricingData;


public interface PricingDataRepository extends JpaRepository<PricingData, Integer>{



	@Query(value="SELECT p.* FROM pricing_data p , vehicle v where p.vehicle_id = v.id AND v.make_id=:makeId AND v.model_id=:modelId "
			+ "AND v.suffix=:suffix AND v.fuel_type=:fuelType AND v.transmission_type=:transmissionType AND v.year=:year AND v.accidental=:accidental AND "
			+ "v.exterior_colour_id=:exteriorColourId AND v.insurance=:insurance AND "
			+ "v.previous_owners=:previousOwners AND v.variant_id=:variantId",nativeQuery=true)
	public PricingData getPricingData(@Param("makeId") Integer makeId,
			@Param("modelId") int modelId,
			@Param("suffix") String suffix,
			@Param("fuelType") String fuelType,
			@Param("transmissionType") String transmissionType,
			@Param("year") int year,
			@Param("accidental") boolean accidental,
			@Param("exteriorColourId") int exteriorColourId,
			@Param("insurance") boolean insurance,
			@Param("previousOwners") int previousOwners,
			@Param("variantId") int variantId
			);

	
//	@Query("SELECT p FROM PricingData p , Vehicle v where p.vehicleId = v.vehicleId")
//			/*+ " AND v.make_id=:makeId AND v.model_id=:modelId "
//			+ "AND v.suffix=:suffix AND v.fuel_type=:fuelType AND v.transmission_type=:transmissionType AND v.year=:year AND v.accidental=:accidental AND "
//			+ "v.exterior_colour_id=:exteriorColourId AND v.insurance=:insurance AND "
//			+ "v.previous_owners=:previousOwners AND v.variant_id=:variantId")*/
//	public PricingData getPricingDataNew(@Param("makeId") Integer makeId,
//			@Param("modelId") int modelId,
//			@Param("suffix") String suffix,
//			@Param("fuelType") String fuelType,
//			@Param("transmissionType") String transmissionType,
//			@Param("year") int year,
//			@Param("accidental") boolean accidental,
//			@Param("exteriorColourId") int exteriorColourId,
//			@Param("insurance") boolean insurance,
//			@Param("previousOwners") int previousOwners,
//			@Param("variantId") int variantId
//			);

}
