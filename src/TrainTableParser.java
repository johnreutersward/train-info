import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TrainTableParser {
	
	private TrainTable trainTable;
	private String trainTableInfoURL;
	private InputStream stream;

	public TrainTableParser(String trainStation, String apiKey) throws IOException {
		
		trainTable = new TrainTable();
		
		String unicode = URLEncoder.encode(trainStation, "utf-8");
		
		trainTableInfoURL = "http://xn--tg-yia.info/" + unicode + ".xml?apikey=" + apiKey;
		URL url = new URL(trainTableInfoURL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        try {
        	stream = connection.getInputStream();
        } catch (IOException e) {
        	System.out.println("Kunde inte finna någon station kallad " + trainStation);
        	System.exit(0);
        }
        
		Xml station = new Xml(stream, "station");
		trainTable.setTrainStation(station.child("namn").content());
		for (Xml Train:station.child("avgaende").children("tag")) {
			TrainTableRow trainTableRow = new TrainTableRow();
			trainTableRow.setTime(Train.child("tid").content());
			trainTableRow.setStation(Train.child("till").content());
			trainTableRow.setNewTime(Train.child("berTid").content());
			trainTableRow.setTrack(Train.child("spar").content());
			trainTableRow.setNr(Train.child("nr").content());
			trainTable.addDepartureTrainTableRow(trainTableRow);
			trainTableRow = null;
		}
		for (Xml Train:station.child("ankommande").children("tag")) {
			TrainTableRow trainTableRow = new TrainTableRow();
			trainTableRow.setTime(Train.child("tid").content());
			trainTableRow.setStation(Train.child("fran").content());
			trainTableRow.setNewTime(Train.child("berTid").content());
			trainTableRow.setTrack(Train.child("spar").content());
			trainTableRow.setNr(Train.child("nr").content());
			trainTable.addArrivalTrainTableRow(trainTableRow);
			trainTableRow = null;	
		}	
	}
	
	public void print() {
		this.trainTable.printTrainTable();
	}
	
	
}
