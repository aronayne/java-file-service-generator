package src.common.strategy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CreateFiles {
	
	private Set<String> filmNames;
	private Map<String, String> filmYearMap;
	
	public CreateFiles(Set<String> filmNames , Map<String, String> filmYearMap){
		this.filmNames = filmNames;
		this.filmYearMap = filmYearMap;
	}
	
	public void generateFiles(){
		int lineCounter = 0;
		int fileCounter = 0;

		List<String> lines = new ArrayList<String>();

		for (String filmName : filmNames) {
			

			System.out.println(filmName + "," + filmYearMap.get(filmName));

			/**
			 * This line will be amended each time a new strategy is added
			 * e.g-  String line = filmName + "," + filmYearMap.get(filmName) +"," +filmActorMap.get(filmName) 
			 */
			String line = filmName + "," + filmYearMap.get(filmName);

			line = line.replaceAll("\"", "\\\\\"");
	/*		line = line.replaceAll("\"", "");*/
			lines.add(line);

			++lineCounter;
			if (lineCounter == 5000) {
				System.out.println("Creating file d:/tmp/Movie" + fileCounter+ ".java");

				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(
							"d:/tmp/Movie" + fileCounter + ".java"));

					out.write("package com.movie.values;");
					out.newLine();
					out.write("import java.util.ArrayList;");
					out.newLine();
					out.write("import java.util.List;");
					out.newLine();
					out.write("public class Movie" + fileCounter + " {");
					out.newLine();
					out.write("public static List<String> movieList = new ArrayList<String>();");
					out.newLine();
					out.write("static {");
					out.newLine();

					for (String fileLine : lines) {

						out.write("movieList.add(\"" + fileLine + "\");");
						out.newLine();
					}
					out.write("}");
					out.newLine();
					out.write("}");
					out.close();
					++fileCounter;
					lineCounter = 0;
					lines = new ArrayList<String>();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

}
