import java.io.IOException;
import java.time.Year;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Format format= Format.NY;
        ReadInfractions ri = new ReadInfractions(format,args[1]);
        ReadTickets rt = new ReadTickets(format,args[0],ri.getValues());
        Queries q = new Queries(ri.getValues(),rt.getValues());
        q.query1();
        q.query2();
        q.query3();
        q.query4();
        q.query5();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Duración en nanosegundos: " + duration);
        System.out.println("Duración en milisegundos: " + (duration / 1_000_000));
        System.out.println("Duración en segundos: " + (duration / 1_000_000_000));
    }
}