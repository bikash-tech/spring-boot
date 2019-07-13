package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import in.utrust.model.User;


@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	 
	@Query("FROM User  WHERE uctdmsId = :uctdmsId")
	public User getUserDetails(@Param("uctdmsId") Integer uctdmsId);
	
	@Query("FROM User  WHERE userRoleId =:userRoleId")
	public List<User> getPoList(@Param("userRoleId") Integer userRoleId);

}
