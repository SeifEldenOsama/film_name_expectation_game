package FilmGame;

import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayFrame extends Application{

	private Group Root;
	private Scene S1;
	private ImageView Image,coinsImage,VictoryImage,coinsRewardImage,hintImage;
	private Rectangle R1;
	private Label levelInfo,HeroInfo,coins_value,film_hero_label,film_name_enter,RewardValue,allname;
	private Rectangle Container2,letters_container;
	private filmdata filmInfo;
	private Button Back,Submit,Collect,Next,hint;
	private static boolean IsClicked=false;
	private Scale scale;
	private TextField NameFields[];
	private int width=80,old_value,new_value;
	private ArrayList<Integer> true_values=new ArrayList<>();
	private ArrayList<Integer> hinted=new ArrayList<>();
	private String film_name;
	private char film_name_array[];
	private Timeline timeline1;
	private boolean IsDone=false;
	@Override
	public void start(Stage stage) throws Exception {
		Root=MainFrame.GetRoot();
		Root.getChildren().clear();
		S1=MainFrame.GetScene();
		stage.setTitle("PLAY");
		stage.setScene(S1);
		
		Image = new ImageView(new Image("file:////C://seif//cartoon1.jpg"));
		
		scale=new Scale(1.01,1.01);
		
		 Back=new Button("<- GO BACK");
	        Back.setPrefSize(200,50);
	        Back.setStyle("-fx-font-size: 22px;-fx-font-weight: bold;-fx-background-color: BURLYWOOD;-fx-background-radius: 10px");
	        Back.setTextFill(Color.DARKRED);
	        VBox.setMargin(Back, new Insets(0, 0, 0, 0));
	        Back.addEventFilter((MouseEvent.MOUSE_ENTERED), (MouseEvent E)->{
	        	MainFrame.GetScene().setCursor(Cursor.HAND);
	        	Back.getTransforms().add(scale);
	        	try {
	        		MusicAndSound.enter("C:\\seif\\enter.wav");
				} catch (LineUnavailableException e) {				
					e.printStackTrace();
				}
	        });
	        Back.addEventFilter((MouseEvent.MOUSE_EXITED), (MouseEvent E)->{
	        	MainFrame.GetScene().setCursor(Cursor.DEFAULT);
	        	Back.getTransforms().remove(scale);
	        });
	        Back.setOnAction((ActionEvent)->{
	        	IsClicked=true;
	        	Root.getChildren().clear();
	        	try {
					new MainFrame().start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        	if(!MusicAndSound.GetClip().isActive())
	        	{
	        		MainFrame.getButton().setGraphic(MainFrame.getImage());
	        	}
	        	try {
					MusicAndSound.click("C://seif//M23.wav");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
	        });        
		
		
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
		
		R1=new Rectangle(470,150,600,75);
		R1.setStroke(Color.BROWN);
		R1.setFill(Color.DARKGOLDENROD);
		R1.setArcHeight(80);
		R1.setArcWidth(80);
		R1.setStrokeWidth(6);
		
				
		filmInfo=ManageDataBase.getfilmAndhero(ManageDataBase.getLevel());
		
		film_hero_label=new Label(filmInfo.getHero());
		film_hero_label.setLayoutX(490);
		film_hero_label.setLayoutY(155);
		film_hero_label.setStyle("-fx-font-size: 40px;-fx-font-weight: bold;");
		
		levelInfo=new Label("LEVEL "+String.valueOf(ManageDataBase.getLevel()));
		levelInfo.setLayoutX(680);
		levelInfo.setLayoutY(5);
		levelInfo.setStyle("-fx-font-size: 50px;-fx-font-weight: bold;-fx-text-fill: orange");
		
		HeroInfo=new Label("HERO REAL NAME");
		HeroInfo.setLayoutX(490);
		HeroInfo.setLayoutY(110);
		HeroInfo.setStyle("-fx-font-size: 30px;-fx-font-weight: bold;-fx-text-fill: brown");
		
		
		
		
		letters_container=new Rectangle(10,470,1520,100);
		letters_container.setStroke(Color.DARKORANGE);
		letters_container.setFill(Color.TRANSPARENT);
		letters_container.setStrokeWidth(7);
		letters_container.setArcHeight(80);
		letters_container.setArcWidth(80);
		
		
		film_name_enter=new Label("ENTER FILM NAME");
		film_name_enter.setLayoutX(630);
		film_name_enter.setLayoutY(415);
		film_name_enter.setStyle("-fx-font-size: 30px;-fx-font-weight: bold;-fx-text-fill: darkorange");
	
		
		 VictoryImage=new ImageView(new Image("file:////C://seif//Victory.png"));
		 VictoryImage.setLayoutX(400);
		 VictoryImage.setLayoutY(75);
		 
		 Collect=new Button("COLLECT");
		 Collect.setLayoutX(660);
		 Collect.setLayoutY(540);
		 Collect.setPrefSize(200, 50);
		 Collect.setStyle("-fx-font-size: 25px;-fx-font-weight: bold;-fx-background-color: PINK");
		 Collect.addEventFilter((MouseEvent.MOUSE_ENTERED), (MouseEvent E1)->{
	        	MainFrame.GetScene().setCursor(Cursor.HAND);
	        	Collect.getTransforms().add(scale);
	        	try {
	        		MusicAndSound.enter("C:\\seif\\enter.wav");
				} catch (LineUnavailableException e) {				
					e.printStackTrace();
				}
	        });
		 Collect.addEventFilter((MouseEvent.MOUSE_EXITED), (MouseEvent E1)->{
	        	MainFrame.GetScene().setCursor(Cursor.DEFAULT);
	        	Collect.getTransforms().remove(scale);
	        });
		 Collect.setOnAction((ActionEvent E2)->{
		    	try {
					MusicAndSound.collect("C://seif//collect.wav");
	        		MusicAndSound.click("C://seif//M23.wav");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			 Root.getChildren().removeAll(Submit,Collect,VictoryImage,coinsRewardImage,RewardValue,allname);		 
			 if(IsDone) {
				 Root.getChildren().add(Next);	
			     this.setCounter1(coins_value);
			 }
		 });
		
		 coinsRewardImage=new ImageView(new Image("file:////C://seif//coins.png"));
		 coinsRewardImage.setLayoutX(660);
		 coinsRewardImage.setLayoutY(450);
		 
		 RewardValue=new Label("+ 10");
		 RewardValue.setLayoutX(735);
		 RewardValue.setLayoutY(460);
		 RewardValue.setStyle("-fx-font-size: 35px; -fx-font-weight: bold;-fx-text-fill: PINK");
		
		
		 allname=new Label();
		 allname.setLayoutX(650);
		 allname.setLayoutY(370);
		 allname.setStyle("-fx-font-size: 35px; -fx-font-weight: bold;-fx-text-fill: PINK");
		
		
		Submit=new Button("SUBMIT");
	    Submit.setLayoutX(660);
	    Submit.setLayoutY(650);
	    Submit.setPrefSize(200, 40);
		Submit.setStyle("-fx-background-radius: 20px;-fx-font-size: 20px;-fx-font-weight: bold;-fx-background-color: DARKGREEN;-fx-text-fill: darkorange");
		Submit.addEventFilter((MouseEvent.MOUSE_ENTERED), (MouseEvent E)->{
        	MainFrame.GetScene().setCursor(Cursor.HAND);
        	Submit.getTransforms().add(scale);
        	try {
        		MusicAndSound.enter("C:\\seif\\enter.wav");
			} catch (LineUnavailableException e) {				
				e.printStackTrace();
			}
        });
		Submit.addEventFilter((MouseEvent.MOUSE_EXITED), (MouseEvent E)->{
        	MainFrame.GetScene().setCursor(Cursor.DEFAULT);
        	Submit.getTransforms().remove(scale);
        });
		
		Submit.setOnAction((ActionEvent E)->{			
	    	try {
        		MusicAndSound.click("C://seif//M23.wav");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
	    	for(int i=0;i<NameFields.length;i++)
	    	{
	    		
	    		if(NameFields[i].getText().trim().equalsIgnoreCase(String.valueOf(film_name_array[i]))&&!true_values.contains(i))
	    		{
	    			true_values.add(i);
	    			NameFields[i].setBackground(Background.fill(Color.GREEN));
	    			NameFields[i].setEditable(false);
	    			if(!hinted.isEmpty()&&hinted.get(hinted.size()-1).equals(i))
	    			    hint.setDisable(false);
	    			try {
						MusicAndSound.goobjob("C://seif//goodjob.wav");
					} catch (LineUnavailableException e) {
						e.printStackTrace();
					}
	    		}
	    		
	    	 if(true_values.size()==film_name.length())
	    	 {
	    		 Submit.setDisable(true);
	    		 try {
					MusicAndSound.victory("C://seif//victory.wav");
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}	    		 
	    		 allname.setText(film_name);	 
	    		 if(ManageDataBase.IsSolved(ManageDataBase.getLevel())) {
	    			 RewardValue.setText("+ 0");
	    			 ManageDataBase.UpdateLevelTo(LevelsFrame.getCurrentLevel());
	    		 }
	    		 else {
	        		 ManageDataBase.AddCoins();
	    			 ManageDataBase.setSolved(ManageDataBase.getLevel());
	        		 ManageDataBase.UpdateLevel();
	    			 IsDone=true;
	    		 }
	    		 Root.getChildren().addAll(VictoryImage,Collect,coinsRewardImage,RewardValue,allname);
	    		 this.setTransitionImage(VictoryImage);
	    		 this.setTransitionButton(Collect);
	    		 this.setTransitionImage(coinsRewardImage);
	    		 this.setTransitionLabel(RewardValue);
	    		 this.setTransitionLabel(allname);
	    	 }
	    	 
	    	}
	    		    	
	    });;
		
		
		Next=new Button("NEXT LEVEL -->");
		Next.setLayoutX(660);
		Next.setLayoutY(650);
		Next.setPrefSize(200, 40);
		Next.setStyle("-fx-background-radius: 20px;-fx-font-size: 20px;-fx-font-weight: bold;-fx-background-color: DARKGREEN;-fx-text-fill: darkorange");
		Next.addEventFilter((MouseEvent.MOUSE_ENTERED), (MouseEvent E)->{
        	MainFrame.GetScene().setCursor(Cursor.HAND);
        	Next.getTransforms().add(scale);
        	try {
        		MusicAndSound.enter("C:\\seif\\enter.wav");
			} catch (LineUnavailableException e) {				
				e.printStackTrace();
			}
        });
		Next.addEventFilter((MouseEvent.MOUSE_EXITED), (MouseEvent E)->{
        	MainFrame.GetScene().setCursor(Cursor.DEFAULT);
        	Next.getTransforms().remove(scale);
        });
	    Next.setOnAction((ActionEvent)->{
	    	this.setTransitionRoot(Root);
	    	try {
        		MusicAndSound.click("C://seif//M23.wav");
        		MusicAndSound.next("C://seif//next.wav");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
	    	try {
				new PlayFrame().start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    });
	    
	    hintImage=new ImageView(new Image("file:////C://seif//hint.png"));
	    
	    hint=new Button("HINT -10");
	    hint.setLayoutX(1200);
	    hint.setLayoutY(390);
	    hint.setPrefSize(200, 20);
	    hint.setStyle("-fx-font-size: 25px;-fx-font-weight: bold;-fx-background-color: orange;-fx-text-fill: darkgreen;-fx-background-radius: 25px");
	    hint.setGraphic(hintImage);
	    hint.setContentDisplay(ContentDisplay.RIGHT);
	    
	    hint.addEventFilter((MouseEvent.MOUSE_ENTERED), (MouseEvent E)->{
        	MainFrame.GetScene().setCursor(Cursor.HAND);
        	hint.getTransforms().add(scale);
        	try {
        		MusicAndSound.enter("C:\\seif\\enter.wav");
			} catch (LineUnavailableException e) {				
				e.printStackTrace();
			}
        });
	    hint.addEventFilter((MouseEvent.MOUSE_EXITED), (MouseEvent E)->{
        	MainFrame.GetScene().setCursor(Cursor.DEFAULT);
        	hint.getTransforms().remove(scale);
        });
	    
	    hint.setOnAction((ActionEvent)->{	
	    	Submit.requestFocus();
	    	if(Integer.valueOf(coins_value.getText())>=10&&true_values.size()!=film_name.length())
	    	{
	        ManageDataBase.RemoveCoins();		
	    	ArrayList <Integer> film_list=new ArrayList<>();
	    	for(int i=0;i<film_name.length();i++)
	    	{
	    		film_list.add(i);
	    	}	    		    	
	    	ArrayList <Integer> difference =new ArrayList<>(film_list);
	    	difference.removeAll(true_values);
	    	Random random=new Random();
	    	int RandomIndex=random.nextInt(difference.size());
	    	int Index=difference.get(RandomIndex);
	    	hinted.add(Index);
	    	NameFields[Index].setPromptText(String.valueOf(film_name_array[Index]));
	    	NameFields[Index].setBackground(Background.fill(Color.DARKCYAN));
	    	hint.setDisable(true);
	    	try {
        		MusicAndSound.click("C://seif//hint.wav");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
	    		this.setCounter2(coins_value);
	    	}
	    });
		
	    Root.getChildren().addAll(Image,R1,Back,levelInfo,HeroInfo,Container2,letters_container,film_name_enter,coinsImage,coins_value,film_hero_label,Submit,hint);	    
		this.makegame();
	    stage.show();
	}
	
	public static boolean IsClicked()
    {
    	return IsClicked;
    }
	
	public void makegame()
	{
		
		film_name=filmInfo.getName();
		film_name_array=film_name.toCharArray();
		
		NameFields=new TextField[film_name.length()];	
	    for(int i=0;i<NameFields.length;i++)
		{
			NameFields[i]=new TextField();
			NameFields[i].setLayoutX(width);
			NameFields[i].setLayoutY(500);
			NameFields[i].setPrefSize(50, 30);
			NameFields[i].setAlignment(Pos.CENTER);
			NameFields[i].setFont(new Font("bold",20));
			Root.getChildren().add(NameFields[i]);
			width+=70;
		}	    	    	    
	}
	public void setCounter1(Label l)
	{
		old_value=Integer.valueOf(l.getText());
		new_value=old_value+10;
		int [] counter= {old_value};
		timeline1 = new Timeline(
                new KeyFrame(Duration.seconds(0.05), e -> {
                	 if (counter[0] < new_value) {
                         counter[0]++;
                         l.setText(String.valueOf(counter[0]));
                     } else {
                         timeline1.stop();
                     }
                })
        );
		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.play();
	}
	public void setCounter2(Label l)
	{
		old_value=Integer.valueOf(l.getText());
		new_value=old_value-10;
		int [] counter= {old_value};
		timeline1 = new Timeline(
                new KeyFrame(Duration.seconds(0.05), e -> {
                	 if (counter[0] > new_value) {
                         counter[0]--;
                         l.setText(String.valueOf(counter[0]));
                     } else {
                         timeline1.stop();
                     }
                })
        );
		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.play();
	}
	
	public void setTransitionImage(ImageView Image)
	{
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), Image);
        scaleTransition.setFromX(0); 
        scaleTransition.setFromY(0); 
        scaleTransition.setToX(1); 
        scaleTransition.setToY(1); 
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
        scaleTransition.play();
	}
	public void setTransitionButton(Button button)
	{
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), button);
        scaleTransition.setFromX(0); 
        scaleTransition.setFromY(0); 
        scaleTransition.setToX(1); 
        scaleTransition.setToY(1); 
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
        scaleTransition.play();
	}
	
	public void setTransitionLabel(Label label)
	{
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), label);
        scaleTransition.setFromX(0); 
        scaleTransition.setFromY(0); 
        scaleTransition.setToX(1); 
        scaleTransition.setToY(1); 
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
        scaleTransition.play();
	}
	
	public void setTransitionRoot(Group Root)
	{
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2.5), Root);
        fadeTransition.setFromValue(0); 
        fadeTransition.setToValue(1); 
        fadeTransition.setInterpolator(Interpolator.EASE_BOTH);
        fadeTransition.play();
    }
	
}


