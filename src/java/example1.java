import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class example1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Пример 1");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.LIGHTGREEN);
        final Button btn = new Button();
        btn.setLayoutX(20);
        btn.setLayoutY(20);
        btn.setText("Тестировать свойства");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Свойства, унаследованные от класса Node:"+"\n"+
                        "Свойство blendMode: "+btn.blendModeProperty().getValue()+"\n"+
                        "Свойство boundsInLocal: "+btn.boundsInLocalProperty().getValue()+"\n");
            }
        });

        final Button btnOn;
        btnOn = ButtonBuilder.create().build();
        btnOn.setLayoutX(20);
        btnOn.setLayoutY(150);
        btnOn.setText("Установить свойства");
        btnOn.setStyle("-fx-font: bold italic 12pt Arial; -fx-text-fill: #660000; -fx-background-color: #ff99ff;" +
                "-fx-border-width: 3px; -fx-border-radius: 30; -fx-background-radius: 30; -fx-border-color: #660066" );
        btnOn.setPrefSize(200,30);
        btnOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn.setBlendMode(BlendMode.DARKEN);
                Circle clip = new Circle(75, 53, 80);
//                btn.setClip(clip);
                btn.setCursor(Cursor.CLOSED_HAND);
                DropShadow effect = new DropShadow();
                effect.setOffsetX(10);
                effect.setOffsetY(10);
                btn.setEffect(effect);
//                btn.setManaged(false);
//                btn.setMouseTransparent(true);
                btn.setOpacity(0.5);
                btn.setRotate(10);
                btn.setLayoutX(80);
                btn.setScaleX(1.8);
                btn.setLayoutY(170);
                btn.setTranslateZ(-50);
                btn.setPrefSize(150,100);
                btn.setTooltip(new Tooltip("Это кнопка тестирования свойств класса Button"));
                Image im = new Image(this.getClass().getResource("pic1.jpg").toString());
                ImageView imv = new ImageView(im);
                imv.setFitHeight(50);
                imv.setFitWidth(50);
                btn.setGraphic(imv);
                btn.setStyle("-fx-font: bold italic 10pt Helvetica;");
//                btn.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 10));
                btn.setAlignment(Pos.CENTER);
                btn.setContentDisplay(ContentDisplay.RIGHT);
                btn.setUnderline(true);
                btn.setWrapText(true);
//                btn.setCancelButton(true);
//                btn.toBack();
            }
        });
        root.getChildren().add(btnOn);
        root.getChildren().add(btn);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(example1.class, args);
    }
}
