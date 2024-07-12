import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SupBorder extends BorderPane {
    private ChoiceBox<FormatEnum> formatChoiceBox = new ChoiceBox<>();
    private ChoiceBox<AmountEnum> AmountChoiceBox = new ChoiceBox<>();
    private TextField year1 =new TextField();
    private TextField year2 =new TextField();

    SupBorder(){
        HBox supBorder = new HBox(10);
        setStyle("-fx-background-color: #999");
        supBorder.setAlignment(Pos.CENTER);
        supBorder.setPadding(new Insets(5));

        supBorder.getChildren().add(new Label("Data Options"));

        ObservableList<FormatEnum> format = FXCollections.observableArrayList(
                FormatEnum.NYC,FormatEnum.CHI
        );
        formatChoiceBox.getItems().addAll(format);
        formatChoiceBox.setValue(FormatEnum.NYC);

        ObservableList<AmountEnum> amount = FXCollections.observableArrayList(
                AmountEnum.UN_MILLON,AmountEnum.QUINCE_MILLONES,AmountEnum.COMPLETO
        );
        AmountChoiceBox.getItems().addAll(amount);
        AmountChoiceBox.setValue(AmountEnum.UN_MILLON);

        supBorder.getChildren().addAll(formatChoiceBox,AmountChoiceBox,year1,year2);

        setCenter(supBorder);
    }

    public ChoiceBox<AmountEnum> getAmountChoiceBox() {
        return AmountChoiceBox;
    }
    public ChoiceBox<FormatEnum> getFormatChoiceBox() {
        return formatChoiceBox;
    }
    public TextField getYear1() {
        return year1;
    }
    public TextField getYear2() {
        return year2;
    }
}
