package FilmGame;


import javax.sound.sampled.LineUnavailableException;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class LevelsFrame extends Application {

    private Screen screen = Screen.getPrimary();
    private Rectangle2D bounds = screen.getBounds();
    private double width = bounds.getWidth(), height = bounds.getHeight();
    private Group Root;
    private ImageView Image;
    private Button Levels[] = new Button[50];
    private GridPane Group1;
    private Scene S1;
    private Button Back;
    private Scale scale;
    private static boolean IsClicked=false;
    private static int chosed_level,current_level;
    private StackPane stackPane;
    private VBox vBox;
    @Override
    public void start(Stage stage) throws Exception {
        Root = MainFrame.GetRoot();
        Root.getChildren().clear();
        stage.setTitle("LEVELS");

        Image = new ImageView(new Image("file:////C://seif//levelsimage.jpg"));

        scale=new Scale(1.01,1.01);
        
        Text label = new Text("CHOOSE A LEVEL");
        label.setStyle("-fx-font-size: 50px; -fx-text-fill: red;-fx-font-weight: bold");
        VBox.setMargin(label, new Insets(0, 4, 0, 540));       
        this.Animation(label);
        
        
        Back=new Button("<- GO BACK");
        Back.setPrefSize(200,100);
        Back.setStyle("-fx-font-size: 22px;-fx-font-weight: bold;-fx-background-color: BURLYWOOD;-fx-background-radius: 10px");
        Back.setTextFill(Color.DARKRED);
        VBox.setMargin(Back, new Insets(0, 0, 0, 0));
        Back.addEventFilter((MouseEvent.MOUSE_ENTERED), (MouseEvent E)->{
        	S1.setCursor(Cursor.HAND);
        	Back.getTransforms().add(scale);
        	try {
        		MusicAndSound.enter("C:\\seif\\enter.wav");
			} catch (LineUnavailableException e) {				
				e.printStackTrace();
			}
        });
        Back.addEventFilter((MouseEvent.MOUSE_EXITED), (MouseEvent E)->{
        	S1.setCursor(Cursor.DEFAULT);
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

        Group1 = new GridPane();
        Group1.getChildren().add(Image);
        Group1.setVgap(7);
        Group1.setHgap(7);

        for (int i = 0; i < 50; i++) {
        	final int current=i;
            Levels[i] = new Button("Level " + (i + 1));
            Levels[i].setPrefSize(600, 60);
            Levels[i].setStyle("-fx-font-size:30px; -fx-font-weight: bold;-fx-background-radius: 20px;");
            Group1.add(Levels[i], i % 4, i / 4);
            Levels[current].addEventHandler((MouseEvent.MOUSE_ENTERED), (MouseEvent E)->{
            	try {
            		MusicAndSound.enter("C:\\seif\\enter.wav");
    			} catch (LineUnavailableException e) {				
    				e.printStackTrace();
    			}
            	Levels[current].getTransforms().add(scale);
            	S1.setCursor(Cursor.HAND);
            });
            Levels[current].addEventHandler((MouseEvent.MOUSE_EXITED), (MouseEvent E)->{           	
            	Levels[current].getTransforms().remove(scale);
            	S1.setCursor(Cursor.DEFAULT);
            });
            Levels[current].setOnAction((ActionEvent E)->{
            	try {
    				MusicAndSound.click("C://seif//M23.wav");
    			} catch (LineUnavailableException e) {
    				e.printStackTrace();
    			}  
            	
            	String level=Levels[current].getText();
            	char level_string[]=level.toCharArray();
            	chosed_level=Integer.valueOf(String.valueOf(level_string[level_string.length-1]));
            	current_level=ManageDataBase.getLevel();
            	if(chosed_level<=current_level)
            	{
            	ManageDataBase.UpdateLevelTo(chosed_level);            	
            	try {
            		stackPane.getChildren().clear();
					new PlayFrame().start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
            });            
        }
        
        for(int j=0;j<=ManageDataBase.getsolvedlevels();j++)
        {
        	Levels[j].setStyle("-fx-font-size:30px; -fx-font-weight: bold;-fx-background-radius: 20px;-fx-background-color: GREEN");
        }

        ScrollPane scrollPane = new ScrollPane(Group1);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        

        vBox = new VBox();
        vBox.getChildren().addAll(Back,label, scrollPane);

        stackPane = new StackPane();
        stackPane.getChildren().addAll(Image, vBox);

        S1 = new Scene(stackPane, width, height - 50);
        stage.setScene(S1);
        stage.show();
    }
    public void Animation(Text text)
	{
		    DropShadow dropShadow = new DropShadow();
	        dropShadow.setColor(Color.RED);
	        dropShadow.setRadius(10);
	        dropShadow.setOffsetX(0);
	        dropShadow.setOffsetY(0);
	        text.setEffect(dropShadow);
	        ScaleTransition scaleTransition = new ScaleTransition(javafx.util.Duration.millis(2000), text);
	        scaleTransition.setFromX(1.0);
	        scaleTransition.setToX(1.1);
	        scaleTransition.setFromY(1.0);
	        scaleTransition.setToY(1.1);
	        scaleTransition.setCycleCount(Animation.INDEFINITE);
	        scaleTransition.setAutoReverse(true);
	        scaleTransition.play();
	}
    public static boolean IsClicked()
    {
    	return IsClicked;
    }
    public static int getChosedLevel()
    {
    	return chosed_level;
    }
    public static int getCurrentLevel()
    {
    	return current_level;
    }
    
}