
public class TrainStop {
	
	private String station;
	private String scheduledArrivalTime;
	private String scheduledDepartmentTime;
	private String estimatedLateArrival;
	private String estimatedLateDeparture;
	private String arrived;
	private String departured;
	
	public TrainStop() {
		
	}
	
	public void setStation(String station) {
		this.station = station;
	}
	
	public void setScheduledArrivalTime(String scheduledArrivalTime) {
		this.scheduledArrivalTime = scheduledArrivalTime;
	}
	
	public void setScheduledDepartmentTime(String scheduledDepartmentTime) {
		this.scheduledDepartmentTime = scheduledDepartmentTime;
	}
	
	public void setEstimatedLateArrival(String estimatedLateArrival) {
		this.estimatedLateArrival = estimatedLateArrival;
	}
	
	public void setEstimatedLateDeparture(String estimatedLateDeparture) {
		this.estimatedLateDeparture = estimatedLateDeparture;
	}
	
	public void setArrived(String arrived) {
		this.arrived = arrived;
	}
	
	public void setDepartured(String departured) {
		this.departured = departured;
	}
	
	public String getStation() {
		return this.station;
	}
	
	public String getScheduledArrivalTime() {
		return this.scheduledArrivalTime;
	}
	
	public String getScheduledDepartmentTime() {
		return this.scheduledDepartmentTime;
	}
	
	public String getEstimatedLateArrival() {
		return this.estimatedLateArrival;
	}
	
	public String getEstimatedLateDeparture() {
		return this.estimatedLateDeparture;
	}
	
	public String getArrived() {
		return this.arrived;
	}
	
	public String getDepartured() {
		return this.departured;
	}

}
