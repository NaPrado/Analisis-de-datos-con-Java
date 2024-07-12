import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import querys.Format;
import querys.Queries;
import querys.ReadInfractions;
import querys.ReadTickets;

import java.io.IOException;
import java.time.Year;


public class InfBorder extends BorderPane {
    private final QueryRadioButton query1Button = new QueryRadioButton("Query 1",QuerysEnum.QUERY1);
    private final QueryRadioButton query2Button = new QueryRadioButton("Query 2",QuerysEnum.QUERY2);
    private final QueryRadioButton query3Button = new QueryRadioButton("Query 3",QuerysEnum.QUERY3);
    private final QueryRadioButton query4Button = new QueryRadioButton("Query 4",QuerysEnum.QUERY4);
    private final QueryRadioButton query5Button = new QueryRadioButton("Query 5",QuerysEnum.QUERY5);
    private final Button startButton = new Button("Start");
    private final Button quitButton = new Button("Quit");

    public InfBorder(SupBorder supBorder) {
        HBox infBorder = new HBox(10);
        setStyle("-fx-background-color: #999");
        infBorder.setAlignment(Pos.CENTER);
        infBorder.setPadding(new Insets(5));

        infBorder.getChildren().addAll(query1Button,query2Button,query3Button,query4Button,query5Button,startButton,quitButton);

        startButton.setOnAction(event->{
            Format format= supBorder.getFormatChoiceBox().getValue().getFormat();
            String[] args = supBorder.getAmountChoiceBox().getValue().getFileName(supBorder.getFormatChoiceBox().getValue());
            ReadInfractions ri = new ReadInfractions(format,args[1]);
            ReadTickets rt = null;
            try {
                rt = new ReadTickets(format,args[0],ri.getValues());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Queries q=null;
            try {
                q = new Queries(ri.getValues(),rt.getValues());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Alert alertRead = new Alert(Alert.AlertType.INFORMATION);
            alertRead.setTitle("Information read");
            alertRead.setHeaderText(null);
            alertRead.setContentText("Information read");
            alertRead.showAndWait();
            QueryRadioButton[] queryRadioButtons = new QueryRadioButton[]{query1Button,query2Button,query3Button,query4Button,query5Button};
            for (QueryRadioButton queryRadioButton : queryRadioButtons) {
                if(queryRadioButton.isSelected()){
                    if (supBorder.getYear1().getText().trim().isEmpty()) {
                        try {
                            queryRadioButton.doQuery(q);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (isNumeric(supBorder.getYear1().getText().trim()) && isNumeric(supBorder.getYear2().getText().trim())){
                        try {
                            queryRadioButton.doQuery(q, Year.of(Integer.parseInt(supBorder.getYear1().getText().trim())),Year.of(Integer.parseInt(supBorder.getYear2().getText().trim())));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (supBorder.getYear2().getText().trim().isEmpty() && isNumeric(supBorder.getYear1().getText().trim())) {
                        try {
                            queryRadioButton.doQuery(q, Year.of(Integer.parseInt(supBorder.getYear1().getText().trim())));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Please select a valid year");
                        alert.showAndWait();
                    }
                    Alert queryAlert = new Alert(Alert.AlertType.INFORMATION);
                    queryAlert.setTitle("Query Finished");
                    queryAlert.setHeaderText(null);
                    queryAlert.setContentText(queryRadioButton.toString()+" finished");
                    queryAlert.showAndWait();
                }
            }
        });
        quitButton.setOnAction(actionEvent -> {
            System.exit(0);
        });
        setCenter(infBorder);
    }
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str); // Para verificar si es un número decimal
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
