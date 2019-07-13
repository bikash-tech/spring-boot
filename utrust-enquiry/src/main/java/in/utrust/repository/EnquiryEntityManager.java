package in.utrust.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.utrust.constants.Constants;
import in.utrust.model.Channel;
import in.utrust.model.DemandStructure;
import in.utrust.model.ExteriorColor;
import in.utrust.model.InsuranceType;
import in.utrust.model.PricingChartDataInfo;
import in.utrust.model.SellingReason;
import in.utrust.model.SourceName;
import in.utrust.model.SourceType;
import in.utrust.model.StatusReasoning;
import in.utrust.model.TemporaryVehicle;
import in.utrust.model.VehicleStage;

@Repository
public class EnquiryEntityManager {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(EnquiryEntityManager.class);
 	
	public String getTemporaryRegNumber(){
		try {
			Query query = entityManager.createQuery("select max(tempRegistraionNumber) from TemporaryVehicle");
			return  (String) query.getSingleResult();
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	public void saveTemporaryRegNumber(TemporaryVehicle tempVehicle){
		try {
			entityManager.persist(tempVehicle);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SourceType> getAllSourceType() {
		try {
			return entityManager.createQuery("from SourceType").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<StatusReasoning> getAllStatusReasoning() {
		try {
			return entityManager.createQuery("from StatusReasoning").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Channel> getAllChannel() {
		try {
			return entityManager.createQuery("from Channel").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SellingReason> getAllSellingReason() {
		try {
			return entityManager.createQuery("from SellingReason").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExteriorColor> getAllExteriorColor() {
		try {
			return entityManager.createQuery("from ExteriorColor").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DemandStructure> getAllDemandStructure() {
		try {
			return entityManager.createQuery("from DemandStructure").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<InsuranceType> getAllInsuranceType() {
		try {
			return entityManager.createQuery("from InsuranceType").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SourceName> getAllSourceName() {
		try {
			return entityManager.createQuery("from SourceName").getResultList();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	public VehicleStage getVehicleStage(int stageId) {
		try {
			Query query = entityManager.createQuery("from VehicleStage where id=:stageId");
			query.setParameter("stageId", stageId);
			
			return (VehicleStage) query.getSingleResult();
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public PricingChartDataInfo getPricingChartDataByByCarMake(String carMake) {
		try {
			Query query = entityManager.createQuery("from PricingChartDataInfo where make=:carMake order by id desc");
			return (PricingChartDataInfo) query.setParameter("carMake", carMake).getResultList().stream().findFirst().orElse(null);
		}catch(Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	
}
