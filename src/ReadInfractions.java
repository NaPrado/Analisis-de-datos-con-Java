import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class ReadInfractions {
    Path pathInfractions;
    SortedMap<Integer, Infraction> infractions = new TreeMap<>();
    ReadInfractions(Format format,String pathToGet) {
        pathInfractions = Paths.get(pathToGet);
        List<Infraction> infractionslist;
        try(Stream<String> stream = Files.lines(pathInfractions)){
            infractionslist = stream
                    .skip(1)
                    .map(line->{
                        String[] fields = line.split(";");
                        int id =Integer.parseInt(fields[format.getIdField()]);
                        String description = fields[format.getDescriptionField()];
                        return new Infraction(id, description);
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Infraction infraction : infractionslist){
            infractions.put(infraction.getId(), infraction);
        }
    }
    public SortedMap<Integer, Infraction> getValues() throws IOException {
        return infractions;
    }
}
