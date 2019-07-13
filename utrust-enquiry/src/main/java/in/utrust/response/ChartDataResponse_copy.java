package in.utrust.response;

import java.util.ArrayList;
import java.util.List;

public class ChartDataResponse_copy {

	private PriceRangeResponse priceRangeResponse;
	
	private List<SimilarTransactionResponse> SimilarTransactionResponse = new ArrayList<>();
	
	private CarVolumeResponse carVolumeResponse;

	public PriceRangeResponse getPriceRangeResponse() {
		return priceRangeResponse;
	}

	public void setPriceRangeResponse(PriceRangeResponse priceRangeResponse) {
		this.priceRangeResponse = priceRangeResponse;
	}

	public List<SimilarTransactionResponse> getSimilarTransactionResponse() {
		return SimilarTransactionResponse;
	}

	public void setSimilarTransactionResponse(List<SimilarTransactionResponse> similarTransactionResponse) {
		SimilarTransactionResponse = similarTransactionResponse;
	}

	public CarVolumeResponse getCarVolumeResponse() {
		return carVolumeResponse;
	}

	public void setCarVolumeResponse(CarVolumeResponse carVolumeResponse) {
		this.carVolumeResponse = carVolumeResponse;
	}

	@Override
	public String toString() {
		return "ChartDataResponse [priceRangeResponse=" + priceRangeResponse + ", SimilarTransactionResponse="
				+ SimilarTransactionResponse + ", carVolumeResponse=" + carVolumeResponse + "]";
	}

	
	
}
