package in.utrust.response;

import java.util.List;

public class StockMatchingResponse {
	public List<VehicleResponseStock> getListVehicleResponses() {
		return listVehicleResponses;
	}

	public void setListVehicleResponses(List<VehicleResponseStock> listVehicleResponses) {
		this.listVehicleResponses = listVehicleResponses;
	}

	List<VehicleResponseStock> listVehicleResponses;
}