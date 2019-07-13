package in.utrust.response;

import java.util.List;

public class ParallelEnqPairResponse {

	private List<ParallelEnquiryResponse> ParallelEnquiryResponse;
	public List<ParallelEnquiryResponse> getParallelEnquiryResponse() {
		return ParallelEnquiryResponse;
	}
	public void setParallelEnquiryResponse(List<ParallelEnquiryResponse> parallelEnquiryResponse) {
		ParallelEnquiryResponse = parallelEnquiryResponse;
	}
	@Override
	public String toString() {
		return "ParallelEnqPairResponse [ParallelEnquiryResponse=" + ParallelEnquiryResponse + "]";
	}
}
