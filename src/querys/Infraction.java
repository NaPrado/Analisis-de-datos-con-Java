package querys;

public class Infraction {
    int id;
    String description;
    int amount=0;//cantidad de esta infraccion

    Infraction(int id, String description){
        this.id = id;
        this.description = description;
    }
    int getId(){
        return id;
    }
    String getDescription(){
        return description;
    }
    void incrementAmount(){
        amount++;
    }
    public int getAmount() {
        return amount;
    }
}
