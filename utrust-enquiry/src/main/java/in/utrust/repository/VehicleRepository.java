package in.utrust.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	@Query("from Vehicle where collectedDate between (:fromDate) and (:toDate)")
	public List<Vehicle> collectedVehicle(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);
	
	@Query("from Vehicle where purchaseDate between (:fromDate) and (:toDate)")
	public List<Vehicle> purchasedVehicle(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);
	
	@Query(value = "SELECT * FROM vehicle where branch_code in (:branchCodeList) and make_id = IFNULL(:makeId,make_id) and model_id = IFNULL(:modelId,model_id) and variant_id = IFNULL(:vairentId,variant_id) and year = IFNULL(:year,year)"
			+ " and vehicle_stage_id is not null and vehicle_stage_id not in(:soldId)", nativeQuery = true)
	List<Vehicle> getGivenStockData(@Param("branchCodeList")List<String> branchCodeList,@Param("makeId")Integer makeId, @Param("modelId")Integer modelId, @Param("vairentId")Integer vairentId, @Param("year")Integer year,@Param("soldId")Integer soldId);
	
	
}