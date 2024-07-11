public class InfracionDiference implements Comparable<InfracionDiference>{
    private final String name;
    private final int min;
    private final int max;
    private final int dif;
    InfracionDiference(String name, int min, int max){
        this.name = name;
        this.min = min;
        this.max = max;
        this.dif = max - min;
    }

    @Override
    public String toString() {
        return "%s;%d;%d;%d".formatted(name,min,max,dif);
    }

    @Override
    public int compareTo(InfracionDiference o) {
        return o.dif - dif;
    }
}
