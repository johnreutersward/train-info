import java.util.ArrayList;

public class TrainTable {
	
	private String trainStation;
	private ArrayList<TrainTableRow> arrival;
	private ArrayList<TrainTableRow> departure;
	private TrainTableRow trainTableRow;
	private int numTrains;
	
	public TrainTable() {
		arrival = new ArrayList<TrainTableRow>();
		departure = new ArrayList<TrainTableRow>();
	}
	
	public void addArrivalTrainTableRow(TrainTableRow trainTableRow) {
		arrival.add(trainTableRow);
	}
	
	public void addDepartureTrainTableRow(TrainTableRow trainTableRow) {
		departure.add(trainTableRow);
	}
	
	public String getTrainStation() {
		return this.trainStation;
	}
	
	public void setTrainStation(String trainStation) {
		this.trainStation = trainStation;
	}
	
	public void printTrainTable() {
		//worst print-method ever	
		System.out.format("%1$s%n", getTrainStation().toUpperCase());
		System.out.format("%1$s%n","Avgående:");
		System.out.format("%1$s %2$6s %3$15s %4$5s %5$4s%n", "Tid", "Till", "Ny Tid", "Spår", "Tåg");
		numTrains = departure.size();
		if (numTrains > 10) {
			numTrains = 10;
		}
		for (int i = 0; i < numTrains; i++) {
			trainTableRow = departure.get(i);
			if (trainTableRow.getNewTime().isEmpty()) {
				System.out.format("%1$s %2$"+(trainTableRow.getStation().length())+"s %3$"+(21-(trainTableRow.getStation().length() - trainTableRow.getTrack().length()))+"s %4$"+(8-(trainTableRow.getTrack().length()))+"s%n", trainTableRow.getTime(), trainTableRow.getStation(), trainTableRow.getTrack(), trainTableRow.getNr());
			} else {
				System.out.format("%1$s %2$"+(trainTableRow.getStation().length())+"s %3$"+(13-(trainTableRow.getStation().length() - trainTableRow.getNewTime().length()))+"s %4$"+(7-(trainTableRow.getNewTime().length() - trainTableRow.getTrack().length()))+"s %5$"+(8-(trainTableRow.getTrack().length()))+"s%n", trainTableRow.getTime(), trainTableRow.getStation(), trainTableRow.getNewTime(), trainTableRow.getTrack(), trainTableRow.getNr());
			}
			trainTableRow = null;
		}
		System.out.format("%1$s%n","Ankommande:");
		System.out.format("%1$s %2$6s %3$15s %4$5s %5$4s%n", "Tid", "Till", "Ny Tid", "Spår", "Tåg");
		numTrains = arrival.size();
		if (numTrains > 10) {
			numTrains = 10;
		}
		for (int i = 0; i < numTrains; i++) {
			trainTableRow = arrival.get(i);
			if (trainTableRow.getNewTime().isEmpty()) {
				System.out.format("%1$s %2$"+(trainTableRow.getStation().length())+"s %3$"+(21-(trainTableRow.getStation().length() - trainTableRow.getTrack().length()))+"s %4$"+(8-(trainTableRow.getTrack().length()))+"s%n", trainTableRow.getTime(), trainTableRow.getStation(), trainTableRow.getTrack(), trainTableRow.getNr());
			} else {
				System.out.format("%1$s %2$"+(trainTableRow.getStation().length())+"s %3$"+(13-(trainTableRow.getStation().length() - trainTableRow.getNewTime().length()))+"s %4$"+(7-(trainTableRow.getNewTime().length() - trainTableRow.getTrack().length()))+"s %5$"+(8-(trainTableRow.getTrack().length()))+"s%n", trainTableRow.getTime(), trainTableRow.getStation(), trainTableRow.getNewTime(), trainTableRow.getTrack(), trainTableRow.getNr());
			}
			trainTableRow = null;
		}
		System.out.println("\nTåginformation från Tåg.Info (http://tåg.info)");
	}

}
