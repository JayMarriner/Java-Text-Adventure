package test1.Items;

public class Armour extends Items{
    public enum ArmourType{
        Helmet,
        ChestPlate,
        PlateLegs,
        Boots,
        Ring,
        Shield,
        Necklace
    }
    ArmourType type;
    int defenceAmt;
    boolean isDeg;
    float degAmt;

    public Armour(int id, int price, String name, boolean isTrade, int defenceAmt, boolean isDeg, ArmourType type){
        super(id, price, name, isTrade);
        this.defenceAmt = defenceAmt;
        degAmt = 100;
        this.type = type;
    }
}
