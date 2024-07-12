package querys;

public enum Format {
    NY(0, 1,2,3,4,0,1){
        @Override
        public String getPaternDate() {
            return "yyyy-MM-dd";
        }
    },
    CHI(1,0,3,4,2,0,1){
        @Override
        public String getPaternDate() {
            return "yyyy-MM-dd HH:mm:ss";
        }
    };
    private final int plate;
    private final int infractionId;
    private final int issuingAgency;
    private final int id;
    private final int description;
    private final int date;
    private final int amount;
    Format(int plate, int date,int infractionId,int amount, int issuingAgency, int id,int description) {
        this.plate = plate;
        this.infractionId = infractionId;
        this.issuingAgency = issuingAgency;
        this.id = id;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }
    int getPlateField(){
        return plate;
    }
    int getInfractionIdField(){
        return infractionId;
    }
    int getIssuingAgencyField(){
        return issuingAgency;
    }
    int getIdField(){
        return id;
    }
    int getDescriptionField(){
        return description;
    }
    int getDateField(){
        return date;
    }
    int getAmountField(){
        return amount;
    }
    public abstract String getPaternDate();
}
