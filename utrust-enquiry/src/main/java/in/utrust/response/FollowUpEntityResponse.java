package in.utrust.response;

import java.util.List;

public class FollowUpEntityResponse {
	private List<FollowUpResponse> followUpList;

	public List<FollowUpResponse> getFollowUpList() {
		return followUpList;
	}

	public void setFollowUpList(List<FollowUpResponse> followUpList) {
		this.followUpList = followUpList;
	}

	@Override
	public String toString() {
		return "FollowUpEntityResponse [\nfollowUpList=" + followUpList + "]";
	}

}
