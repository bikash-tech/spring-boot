package in.utrust.model;

	import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "valuation")
	public class Valuation {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
 		@Column(name = "valuation_id")
		private Integer valuationId;

		@Column(name = "ext_score")
		private String exteriorScore;

		@Column(name = "int_score")
		private String interiorScore;

		@Column(name = "frame_score")
		private String frameScore;

		@Column(name = "eng_score")
		private String engineScore;

		@Column(name = "total_score")
		private String totalScore;

		@Column(name = "valuation_lvl")
		private String valuationLevel;

		@Column(name = "valuation_lvl_1")
		private String valuationLevel1;

		@Column(name = "valuation_lvl_2")
		private String valuationLevel2;

		@Column(name = "valuation_lvl_3")
		private String valuationLevel3;

		@Column(name = "estimated_rf_cost")
		private String estimatedRFCost;

		private String score;

		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "enquiry_id")
		private Enquiry enquiry;

		public Integer getValuationId() {
			return valuationId;
		}

		public void setValuationId(Integer valuationId) {
			this.valuationId = valuationId;
		}

		public String getExteriorScore() {
			return exteriorScore;
		}

		public void setExteriorScore(String exteriorScore) {
			this.exteriorScore = exteriorScore;
		}

		public String getInteriorScore() {
			return interiorScore;
		}

		public void setInteriorScore(String interiorScore) {
			this.interiorScore = interiorScore;
		}

		public String getFrameScore() {
			return frameScore;
		}

		public void setFrameScore(String frameScore) {
			this.frameScore = frameScore;
		}

		public String getEngineScore() {
			return engineScore;
		}

		public void setEngineScore(String engineScore) {
			this.engineScore = engineScore;
		}

		public String getTotalScore() {
			return totalScore;
		}

		public void setTotalScore(String totalScore) {
			this.totalScore = totalScore;
		}

		public String getValuationLevel() {
			return valuationLevel;
		}

		public void setValuationLevel(String valuationLevel) {
			this.valuationLevel = valuationLevel;
		}

		public String getValuationLevel1() {
			return valuationLevel1;
		}

		public void setValuationLevel1(String valuationLevel1) {
			this.valuationLevel1 = valuationLevel1;
		}

		public String getValuationLevel2() {
			return valuationLevel2;
		}

		public void setValuationLevel2(String valuationLevel2) {
			this.valuationLevel2 = valuationLevel2;
		}

		public String getValuationLevel3() {
			return valuationLevel3;
		}

		public void setValuationLevel3(String valuationLevel3) {
			this.valuationLevel3 = valuationLevel3;
		}

		public String getEstimatedRFCost() {
			return estimatedRFCost;
		}

		public void setEstimatedRFCost(String estimatedRFCost) {
			this.estimatedRFCost = estimatedRFCost;
		}

		public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}

		public Enquiry getEnquiry() {
			return enquiry;
		}

		public void setEnquiry(Enquiry enquiry) {
			this.enquiry = enquiry;
		}

	}

