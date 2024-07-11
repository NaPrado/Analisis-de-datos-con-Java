import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.time.Year;
import java.util.*;


public class Queries {
    private final SortedMap<Integer, Infraction> infractions;
    private final List<Ticket> tickets;
    Queries(SortedMap<Integer, Infraction> infractions, List<Ticket> tickets){
        this.infractions = infractions;
        this.tickets = tickets;
    }
    void query1() throws IOException {
        for(Ticket ticket:tickets) {
            infractions.get(ticket.getId()).incrementAmount();
        }
        List<Infraction> infractionList=infractions.values().stream().sorted(Comparator.comparing(Infraction::getAmount).reversed().thenComparing(Infraction::getDescription)).toList();
        List<String> queryLines=infractionList.stream().map(infraction -> "%s;%d".formatted(infraction.getDescription(),infraction.getAmount())).toList();
        List<String> linesToWrite= new ArrayList<>();
        linesToWrite.addFirst("infraction;tickets");
        linesToWrite.addAll(queryLines);
        Path outputPath = Paths.get("Query1.csv");
        Files.write(outputPath, linesToWrite);
    }
    void query2() throws IOException {
        SortedMap<String, Map<Integer,PairStrInt>> queryMap = new TreeMap<>();
        for(Ticket ticket:tickets) {
            queryMap.putIfAbsent(ticket.getIssuingAgency(), new HashMap<>());
            queryMap.get(ticket.getIssuingAgency()).putIfAbsent(ticket.getId(), new PairStrInt(infractions.get(ticket.getId()).description, ticket.getId()));
            queryMap.get(ticket.getIssuingAgency()).get(ticket.getId()).increaceB();
        }
        List<String> linesToWrite = new ArrayList<>();
        linesToWrite.addFirst("issuingAgency;infraction;tickets");
        for(String issuingAgency:queryMap.keySet()) {
            linesToWrite.add("%s;%s".formatted(issuingAgency,queryMap.get(issuingAgency).values().stream().sorted().toList().getFirst()));
        }
        Path outputPath = Paths.get("Query2.csv");
        Files.write(outputPath, linesToWrite);
    }
    void query3() throws IOException {
        SortedMap<String, Map<String, PairPlatesTickets>> queryMap = new TreeMap<>();
        for(Ticket ticket:tickets) {
            queryMap.putIfAbsent(infractions.get(ticket.getId()).description, new HashMap<>());
            queryMap.get(infractions.get(ticket.getId()).description).putIfAbsent(ticket.getPlate(),new PairPlatesTickets(ticket.getPlate()));
            queryMap.get(infractions.get(ticket.getId()).description).get(ticket.getPlate()).increaseTicket();
        }
        List<String> linesToWrite = new ArrayList<>();
        linesToWrite.addFirst("infraction;plate;tickets");
        for(String plate:queryMap.keySet()) {
            linesToWrite.add("%s;%s".formatted(plate,queryMap.get(plate).values().stream().sorted().toList().getFirst()));
        }
        Path outputPath = Paths.get("Query3.csv");
        Files.write(outputPath, linesToWrite);
    }
    void query4(Year min, Year max) throws IOException{
        query4(new Year[] {min, max});
    }
    void query4(Year min) throws IOException{
        query4(new Year[] {min});
    }
    void query4() throws IOException{
        query4(new Year[]{});
    }
    private void query4(Year[] args) throws IOException {
        if (args.length >2){
            return;
        }
        SortedMap<Year,Map<Month,MonthMostPop>> queryMap = new TreeMap<>();
        for(Ticket ticket:tickets) {
            if (args.length==0 || ( args.length==1 && (Year.of(ticket.getDate().getYear()).compareTo(args[0])>0) ) || ( args.length==2 && (Year.of(ticket.getDate().getYear()).compareTo(args[0])>0) && (Year.of(ticket.getDate().getYear()).compareTo(args[1])<=0)) ) {
                queryMap.putIfAbsent(Year.of(ticket.getDate().getYear()), new HashMap<>());
                queryMap.get(Year.of(ticket.getDate().getYear())).putIfAbsent(ticket.getDate().getMonth(), new MonthMostPop(ticket.getDate().getMonth()));
                queryMap.get(Year.of(ticket.getDate().getYear())).get(ticket.getDate().getMonth()).increasePop();
            }
        }
        List<String> linesToWrite = new ArrayList<>();
        linesToWrite.addFirst("year;ticketsTop1Month;ticketsTop2Month;ticketsTop3Month");
        for (Year year:queryMap.keySet()){
            StringBuilder meses = new StringBuilder();
            Iterator<MonthMostPop> it= queryMap.get(year).values().stream().sorted().iterator();
            for (int i = 0; i < 3; i++) {
                if (it.hasNext()) {
                    MonthMostPop m=it.next();
                    meses.append(";").append(m.getPop()).append("/").append(m);
                }
                else {
                    meses.append(";").append("Empty");
                }
            }
            linesToWrite.add("%s%s".formatted(year,meses.toString()));
        }
        Path outputPath = Paths.get("Query4.csv");
        Files.write(outputPath, linesToWrite);
    }
    void query5(Year min, Year max) throws IOException{
        query5(new Year[] {min, max});
    }
    void query5(Year min) throws IOException{
        query5(new Year[] {min});
    }
    void query5() throws IOException{
        query5(new Year[]{});
    }
    public void query5(Year[] args) throws IOException {
        if (args.length >2){
            return;
        }
        Map<String, SortedSet<Integer>> queryMap = new HashMap<>();
        for(Ticket ticket:tickets) {
            if (args.length==0 || ( args.length==1 && (Year.of(ticket.getDate().getYear()).compareTo(args[0])>0) ) || ( args.length==2 && (Year.of(ticket.getDate().getYear()).compareTo(args[0])>0) && (Year.of(ticket.getDate().getYear()).compareTo(args[1])<=0)) ) {
                queryMap.putIfAbsent(infractions.get(ticket.getId()).description, new TreeSet<>());
                queryMap.get(infractions.get(ticket.getId()).description).add(ticket.getAmount());
            }
        }
        SortedSet<InfracionDiference> data = new TreeSet<>();
        for (String descriptions:queryMap.keySet()){
            data.add(new InfracionDiference(descriptions,queryMap.get(descriptions).getFirst(),queryMap.get(descriptions).getLast()));
        }
        List<String> linesToWrite = new ArrayList<>();
        linesToWrite.addFirst("infraction;minAmount;maxAmount;diffAmount");
        for (InfracionDiference infraction:data) {
            linesToWrite.add(infraction.toString());
        }
        Path outputPath = Paths.get("Query5.csv");
        Files.write(outputPath, linesToWrite);
    }
}
