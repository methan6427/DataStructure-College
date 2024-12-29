package application;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class updatedMain extends Application {
	private TableView<Student> tableView = new TableView<>();
	TableView<Student> tableM = new TableView<>();
	MajorDoubleLList MJlist = new MajorDoubleLList();
	DNode<Major> current;
	Label mshow = new Label("No major");
	Alert alert = new Alert(Alert.AlertType.ERROR);

	@Override
	public void start(Stage primaryStage) {
//*****************************************************MAJOR SCENE***********************************************************************************************************************		
		try {
			// Creating Major Scene
			BorderPane MajorPane = new BorderPane();
			Stage MajorStage = new Stage();
			Scene MajorScene = new Scene(MajorPane, 900, 600);
			MajorStage.setScene(MajorScene);
			MajorStage.setTitle("INSERT NEW MAJOR");
			MajorStage.show();
			MajorScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			TableColumn<Student, Integer> idColumnMajor = new TableColumn<>("ID");
			idColumnMajor.setCellValueFactory(new PropertyValueFactory<>("id"));
			idColumnMajor.setMinWidth(80);
			idColumnMajor.setMaxWidth(150);

			TableColumn<Student, String> nameColumnMajor = new TableColumn<>("Name");
			nameColumnMajor.setCellValueFactory(new PropertyValueFactory<>("name"));
			nameColumnMajor.setMinWidth(250);
			nameColumnMajor.setMaxWidth(400);

			TableColumn<Student, Double> tawjihiGradeColumnMajor = new TableColumn<>("Tawjihi Grade");
			tawjihiGradeColumnMajor.setCellValueFactory(new PropertyValueFactory<>("tawjihiGrade"));

			tawjihiGradeColumnMajor.setMinWidth(200);
			tawjihiGradeColumnMajor.setMaxWidth(400);

			TableColumn<Student, Double> placementTestGradeColumnMajor = new TableColumn<>("Placement Test Grade");
			placementTestGradeColumnMajor.setCellValueFactory(new PropertyValueFactory<>("placementTestGrade"));
			placementTestGradeColumnMajor.setMinWidth(200);
			placementTestGradeColumnMajor.setMaxWidth(400);

			TableColumn<Student, String> chosenMajorColumnMajor = new TableColumn<>("Chosen Major");
			chosenMajorColumnMajor.setCellValueFactory(new PropertyValueFactory<>("chosenMajor"));
			chosenMajorColumnMajor.setMinWidth(200);
			chosenMajorColumnMajor.setMaxWidth(400);

			tableM.getColumns().addAll(idColumnMajor, nameColumnMajor, tawjihiGradeColumnMajor,
					placementTestGradeColumnMajor);

			if (current != null) {
				MJlist.fillTable(tableM, current.getData().getName());
				mshow.setText(current.getData().getName());
			}
			// show table in the scene
			VBox centerMVBox = new VBox(10, tableM);
			centerMVBox.setAlignment(Pos.CENTER);
			MajorPane.setCenter(centerMVBox);

			// search area
			Button studentScreenButton = new Button("Student Page");
			Label searchMLabel = new Label("Search:");
			TextField searchMField = new TextField();
			Button searchMButton = new Button("Search");
			Button statisticsScreenButton = new Button("Statistics");
			Label msgM = new Label();

			// major show
			HBox majorShow = new HBox(10, mshow);
			majorShow.setAlignment(Pos.CENTER);
			// Major search action
			searchMButton.setOnMouseClicked(search -> {

			});

			HBox searchMBox = new HBox(10, studentScreenButton, searchMLabel, searchMField, searchMButton,
					statisticsScreenButton, msgM);
			VBox vbox = new VBox(10, searchMBox, majorShow);
			vbox.setAlignment(Pos.CENTER);
			searchMBox.setAlignment(Pos.CENTER);
			Button prev = new Button("prev");
			Button saveMButton = new Button("Save");
			Button loadMButton = new Button("Load");
			Button next = new Button("Next");
			HBox fileMButtonBox = new HBox(10, prev, saveMButton, loadMButton, next);
			fileMButtonBox.setAlignment(Pos.CENTER);

			// prev,save,load,next actions
			prev.setOnAction(e -> {
				try {
					if (current == null)
						prev.setDisable(true);
					next.setDisable(true);
					if (current.getPrevious() == null) {
						prev.setDisable(true);
						next.setDisable(false);
					} else {
						current = current.getPrevious();
						next.setDisable(false);
						MJlist.fillTable(tableM, current.getData().getName());
						mshow.setText(current.getData().getName());

					}
				} catch (Exception e2) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();

				}

			});
			saveMButton.setOnMouseClicked(savet -> {
				try {
					saveMajors(MajorStage);

				} catch (Exception e3) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();

				}
			});

			loadMButton.setOnMouseClicked(loadt -> {
				try {
					loadMajors(MajorStage);

				} catch (Exception e3) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();

				}
			});
			next.setOnAction(e -> {
				try {
					if (current == null)
						next.setDisable(true);
					prev.setDisable(true);
					if (current.getNext() == null) {
						next.setDisable(true);
						prev.setDisable(false);
					} else {
						current = current.getNext();
						prev.setDisable(false);
						MJlist.fillTable(tableM, current.getData().getName());
						mshow.setText(current.getData().getName());

					}
				} catch (Exception e2) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();
				}
			});

			VBox topMNodes = new VBox(10);
			topMNodes.getChildren().addAll(vbox, fileMButtonBox);
			MajorPane.setTop(topMNodes);

			Button insertMajorButton = new Button("Insert");
			Button deleteMajorButton = new Button("Delete");
			Button updateMajorButton = new Button("Update");
			HBox buttonMajorBox = new HBox(10, insertMajorButton, deleteMajorButton, updateMajorButton);
			buttonMajorBox.setAlignment(Pos.CENTER);
			MajorPane.setBottom(buttonMajorBox);

			// actions
			updateMajorButton.setOnAction(e -> {
				try {

				} catch (Exception e2) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();
				}
			});
			deleteMajorButton.setOnAction(e -> {
				try {
					MJlist.deleteMajor(current.getData().getName());
					if (current.getNext() != null)
						current = current.getNext();
					else if (current.getPrevious() != null)
						current = current.getPrevious();
					else {
						mshow.setText("NO MAJORS");
						tableM.getItems().clear();
					}
					MJlist.fillTable(tableM, current.getData().getName());
					mshow.setText(current.getData().getName());
				} catch (Exception e2) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();
				}

			});
			updateMajorButton.setOnMouseClicked(insert -> {

				try {
					Pane insertMajorPane = new Pane();
					Stage insertMajorStage = new Stage();
					Scene insertMajorScene = new Scene(insertMajorPane, 400, 450);
					insertMajorStage.setScene(insertMajorScene);
					insertMajorStage.setTitle("Update NEW Major");
					insertMajorStage.show();

					// Create Labels and TextFields for student data

					Label nameLabel = new Label("Major Name:");
					TextField nameField = new TextField();
					HBox NAME = new HBox(50);
					NAME.getChildren().addAll(nameLabel, nameField);

					Label acceptanceGradeLabel = new Label("Acceptance Grade:");
					TextField acceptanceGradeField = new TextField();
					HBox AGBox = new HBox(13);
					AGBox.getChildren().addAll(acceptanceGradeLabel, acceptanceGradeField);

					Label tawjihiGradeLabel = new Label("Tawjihi Grade:");
					TextField tawjihiGradeField = new TextField();
					HBox TGBox = new HBox(40);
					TGBox.getChildren().addAll(tawjihiGradeLabel, tawjihiGradeField);

					Label placementTestGradeLabel = new Label("PT Grade:");
					TextField placementTestGradeField = new TextField();
					HBox PTBox = new HBox(70);
					PTBox.getChildren().addAll(placementTestGradeLabel, placementTestGradeField);

					VBox formLayout = new VBox(15);
					formLayout.getChildren().addAll(NAME, AGBox, TGBox, PTBox);
					formLayout.setLayoutX(10);
					formLayout.setLayoutY(20);

					HBox insertPaneButtons = new HBox(10);
					Button saveSt = new Button("SAVE");
					saveSt.setPrefSize(70, 40);
					insertPaneButtons.getChildren().addAll(saveSt);
					insertPaneButtons.setLayoutX(160);
					insertPaneButtons.setLayoutY(350);
					if (current != null) {
						nameField.setText(current.getData().getName());
						acceptanceGradeField.setText(current.getData().getAcceptanceGrade() + "");
						tawjihiGradeField.setText(current.getData().getTawjihiWeight() + "");
						placementTestGradeField.setText(current.getData().getPlacementTestWeight() + "");
					} else
						// nothing to update
						saveSt.setOnAction(save -> {

							String name = nameField.getText().trim();
							if (name.isEmpty()) {

							} else {
								try {
									double acceptance = Double.parseDouble(acceptanceGradeField.getText().trim());
									double taw = Double.parseDouble(tawjihiGradeField.getText().trim());
									double place = Double.parseDouble(placementTestGradeField.getText().trim());
									Major m = new Major(name, acceptance, taw, place);
									m.setSlist(current.getData().getSlist());
									if (MJlist.searchMajor(name) == null || name.equals(current.getData().getName())) {
										MJlist.deleteMajor(current.getData().getName());
										MJlist.insertMajor(m);
									} else {
										// already exists
									}
								} catch (Exception e) {
									alert.setContentText("An error has occurred.");
									alert.showAndWait();

								}

							}
						});
					insertMajorPane.getChildren().addAll(formLayout, insertPaneButtons);

					insertMajorPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				} catch (Exception e) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();
				}

			});
			// insert action
			insertMajorButton.setOnMouseClicked(insert -> {

				try {
					Pane insertMajorPane = new Pane();
					Stage insertMajorStage = new Stage();
					Scene insertMajorScene = new Scene(insertMajorPane, 400, 450);
					insertMajorStage.setScene(insertMajorScene);
					insertMajorStage.setTitle("INSERT NEW Major");
					insertMajorStage.show();

					// Create Labels and TextFields for student data

					Label nameLabel = new Label("Major Name:");
					TextField nameField = new TextField();
					HBox NAME = new HBox(50);
					NAME.getChildren().addAll(nameLabel, nameField);

					Label acceptanceGradeLabel = new Label("Acceptance Grade:");
					TextField acceptanceGradeField = new TextField();
					HBox AGBox = new HBox(13);
					AGBox.getChildren().addAll(acceptanceGradeLabel, acceptanceGradeField);

					Label tawjihiGradeLabel = new Label("Tawjihi Grade:");
					TextField tawjihiGradeField = new TextField();
					HBox TGBox = new HBox(40);
					TGBox.getChildren().addAll(tawjihiGradeLabel, tawjihiGradeField);

					Label placementTestGradeLabel = new Label("PT Grade:");
					TextField placementTestGradeField = new TextField();
					HBox PTBox = new HBox(70);
					PTBox.getChildren().addAll(placementTestGradeLabel, placementTestGradeField);

					VBox formLayout = new VBox(15);
					formLayout.getChildren().addAll(NAME, AGBox, TGBox, PTBox);
					formLayout.setLayoutX(10);
					formLayout.setLayoutY(20);

					HBox insertPaneButtons = new HBox(10);
					Button saveSt = new Button("SAVE");
					saveSt.setPrefSize(70, 40);
					insertPaneButtons.getChildren().addAll(saveSt);
					insertPaneButtons.setLayoutX(160);
					insertPaneButtons.setLayoutY(350);
					saveSt.setOnAction(save -> {

						String name = nameField.getText().trim();
						if (name.isEmpty()) {

						} else {
							try {
								double acceptance = Double.parseDouble(acceptanceGradeField.getText().trim());
								double taw = Double.parseDouble(tawjihiGradeField.getText().trim());
								double place = Double.parseDouble(placementTestGradeField.getText().trim());
								Major m = new Major(name, acceptance, taw, place);
								if (MJlist.searchMajor(name) == null) {
									MJlist.insertMajor(m);
								} else {
									// already exists
								}
							} catch (Exception e) {
								alert.setContentText("An error has occurred.");
								alert.showAndWait();

							}

						}
					});
					insertMajorPane.getChildren().addAll(formLayout, insertPaneButtons);

					insertMajorPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				} catch (Exception e) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();
				}

			});
