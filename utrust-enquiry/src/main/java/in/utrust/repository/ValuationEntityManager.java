package in.utrust.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.utrust.constants.Constants;
import in.utrust.response.BodyTypeResponse;
import in.utrust.response.CurrentCarResponse;
import in.utrust.response.CurrentCarUsageResponse;
import in.utrust.response.EmmissionResponse;
import in.utrust.response.InsuranceCompanyResponse;
import in.utrust.response.InsuranceTypeResponse;
import in.utrust.response.NocStatusResponse;
import in.utrust.response.RCTypeResponse;
import in.utrust.response.ServiceHistoryResponse;
import in.utrust.response.VinPlateResponse;

@Repository
public class ValuationEntityManager {

	@PersistenceContext
	EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(ValuationEntityManager.class);

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<VinPlateResponse> getVinPlateResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_vin_plate");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}

	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<BodyTypeResponse> getBodyTypeResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_body_type");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}

	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<ServiceHistoryResponse> getServiceHistoryResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_service_history");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<CurrentCarUsageResponse> getCurrentCarUsageResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_current_car_usage");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<NocStatusResponse> getNocStatusResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_noc_status");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<CurrentCarResponse> getCurrentCarResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_current_car");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RCTypeResponse> getRCTypeResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_rc_type");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<EmmissionResponse> getEmmissionResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_emmission");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<InsuranceTypeResponse> getInsuranceTypeResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_insurance_type");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<InsuranceCompanyResponse> getInsuranceCompanyResponse() {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM master_insurance_company");

			return query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VinPlateResponse.class)).getResultList();

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			throw e;
		}
	}
}
