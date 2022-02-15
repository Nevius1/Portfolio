/*
 * Ian Nevius
 * 04/26/2021
 * Five Guys interactive GUI
 */

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FiveGuysGUI extends Application{
	
	float total = 0;
	
	public static void main(String[] args) {

		launch(args);
		
		
	}

	public void start(Stage primaryStage) throws Exception {
		//Declaring the button size
		int buttonW = 150;
		int buttonH = 150;
		
		//Creating all the objects for the cart section
		ListView<String> cartListView = new ListView();
		Label cartLabel = new Label("Shopping cart");
		String STotal =  String.valueOf(total);
		Label subTotal = new Label(String.format(STotal));
		VBox cart = new VBox(10, cartLabel, cartListView, subTotal);
		
		cartListView.setPrefHeight(1000);
		
		//Making the menu items and putting images on them for burgers
		Image image2 = new Image("ham.png");
		ImageView iv2 = new ImageView(image2);
		iv2.setFitHeight(buttonH);
		iv2.setFitWidth(buttonW);
		
		Image image3 = new Image("cheese.png");
		ImageView iv3 = new ImageView(image3);
		iv3.setFitHeight(buttonH);
		iv3.setFitWidth(buttonW);
		
		Image image4 = new Image("bacon.png");
		ImageView iv4 = new ImageView(image4);
		iv4.setFitHeight(buttonH);
		iv4.setFitWidth(buttonW);
		
		Image image5 = new Image("baconcheese.png");
		ImageView iv5 = new ImageView(image5);
		iv5.setFitHeight(buttonH);
		iv5.setFitWidth(buttonW);
		
		
		//Making the menu items and putting images on them for dogs
		
		Image image6 = new Image("hot_dog_PNG10217.png");
		ImageView iv6 = new ImageView(image6);
		iv6.setFitHeight(buttonH);
		iv6.setFitWidth(buttonW);
		
		Image image7 = new Image("cheesedog.png");
		ImageView iv7 = new ImageView(image7);
		iv7.setFitHeight(buttonH);
		iv7.setFitWidth(buttonW);
		
		Image image8= new Image("bacondog.png");
		ImageView iv8 = new ImageView(image8);
		iv8.setFitHeight(buttonH);
		iv8.setFitWidth(buttonW);
		
		Image image9 = new Image("baconcheesedog.png");
		ImageView iv9 = new ImageView(image9);
		iv9.setFitHeight(buttonH);
		iv9.setFitWidth(buttonW);
		
		//Making the menu items and putting images on them for sandwiches
		
		Image image10 = new Image("sandwich.png");
		ImageView iv10 = new ImageView(image10);
		iv10.setFitHeight(buttonH);
		iv10.setFitWidth(buttonW);
		
		Image image11 = new Image("sandwich_PNG59.png");
		ImageView iv11 = new ImageView(image11);
		iv11.setFitHeight(buttonH);
		iv11.setFitWidth(buttonW);
		
		Image image12= new Image("grilled.png");
		ImageView iv12 = new ImageView(image12);
		iv12.setFitHeight(buttonH);
		iv12.setFitWidth(buttonW);
		
		//Making the menu items and putting images on them for drinks
		
		Image image13 = new Image("cupsR.png");
		ImageView iv13 = new ImageView(image13);
		iv13.setFitHeight(buttonH);
		iv13.setFitWidth(buttonW);
		
		Image image14 = new Image("cupsL.png");
		ImageView iv14 = new ImageView(image14);
		iv14.setFitHeight(buttonH);
		iv14.setFitWidth(buttonW);
		
		Image image15= new Image("water.png");
		ImageView iv15 = new ImageView(image15);
		iv15.setFitHeight(buttonH);
		iv15.setFitWidth(buttonW);
		
		//Making the menu items and putting images on them for frys
		
		Image image16 = new Image("frysR.png");
		ImageView iv16 = new ImageView(image16);
		iv16.setFitHeight(buttonH);
		iv16.setFitWidth(buttonW);
		
		Image image17 = new Image("frysL.png");
		ImageView iv17 = new ImageView(image17);
		iv17.setFitHeight(buttonH);
		iv17.setFitWidth(buttonW);
		
		//Making the menu items and putting images on them for sides
		
		Image image18 = new Image("lettuce.png");
		ImageView iv18 = new ImageView(image18);
		iv18.setFitHeight(buttonH);
		iv18.setFitWidth(buttonW);
		
		Image image19 = new Image("mayo.png");
		ImageView iv19 = new ImageView(image19);
		iv19.setFitHeight(buttonH);
		iv19.setFitWidth(buttonW);
		
		Image image20 = new Image("mustard.png");
		ImageView iv20 = new ImageView(image20);
		iv20.setFitHeight(buttonH);
		iv20.setFitWidth(buttonW);
		
		Image image21 = new Image("pickels.png");
		ImageView iv21 = new ImageView(image21);
		iv21.setFitHeight(buttonH);
		iv21.setFitWidth(buttonW);
		
		Image image22 = new Image("6-tomato-png-image.png");
		ImageView iv22 = new ImageView(image22);
		iv22.setFitHeight(buttonH);
		iv22.setFitWidth(buttonW);
		
		Image image23 = new Image("ketchup.png");
		ImageView iv23 = new ImageView(image23);
		iv23.setFitHeight(buttonH);
		iv23.setFitWidth(buttonW);
		
		//Setting the images on the buttons for burgers
		Button b1 = new Button();
		b1.setGraphic(iv2);
		
		Button b2 = new Button();
		b2.setGraphic(iv3);
		
		Button b3 = new Button();
		b3.setGraphic(iv4);
		
		Button b4 = new Button();
		b4.setGraphic(iv5);
		
		
		//Setting the images to buttons for dogs
		
		Button b5 = new Button();
		b5.setGraphic(iv6);
		
		Button b6 = new Button();
		b6.setGraphic(iv7);
		
		Button b7 = new Button();
		b7.setGraphic(iv8);
		
		Button b8 = new Button();
		b8.setGraphic(iv9);
		
		//Setting the images to buttons for sandwiches
		
		Button b9 = new Button();
		b9.setGraphic(iv10);
		
		Button b10 = new Button();
		b10.setGraphic(iv11);
		
		Button b11 = new Button();
		b11.setGraphic(iv12);
		
		//Setting the images to buttons for drinks
		
		Button b12 = new Button();
		b12.setGraphic(iv13);
		
		Button b13 = new Button();
		b13.setGraphic(iv14);
		
		Button b14 = new Button();
		b14.setGraphic(iv15);
		
		//Setting the images to buttons for drinks
		
		Button b15 = new Button();
		b15.setGraphic(iv16);
		
		Button b16 = new Button();
		b16.setGraphic(iv17);
		
		//Setting the images to buttons for sides
		
		Button b17 = new Button();
		b17.setGraphic(iv18);
		
		Button b18 = new Button();
		b18.setGraphic(iv19);
		
		Button b19 = new Button();
		b19.setGraphic(iv20);
		
		Button b20 = new Button();
		b20.setGraphic(iv21);
		
		Button b21 = new Button();
		b21.setGraphic(iv22);
		
		Button b22 = new Button();
		b22.setGraphic(iv23);
		
		//creating the grid pane to hold the menu items
		GridPane grid = new GridPane();
		
		GridPane dogGrid = new GridPane();
		
		GridPane sGrid = new GridPane();
		
		GridPane drinkGrid = new GridPane();
		
		GridPane fGrid = new GridPane();
		
		GridPane sideGridOne = new GridPane();
		
		GridPane sideGridTwo = new GridPane();
		
		//adding the menu items to the grid pane for burgers
		grid.add(b1,  0, 0);
		grid.add(b2,  1, 0);
		grid.add(b3,  2, 0);
		grid.add(b4,  3, 0);
		
		//adding the menu items to the grid pane for dogs
		dogGrid.add(b5,  0, 0);
		dogGrid.add(b6,  1, 0);
		dogGrid.add(b7,  2, 0);
		dogGrid.add(b8,  3, 0);
		
		//adding the menu items to the grid pane for sandwiches
		sGrid.add(b9,  0, 0);
		sGrid.add(b10,  1, 0);
		sGrid.add(b11,  2, 0);

		//adding the menu items to the grid pane for sandwiches
		drinkGrid.add(b12,  0, 0);
		drinkGrid.add(b13,  1, 0);
		drinkGrid.add(b14,  2, 0);
		
		//adding the menu items to the grid pane for frys
		fGrid.add(b15,  0, 0);
		fGrid.add(b16,  1, 0);
		
		//adding the menu items to the grid pane for side
		sideGridOne.add(b17,  0, 0);
		sideGridOne.add(b18,  1, 0);
		sideGridOne.add(b19,  2, 0);
		sideGridTwo.add(b20,  0, 1);
		sideGridTwo.add(b21,  1, 1);
		sideGridTwo.add(b22,  2, 1);
		
		//styling the grid pane
		
		grid.setAlignment(Pos.TOP_LEFT);
		
		dogGrid.setAlignment(Pos.CENTER_LEFT);
		
		sGrid.setAlignment(Pos.BOTTOM_LEFT);
		
		drinkGrid.setAlignment(Pos.BOTTOM_LEFT);
		
		fGrid.setAlignment(Pos.BOTTOM_LEFT);
		
		sideGridOne.setAlignment(Pos.TOP_RIGHT);
		
		sideGridTwo.setAlignment(Pos.TOP_RIGHT);
		
		grid.setPadding(new Insets(10,475,10,10));
		
		dogGrid.setPadding(new Insets(10));
		
		sGrid.setPadding(new Insets(10));
		
		drinkGrid.setPadding(new Insets(10));
		
		fGrid.setPadding(new Insets(10));
		
		sideGridOne.setPadding(new Insets(10,0,0,0));
		
		
		BorderPane main = new BorderPane();
		
		GridPane mainGrid = new GridPane();
		
		mainGrid.add(grid, 0, 0);
		mainGrid.add(dogGrid, 0, 1);
		mainGrid.add(sGrid, 0, 2);
		mainGrid.add(drinkGrid, 0, 3);
		mainGrid.add(fGrid, 0, 4);
		mainGrid.add(sideGridOne, 1, 0);
		mainGrid.add(sideGridTwo, 1, 1);
		
		mainGrid.getStyleClass().add("grid");
		
		//adding the cart and grid pane to the main stage
		main.setCenter(mainGrid);
		main.setRight(cart);
		
		//creating the main stage
		Scene scene = new Scene(main);
		scene.getStylesheets().add("stylesheet.css");
		
		//creating action events for all the buttons at add items to the cart
		b1.setOnAction(e ->
		{
			cartListView.getItems().add("Hamburger $4.59");
			
			total = (float) (total + 4.59);
			
			subTotal.setText(String.valueOf(total));
			
		});
		
		b2.setOnAction(e1 ->
		{
			
			cartListView.getItems().add("Cheese Burger $5.09");
			
			total = (float) (total + 5.09);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b3.setOnAction(e2 ->
		{
			
			cartListView.getItems().add("Bacon Burger $5.19");
			
			total = (float) (total + 5.19);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b4.setOnAction(e3 ->
		{
			
			cartListView.getItems().add("Bacon Cheese Burger $5.79");
			
			total = (float) (total + 5.79);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b5.setOnAction(e4 ->
		{
			
			cartListView.getItems().add("Kosher Style Dog $2.99");
			
			total = (float) (total + 2.99);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b6.setOnAction(e5 ->
		{
			
			cartListView.getItems().add("Cheese Dog $3.59");
			
			total = (float) (total + 3.59);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b7.setOnAction(e6 ->
		{
			
			cartListView.getItems().add("Bacon Dog $3.59");
			
			total = (float) (total + 3.59);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b8.setOnAction(e7 ->
		{
			
			cartListView.getItems().add("Bacon Chesse Dog $4.09");
			
			total = (float) (total + 4.09);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b9.setOnAction(e8 ->
		{
			
			cartListView.getItems().add("Veggie Sandwich $2.49");
			
			total = (float) (total + 2.49);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b10.setOnAction(e9 ->
		{
			
			cartListView.getItems().add("Cheese Veggie Sandwich $2.49");
			
			total = (float) (total + 2.49);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b11.setOnAction(e10 ->
		{
			
			cartListView.getItems().add("Grilled Cheese Sandwich $2.49");
			
			total = (float) (total + 2.49);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b12.setOnAction(e11 ->
		{
			
			cartListView.getItems().add("Regular Drink $1.79");
			
			total = (float) (total + 2.59);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b13.setOnAction(e12 ->
		{
			
			cartListView.getItems().add("Large Drink $1.99");
			
			total = (float) (total + 4.09);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b14.setOnAction(e13 ->
		{
			
			cartListView.getItems().add("Water $1.99");
			
			total = (float) (total + 1.99);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b15.setOnAction(e14 ->
		{
			
			cartListView.getItems().add("Regular Frys $2.59");
			
			total = (float) (total + 2.59);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b16.setOnAction(e15 ->
		{
			
			cartListView.getItems().add("Large Frys $4.09");
			
			total = (float) (total + 4.09);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b17.setOnAction(e16 ->
		{
			
			cartListView.getItems().add("Lettuce FREE");
			
			total = (float) (total + 0);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b18.setOnAction(e17 ->
		{
			
			cartListView.getItems().add("Mayo FREE");
			
			total = (float) (total + 0);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b19.setOnAction(e18 ->
		{
			
			cartListView.getItems().add("Mustard FREE");
			
			total = (float) (total + 0);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b20.setOnAction(e19 ->
		{
			
			cartListView.getItems().add("Pickles FREE");
			
			total = (float) (total + 0);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b21.setOnAction(e20 ->
		{
			
			cartListView.getItems().add("Tomatoes FREE");
			
			total = (float) (total + 0);
			
			subTotal.setText(String.valueOf(total));
				
		});
		
		b22.setOnAction(e21 ->
		{
			
			cartListView.getItems().add("Katchup FREE");
			
			total = (float) (total + 0);
			
			subTotal.setText(String.valueOf(total));
				
		});
		

		//adding everything to the main stage and some main stage style
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setMaximized(true);
		primaryStage.getIcons().add(new Image("icon.png"));
			
			
		}
		
	}
	

