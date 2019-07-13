package in.utrust.request;

public class FollowUpRequest {
	ActualFollowUpRequest actualFollowUp;
	NextFollowUpRequest nextFollowUp;
	public ActualFollowUpRequest getActualFollowUp() {
		return actualFollowUp;
	}
	public void setActualFollowUp(ActualFollowUpRequest actualFollowUp) {
		this.actualFollowUp = actualFollowUp;
	}
	public NextFollowUpRequest getNextFollowUp() {
		return nextFollowUp;
	}
	public void setNextFollowUp(NextFollowUpRequest nextFollowUp) {
		this.nextFollowUp = nextFollowUp;
	}
}
