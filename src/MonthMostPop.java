import java.time.Month;

public class MonthMostPop implements Comparable<MonthMostPop> {
    private Month month;
    private int pop=0;
    MonthMostPop(Month month){
        this.month = month;
    }
    public void increasePop(){
        pop++;
    }
    public int getPop() {
        return pop;
    }
    @Override
    public String toString() {
        return month.toString();
    }
    @Override
    public int compareTo(MonthMostPop o) {
        int cmp=Integer.compare(o.pop,pop);
        if(cmp==0) {
            return month.compareTo(o.month);
        }
        return cmp;
    }
}
