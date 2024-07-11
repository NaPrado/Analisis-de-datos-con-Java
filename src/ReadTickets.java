import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class ReadTickets {
    private Path pathTickets;
    private List<Ticket> ticketslist;
    ReadTickets(Format format,String pathToGet,SortedMap<Integer,Infraction> infractionValues) throws IOException {
        pathTickets = Paths.get(pathToGet);
        try(Stream<String> stream = Files.lines(pathTickets)){
            ticketslist = stream
                    .skip(1)
                    .map(line->{
                        String[] fields = line.split(";");
                        for(String s:fields){
                            if(s.isEmpty()){
                                return null;
                            }
                        }
                        String plate = fields[format.getPlateField()];
                        int infractionId =Integer.parseInt(fields[format.getInfractionIdField()]);
                        String issuingAgency = fields[format.getIssuingAgencyField()];
                        String fechaString = fields[format.getDateField()];
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(fechaString, formatter);
                        int amount = Integer.parseInt(fields[format.getAmountField()]);
                        if(infractionValues.containsKey(infractionId)){
                            return new Ticket(plate,infractionId,issuingAgency,date,amount);
                        }
                        return null;
                    })
                    .toList();
        }
    }
    public List<Ticket> getValues() throws IOException {
        return ticketslist;
    }
}
