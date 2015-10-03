import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CityGraph {
	List<City> cities;
	
	public CityGraph() {
		cities = new ArrayList<City>();
	}
	
	
	public static void main(String[] args) {

		String[] cityNames = {
				"Seattle", 
				"San Francisco",
				"San Diego", 
				"Denver", 
				"St. Louis",
				"Boston", 
				"Columbia", 
				"Austin" 
			};
		
		CityGraph map = new CityGraph();
		
		for (int i = 0; i < cityNames.length; i++) {
			City c = new City(cityNames[i], null);
			map.cities.add(c);
		}
		
		int[][] trips = 
			{
				{0, 1, 1500}, //Seattle, SF
				{0, 3, 1200}, //Seattle, Denver
				{1, 3, 1400}, //SF, Denver
				{1, 2, 1100},
				{3, 4, 1000},
				{3, 7, 700},
				{4, 7, 500},
				{4, 5, 1500},
				{4, 6, 800},
				{6, 7, 1400},
				{2, 7, 1300}
			};
				
		for (int i = 0; i < trips.length; i++) {
			
			City c1 = map.cities.get(trips[i][0]);
			City c2 = map.cities.get(trips[i][1]);
			int distance = trips[i][2];
						
			Destination d1 = new Destination(map.cities.indexOf(c2), c1.getDestinationList(), distance);
			Destination d2 = new Destination(map.cities.indexOf(c1), c2.getDestinationList(), distance);
			
			c1.setDestinationList(d1);
			c2.setDestinationList(d2);
			
		}
		
		map.print();
		

	}
	
	
	public void print() {
        System.out.println();
        for (int i = 0; i < this.cities.size(); i++) {
            System.out.print(this.cities.get(i).getName());
            Destination d = this.cities.get(i).getDestinationList(); 
            while (d != null) {
                System.out.print(" --> " + this.cities.get(d.getCityNumber()).getName() + " (" +
                		d.getDistance() + ")");
                d = d.getNext();
            }
            System.out.println("\n");
        }
    }
}
