import java.util.ArrayList;

public class Train {
	
	private String nr;
	private String company;
	private String date;
	private String info;
	private String url;
	private String status;
	private ArrayList<TrainStop> trainStops; 
	private TrainStop trainStop;
	
	public Train() {
		trainStops = new ArrayList<TrainStop>();
	}
	
	public void addTrainStop(TrainStop trainStop) {
		this.trainStops.add(trainStop);
	}
	
	public void setNr(String nr) {
		this.nr = nr;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNr() {
		return this.nr;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public String getDate() {
		date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		return this.date;
	}
	
	public String getInfo() {
		return this.info;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void printTrainInfo() {
		System.out.println("================================================================================");
		System.out.println("Tåg " + getNr() + " (" + getCompany() + " " + getInfo() + ") " + trainStops.get(0).getStation() + " (" + trainStops.get(0).getScheduledDepartmentTime() + ") - " +  trainStops.get(trainStops.size() - 1).getStation() + " (" + trainStops.get(trainStops.size() - 1).getScheduledArrivalTime() + ") [" + getDate() + "]");
		System.out.println("Status: " + getStatus());
		System.out.println("Mer info: " + getUrl());
		System.out.println("================================================================================\n");
		System.out.println("Tåget gör uppehåll i: ");
		for (int i = 0; i < trainStops.size(); i++) {
			System.out.println();
			trainStop = trainStops.get(i);
			System.out.println("========== [" + (i+1) + "] " + trainStop.getStation() + " ==========");
			if (!trainStop.getScheduledArrivalTime().isEmpty()) {
				System.out.println("Ordinarie Ankomsttid: " + trainStop.getScheduledArrivalTime());
			}
			if (!trainStop.getScheduledDepartmentTime().isEmpty()) {
				System.out.println("Ordinarie Avgångstid: " + trainStop.getScheduledDepartmentTime());
			}
			if (!trainStop.getEstimatedLateArrival().isEmpty()) {
				System.out.println("Beräknad Ankomsttid: " + trainStop.getEstimatedLateArrival());
			}
			if (!trainStop.getEstimatedLateDeparture().isEmpty()) {
				System.out.println("Beräknad Avgångstid: " + trainStop.getEstimatedLateDeparture());
			}
			if (!trainStop.getArrived().isEmpty()) {
				System.out.println("Ankom: " + trainStop.getArrived());
			}
			if (!trainStop.getDepartured().isEmpty()) {
				System.out.println("Avgick: " + trainStop.getDepartured());
			}
			trainStop = null;
		}
		System.out.println("\nTåginformation från Tåg.Info (http://tåg.info)");
	}
}
