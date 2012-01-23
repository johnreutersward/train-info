import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TrainParser {
	
	private String trainInfoURL;
	private Train train;
	private InputStream stream;

	public TrainParser(String trainId, String apiKey) throws IOException {
		
		train = new Train();

		trainInfoURL = "http://xn--tg-yia.info/" + trainId + ".xml?apikey=" + apiKey;
		URL url = new URL(trainInfoURL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        try {
        	stream = connection.getInputStream();
        } catch (IOException e) {
        	System.out.println("Det finns inget tåg med det numret (" + trainId + ")");
        	System.exit(0);
        }
        
		
		Xml tag = new Xml(stream, "tag");
		train.setNr(tag.child("tagNr").content());
		train.setCompany(tag.child("foretag").content());
		train.setDate(tag.child("datum").content());
		train.setInfo(tag.child("info").content());
		train.setUrl(tag.child("url").content());
		train.setStatus(tag.child("status").content());
		
		for (Xml Station:tag.child("stationer").children("station")) {
			TrainStop trainStop = new TrainStop();
			trainStop.setStation(Station.child("namn").content());
			trainStop.setScheduledArrivalTime(Station.child("ordAnkomst").content());
			trainStop.setScheduledDepartmentTime(Station.child("ordAvgang").content());
			trainStop.setEstimatedLateArrival(Station.child("berAnkomst").content());
			trainStop.setEstimatedLateDeparture(Station.child("berAvgang").content());
			trainStop.setArrived(Station.child("ankom").content());
			trainStop.setDepartured(Station.child("avgick").content());
			train.addTrainStop(trainStop);
			trainStop = null;
		}	
	}
	
	public void print() {
		train.printTrainInfo();
	}

}
