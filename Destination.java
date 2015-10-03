
//Destination is a linked list that accompanies each City
//Each node in the linked list carries a reference to the initial City,
//and the edge weight is the distance

public class Destination {
	
	private int cityNumber;
	private Destination next;
	private int distance;
	
	
	public Destination(int cityNumber, Destination destination, int distance) {
		this.setCityNumber(cityNumber);
		this.setNext(destination);
		this.setDistance(distance);
	}

	public Destination getNext() {
	    return next;
    }

	public void setNext(Destination next) {
	    this.next = next;
    }
	
	public int getCityNumber() {
	    return cityNumber;
    }

	public void setCityNumber(int cityNumber) {
	    this.cityNumber = cityNumber;
    }

	public int getDistance() {
	    return distance;
    }

	public void setDistance(int distance) {
	    this.distance = distance;
    }


}
