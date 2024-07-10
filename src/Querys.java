import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Querys {
    private SortedMap<Integer, Infraction> infractions;
    private List<Ticket> tickets;
    Querys(SortedMap<Integer, Infraction> infractions,List<Ticket> tickets){
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
}
