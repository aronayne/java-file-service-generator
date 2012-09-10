package src.common.main;


import java.util.Map;
import java.util.Set;

import src.common.strategy.Context;
import src.common.strategy.CreateFiles;
import src.common.strategy.CreateMovieYearMapStrategy;

public class Driver {

	
	public static void main(String args[]) {

		Context context;

		context = new Context(new CreateMovieYearMapStrategy("d:\\filmfiles\\movies.list"));
		Map<String, String> filmYearMap = context.executeStrategy();

		Set<String> filmNames = filmYearMap.keySet();
		System.out.println("Total films : " + filmNames.size());
 
		/**
		 * Constructor will be amended as new strategys are added
		 */
		CreateFiles createFiles = new CreateFiles(filmNames , filmYearMap);
		createFiles.generateFiles();
		
	}
	
	
}
