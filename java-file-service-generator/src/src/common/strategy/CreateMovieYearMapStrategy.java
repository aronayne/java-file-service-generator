package src.common.strategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateMovieYearMapStrategy extends Parser implements ParseStrategy {
	
	private Map<String , String> details = new HashMap<String , String>();
	
	public CreateMovieYearMapStrategy(String fileNameToRead) {
		super(fileNameToRead);
	}

	private void populateDetailsMap(){
		
		try {

		BufferedReader br = new BufferedReader(new FileReader(super.getFileNameToRead()));
		String line = br.readLine();
		while (line != null)
		{
			//TODO use a regular expression to parse the film name and year
			try {
			 line = br.readLine();	
			 String filmName = line.substring(0 , line.length() - 4);
			 String filmYear = line.substring(line.length() - 4 , line.length());
			 details.put(filmName, filmYear);
			}
			catch(java.lang.StringIndexOutOfBoundsException obe){
				
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, String> execute() {
		this.populateDetailsMap();
		return this.details;
	}
}
