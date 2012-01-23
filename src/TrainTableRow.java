
public class TrainTableRow {
	
	private String time;
	private String station;
	private String newTime;
	private String track;
	private String nr;
	
	public TrainTableRow() {
		
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setStation(String station) {
		this.station = station;
	}
	
	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}
	
	public void setTrack(String track) {
		this.track = track;
	}
	
	public void setNr(String nr) {
		this.nr = nr;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public String getStation() {
		return this.station;
	}
	
	public String getNewTime() {
		return this.newTime;
	}
	
	public String getTrack() {
		return this.track;
	}
	
	public String getNr() {
		return this.nr;
	}

}
