import javafx.scene.layout.VBox;


public class MainFrame extends VBox {

    public MainFrame() {
        getChildren().add(new AppMenuBar());
        SupBorder supBorder = new SupBorder();
        getChildren().add(supBorder);
        getChildren().add(new InfBorder(supBorder));
    }

}
