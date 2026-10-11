
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SDGPoster extends Application {

    private Label makeLabel(String text, int size,
                            String color, boolean bold) {
        Label label = new Label(text);
        label.setFont(bold
                ? Font.font("Arial", FontWeight.BOLD, size)
                : Font.font("Arial", size));
        label.setTextFill(Color.web(color));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        return label;
    }

    private VBox makeCard(String symbol, String heading,
                          String description) {
        VBox card = new VBox(5);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(7));
        card.setPrefSize(230, 90);
        card.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 12;" +
            "-fx-border-color: #A5D6A7;" +
            "-fx-border-radius: 12;"
        );

        card.getChildren().addAll(
            makeLabel(symbol, 25, "#287D3C", true),
            makeLabel(heading, 13, "#1B5E20", true),
            makeLabel(description, 11, "#315C36", false)
        );

        return card;
    }

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F1F8E9;");

        // Poster header
        VBox header = new VBox(6);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setStyle("-fx-background-color: #14532D;");

        header.getChildren().addAll(
            makeLabel("SUSTAINABLE DEVELOPMENT GOAL 13",
                      13, "#FFFFFF", true),
            makeLabel("CLIMATE ACTION",
                      30, "#FFFFFF", true),
            makeLabel("THERE IS NO PLANET B!",
                      19, "#D9F99D", true),
            makeLabel("Act now for a greener and safer future.",
                      13, "#FFFFFF", false)
        );

        root.setTop(header);

        // Main poster area
        VBox body = new VBox(12);
        body.setAlignment(Pos.CENTER);
        body.setPadding(new Insets(12));

        Label earth = makeLabel("🌍", 85, "#287D3C", false);

        Label message = makeLabel(
            "SAVE OUR PLANET!\nProtect nature for a better tomorrow.",
            17, "#1B5E20", true
        );

        // Six climate action cards
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(12);
        grid.setVgap(10);

        grid.add(makeCard("🌳", "PLANT TREES",
                          "Grow trees and protect forests."), 0, 0);

        grid.add(makeCard("💡", "SAVE ENERGY",
                          "Switch off unused lights."), 1, 0);

        grid.add(makeCard("♻", "REDUCE WASTE",
                          "Reuse and recycle materials."), 0, 1);

        grid.add(makeCard("💧", "SAVE WATER",
                          "Use water wisely."), 1, 1);

        grid.add(makeCard("🚲", "GO GREEN",
                          "Walk, cycle or use public transport."), 0, 2);

        grid.add(makeCard("🌱", "PROTECT NATURE",
                          "Keep our environment clean."), 1, 2);

        body.getChildren().addAll(earth, message, grid);
        root.setCenter(body);

        // Poster footer
        Label footer = makeLabel(
            "A GREENER TOMORROW STARTS WITH YOU!",
            16, "#FFFFFF", true
        );

        footer.setMaxWidth(Double.MAX_VALUE);
        footer.setPadding(new Insets(14));
        footer.setStyle("-fx-background-color: #14532D;");

        root.setBottom(footer);

        // Window and scene
        Scene scene = new Scene(root, 650, 750);

        stage.setTitle("SDG 13 - Climate Action");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinWidth(600);
        stage.setMinHeight(650);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
