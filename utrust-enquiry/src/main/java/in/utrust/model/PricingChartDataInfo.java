package in.utrust.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pricing_chart_data_info")
public class PricingChartDataInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "variant")
	private String variant;

	@Column(name = "year")
	private String year;

	@Column(name = "colour")
	private String color;

	@Column(name = "mileage")
	private Integer mileage;

	@Column(name = "city")
	private String city;

	@Column(name = "previous_owner")
	private Integer prevOwner;

	@Column(name = "quality")
	private Integer quality;

	@Column(name = "fuel")
	private Integer fuel;

	@Column(name = "transmission")
	private Integer transmission;

	@Column(name = "insurance_type")
	private Integer insuranceType;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pricingChartDataInfo", fetch = FetchType.LAZY)
	private List<SimilarTransaction_copy> similarTransaction = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pricingChartDataInfo", fetch = FetchType.LAZY)
	private List<CarVolume_copy> CarVolumeList = new ArrayList<>();

	@Column(name = "final_price_range_min")
	private Double finalPriceRangeMin;

	@Column(name = "final_price_range_max")
	private Double finalPriceRangeMax;

	@Column(name = "final_price_range_best_buy_min")
	private Double finalPriceRangeBestBuyMin;

	@Column(name = "final_price_range_best_buy_max")
	private Double finalPriceRangeBestBuyMax;

	@Column(name = "typical_inventory_days")
	private Integer typicalInventoryDays;

	@Column(name = "sourcing_price_toyota_min")
	private Double sourcingPriceToyotaMin;

	@Column(name = "sourcing_price_toyota_max")
	private Double sourcingPriceToyotaMax;

	@Column(name = "retail_price_toyota_min")
	private Double retailPriceToyotaMin;

	@Column(name = "retail_price_toyota_max")
	private Double retailPriceToyotaMax;

	@Column(name = "market_price_c2c_min")
	private Double marketPriceC2CMin;

	@Column(name = "market_price_c2c_max")
	private Double marketPriceC2CMax;

	@Column(name = "market_price_b2c_min")
	private Double marketPriceB2CMin;

	@Column(name = "market_price_b2c_max")
	private Double marketPriceB2CMax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPrevOwner() {
		return prevOwner;
	}

	public void setPrevOwner(Integer prevOwner) {
		this.prevOwner = prevOwner;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Integer getFuel() {
		return fuel;
	}

	public void setFuel(Integer fuel) {
		this.fuel = fuel;
	}

	public Integer getTransmission() {
		return transmission;
	}

	public void setTransmission(Integer transmission) {
		this.transmission = transmission;
	}

	public Integer getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}

	public List<SimilarTransaction_copy> getSimilarTransaction() {
		return similarTransaction;
	}

	public void setSimilarTransaction(List<SimilarTransaction_copy> similarTransaction) {
		this.similarTransaction = similarTransaction;
	}

	public List<CarVolume_copy> getCarVolumeList() {
		return CarVolumeList;
	}

	public void setCarVolumeList(List<CarVolume_copy> carVolumeList) {
		CarVolumeList = carVolumeList;
	}

	public Double getFinalPriceRangeMin() {
		return finalPriceRangeMin;
	}

	public void setFinalPriceRangeMin(Double finalPriceRangeMin) {
		this.finalPriceRangeMin = finalPriceRangeMin;
	}

	public Double getFinalPriceRangeMax() {
		return finalPriceRangeMax;
	}

	public void setFinalPriceRangeMax(Double finalPriceRangeMax) {
		this.finalPriceRangeMax = finalPriceRangeMax;
	}

	public Double getFinalPriceRangeBestBuyMin() {
		return finalPriceRangeBestBuyMin;
	}

	public void setFinalPriceRangeBestBuyMin(Double finalPriceRangeBestBuyMin) {
		this.finalPriceRangeBestBuyMin = finalPriceRangeBestBuyMin;
	}

	public Double getFinalPriceRangeBestBuyMax() {
		return finalPriceRangeBestBuyMax;
	}

	public void setFinalPriceRangeBestBuyMax(Double finalPriceRangeBestBuyMax) {
		this.finalPriceRangeBestBuyMax = finalPriceRangeBestBuyMax;
	}

	public Integer getTypicalInventoryDays() {
		return typicalInventoryDays;
	}

	public void setTypicalInventoryDays(Integer typicalInventoryDays) {
		this.typicalInventoryDays = typicalInventoryDays;
	}

	public Double getSourcingPriceToyotaMin() {
		return sourcingPriceToyotaMin;
	}

	public void setSourcingPriceToyotaMin(Double sourcingPriceToyotaMin) {
		this.sourcingPriceToyotaMin = sourcingPriceToyotaMin;
	}

	public Double getSourcingPriceToyotaMax() {
		return sourcingPriceToyotaMax;
	}

	public void setSourcingPriceToyotaMax(Double sourcingPriceToyotaMax) {
		this.sourcingPriceToyotaMax = sourcingPriceToyotaMax;
	}

	public Double getRetailPriceToyotaMin() {
		return retailPriceToyotaMin;
	}

	public void setRetailPriceToyotaMin(Double retailPriceToyotaMin) {
		this.retailPriceToyotaMin = retailPriceToyotaMin;
	}

	public Double getRetailPriceToyotaMax() {
		return retailPriceToyotaMax;
	}

	public void setRetailPriceToyotaMax(Double retailPriceToyotaMax) {
		this.retailPriceToyotaMax = retailPriceToyotaMax;
	}

	public Double getMarketPriceC2CMin() {
		return marketPriceC2CMin;
	}

	public void setMarketPriceC2CMin(Double marketPriceC2CMin) {
		this.marketPriceC2CMin = marketPriceC2CMin;
	}

	public Double getMarketPriceC2CMax() {
		return marketPriceC2CMax;
	}

	public void setMarketPriceC2CMax(Double marketPriceC2CMax) {
		this.marketPriceC2CMax = marketPriceC2CMax;
	}

	public Double getMarketPriceB2CMin() {
		return marketPriceB2CMin;
	}

	public void setMarketPriceB2CMin(Double marketPriceB2CMin) {
		this.marketPriceB2CMin = marketPriceB2CMin;
	}

	public Double getMarketPriceB2CMax() {
		return marketPriceB2CMax;
	}

	public void setMarketPriceB2CMax(Double marketPriceB2CMax) {
		this.marketPriceB2CMax = marketPriceB2CMax;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PricingChartDataInfo [id=");
		builder.append(id);
		builder.append(", make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", variant=");
		builder.append(variant);
		builder.append(", year=");
		builder.append(year);
		builder.append(", color=");
		builder.append(color);
		builder.append(", mileage=");
		builder.append(mileage);
		builder.append(", city=");
		builder.append(city);
		builder.append(", prevOwner=");
		builder.append(prevOwner);
		builder.append(", quality=");
		builder.append(quality);
		builder.append(", fuel=");
		builder.append(fuel);
		builder.append(", transmission=");
		builder.append(transmission);
		builder.append(", insuranceType=");
		builder.append(insuranceType);
		builder.append(", similarTransaction=");
		builder.append(similarTransaction);
		builder.append(", CarVolumeList=");
		builder.append(CarVolumeList);
		builder.append(", finalPriceRangeMin=");
		builder.append(finalPriceRangeMin);
		builder.append(", finalPriceRangeMax=");
		builder.append(finalPriceRangeMax);
		builder.append(", finalPriceRangeBestBuyMin=");
		builder.append(finalPriceRangeBestBuyMin);
		builder.append(", finalPriceRangeBestBuyMax=");
		builder.append(finalPriceRangeBestBuyMax);
		builder.append(", typicalInventoryDays=");
		builder.append(typicalInventoryDays);
		builder.append(", sourcingPriceToyotaMin=");
		builder.append(sourcingPriceToyotaMin);
		builder.append(", sourcingPriceToyotaMax=");
		builder.append(sourcingPriceToyotaMax);
		builder.append(", retailPriceToyotaMin=");
		builder.append(retailPriceToyotaMin);
		builder.append(", retailPriceToyotaMax=");
		builder.append(retailPriceToyotaMax);
		builder.append(", marketPriceC2CMin=");
		builder.append(marketPriceC2CMin);
		builder.append(", marketPriceC2CMax=");
		builder.append(marketPriceC2CMax);
		builder.append(", marketPriceB2CMin=");
		builder.append(marketPriceB2CMin);
		builder.append(", marketPriceB2CMax=");
		builder.append(marketPriceB2CMax);
		builder.append("]");
		return builder.toString();
	}

}
