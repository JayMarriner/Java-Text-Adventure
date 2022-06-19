package test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Player {
    //Skills + stats
    private float hitPoints;
    private int attackStat;
    private int defenceStat;

    //Inventory
    private PlayerInventory inventory;
    public PlayerInventory getInventory() { return inventory; }

    //Location
    Places currentPlace;
    public Places getCurrentPlace() { return currentPlace; }
    City currentCity;
    public City getCurrentCity() { return currentCity; }

    public Player(int hp, int attk, int def){
        //Set basic stats
        hitPoints = hp*10;
        attackStat = attk;
        defenceStat = def;

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

        System.out.println("New city: " + currentCity.name + ", New place: " + currentPlace.placeName);
    }
}
