package test1.GameWorld;

public class Places {
    public enum PlaceType{
        Shop,
        Fishing,
        Mining,
        Smithing,
        Cooking,
        Dungeon
    }

    PlaceType placeType;
    String placeName;
    public String getPlaceName() { return placeName; }

    int tier;

    public Places(PlaceType type, String name, int tier){
        //Type is what area it is, name is the actual name of the place and tier is the difficulty of the area/range of items available.
        this.placeType = type;
        this.placeName = name;
        this.tier = tier;
    }

    public void Interact(){
        switch(placeType){
            case Shop:
                System.out.println("Shopkeeper: Welcome to " + placeName + "! \r\nPlease take a look at our items...");

                break;
            case Fishing:
                System.out.println("It's fish");
                break;
            case Mining:
                System.out.println("It's a mine");
                break;
            case Smithing:
                System.out.println("It's an smithing");
                break;
            case Cooking:
                System.out.println("Cooking.");
                break;
            case Dungeon:
                System.out.println("Dung");
                break;
            default:
                System.out.println("smthn went wrong...");
        }
    }

    private void Shop(){
        //Items class needs to be created then this will pull all relevant tier of items...
    }
}
