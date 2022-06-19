package test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLoop {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Player mainPlayer;
    GameWorld mainWorld;

    public void Loop() throws IOException, InterruptedException
    {
        String userInput ="";

        //Title of game
        System.out.println(Spacer());
        System.out.println("RuneText or smthn");
        System.out.println(Spacer());
        Sleeper(1);

        //Set initial game state.
        GameState.currState = GameState.MainMenu;

        //Gameloop
        while(!userInput.equals("exit")){    
            //Mainmenu state
            if(GameState.currState.equals(GameState.MainMenu)){
                MenuHandler();
            }
            //Gameplay state
            else if(GameState.currState.equals(GameState.GamePlay)){
                GameHandler();
            }
        } 
    }

    void MenuHandler()  throws IOException, InterruptedException{
        String userInput;
        //Initial display of main options
        System.out.println(MainOptions());
        System.out.println(Spacer());
        //Read user input
        userInput = reader.readLine();
        System.out.println(Spacer());
        //Handle user input
        switch(userInput){
            case "1":
                if(mainPlayer == null){
                    mainPlayer = Player.CreateNew(reader);
                }
                else{
                    System.out.println("Your player is already created!");
                }
                break;
            default:
                System.out.println("Incorrect input!");
        }
        Sleeper(1);
        System.out.println(Spacer());
    }

    void GameHandler()  throws IOException, InterruptedException{
        String userInput;

        //Initialise gameworld
        if(mainWorld == null){
            mainWorld = new GameWorld();
        }

        //Display play menu
        System.out.println(GameOptions());
        System.out.println(Spacer());

        //Wait for input
        userInput = reader.readLine();
        System.out.println(Spacer());

        //Handle user input
        switch(userInput){
            //Movement
            case "1":
                mainWorld.ChangeLocation(mainPlayer);
                break;
            case "2":
                System.out.println("Look around command.");
                break;
            //Inventory
            case "3":
                System.out.println(mainPlayer.getInventory().DisplayInventory());
                break;
            case "5":
                System.out.println(mainPlayer.ViewStats());
                break;
            //Wrong inputs
            default:
                System.out.println("Incorrect input!");
                break;
        }
        Sleeper(1);
        System.out.println(Spacer());
    }

    public static String Spacer(){
        return ("=============");
    }

    public static String MainOptions(){
        return("MAIN OPTIONS \r\n1 - Create player \r\n2 - Undefined");
    }

    public static String GameOptions(){
        return("GAME OPTIONS \r\n1 - Move \r\n2 - Look around \r\n3 - See inventory \r\n4 - See equipment \r\n5 - See stats");
    }

    public void Sleeper(int time) throws InterruptedException{
        Thread.sleep(time*1000);
    }
}
