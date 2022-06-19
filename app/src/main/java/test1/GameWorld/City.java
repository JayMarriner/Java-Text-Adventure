package test1.GameWorld;
import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    public String getName() { return name; }

    List<Places> cityPlaces = new ArrayList();
    //Getter for cityPlaces
    public List<Places> getCityPlaces(){ return cityPlaces;}

    public City(String name, Places[] places){
        //For the length of places passed through to the constructor it will loop through and add the place to the list above.
        for(int x = 0; x < places.length; x++){
            cityPlaces.add(places[x]);
        }

        //Sets city name to passthrough on constructor.
        this.name = name;
    }

    public String PlaceName(int index){
        //Returns name of individual index.
        return cityPlaces.get(index).placeName;
    }
}
