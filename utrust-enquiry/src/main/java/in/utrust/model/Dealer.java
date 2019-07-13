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
import javax.persistence.Table;

@Entity
@Table(name = "dealer")
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dealer_id")
	private Integer dealerId;

	@Column(name = "dealer_name")
	private String dealerName;

	@Column(name = "dealer_location")
	private String dealerLocation;

	@Column(name = "dealer_group")
	private String dealerGroup;

	@Column(name = "branch_code")
	private String branchCode;
	
	@Column(name = "dealer_code")
	private String dealerCode;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer", fetch = FetchType.LAZY)
	private List<DealerUser> dealerUserList = new ArrayList<>();
	
	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public String getDealerGroup() {
		return dealerGroup;
	}

	public void setDealerGroup(String dealerGroup) {
		this.dealerGroup = dealerGroup;
	}

	public List<DealerUser> getDealerUserList() {
		return dealerUserList;
	}

	public void setDealerUserList(List<DealerUser> dealerUserList) {
		this.dealerUserList = dealerUserList;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

}