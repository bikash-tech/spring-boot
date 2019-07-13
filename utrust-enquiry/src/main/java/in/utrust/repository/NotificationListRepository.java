package in.utrust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.utrust.model.NotificationList;

@Repository("NotificationListRepository")
public interface NotificationListRepository extends JpaRepository<NotificationList, Integer> {

	@Query("from NotificationList where toUser=:uctdmsId order by id desc")
	List<NotificationList> getNotificationList(@Param("uctdmsId") Integer uctdmsId);

	public NotificationList getNotificationByIdAndEnquiryNumber(Integer notificationId,String enquiryNumber);

	@Query("from NotificationList where id=:notificationId")
	public NotificationList getNotificationListById(@Param("notificationId")Integer notificationId);
	
	@Query(value =" select * from  notification_list where enq_number=:enqNumber ORDER BY id DESC LIMIT 1 ", nativeQuery=true )
	public NotificationList getLatestEnquiry(@Param("enqNumber") String enqNumber);
	
}
