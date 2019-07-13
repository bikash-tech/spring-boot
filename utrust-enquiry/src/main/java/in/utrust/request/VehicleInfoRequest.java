package in.utrust.request;

public class VehicleInfoRequest {
	private String vinNumber;
	private int vinPlateId;
	private Boolean originalVinPlate;
	private int engineNo;
	private int bodyTypeId;
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public int getVinPlateId() {
		return vinPlateId;
	}
	public void setVinPlateId(int vinPlateId) {
		this.vinPlateId = vinPlateId;
	}
	public Boolean getOriginalVinPlate() {
		return originalVinPlate;
	}
	public void setOriginalVinPlate(Boolean originalVinPlate) {
		this.originalVinPlate = originalVinPlate;
	}
	public int getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}
	public int getBodyTypeId() {
		return bodyTypeId;
	}
	public void setBodyTypeId(int bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}
}
