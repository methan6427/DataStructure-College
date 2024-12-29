package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

	private static ComboBox<String> colorDropBox;
	private boolean isCircleSelected = false;
	private boolean isRectangleSelected = false;
	private static ArrayList<String> list = new ArrayList<>();
	private static Pane drawingArea = new Pane();

	@Override
	public void start(Stage primaryStage) {
		try {
			// THE MAIN PANE
			Pane root = new Pane();
			root.setStyle("-fx-background-color: black;");

			Scene scene = new Scene(root, 1200, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Drawing Application");

			// SECONDARY PANE ( DRAWING PANE )
			drawingArea.setStyle("-fx-background-color: #FFFFFF;");
			drawingArea.setPrefSize(1920, 1080);
			drawingArea.setLayoutX(200);
			drawingArea.setLayoutY(100);

			root.getChildren().add(drawingArea);

			// MENU STUFF
			MenuBar MenuBarFile = new MenuBar();
			Menu fileMenu = new Menu("📁 📂");
			fileMenu.setStyle("-fx-background-color: black;-fx-dark-text-color: white;-fx-mid-text-color: white;"
					+ "-fx-light-text-color: white;fx-font-size: 14px;-fx-font-weight: bold;-fx-pref-width: 70px;-fx-pref-height: 7px;");
			MenuBarFile.setStyle("-fx-background-color: black;");
			MenuItem saveItem = new MenuItem("Save");
			MenuItem openItem = new MenuItem("Open");

			fileMenu.getItems().addAll(saveItem, openItem);
			MenuBarFile.getMenus().add(fileMenu);
			saveItem.setOnAction(e -> {
				writeFile();
			});
			openItem.setOnAction(e -> {
				readFile();
			});

			// VBOX CONTAINING BUTTONS AND A COMBOBOX
			VBox buttonVbox = new VBox(10);
			buttonVbox.setLayoutY(30);

			HBox buttons = new HBox(5);
			buttons.setLayoutY(70);
			Button circleButton = new Button("⚫");
			circleButton.setTextFill(Color.WHITE);
			circleButton.getStyleClass().add("circleButton");

			circleButton.setStyle("-fx-pref-width: 50px; -fx-pref-height: 10px;");

			Button rectangleButton = new Button("⬛");
			rectangleButton.setTextFill(Color.WHITE);
			rectangleButton.getStyleClass().add("rectangleButton");

			rectangleButton.setStyle("-fx-pref-width: 50px; -fx-pref-height: 10px;");
			buttons.getChildren().addAll(circleButton, rectangleButton);

			colorDropBox = new ComboBox<>();
			colorDropBox.getItems().addAll("Red", "Green", "Blue", "Black");
			colorDropBox.setValue("Black");
			colorDropBox.getStyleClass().add("comboBox");

			buttonVbox.getChildren().addAll(buttons, colorDropBox);

			// EVENTS AND ACTIONS
			circleButton.setOnAction(e -> {
				isCircleSelected = true;
				isRectangleSelected = false;

			});

			rectangleButton.setOnAction(e -> {
				isRectangleSelected = true;
				isCircleSelected = false;

			});

			drawingArea.setOnMousePressed(e -> {
				if (isCircleSelected) {
					Circle circle = new Circle(e.getX(), e.getY(), 0, Color.valueOf(colorDropBox.getValue()));
					circle.setStroke(Color.valueOf(colorDropBox.getValue()));
					circle.setFill(Color.WHITE);
					drawingArea.getChildren().add(circle);

					drawingArea.setOnMouseDragged(dragEvent -> {
						double radius = Math.sqrt(
								Math.pow(dragEvent.getX() - e.getX(), 2) + Math.pow(dragEvent.getY() - e.getY(), 2));
						circle.setRadius(radius);
						list.add(
								"C," + e.getX() + "," + e.getY() + "," + radius + "," + colorDropBox.getValue() + "\n");
					});

				} else if (isRectangleSelected) {
					Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 0, 0);
					rectangle.setStroke(Color.valueOf(colorDropBox.getValue()));
					rectangle.setFill(Color.WHITE);
					drawingArea.getChildren().add(rectangle);

					drawingArea.setOnMouseDragged(dragEvent -> {
						double width = Math.abs(dragEvent.getX() - e.getX());
						double height = Math.abs(dragEvent.getY() - e.getY());

						rectangle.setWidth(width);
						rectangle.setHeight(height);
						list.add("R," + e.getX() + "," + e.getY() + "," + width + "," + height + ","
								+ colorDropBox.getValue() + "\n");

					});
				}
			});

			root.getChildren().addAll(MenuBarFile, buttonVbox);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readFile() {
		File file = new FileChooser().showOpenDialog(new Stage());
		try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
			while (in.available() > 0) {
				char shapeType = in.readChar();
				double x = in.readDouble();
				double y = in.readDouble();
				String color = in.readUTF().trim();
				if (shapeType == 'C') {
					double radius = in.readDouble();
					Circle circle = new Circle(x, y, radius, Color.valueOf(color));
					circle.setStroke(Color.valueOf(color));
					circle.setFill(Color.WHITE);
					drawingArea.getChildren().add(circle);
					list.add("C," + x + "," + y + "," + radius + "," + color);
				} else if (shapeType == 'R') {
					double width = in.readDouble();
					double height = in.readDouble();
					Rectangle rectangle = new Rectangle(x, y, width, height);
					rectangle.setStroke(Color.valueOf(color));
					rectangle.setFill(Color.WHITE);
					drawingArea.getChildren().add(rectangle);
					list.add("R," + x + "," + y + "," + width + "," + height + "," + color);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Drawing Data");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Binary Files", "*.dat"));
		File file = fileChooser.showSaveDialog(new Stage());

		if (file != null) {
			try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
				for (String item : list) {
					String[] parts = item.split(",");
					char shapeType = parts[0].charAt(0); // 'C' for Circle or 'R' for Rectangle
					double x = Double.parseDouble(parts[1]);
					double y = Double.parseDouble(parts[2]);
					String color = parts[parts.length - 1]; // Color is always the last item

					out.writeChar(shapeType);
					out.writeDouble(x);
					out.writeDouble(y);
					out.writeUTF(color);

					if (shapeType == 'C') {
						double radius = Double.parseDouble(parts[3]);
						out.writeDouble(radius);
					} else if (shapeType == 'R') {
						double width = Double.parseDouble(parts[3]);
						double height = Double.parseDouble(parts[4]);
						out.writeDouble(width);
						out.writeDouble(height);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File save operation was cancelled.");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
