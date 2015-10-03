
public class City {

	private String name;
	private Destination destinationList;
	
	public City(String name, Destination destinations) {
		this.setName(name);
		this.setDestinationList(destinations);
	}

	public String getName() {
	    return name;
    }

	public void setName(String name) {
	    this.name = name;
    }

	public Destination getDestinationList() {
	    return destinationList;
    }

	public void setDestinationList(Destination destinationList) {
	    this.destinationList = destinationList;
    }
	
}
