package in.utrust.request;

public class ValuationSummaryResponse{
	
	private Boolean initial;
	private Boolean detailed;
	private int exterior;
	private int interior;
	private int frame  ;
	private int score;
	private Boolean accidental;
	private Boolean flooding;
	private Boolean duplicateRc;
	private Boolean insuranceExpired;
	private Boolean totalLoss;
	private double estRfCost;
	private Boolean documentation;
	public Boolean getInitial() {
		return initial;
	}
	public void setInitial(Boolean initial) {
		this.initial = initial;
	}
	public Boolean getDetailed() {
		return detailed;
	}
	public void setDetailed(Boolean detailed) {
		this.detailed = detailed;
	}
	public int getExterior() {
		return exterior;
	}
	public void setExterior(int exterior) {
		this.exterior = exterior;
	}
	public int getInterior() {
		return interior;
	}
	public void setInterior(int interior) {
		this.interior = interior;
	}
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Boolean getAccidental() {
		return accidental;
	}
	public void setAccidental(Boolean accidental) {
		this.accidental = accidental;
	}
	public Boolean getFlooding() {
		return flooding;
	}
	public void setFlooding(Boolean flooding) {
		this.flooding = flooding;
	}
	public Boolean getDuplicateRc() {
		return duplicateRc;
	}
	public void setDuplicateRc(Boolean duplicateRc) {
		this.duplicateRc = duplicateRc;
	}
	public Boolean getInsuranceExpired() {
		return insuranceExpired;
	}
	public void setInsuranceExpired(Boolean insuranceExpired) {
		this.insuranceExpired = insuranceExpired;
	}
	public Boolean getTotalLoss() {
		return totalLoss;
	}
	public void setTotalLoss(Boolean totalLoss) {
		this.totalLoss = totalLoss;
	}
	public double getEstRfCost() {
		return estRfCost;
	}
	public void setEstRfCost(double estRfCost) {
		this.estRfCost = estRfCost;
	}
	public Boolean getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Boolean documentation) {
		this.documentation = documentation;
	}
}
