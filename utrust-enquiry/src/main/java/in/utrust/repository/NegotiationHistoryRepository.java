package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.NegotiationHistory;

public interface NegotiationHistoryRepository extends JpaRepository<NegotiationHistory, Integer>{
	
	@Query(value =" select * from  negotiation_history where enq_number=:enqNumber ORDER BY id DESC LIMIT 1 ", nativeQuery=true )
	public NegotiationHistory findByEnqNumber(@Param("enqNumber") String enqNumber);
	
}