//***************************************************************************************************************************************************************************************
			// END OF MAJOR SCENE//
//********************************************************STUDENT SCENE******************************************************************************************************************
			studentScreenButton.setOnMouseClicked(click -> {

				try {
					// main scene
					BorderPane root = new BorderPane();
					Scene scene = new Scene(root, 900, 600);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					primaryStage.setTitle("Student Admission Management System");

					// --------------------------------------------------------------------------------------------------------------------------------------

					// TableView
					TableColumn<Student, Integer> idColumn = new TableColumn<>("ID");
					idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
					idColumn.setMinWidth(80);
					idColumn.setMaxWidth(150);

					TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
					nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
					nameColumn.setMinWidth(250);
					nameColumn.setMaxWidth(400);

					TableColumn<Student, Double> tawjihiGradeColumn = new TableColumn<>("Tawjihi Grade");
					tawjihiGradeColumn.setCellValueFactory(new PropertyValueFactory<>("tawjihiGrade"));

					tawjihiGradeColumn.setMinWidth(200);
					tawjihiGradeColumn.setMaxWidth(400);

					TableColumn<Student, Double> placementTestGradeColumn = new TableColumn<>("Placement Test Grade");
					placementTestGradeColumn.setCellValueFactory(new PropertyValueFactory<>("placementTestGrade"));
					placementTestGradeColumn.setMinWidth(200);
					placementTestGradeColumn.setMaxWidth(400);

					TableColumn<Student, String> chosenMajorColumn = new TableColumn<>("Chosen Major");
					chosenMajorColumn.setCellValueFactory(new PropertyValueFactory<>("chosenMajor"));
					chosenMajorColumn.setMinWidth(200);
					chosenMajorColumn.setMaxWidth(400);

					// TableColumn<Student, Double> admissionMarkColumn = new
					// TableColumn<>("Admission Mark");
					// admissionMarkColumn.setCellValueFactory(new
					// PropertyValueFactory<>("admissionMark"));

					tableView.getColumns().addAll(idColumn, nameColumn, tawjihiGradeColumn, placementTestGradeColumn,
							chosenMajorColumn);

					// --------------------------------------------------------------------------------------------------------------------------------------

					// Center VBox with TableView
					VBox centerVBox = new VBox(10, tableView);
					centerVBox.setAlignment(Pos.CENTER);
					root.setCenter(centerVBox);

					// Top Search Bar
					Label searchLabel = new Label("Search:");
					TextField searchField = new TextField();
					Button searchButton = new Button("Search");
					Label msg = new Label();
					HBox searchBox = new HBox(10, searchLabel, searchField, searchButton, msg);
					searchBox.setAlignment(Pos.CENTER);

					// Top Buttons for save and load
					Button saveButton = new Button("Save");
					Button loadButton = new Button("Load");
					HBox fileButtonBox = new HBox(10, saveButton, loadButton);
					fileButtonBox.setAlignment(Pos.CENTER);

					// vbox that contains search hbox and file hbox
					VBox topNodes = new VBox(10);
					topNodes.getChildren().addAll(searchBox, fileButtonBox);
					root.setTop(topNodes);

					// Bottom Buttons for Insert, Delete, Update
					Button insertButton = new Button("Insert");
					Button deleteButton = new Button("Delete");
					Button updateButton = new Button("Update");
					HBox buttonBox = new HBox(10, insertButton, deleteButton, updateButton);
					buttonBox.setAlignment(Pos.CENTER);
					root.setBottom(buttonBox);

					// --------------------------------------------------------------------------------------------------------------------------------------
					// --------------------------------------------------------------------------------------------------------------------------------------

					// actions

					// insert action
					insertButton.setOnMouseClicked(insert -> {
						try {
							Pane insertPane = new Pane();
							Stage insertStage = new Stage();
							Scene insertScene = new Scene(insertPane, 300, 400);
							insertStage.setScene(insertScene);
							insertStage.setTitle("INSERT NEW STUDENT");
							insertStage.show();

							// Create Labels and TextFields for student data
							Label idLabel = new Label("Student ID:");
							TextField idField = new TextField();
							HBox ID = new HBox(30);
							ID.getChildren().addAll(idLabel, idField);

							Label nameLabel = new Label("Name:");
							TextField nameField = new TextField();
							HBox NAME = new HBox(62);
							NAME.getChildren().addAll(nameLabel, nameField);

							Label tawjihiGradeLabel = new Label("Tawjihi Grade:");
							TextField tawjihiGradeField = new TextField();
							HBox TGBox = new HBox(10);

							TGBox.getChildren().addAll(tawjihiGradeLabel, tawjihiGradeField);

							Label placementTestGradeLabel = new Label("PT Grade:");
							TextField placementTestGradeField = new TextField();
							HBox PTBox = new HBox(40);
							PTBox.getChildren().addAll(placementTestGradeLabel, placementTestGradeField);

							Label majorLabel = new Label("Chosen Major:");
							TextField majorField = new TextField();
							HBox MAJOR = new HBox(10);
							MAJOR.getChildren().addAll(majorLabel, majorField);

							VBox formLayout = new VBox(15);
							formLayout.getChildren().addAll(ID, NAME, TGBox, PTBox, MAJOR);
							formLayout.setLayoutX(10);
							formLayout.setLayoutY(20);

							HBox insertPaneButtons = new HBox(10);
							Button saveSt = new Button("SAVE");
							saveSt.setOnMouseClicked(paneSave -> {
								try {
									int id = Integer.parseInt(idField.getText().trim());
									String name = nameField.getText().trim();
									double tawjihigrade = Double.parseDouble(tawjihiGradeField.getText().trim());
									double placementgrade = Double
											.parseDouble(placementTestGradeField.getText().trim());

									String bmajor = majorField.getText().trim();

									Student newStudent = new Student(id, name, tawjihigrade, placementgrade, bmajor);
									int answer = MJlist.searchMajor(bmajor).AcceptedOrRejected(newStudent);
									System.out.println(answer);
									if (answer == -1) {
										Stage stage = new Stage();
										ComboBox<String> combo = new ComboBox<>();
										DNode<Major> cMajor = MJlist.getHead();

										while (cMajor != null) {
											if (cMajor.getData().checkStudent(newStudent) > 0)
												combo.getItems().add(cMajor.getData().getName());
											cMajor = cMajor.getNext();
										}
										Button ok = new Button("Ok");
										VBox vbo1x = new VBox(10, combo, ok);
										vbo1x.setAlignment(Pos.CENTER);
										stage.setScene(new Scene(vbo1x, 400, 300));
										stage.show();
										;
										if (newStudent.equals("")) {

										} else {
											ok.setOnAction(e -> {
												if (combo.getSelectionModel().getSelectedItem() != null) {
													MJlist.searchMajor(combo.getSelectionModel().getSelectedItem())
															.AcceptedOrRejected(newStudent);
													stage.close();
												}

											});
										}
										MJlist.fillTableStudents(tableView);

									}
								} catch (Exception e) {
									alert.setContentText("An error has occurred.");
									alert.showAndWait();
								}
							});
							saveSt.setPrefSize(70, 40);
							insertPaneButtons.getChildren().addAll(saveSt);
							insertPaneButtons.setLayoutX(120);
							insertPaneButtons.setLayoutY(350);

							insertPane.getChildren().addAll(formLayout, insertPaneButtons);

							insertScene.getStylesheets()
									.add(getClass().getResource("application.css").toExternalForm());
						} catch (Exception e) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}

					});
					// --------------------------------------------------------------------------------------------------------------------------------------

					saveButton.setOnMouseClicked(save -> {
						try {
							saveStudents(primaryStage);
						} catch (Exception e) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}

					});
					// --------------------------------------------------------------------------------------------------------------------------------------

					// load action(read file)
					loadButton.setOnMouseClicked(loadst -> {
						try {
							loadStudents(primaryStage);
						} catch (Exception e) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();
						}

					});

					// --------------------------------------------------------------------------------------------------------------------------------------

					// delete action
					deleteButton.setOnMouseClicked(delete -> {

						try {
							Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
							if (selectedStudent != null) {
								MJlist.searchMajor(selectedStudent.getChosenMajor()).getSlist()
										.deleteStudent(selectedStudent.getId());

								MJlist.fillTableStudents(tableView);
							} else {
								System.out.println("No employee selected for deletion.");
							}
						} catch (Exception e) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}

					});
					// --------------------------------------------------------------------------------------------------------------------------------------

					// update action
					updateButton.setOnMouseClicked(update -> {

						try {// delete
							Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
							if (selectedStudent != null) {
								MJlist.searchMajor(selectedStudent.getChosenMajor()).getSlist()
										.deleteStudent(selectedStudent.getId());
								// insert new
								Pane insertPane = new Pane();
								Stage insertStage = new Stage();
								Scene insertScene = new Scene(insertPane, 300, 400);
								insertStage.setScene(insertScene);
								insertStage.setTitle("update NEW STUDENT");
								insertStage.show();

								// Create Labels and TextFields for student data
								Label idLabel = new Label("Student ID:");
								TextField idField = new TextField();
								HBox ID = new HBox(30);
								ID.getChildren().addAll(idLabel, idField);

								Label nameLabel = new Label("Name:");
								TextField nameField = new TextField();
								HBox NAME = new HBox(62);
								NAME.getChildren().addAll(nameLabel, nameField);

								Label tawjihiGradeLabel = new Label("Tawjihi Grade:");
								TextField tawjihiGradeField = new TextField();
								HBox TGBox = new HBox(10);

								TGBox.getChildren().addAll(tawjihiGradeLabel, tawjihiGradeField);

								Label placementTestGradeLabel = new Label("PT Grade:");
								TextField placementTestGradeField = new TextField();
								HBox PTBox = new HBox(40);
								PTBox.getChildren().addAll(placementTestGradeLabel, placementTestGradeField);

								Label majorLabel = new Label("Chosen Major:");
								TextField majorField = new TextField();
								HBox MAJOR = new HBox(10);
								MAJOR.getChildren().addAll(majorLabel, majorField);
								idField.setText(selectedStudent.getId() + "");
								nameField.setText(selectedStudent.getName() + "");
								tawjihiGradeField.setText(selectedStudent.getTawjihiGrade() + "");
								placementTestGradeField.setText(selectedStudent.getPlacementTestGrade() + "");

								VBox formLayout = new VBox(15);
								formLayout.getChildren().addAll(ID, NAME, TGBox, PTBox, MAJOR);
								formLayout.setLayoutX(10);
								formLayout.setLayoutY(20);

								HBox insertPaneButtons = new HBox(10);
								Button saveSt = new Button("SAVE");
								saveSt.setPrefSize(70, 40);
								insertPaneButtons.getChildren().addAll(saveSt);
								insertPaneButtons.setLayoutX(120);
								insertPaneButtons.setLayoutY(350);

								insertPane.getChildren().addAll(formLayout, insertPaneButtons);

								insertScene.getStylesheets()
										.add(getClass().getResource("application.css").toExternalForm());

								saveSt.setOnMouseClicked(paneSave -> {
									try {
										int id = Integer.parseInt(idField.getText().trim());
										String name = nameField.getText().trim();
										double tawjihigrade = Double.parseDouble(tawjihiGradeField.getText().trim());
										double placementgrade = Double
												.parseDouble(placementTestGradeField.getText().trim());

										String bmajor = majorField.getText().trim();
										if (name.equals("") ||bmajor.equals("") ) {
											alert.setContentText("An error has occurred.");
											alert.showAndWait();
										} else {

											Student newStudent = new Student(id, name, tawjihigrade, placementgrade,
													bmajor);
											MJlist.searchMajor(selectedStudent.getChosenMajor())
													.AcceptedOrRejected(newStudent);
											MJlist.fillTableStudents(tableView);
										}
									} catch (Exception e) {
										alert.setContentText("An error has occurred.");
										alert.showAndWait();
									}
								});

							} else {
								System.out.println("No students selected to update.");
							}
						} catch (Exception e) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}

					});
					// --------------------------------------------------------------------------------------------------------------------------------------

					// search action
					searchButton.setOnMouseClicked(search -> {
						try {
							String searchText = searchField.getText().trim();
							System.out.println(searchText);
							if (!searchText.isEmpty()) {
								StudentList<Student> list = MJlist.fillAllStudents();
								SNode<Student> currentS = list.getHead();
								while (currentS != null) {
									if (currentS.getData().getId() == Integer.parseInt(searchText)) {
										tableView.setItems(FXCollections.observableArrayList(currentS.getData()));
										msg.setText("student found: " + currentS.getData().getName());
										return;
									}
									currentS = currentS.getNext();
								}
								msg.setText("student not found.");

							} else {
								MJlist.fillAllStudents();

							}
						} catch (Exception e) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}

					});
					// --------------------------------------------------------------------------------------------------------------------------------------

					// --------------------------------------------------------------------------------------------------------------------------------------

				} catch (Exception e) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();

				}

			});
