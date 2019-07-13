package in.utrust.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.utrust.model.UserDevice;

@Repository("UserDeviceRepository")
public interface UserDeviceRepository extends JpaRepository<UserDevice, Integer> {
	@Query(value = "select  deviceToken from UserDevice where uctdmsId=:uctdmsId ")
	public String getDeviceToken(@Param("uctdmsId") Integer  uctdmsId);

	@Query(value = "from UserDevice where uctdmsId=:uctdmsId ")
	public UserDevice getUserDevice(@Param("uctdmsId") Integer  uctdmsId);
}
