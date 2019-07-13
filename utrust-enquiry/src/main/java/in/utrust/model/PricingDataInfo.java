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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pricing_data_info")
public class PricingDataInfo {

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "priceDataInfo", fetch = FetchType.LAZY)
	private List<SimilarTransaction> similarTransaction = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "priceDataInf", fetch = FetchType.LAZY)
	private List<CarVolume> CarVolumeList = new ArrayList<>();

	@OneToOne(mappedBy="pricingDataInformation", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private PricingData pricingData;

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

	public List<SimilarTransaction> getSimilarTransaction() {
		return similarTransaction;
	}

	public void setSimilarTransaction(List<SimilarTransaction> similarTransaction) {
		this.similarTransaction = similarTransaction;
	}

	public List<CarVolume> getCarVolumeList() {
		return CarVolumeList;
	}

	public void setCarVolumeList(List<CarVolume> carVolumeList) {
		CarVolumeList = carVolumeList;
	}

	public PricingData getPricingData() {
		return pricingData;
	}

	public void setPricingData(PricingData pricingData) {
		this.pricingData = pricingData;
	}

	@Override
	public String toString() {
		return "PricingDataInfo [id=" + id + ", make=" + make + ", model=" + model + ", variant=" + variant + ", year="
				+ year + ", color=" + color + ", mileage=" + mileage + ", city=" + city + ", prevOwner=" + prevOwner
				+ ", quality=" + quality + ", fuel=" + fuel + ", transmission=" + transmission + ", insuranceType="
				+ insuranceType + ", similarTransaction=" + similarTransaction + ", CarVolumeList=" + CarVolumeList
				+ ", pricingData=" + pricingData + "]";
	}

	
	
}
