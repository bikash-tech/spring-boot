package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pricing_data")
public class PricingData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer pricingDataId;
	
	@Column(name = "vehicle_id")
	private Integer vehicleId;
	
	@Column(name = "final_price_range_min")
	private double finalPriceRangeMin;
	
	@Column(name = "final_price_range_max")
	private double finalPriceRangeMax;
	
	@Column(name = "final_price_range_best_buy_min")
	private double finalPriceRangeBestBuyMin;
	
	@Column(name = "final_price_range_best_buy_max")
	private double finalPriceRangeBestBuyMax;
	
	@Column(name = "typical_inventory_days")
	private int typicalInventoryDays;
	
	@Column(name = "sourcing_price_toyota_min")
	private double sourcingPriceToyotaMin;
	
	@Column(name = "sourcing_price_toyota_max")
	private double sourcingPriceToyotaMax;
	
	@Column(name = "retail_price_toyota_min")
	private double retailPriceToyotaMin;
	
	@Column(name = "retail_price_toyota_max")
	private double retailPriceToyotaMax;
	
	@Column(name = "market_price_c2c_min")
	private double marketPriceC2CMin;
	
	@Column(name = "market_price_c2c_max")
	private double marketPriceC2CMax;
	
	@Column(name = "market_price_b2c_min")
	private double marketPriceB2CMin;
	
	@Column(name = "market_price_b2c_max")
	private double marketPriceB2CMax;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="price_data_info_id")
	private PricingDataInfo pricingDataInformation;
	
	public Integer getPricingDataId() {
		return pricingDataId;
	}

	public void setPricingDataId(Integer pricingDataId) {
		this.pricingDataId = pricingDataId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getFinalPriceRangeMin() {
		return finalPriceRangeMin;
	}

	public void setFinalPriceRangeMin(double finalPriceRangeMin) {
		this.finalPriceRangeMin = finalPriceRangeMin;
	}

	public double getFinalPriceRangeMax() {
		return finalPriceRangeMax;
	}

	public void setFinalPriceRangeMax(double finalPriceRangeMax) {
		this.finalPriceRangeMax = finalPriceRangeMax;
	}

	public double getFinalPriceRangeBestBuyMin() {
		return finalPriceRangeBestBuyMin;
	}

	public void setFinalPriceRangeBestBuyMin(double finalPriceRangeBestBuyMin) {
		this.finalPriceRangeBestBuyMin = finalPriceRangeBestBuyMin;
	}

	public double getFinalPriceRangeBestBuyMax() {
		return finalPriceRangeBestBuyMax;
	}

	public void setFinalPriceRangeBestBuyMax(double finalPriceRangeBestBuyMax) {
		this.finalPriceRangeBestBuyMax = finalPriceRangeBestBuyMax;
	}

	public int getTypicalInventoryDays() {
		return typicalInventoryDays;
	}

	public void setTypicalInventoryDays(int typicalInventoryDays) {
		this.typicalInventoryDays = typicalInventoryDays;
	}

	public double getSourcingPriceToyotaMin() {
		return sourcingPriceToyotaMin;
	}

	public void setSourcingPriceToyotaMin(double sourcingPriceToyotaMin) {
		this.sourcingPriceToyotaMin = sourcingPriceToyotaMin;
	}

	public double getSourcingPriceToyotaMax() {
		return sourcingPriceToyotaMax;
	}

	public void setSourcingPriceToyotaMax(double sourcingPriceToyotaMax) {
		this.sourcingPriceToyotaMax = sourcingPriceToyotaMax;
	}

	public double getRetailPriceToyotaMin() {
		return retailPriceToyotaMin;
	}

	public void setRetailPriceToyotaMin(double retailPriceToyotaMin) {
		this.retailPriceToyotaMin = retailPriceToyotaMin;
	}

	public double getRetailPriceToyotaMax() {
		return retailPriceToyotaMax;
	}

	public void setRetailPriceToyotaMax(double retailPriceToyotaMax) {
		this.retailPriceToyotaMax = retailPriceToyotaMax;
	}

	public double getMarketPriceC2CMin() {
		return marketPriceC2CMin;
	}

	public void setMarketPriceC2CMin(double marketPriceC2CMin) {
		this.marketPriceC2CMin = marketPriceC2CMin;
	}

	public double getMarketPriceC2CMax() {
		return marketPriceC2CMax;
	}

	public void setMarketPriceC2CMax(double marketPriceC2CMax) {
		this.marketPriceC2CMax = marketPriceC2CMax;
	}

	public double getMarketPriceB2CMin() {
		return marketPriceB2CMin;
	}

	public void setMarketPriceB2CMin(double marketPriceB2CMin) {
		this.marketPriceB2CMin = marketPriceB2CMin;
	}

	public double getMarketPriceB2CMax() {
		return marketPriceB2CMax;
	}

	public void setMarketPriceB2CMax(double marketPriceB2CMax) {
		this.marketPriceB2CMax = marketPriceB2CMax;
	}

	
	
	
}
