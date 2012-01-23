import java.io.IOException;

public class Main {

	public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {}
        return false;
    }

	public static void main(String[] args) throws IOException {
		
		if (args.length < 1) {
			System.out.println("usage:");
			System.out.println("train-info tågnr");
			System.out.println("train-info \"stationsnamn\"");
			System.exit(0);
		}
		
		String input = args[0].trim();
		
		if (isInteger(args[0])) {
			TrainParser tps = new TrainParser(input, "myapikey");
			tps.print();
			
		} else {
			TrainTableParser ttp = new TrainTableParser(input, "myapikey");
			ttp.print();
		}
	}
}
