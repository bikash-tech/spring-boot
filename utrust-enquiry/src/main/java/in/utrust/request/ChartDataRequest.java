package in.utrust.request;

import java.util.Date;

public class ChartDataRequest {

	private String carMake;
	
	private String carModel;
	
	private String variant;
	
	private String mfdYear;
	
	private String carColour;
	
	private Integer mileage;
	
	private String city;
	
	private Integer previousOwner;
	
	private Integer quality;
	
	private Integer fuel;
	
	private Integer transmission;
	
	private Integer insuranceType;

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getMfdYear() {
		return mfdYear;
	}

	public void setMfdYear(String mfdYear) {
		this.mfdYear = mfdYear;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
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

	public Integer getPreviousOwner() {
		return previousOwner;
	}

	public void setPreviousOwner(Integer previousOwner) {
		this.previousOwner = previousOwner;
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

	@Override
	public String toString() {
		return "ChartDataRequest [carMake=" + carMake + ", carModel=" + carModel + ", variant=" + variant + ", mfdYear="
				+ mfdYear + ", carColour=" + carColour + ", mileage=" + mileage + ", city=" + city + ", previousOwner="
				+ previousOwner + ", quality=" + quality + ", fuel=" + fuel + ", transmission=" + transmission
				+ ", insuranceType=" + insuranceType + "]";
	}

	
}
