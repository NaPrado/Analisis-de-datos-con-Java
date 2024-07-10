import java.util.Comparator;
import java.util.Objects;

public class PairPlatesTickets implements Comparable<PairPlatesTickets>{
    String plate;
    int ticket=0;
    PairPlatesTickets(String plate){
        this.plate=plate;
    }
    public void increaseTicket(){
        ticket++;
    }

    public int getTicket() {
        return ticket;
    }

    public String getPlate() {
        return plate;
    }

    @Override
    public String toString() {
        return "%s;%d".formatted(plate,ticket);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof PairPlatesTickets o && plate.equals(o.plate));
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate);
    }

    @Override
    public int compareTo(PairPlatesTickets o) {
        int cmp =Integer.compare(o.ticket,this.ticket);
        if(cmp==0){
            cmp=o.plate.compareTo(plate);
        }
        return cmp;
    }
}
