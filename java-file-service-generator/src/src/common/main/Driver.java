package src.common.main;


import java.util.Map;
import java.util.Set;

import src.common.strategy.Context;
import src.common.strategy.CreateCsvFile;
import src.common.strategy.CreateFiles;
import src.common.strategy.CreateMovieActorMapStrategy;
import src.common.strategy.CreateMovieYearMapStrategy;

public class Driver {

	
	public static void main(String args[]) {

		Context context;

		context = new Context(new CreateMovieYearMapStrategy("d:\\filmfiles\\movies.list"));
		Map<String, String> filmYearMap = context.executeStrategy();

		Set<String> filmNames = filmYearMap.keySet();
		System.out.println("Total films : " + filmNames.size());
 
/*		System.out.println("Total files to create : "+filmNames.size()/5000);*/
		/**
		 * Constructor will be amended as new strategys are added
		 */
/*		CreateFiles createFiles = new CreateFiles(filmNames , filmYearMap);
		createFiles.generateFiles();*/
		
		context = new Context(new CreateMovieActorMapStrategy("d:\\filmfiles\\actors.list"));
		Map<String, String> filmActorMap = context.executeStrategy();
		
		CreateCsvFile createFiles = new CreateCsvFile(filmNames , filmYearMap);
		createFiles.generateFile();
		
	}
	
	
}
