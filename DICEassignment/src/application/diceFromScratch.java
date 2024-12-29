package application;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class diceFromScratch extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

//----------------------------------SQUARE 1 EMPTY L---------------------------------------------------------------------------------------------------------	
			Rectangle rectangle1 = new Rectangle();
			rectangle1.setX(70);
			rectangle1.setY(100);
			rectangle1.setWidth(100);
			rectangle1.setHeight(100);
			rectangle1.setArcHeight(35);
			rectangle1.setArcWidth(35);
			rectangle1.setFill(Color.WHITE);
			rectangle1.setStroke(Color.BLACK);

//----------------------------------SQUARE 2 EMPTY R---------------------------------------------------------------------------------------------------------	

			Rectangle rectangle2 = new Rectangle();
			rectangle2.setX(200);
			rectangle2.setY(100);
			rectangle2.setWidth(100);
			rectangle2.setHeight(100);
			rectangle2.setArcHeight(35);
			rectangle2.setArcWidth(35);
			rectangle2.setFill(Color.WHITE);
			rectangle2.setStroke(Color.BLACK);

//------------------------------------------------------------------------------------------------------------------------------------------------------------
			root.getChildren().addAll(rectangle1, rectangle2);
//---------------------------------------1 DOT DICE R---------------------------------------------------------------------------------------------------------

			Circle circle1 = new Circle(250, 150, 10);// middle
			circle1.setFill(Color.BLACK);
			Group G1R = new Group(circle1);
//---------------------------------------2 DOT DICE R---------------------------------------------------------------------------------------------------------

			Circle circle2d1 = new Circle(220, 120, 10);// up left
			circle2d1.setFill(Color.BLACK);
			Circle circle2d2 = new Circle(280, 180, 10);// up right
			circle2d2.setFill(Color.BLACK);
			Group G2R = new Group(circle2d1, circle2d2);

//---------------------------------------3 DOT DICE R---------------------------------------------------------------------------------------------------------

			Circle circle3d1 = new Circle(220, 120, 10);// up left
			circle3d1.setFill(Color.BLACK);
			Circle circle3d2 = new Circle(280, 180, 10);// up right
			circle3d2.setFill(Color.BLACK);
			Circle circle3d3 = new Circle(250, 150, 10);// middle
			circle3d3.setFill(Color.BLACK);

			Group G3R = new Group(circle3d1, circle3d2, circle3d3);

//---------------------------------------4 DOT DICE R---------------------------------------------------------------------------------------------------------

			Circle circle4d1 = new Circle(220, 120, 10);// up left
			circle4d1.setFill(Color.BLACK);
			Circle circle4d2 = new Circle(220, 180, 10);// down left
			circle4d2.setFill(Color.BLACK);
			Circle circle4d3 = new Circle(280, 120, 10);// up right
			circle4d3.setFill(Color.BLACK);
			Circle circle4d4 = new Circle(280, 180, 10);// down right
			circle4d4.setFill(Color.BLACK);

			Group G4R = new Group(circle4d1, circle4d2, circle4d3, circle4d4);

//---------------------------------------5 DOT DICE R---------------------------------------------------------------------------------------------------------

			Circle circle5d1 = new Circle(220, 120, 10);// up left
			circle5d1.setFill(Color.BLACK);
			Circle circle5d2 = new Circle(220, 180, 10);// down left
			circle5d2.setFill(Color.BLACK);
			Circle circle5d3 = new Circle(280, 120, 10);// up right
			circle5d3.setFill(Color.BLACK);
			Circle circle5d4 = new Circle(280, 180, 10);// down right
			circle5d4.setFill(Color.BLACK);
			Circle circle5d5 = new Circle(250, 150, 10);// middle
			circle5d5.setFill(Color.BLACK);

			Group G5R = new Group(circle5d1, circle5d2, circle5d3, circle5d4, circle5d5);

//--------------------------------------- DOT DICE R---------------------------------------------------------------------------------------------------------

			Circle circle6d1 = new Circle(220, 120, 10);// up left
			circle6d1.setFill(Color.BLACK);
			Circle circle6d2 = new Circle(220, 180, 10);// down left
			circle6d2.setFill(Color.BLACK);
			Circle circle6d3 = new Circle(280, 120, 10);// up right
			circle6d3.setFill(Color.BLACK);
			Circle circle6d4 = new Circle(280, 180, 10);// down right
			circle6d4.setFill(Color.BLACK);
			Circle circle6d5 = new Circle(220, 150, 10);// middle left
			circle6d5.setFill(Color.BLACK);
			Circle circle6d6 = new Circle(280, 150, 10);// middle right
			circle6d5.setFill(Color.BLACK);

			Group G6R = new Group(circle6d1, circle6d2, circle6d3, circle6d4, circle6d5, circle6d6);

//---------------------------------------1 DOT DICE L---------------------------------------------------------------------------------------------------------

			Circle circleL1 = new Circle(120, 150, 10); // middle
			circleL1.setFill(Color.BLACK);
			Group G1L = new Group(circleL1);

