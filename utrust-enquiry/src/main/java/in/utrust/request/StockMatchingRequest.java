package in.utrust.request;

public class StockMatchingRequest {
	private Integer makeId;

	private Integer modelId;

	private Integer variantId;

	private Integer year;

	private Integer pageNumber;

	public Integer getMakeId() {
		return makeId;
	}

	public void setMakeId(Integer makeId) {
		this.makeId = makeId;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getVariantId() {
		return variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockMatchingRequest [makeId=");
		builder.append(makeId);
		builder.append(", modelId=");
		builder.append(modelId);
		builder.append(", variantId=");
		builder.append(variantId);
		builder.append(", year=");
		builder.append(year);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append("]");
		return builder.toString();
	}

}