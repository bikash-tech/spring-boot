package in.utrust.response;

public class PriceRangeResponse {

	private Double finalPriceRangeMin;
	
	private Double finalPriceRangeMax;
	
	private Double finalPriceRangeBestBuyMin;
	
	private Double finalPriceRangeBestBuyMax;
	
	private Integer typicalInventoryDays;
	
	private Double sourcingPriceToyotaMin;
	
	private Double sourcingPriceToyotaMax;
	
	private Double retailPriceToyotaMin;
	
	private Double retailPriceToyotaMax;
	
	private Double marketPriceC2CMin;
	
	private Double marketPriceC2CMax;
	
	private Double marketPriceB2CMin;
	
	private Double marketPriceB2CMax;

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
		return "PriceRangeResponse [finalPriceRangeMin=" + finalPriceRangeMin + ", finalPriceRangeMax="
				+ finalPriceRangeMax + ", finalPriceRangeBestBuyMin=" + finalPriceRangeBestBuyMin
				+ ", finalPriceRangeBestBuyMax=" + finalPriceRangeBestBuyMax + ", typicalInventoryDays="
				+ typicalInventoryDays + ", sourcingPriceToyotaMin=" + sourcingPriceToyotaMin
				+ ", sourcingPriceToyotaMax=" + sourcingPriceToyotaMax + ", retailPriceToyotaMin="
				+ retailPriceToyotaMin + ", retailPriceToyotaMax=" + retailPriceToyotaMax + ", marketPriceC2CMin="
				+ marketPriceC2CMin + ", marketPriceC2CMax=" + marketPriceC2CMax + ", marketPriceB2CMin="
				+ marketPriceB2CMin + ", marketPriceB2CMax=" + marketPriceB2CMax + "]";
	}

	

}
