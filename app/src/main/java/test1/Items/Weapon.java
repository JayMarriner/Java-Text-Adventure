package test1.Items;

import org.checkerframework.checker.units.qual.degrees;

public class Weapon extends Items {
    int damageAmt;
    boolean isDeplete;
    int degRate;

    public Weapon(int id, int price, String name, boolean isTrade, int damageAmt, boolean isDeplete, int degRate){
        super(id, price, name, isTrade);
        this.damageAmt = damageAmt;
        this.isDeplete = isDeplete;
        this.degRate = degRate;   
    }
}
