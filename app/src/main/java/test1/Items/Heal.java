package test1.Items;

public class Heal extends Items{
    float healAmt;

    public Heal(int id, int price, String name, boolean isTrade, float healAmt){
        super(id, price, name, isTrade);
        this.healAmt = healAmt;
    }
}
