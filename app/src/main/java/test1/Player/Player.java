package test1.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;

import test1.GameLoop;
import test1.GameState;
import test1.GameWorld.City;
import test1.GameWorld.Places;

public class Player {
    //Skills + stats
    private float hitPoints;
    private int[] skills = {0,0,0,0,0,0};
    private String[] skillNames = {"Attack", "Defence", "Mining", "Smithing", "Fishing", "Cooking"};

    //Inventory
    private PlayerInventory inventory;
    public PlayerInventory getInventory() { return inventory; }

    //Location
    private Places currentPlace;
    public Places getCurrentPlace() { return currentPlace; }
    private City currentCity;
    public City getCurrentCity() { return currentCity; }

    public Player(int hp, int attk, int def){
        //Set basic stats
        hitPoints = (hp+1)*10;
        skills[0] = attk+1;
        skills[1] = def+1;
        skills[2] = skills[3] = skills[4] = skills[5] = 1;

        //Initialise inventory
        inventory = new PlayerInventory();
    }

    public static Player CreateNew(BufferedReader reader) throws IOException{
        System.out.println("You have 5 points to use on 3 skills (hitpoints, attack and defence)");
        //HP input
        System.out.println("Hitpoints: ");
        String hpInput = reader.readLine();
        //Attack input
        System.out.println("Attack: ");
        String attkInput = reader.readLine();
        //Defence input
        System.out.println("Defence: ");
        String defInput = reader.readLine();

        //Check user has not went over amount.
        if(Integer.parseInt(hpInput) + Integer.parseInt(attkInput) + Integer.parseInt(defInput) > 5){
            System.out.println(GameLoop.Spacer());
            System.out.println("You only have 5 points to use...");
            return CreateNew(reader);
        }
        
        //Set game mode to gameplay.
        GameState.currState = GameState.GamePlay;

        //Returns player.
        return new Player(Integer.parseInt(hpInput), Integer.parseInt(attkInput), Integer.parseInt(defInput));
    }
    

    public void MovePlayer(City newCity, Places newPlace){
        this.currentCity = newCity;
        this.currentPlace = newPlace;

        System.out.println("New city: " + currentCity.getName() + ", New place: " + currentPlace.getPlaceName());
    }

    public String ViewStats(){
        //Declare empty string.
        String allStat = "";
        //Add title and HP stat.
        allStat += "ALL STATS \r\nHitpoints: " + hitPoints + "\r\n";

        //Loop through stats and add names + level to string.
        for(int x = 0; x < skills.length; x++){
            allStat += skillNames[x] + ": " + skills[x] + "\r\n"; 
        }

        //Return the string.
        return allStat;
    }
}
