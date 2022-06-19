package test1;

public class PlayerInventory {
    private String[] names = new String[10];
    private int[] amounts = new int[10];

    public PlayerInventory(){
        for(int x = 0; x < 10; x++){
            names[x] = "EMPTY";
            amounts[x] = 0;
        }
    }

    public String DisplayInventory(){
        //Empty string to store inventory text.
        String fullInv = "";
        
        //Loop through array of inventory
        for(int x = 0; x < 10; x++){
            //If the slot is empty, don't display an amount.
            if(names[x].equals("EMPTY")){
                fullInv += "SLOT " + x + ": " + names[x] + " \r\n";
            }
            //If the slot isn't empty then display an amount.
            else{
                fullInv += "SLOT " + x + ": " + names[x] + " x " + amounts[x] + " \r\n";
            }
        }

        //Return the full string of items.
        return fullInv;
    }
}
