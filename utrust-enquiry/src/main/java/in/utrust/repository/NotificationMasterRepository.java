package in.utrust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import in.utrust.model.NotificationMaster;

public interface NotificationMasterRepository extends JpaRepository<NotificationMaster, Integer> {
	@Query("From NotificationMaster where eventName=:eventName ")
	public NotificationMaster getNotificationByEvent(@Param("eventName") String eventName);
}