//---------------------------------------2 DOT DICE L---------------------------------------------------------------------------------------------------------

			Circle circleL2d1 = new Circle(90, 120, 10); // up left
			circleL2d1.setFill(Color.BLACK);
			Circle circleL2d2 = new Circle(150, 180, 10); // down right
			circleL2d2.setFill(Color.BLACK);
			Group G2L = new Group(circleL2d1, circleL2d2);

//---------------------------------------3 DOT DICE L---------------------------------------------------------------------------------------------------------

			Circle circleL3d1 = new Circle(90, 120, 10); // up left
			circleL3d1.setFill(Color.BLACK);
			Circle circleL3d2 = new Circle(150, 180, 10); // down right
			circleL3d2.setFill(Color.BLACK);
			Circle circleL3d3 = new Circle(120, 150, 10); // middle
			circleL3d3.setFill(Color.BLACK);
			Group G3L = new Group(circleL3d1, circleL3d2, circleL3d3);

//---------------------------------------4 DOT DICE L---------------------------------------------------------------------------------------------------------

			Circle circleL4d1 = new Circle(90, 120, 10); // up left
			circleL4d1.setFill(Color.BLACK);
			Circle circleL4d2 = new Circle(90, 180, 10); // down left
			circleL4d2.setFill(Color.BLACK);
			Circle circleL4d3 = new Circle(150, 120, 10); // up right
			circleL4d3.setFill(Color.BLACK);
			Circle circleL4d4 = new Circle(150, 180, 10); // down right
			circleL4d4.setFill(Color.BLACK);
			Group G4L = new Group(circleL4d1, circleL4d2, circleL4d3, circleL4d4);

//---------------------------------------5 DOT DICE L---------------------------------------------------------------------------------------------------------

			Circle circleL5d1 = new Circle(90, 120, 10); // up left
			circleL5d1.setFill(Color.BLACK);
			Circle circleL5d2 = new Circle(90, 180, 10); // down left
			circleL5d2.setFill(Color.BLACK);
			Circle circleL5d3 = new Circle(150, 120, 10); // up right
			circleL5d3.setFill(Color.BLACK);
			Circle circleL5d4 = new Circle(150, 180, 10); // down right
			circleL5d4.setFill(Color.BLACK);
			Circle circleL5d5 = new Circle(120, 150, 10); // middle
			circleL5d5.setFill(Color.BLACK);
			Group G5L = new Group(circleL5d1, circleL5d2, circleL5d3, circleL5d4, circleL5d5);

//---------------------------------------6 DOT DICE L---------------------------------------------------------------------------------------------------------

			Circle circleL6d1 = new Circle(90, 120, 10); // up left
			circleL6d1.setFill(Color.BLACK);
			Circle circleL6d2 = new Circle(90, 180, 10); // down left
			circleL6d2.setFill(Color.BLACK);
			Circle circleL6d3 = new Circle(150, 120, 10); // up right
			circleL6d3.setFill(Color.BLACK);
			Circle circleL6d4 = new Circle(150, 180, 10); // down right
			circleL6d4.setFill(Color.BLACK);
			Circle circleL6d5 = new Circle(90, 150, 10); // middle left
			circleL6d5.setFill(Color.BLACK);
			Circle circleL6d6 = new Circle(150, 150, 10); // middle right
			circleL6d6.setFill(Color.BLACK);
			Group G6L = new Group(circleL6d1, circleL6d2, circleL6d3, circleL6d4, circleL6d5, circleL6d6);

//------------------------------------------------------------------------------------------------------------------------------------------------------------

			// Throw Button
			Button throwButton = new Button("Throw");
			throwButton.setLayoutX(160);
			throwButton.setLayoutY(250);

			throwButton.setOnAction(event -> {
				Random rand = new Random();
				int dice1 = rand.nextInt(6) + 1;
				int dice2 = rand.nextInt(6) + 1;

				root.getChildren().removeAll(G1L, G2L, G3L, G4L, G5L, G6L, G1R, G2R, G3R, G4R, G5R, G6R);

				switch (dice1) {
				case 1:
					root.getChildren().add(G1L);
					break;
				case 2:
					root.getChildren().add(G2L);
					break;
				case 3:
					root.getChildren().add(G3L);
					break;
				case 4:
					root.getChildren().add(G4L);
					break;
				case 5:
					root.getChildren().add(G5L);
					break;
				case 6:
					root.getChildren().add(G6L);
					break;
				}

				switch (dice2) {
				case 1:
					root.getChildren().add(G1R);
					break;
				case 2:
					root.getChildren().add(G2R);
					break;
				case 3:
					root.getChildren().add(G3R);
					break;
				case 4:
					root.getChildren().add(G4R);
					break;
				case 5:
					root.getChildren().add(G5R);
					break;
				case 6:
					root.getChildren().add(G6R);
					break;
				}
			});

			root.getChildren().add(throwButton);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
