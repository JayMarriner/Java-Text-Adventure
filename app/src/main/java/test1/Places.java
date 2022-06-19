package test1;

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
    int tier;

    public Places(PlaceType type, String name, int tier){
        //Type is what area it is, name is the actual name of the place and tier is the difficulty of the area/range of items available.
        this.placeType = type;
        this.placeName = name;
        this.tier = tier;
    }
}
