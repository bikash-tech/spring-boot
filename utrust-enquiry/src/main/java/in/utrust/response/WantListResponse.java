package in.utrust.response;

import java.util.Date;

public class WantListResponse {
	private Integer wantListId;
	private Integer year;
	private Integer count;
	private Date createdDate;
	private Date UpdatedDate;
	private String updatedBy;
	private MakeResponse makeResponse;
	private VariantResponse variantResponse;
	private ModelResponse modelResponse;
	private ExteriorColorResponse colorResponse;

	public Integer getWantListId() {
		return wantListId;
	}

	public void setWantListId(Integer wantListId) {
		this.wantListId = wantListId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		UpdatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public MakeResponse getMakeResponse() {
		return makeResponse;
	}

	public void setMakeResponse(MakeResponse makeResponse) {
		this.makeResponse = makeResponse;
	}

	public VariantResponse getVariantResponse() {
		return variantResponse;
	}

	public void setVariantResponse(VariantResponse variantResponse) {
		this.variantResponse = variantResponse;
	}

	public ModelResponse getModelResponse() {
		return modelResponse;
	}

	public void setModelResponse(ModelResponse modelResponse) {
		this.modelResponse = modelResponse;
	}

	public ExteriorColorResponse getColorResponse() {
		return colorResponse;
	}

	public void setColorResponse(ExteriorColorResponse colorResponse) {
		this.colorResponse = colorResponse;
	}
}