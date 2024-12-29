package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;

public class diceByImages extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			Pane root = new Pane();
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setTitle("Dice Simulator");
			primaryStage.setScene(scene);
			primaryStage.show();

			ImageView dice1View = new ImageView();
			ImageView dice2View = new ImageView();

			Image defaultImage = new Image(getClass().getResourceAsStream("/images/dice1.png"));
			dice1View.setImage(defaultImage);
			dice2View.setImage(defaultImage);

			dice1View.setFitWidth(100);
			dice1View.setFitHeight(100);
			dice2View.setFitWidth(100);
			dice2View.setFitHeight(100);

			Button throwButton = new Button("Throw");
			HBox bottom = new HBox();
			bottom.getChildren().add(throwButton);
			bottom.setAlignment(Pos.BOTTOM_CENTER);

			bottom.setLayoutX(170);
			bottom.setLayoutY(200);

			Random random = new Random();

			throwButton.setOnAction(e -> {
				int dice1 = random.nextInt(6) + 1; // Random number between 1 and 6
				int dice2 = random.nextInt(6) + 1;

				dice1View.setImage(new Image(getClass().getResourceAsStream("/images/dice" + dice1 + ".png")));
				dice2View.setImage(new Image(getClass().getResourceAsStream("/images/dice" + dice2 + ".png")));
			});

			HBox hbox = new HBox(20);
			hbox.getChildren().addAll(dice1View, dice2View);
			hbox.setAlignment(Pos.TOP_CENTER);
			hbox.setLayoutX(90);
			hbox.setLayoutY(75);

			root.getChildren().addAll(hbox, bottom);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