//****************************************************************************************************************************************************************************************
			// END OF STUDENT SCENE//
//******************************STATISTICS SCENE******************************************************************************************************************************************

			statisticsScreenButton.setOnMouseClicked(statClick -> {
				try { // Create a new layout for the statistics screen
					BorderPane statPane = new BorderPane();

					// Top section - TextField and Label
					VBox topBox = new VBox(10);
					Label enterNumberLabel = new Label("Enter the number:");
					TextField numberField = new TextField();
					numberField.setPromptText("Enter a number...");
					enterNumberLabel.setStyle("-fx-text-fill: #f1fa8c; -fx-font-weight: bold;"); // Use the existing
																									// theme
																									// color
					topBox.setAlignment(Pos.CENTER);
					topBox.getChildren().addAll(enterNumberLabel, numberField);

					// Center section - TextArea
					TextArea resultArea = new TextArea();
					resultArea.setPromptText("Results will appear here...");
					resultArea.setEditable(false);

					resultArea.setPrefHeight(300);

					// Bottom section - Buttons and ComboBox
					HBox bottomBox = new HBox(15);
					Button topNButton = new Button("Top N");
					Button calculateButton = new Button("Calculate");
					ComboBox<String> optionsComboBox = new ComboBox<>();
					DNode<Major> cMajor = MJlist.getHead();
					while (cMajor != null) {
						optionsComboBox.getItems().add(cMajor.getData().getName());
						cMajor = cMajor.getNext();
					}

					bottomBox.setAlignment(Pos.CENTER);
					bottomBox.getChildren().addAll(topNButton, calculateButton, optionsComboBox);
					topNButton.setOnAction(e -> {
						try {
							int number = Integer.parseInt(numberField.getText().trim());
							SNode cStudent = MJlist.searchMajor(optionsComboBox.getSelectionModel().getSelectedItem())
									.getSlist().getHead();
							int count = 0;
							while (cStudent != null && count < number) {
								resultArea.appendText(cStudent.getData().toString() + "\n");
								count++;
								cStudent = cStudent.getNext();
							}

						} catch (Exception ex) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}

					});
					calculateButton.setOnAction(ev -> {
						String major = optionsComboBox.getSelectionModel().getSelectedItem();
						Major m = MJlist.searchMajor(major);
						double res = 0;
						try {
							res = m.accept / (m.accept + m.reject);
						} catch (Exception EX) {
							alert.setContentText("An error has occurred.");
							alert.showAndWait();

						}
						resultArea.setText("Accepted students " + m.accept + "\n Rejected Students " + m.reject
								+ " \nEvaluated students " + (m.accept + m.reject) + "\n Acceptance rate" + res);
					});
					// Assemble the layout
					statPane.setTop(topBox);
					statPane.setCenter(resultArea);
					statPane.setBottom(bottomBox);
					BorderPane.setAlignment(topBox, Pos.TOP_CENTER);
					BorderPane.setAlignment(bottomBox, Pos.BOTTOM_CENTER);
					BorderPane.setMargin(topBox, new Insets(20, 0, 10, 0));
					BorderPane.setMargin(bottomBox, new Insets(10, 0, 20, 0));

					// Set up the scene and show it
					Scene statScene = new Scene(statPane, 600, 400);
					statScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					Stage statStage = new Stage();
					statStage.setScene(statScene);
					statStage.setTitle("Statistics Screen");
					statStage.show();
				} catch (Exception e) {
					alert.setContentText("An error has occurred.");
					alert.showAndWait();
				}

			});

		} catch (Exception e) {
			alert.setContentText("An error has occurred.");
			alert.showAndWait();
		}
	}
	// --------------------------------------------------------------------------------------------------------------------------------------

	/*
	 * public void loadMajors(Stage primaryStage) throws IOException { FileChooser
	 * fileChooser = new FileChooser();
	 * fileChooser.setTitle("Select Major Criteria File"); File majorFile =
	 * fileChooser.showOpenDialog(primaryStage);
	 * 
	 * if (majorFile != null) { try (Scanner Fscanner = new Scanner(majorFile)) {
	 * 
	 * Fscanner.nextLine(); while (Fscanner.hasNextLine()) { String[] data =
	 * Fscanner.nextLine().split(","); String major = data[0]; double accgrade =
	 * Double.parseDouble(data[1]); double tawjweigh = Double.parseDouble(data[2]);
	 * double PTweight = Double.parseDouble(data[3]);
	 * 
	 * Major majorl = new Major(major, accgrade, tawjweigh, PTweight);
	 * 
	 * } tableView.setItems(MJlist.toObservableList());
	 * System.out.println("Employees loaded from " + majorFile.getAbsolutePath());
	 * 
	 * } catch (Exception e) { javafx.scene.control.Alert alert = new
	 * javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
	 * alert.setContentText("An error has occurred."); alert.showAndWait(); // TODO:
	 * handle exception } }
	 * 
	 * }
	 */
	public void loadStudents(Stage primaryStage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Student File");
		File studentFile = fileChooser.showOpenDialog(primaryStage);

		if (studentFile != null) {
			try (Scanner Fscanner = new Scanner(studentFile)) {

				Fscanner.nextLine();
				while (Fscanner.hasNextLine()) {
					String[] data = Fscanner.nextLine().split(",");
					int STid = Integer.parseInt(data[0]);
					String Name = data[1];
					double tawjweigh = Double.parseDouble(data[2]);
					double PTweight = Double.parseDouble(data[3]);
					String majordata = data[4];

					Student studentl = new Student(STid, Name, tawjweigh, PTweight, majordata);
					MJlist.searchMajor(studentl.getChosenMajor()).AcceptedOrRejected(studentl);
				}
				MJlist.fillTableStudents(tableView);

			} catch (Exception e) {
				alert.setContentText("An error has occurred.");
				alert.showAndWait();
			}
		}

	}

	public void saveStudents(Stage stage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Major Criteria File");
		fileChooser.setInitialFileName("saved students.txt");
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			try (PrintWriter writer = new PrintWriter(file)) {
				writer.println("Student ID,Name,Tawjihi Grade,Placement Test Grade,Chosen Major");
				StudentList<Student> list = MJlist.fillAllStudents();
				SNode<Student> currentS = list.getHead();
				while (currentS.getNext() != null) {
					writer.println(currentS.getData());
					currentS = currentS.getNext();
				}
				System.out.println("student saved to" + file.getAbsolutePath());

			} catch (Exception e) {
				alert.setContentText("An error has occurred.");
				alert.showAndWait();
			}
		}

	}

	public void loadMajors(Stage primaryStage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Major File");
		File majorFile = fileChooser.showOpenDialog(primaryStage);

		if (majorFile != null) {
			try (Scanner Fscanner = new Scanner(majorFile)) {
				Fscanner.nextLine();
				while (Fscanner.hasNextLine()) {
					String[] data = Fscanner.nextLine().split(",");
					String name = data[0];
					double acceptanceGrade = Double.parseDouble(data[1]);
					double tawjihiWeight = Double.parseDouble(data[2]);
					double placementTestWeight = Double.parseDouble(data[3]);

					Major major = new Major(name, acceptanceGrade, tawjihiWeight, placementTestWeight);
					MJlist.insertMajor(major);
				}
				System.out.println(MJlist.getHead().getData().getName());
				System.out.println(MJlist.getHead().toString());
				current = MJlist.getHead();
				MJlist.fillTable(tableM, current.getData().getName());
				mshow.setText(current.getData().getName());

				System.out.println("Majors loaded from " + majorFile.getAbsolutePath());

			} catch (Exception e) {
				alert.setContentText("An error has occurred.");
				alert.showAndWait();
			}
		}
	}

	public void saveMajors(Stage stage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Major Criteria File");
		fileChooser.setInitialFileName("saved_majors.txt");
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {
			try (PrintWriter writer = new PrintWriter(file)) {
				writer.println("Name,Acceptance Grade,Tawjihi Weight,Placement Test Weight");
//					for (Major major : MJlist.toObservableList()) {
//						writer.println(major);
//					}
				System.out.println("Majors saved to " + file.getAbsolutePath());

			} catch (Exception e) {
				alert.setContentText("An error has occurred.");
				alert.showAndWait();
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * 
	 * try { BorderPane root = new BorderPane(); Scene scene = new Scene(root, 400,
	 * 400); scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); } catch
	 * (Exception e) { e.printStackTrace();
	 * 
	 * 
	 */

	/*
	 * 
	 * 
	 * private void saveEmployees() { FileChooser fileChooser = new FileChooser();
	 * fileChooser.setTitle("Save Employee Data");
	 * fileChooser.setInitialFileName("updatedEmployee.txt"); File file =
	 * fileChooser.showSaveDialog(null);
	 * 
	 * if (file != null) { try (PrintWriter writer = new PrintWriter(file)) {
	 * writer.println("ID,Name,Age,Department,Gender,DateOfJoining"); for (Employee
	 * emp : employeeRecords) { writer.println(emp); }
	 * System.out.println("Employees saved to " + file.getAbsolutePath()); } catch
	 * (IOException e) { System.out.println("Error saving employees: " +
	 * e.getMessage()); } } }
	 *
	 */
}
