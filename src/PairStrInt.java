import java.util.Objects;

public class PairStrInt implements Comparable<PairStrInt> {
    String a;
    int b=0;
    int id;
    PairStrInt(String a, int id) {
        this.a = a;
        this.id = id;
    }
    public String getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public void increaceB(){
        b++;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof PairStrInt o && id==o.id);
    }

    @Override
    public int compareTo(PairStrInt o) {
        return Integer.compare(o.b, this.b);
    }

    @Override
    public String toString() {
        return "%s;%d".formatted(a, b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
