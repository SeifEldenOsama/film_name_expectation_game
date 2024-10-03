package FilmGame;

import javax.sound.sampled.LineUnavailableException;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainFrame extends Application{

	private static Group Root;
	private static Scene S1;
	private Screen screen=Screen.getPrimary();
    private Rectangle2D bounds=screen.getBounds();
	private double width=bounds.getWidth(),height=bounds.getHeight();
	private ImageView MainImage,Banner,PlayImage,LevelsImage,thinkImage,MusicOn,coinsImage;
	private static ImageView MusicOff;
	private Button Play,Levels;
	private static Button Music;
	private Scale scale;
	private Rectangle Container,Container2;
	private boolean IsOn=true;
	private Label coins_value;
	@Override
	public void start(Stage stage) throws Exception {
		Root=new Group();
		S1=new Scene(Root,width,height-50);
		stage.setScene(S1);
		stage.setTitle("FILM GAME");
		
		
		
		MainImage=new ImageView(new Image("file:////C:\\seif\\cartoon1.jpg"));
		if(!LevelsFrame.IsClicked()&&!PlayFrame.IsClicked())
		    MusicAndSound.playMusic("C:\\seif\\videoplayback.wav");
		
		scale=new Scale(1.01,1.01);
		
		PlayImage=new ImageView(new Image("file:////C:\\\\seif\\\\Play.png"));
		
		Banner=new ImageView(new Image("file:////C:\\\\seif\\\\Banner.png"));
		Banner.setLayoutX(520);
		Banner.setLayoutY(120);
		
		
		thinkImage=new ImageView(new Image("file:////C:\\\\seif\\\\think.png"));
		thinkImage.setLayoutX(840);
		thinkImage.setLayoutY(135);
		this.Animation2(thinkImage);
		
		
		
		Container2=new Rectangle(1200,10,300,100);
		Container2.setFill(Color.TRANSPARENT);
		Container2.setStroke(Color.BROWN);
		Container2.setStrokeWidth(10);
		Container2.setArcHeight(60);
		Container2.setArcWidth(60);
		
		coinsImage=new ImageView(new Image("file:////C://seif//coins.png"));
		coinsImage.setLayoutX(1250);
		coinsImage.setLayoutY(30);
		
		
		coins_value=new Label(String.valueOf(ManageDataBase.getCoins()));
		coins_value.setLayoutX(1350);
		coins_value.setLayoutY(35);
		coins_value.setStyle("-fx-font-size: 40px;-fx-font-weight: bold;-fx-text-fill: brown");
		
		
		Container=new Rectangle(310,410,900,270);
		Container.setFill(Color.TRANSPARENT);
		Container.setStroke(Color.DARKCYAN);
		Container.setStrokeWidth(10);
		Container.setArcHeight(60);
		Container.setArcWidth(60);
		
		Play=new Button("PLAY");
		Play.setLayoutX(400);
		Play.setLayoutY(420);
		Play.setStyle("-fx-background-radius:40px;-fx-font-size:40px;-fx-background-color: DARKGREEN;-fx-font-weight: bold");
		Play.setTextFill(Color.DARKGOLDENROD);
		Play.setPrefSize(300, 250);
		Play.setGraphic(PlayImage);
		Play.setContentDisplay(ContentDisplay.TOP);
		Play.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);	
		    Play.getTransforms().add(scale);
		    Play.setStyle("-fx-background-radius:40px;-fx-font-size:40px;-fx-background-color: GREEN;-fx-font-weight: bold");
		    try {
		    	MusicAndSound.enter("C:\\seif\\enter.wav");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		});
		Play.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);		
			Play.getTransforms().remove(scale);
			Play.setStyle("-fx-background-radius:40px;-fx-font-size:40px;-fx-background-color: DARKGREEN;-fx-font-weight: bold");
		});
	    
		Play.setOnAction((ActionEvent E)->{
			try {
				MusicAndSound.click("C://seif//M23.wav");
				new PlayFrame().start(stage);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}			
			
		});
		
		
		LevelsImage=new ImageView(new Image("file:////C:\\\\seif\\\\levels1.png"));
	    
		Levels=new Button("LEVELS");
		Levels.setLayoutX(800);
		Levels.setLayoutY(420);
		Levels.setStyle("-fx-background-radius:40px;-fx-font-size:40px;-fx-background-color: DARKORANGE;-fx-font-weight: bold");
		Levels.setTextFill(Color.DARKGREEN);
		Levels.setPrefSize(300, 250);
		Levels.setGraphic(LevelsImage);
		Levels.setContentDisplay(ContentDisplay.TOP);
		Levels.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);	
			Levels.getTransforms().add(scale);
			Levels.setStyle("-fx-background-radius:40px;-fx-font-size:40px;-fx-background-color: ORANGE;-fx-font-weight: bold");
			 try {
				 MusicAndSound.enter("C:\\seif\\enter.wav");
				} catch (LineUnavailableException e) {					
					e.printStackTrace();
				}
		});
		Levels.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);		
			Levels.getTransforms().remove(scale);
			Levels.setStyle("-fx-background-radius:40px;-fx-font-size:40px;-fx-background-color: DARKORANGE;-fx-font-weight: bold");
		});
		
		Levels.setOnAction((ActionEvent)->{
			try {
				MusicAndSound.click("C://seif//M23.wav");
				new LevelsFrame().start(stage);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}			
		});
		
		Text text = new Text("FILM NAME");
        text.setFill(Color.DARKCYAN);
        text.setStyle("-fx-font-size: 45px;");
        text.setLayoutX(570);
        text.setLayoutY(190);
        
        
        
        MusicOn=new ImageView(new Image("file:////C:\\\\seif\\\\MusicOn.png"));
        MusicOff=new ImageView(new Image("file:////C:\\\\seif\\\\MusicOff.png"));
        
        Music=new Button();
        Music.setLayoutX(665);
        Music.setLayoutY(270);
        Music.setPrefSize(150, 80);
        Music.setStyle("-fx-background-color: cyan;-fx-border-color: darkcyan;-fx-border-width: 7px");
        Music.setGraphic(MusicOn);
        Music.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
        	S1.setCursor(Cursor.HAND);
        	Music.getTransforms().add(scale);
        	 try {
        		 MusicAndSound.enter("C:\\seif\\enter.wav");
				} catch (LineUnavailableException e) {					
					e.printStackTrace();
				}
        });
        Music.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
        	S1.setCursor(Cursor.DEFAULT);       	
        	Music.getTransforms().remove(scale);
        	
        });
        
        Music.setOnAction((ActionEvent E)->{
        	try {
        		MusicAndSound.click("C://seif//M23.wav");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
        	if(IsOn)
        	{
        		IsOn=false;
        		Music.setGraphic(MusicOff);
        		MusicAndSound.GetClip().stop();
        	}
        	else
        	{
        		IsOn=true;
        		Music.setGraphic(MusicOn);
        		MusicAndSound.GetClip().start();
        	}
        });
        
		
		Root.getChildren().addAll(MainImage,Banner,thinkImage,Container2,coins_value,coinsImage,Container,Play,Levels,text,Music);
		stage.show();
	}
	
	
	
	public void Animation2(ImageView image)
	{
		    DropShadow dropShadow = new DropShadow();
	        dropShadow.setColor(Color.RED);
	        dropShadow.setRadius(10);
	        dropShadow.setOffsetX(0);
	        dropShadow.setOffsetY(0);
	        image.setEffect(dropShadow);
	        ScaleTransition scaleTransition = new ScaleTransition(javafx.util.Duration.millis(700), image);
	        scaleTransition.setFromX(1.0);
	        scaleTransition.setToX(1.1);
	        scaleTransition.setFromY(1.0);
	        scaleTransition.setToY(1.1);
	        scaleTransition.setCycleCount(Animation.INDEFINITE);
	        scaleTransition.setAutoReverse(true);
	        scaleTransition.play();
	}
	
	public static Group GetRoot()
	{
		return Root;
	}
	
    public static Scene GetScene()
    {
    	return S1;
    }
    
    public static ImageView getImage()
    {
    	return MusicOff;
    }
    public static Button getButton()
    {
    	return Music;
    }

}
