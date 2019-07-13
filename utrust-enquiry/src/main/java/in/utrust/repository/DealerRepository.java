package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.utrust.model.Dealer;

@Repository("DealerRepository")
public interface DealerRepository extends JpaRepository<Dealer, Long> {

	Dealer findByDealerId(Integer createdBy);

	@Query(value = "select d.* from dealer d,dealer_user du where du.uctdms_id=?1 and du.dealer_id=d.dealer_id", nativeQuery = true)
	public Dealer getDealer(Integer uctdmsId);
	
	@Query("select branchCode from Dealer where dealerCode=:dealerCode")
	public List<String> getDealerByDealerCode(@Param("dealerCode") String  dealerCode);


}