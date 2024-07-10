public class Ticket {
    private String plate;
    private final int infractionId;
    private final String issuingAgency;

    Ticket(String plate, int infractionId, String issuingAgency){
        this.plate = plate;
        this.infractionId = infractionId;
        this.issuingAgency = issuingAgency;
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
}
