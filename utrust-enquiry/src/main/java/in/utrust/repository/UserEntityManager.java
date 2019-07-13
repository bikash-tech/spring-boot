package in.utrust.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.utrust.constants.Constants;
import in.utrust.model.Vehicle;
import in.utrust.response.UserResponse;

@Repository
public class UserEntityManager {

	@PersistenceContext
	EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(UserEntityManager.class);

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<UserResponse> getListOfReporties(Integer reportingTo) {
		try {
			Query query = entityManager
					.createQuery("SELECT uctdmsId as id ,firstName as name from User u where reportingTo= :reportingTo ");
			query.setParameter("reportingTo", reportingTo);

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(UserResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}

	}
	
 	public String getSMSContent(Integer id) {
		try {
			Query query = entityManager
					.createNativeQuery("SELECT content from master_sms where id=:id ");
			query.setParameter("id", id);

			return (String) query.getSingleResult();
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
 	
	public List<Vehicle> getPendingDocuments(Date fromDate,Date toDate){

		try {
			Query query = entityManager
					.createNativeQuery("select v.* FROM enquiry en ,vehicle v ,  procurement_checklist_mapping cm "
							+ "WHERE v.id= en.vehicle_id and en.enq_number=cm.enquiry_number "
			+ " and cm.target_date  >=:fromDate  AND target_date <=:toDate AND  cm.document_urls IS NULL");
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);


			return  query.getResultList();
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	
		
	}
	
}
