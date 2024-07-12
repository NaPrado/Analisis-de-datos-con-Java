package querys;

import java.time.LocalDate;

public class Ticket {
    private String plate;
    private final int infractionId;
    private final String issuingAgency;
    private final LocalDate date;
    private final int amount;

    Ticket(String plate, int infractionId, String issuingAgency, LocalDate date, int amount){
        this.plate = plate;
        this.infractionId = infractionId;
        this.issuingAgency = issuingAgency;
        this.date = date;
        this.amount = amount;
    }
    int getId(){
        return infractionId;
    }
    String getIssuingAgency(){
        return issuingAgency;
    }
    String getPlate(){
        return plate;
    }
    LocalDate getDate(){
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
