package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.utrust.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("from Customer where mobile_number=:mobileNumber ")
	public Customer getCustomer(@Param("mobileNumber") String mobileNumber);
}
