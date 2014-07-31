//Add exceptions to method connect, Gnome.place

package finproject;

import java.io.*;

public class MovingMap {
	
	static PrintWriter pw = new PrintWriter (System.out, true);
	static Village[] testVillage = new Village[10];
	static Gnome[] testGnomes = new Gnome[10];
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		//MapGUI hello = new MapGUI();
		
		testVillage[1] = new Village();
		testVillage[2] = new Village();
		testVillage[3] = new Village();
		testVillage[4] = new Village();
		testVillage[1].connect(3,  testVillage[2]);
		testVillage[1].connect(1,  testVillage[3]);
		testVillage[1].connect(1,  testVillage[4]);
		testVillage[2].connect(5,  testVillage[3]);
		testVillage[4].connect(5,  testVillage[1]);
		
		printMap( testVillage );
		
		testGnomes[0] = new Gnome();

		//testGnomes[0].travelRandom();
		testGnomes[0].travelPick();
		printMap( testVillage );
	}
	
	public static void printMap( Village[] map ) {
		
		for (int i = 1; i <= 4; i++) {
			
			String roadList = "";
			RoadIterator current = map[i].adjacent.firstRoad;
			while (current != null ) { //get adjacent roads

				roadList += "Road to " + current.getVillageName() + " cost " + current.getCost() + ", ";
				current = current.next;
				
			} //AdjList loop
			pw.println("Village " + map[i].name + ":" + roadList);
			
			String population = "Population is Gnome ";
			int j = 0;
			if (map[i].population[j] == null) population = "Population is no one.";
			else {
				while (map[i].population[j] != null) { //get population
				
					population += map[i].population[j].ID + ", ";
					j++;
				}
			}
			pw.println(population);
			
		}//Village list loop
		
	

	} // end printMap method
	
}
