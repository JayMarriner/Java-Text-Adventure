package test1.GameWorld;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import test1.GameLoop;
import test1.GameWorld.Places.PlaceType;
import test1.Player.Player;

public class GameWorld {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //region All city places
    Places[] city1Places = {
        new Places(Places.PlaceType.Fishing, "Brickdown River", 1),
        new Places(Places.PlaceType.Mining, "Brickdown Quarry", 1),
        new Places(Places.PlaceType.Dungeon, "Brickdown Dungeon", 1)
    };

    Places[] city2Places = {
        new Places(Places.PlaceType.Fishing, "Blanter Lake", 2),
        new Places(Places.PlaceType.Smithing, "Blanter Blacksmith", 1),
        new Places(Places.PlaceType.Shop, "Blanter Shop", 1)
    };

    Places[] city3Places = {
        new Places(Places.PlaceType.Mining, "Alberton Mine", 2),
        new Places(Places.PlaceType.Dungeon, "Alberton dungeon", 2),
        new Places(Places.PlaceType.Cooking, "Alberton Bakery", 1)
    };

    Places[] city4Places = {
        new Places(Places.PlaceType.Smithing, "Sundercastle Blacksmith", 2),
        new Places(Places.PlaceType.Dungeon, "Sundercastle Dungeon", 2),
        new Places(Places.PlaceType.Shop, "Sundercastle shop", 2)
    };

    Places[] city5Places = {
        new Places(Places.PlaceType.Fishing, "Kuppery River", 3),
        new Places(Places.PlaceType.Fishing, "Kuppery Lake", 2),
        new Places(Places.PlaceType.Cooking, "Keppery Poissonnier", 2)
    };

    Places[] city6Places = {
        new Places(Places.PlaceType.Fishing, "Brington Lake", 3),
        new Places(Places.PlaceType.Dungeon, "Brington dungeon", 3),
        new Places(Places.PlaceType.Shop, "Brington shop", 3)
    };

    Places[] city7Places = {
        new Places(Places.PlaceType.Shop, "Everlast shop", 3),
        new Places(Places.PlaceType.Cooking, "Everlast kitchens", 3),
    };

    //endregion
    
    String[] cityNames = {"Satus City", "Malleus", "Lacrima", "Quare", "Caeruleum", "Lunae City", "Parvus"};    
    Places[] allPlaces[] = {city1Places, city2Places, city3Places, city4Places, city5Places, city6Places, city7Places};
    List<City> cities = new ArrayList();

    public GameWorld(){
        //Loops through all names in the citynames array and initialises all the cities, passing through all places in a city.
        for(int x = 0; x < cityNames.length; x++){
            cities.add(new City(cityNames[x], allPlaces[x]));
            //TEST System.out.println(cityNames[x] + " - " + cities.get(x).PlaceName(1));
        }
    }

    public void ChangeLocation(Player player) throws IOException{
        //Lists all cities.
        for(int x = 0; x < cityNames.length; x++){
            System.out.println(x + ": " + cityNames[x]);
        }

        //Allow user to select a city.
        System.out.println(GameLoop.Spacer());
        String cityInput = reader.readLine();
        System.out.println(GameLoop.Spacer());

        try{
            int x = Integer.parseInt(cityInput); 
          }
          catch(NumberFormatException e){
            System.out.println("Please enter a number...");
            ChangeLocation(player);
            return; 
          } 

        //Convert user input to an integer.
        int selected1 = Integer.parseInt(cityInput);

        //Check input is allowed.
        if(selected1 > allPlaces.length){
            System.out.println("Please enter a valid number...");
            ChangeLocation(player);
            return;
        }

        //Set array for the places within chosen city.
        Places[] displayPlaces = allPlaces[selected1];

        //Display available locations within city chosen.
        for(int x = 0; x < displayPlaces.length; x++){
            System.out.println(x + ": " + displayPlaces[x].placeName);
        }
        //Set chosen city.
        City selectedCity = cities.get(selected1);

        //Allow for user input for place selection.
        System.out.println(GameLoop.Spacer());
        String placeInput = reader.readLine();
        System.out.println(GameLoop.Spacer());

        try{
            int x = Integer.parseInt(placeInput); 
          }
          catch(NumberFormatException e){
            System.out.println("Please enter a number...");
            ChangeLocation(player);
            return; 
          } 


        //Convert input to integer.
        int selected2 = Integer.parseInt(placeInput);

        //Check input is allowed.
        if(selected2 + 1 > selectedCity.cityPlaces.size()){
            System.out.println("Please enter a valid number...");
            ChangeLocation(player);
            return;
        }

        //Set selected place.
        Places selectedPlace = selectedCity.cityPlaces.get(selected2);

        //Run move method on the main player passed through to this method.
        player.MovePlayer(selectedCity, selectedPlace);
    }
}
