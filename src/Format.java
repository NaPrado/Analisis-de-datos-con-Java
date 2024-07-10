public enum Format {
    NY(0,2,4,0,1),
    CHI(1,2,3,1,0);
    private final int plate;
    private final int infractionId;
    private final int issuingAgency;
    private final int id;
    private final int description;
    Format(int plate, int infractionId, int issuingAgency, int id,int description) {
        this.plate = plate;
        this.infractionId = infractionId;
        this.issuingAgency = issuingAgency;
        this.id = id;
        this.description = description;
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
}
