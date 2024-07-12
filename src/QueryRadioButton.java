import javafx.scene.control.RadioButton;
import querys.Queries;

import java.io.IOException;
import java.time.Year;

public class QueryRadioButton extends RadioButton {
    QuerysEnum querysEnum;
    String name;
    public QueryRadioButton(String name,QuerysEnum querysEnum) {
        super(name);
        this.name=name;
        this.querysEnum=querysEnum;
    }
    public void doQuery(Queries q) throws IOException {
        querysEnum.executeQuery(q);
    }
    public void doQuery(Queries q, Year min) throws IOException {
        querysEnum.executeQuery(q, min);
    }
    public void doQuery(Queries q, Year min , Year max) throws IOException {
        querysEnum.executeQuery(q,min,max);
    }

    @Override
    public String toString() {
        return name;
    }
}
