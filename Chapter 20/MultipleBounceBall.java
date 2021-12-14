import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.*;

/**
 * <h1>MultipleBounceBall</h1>
 *
 * <p>This class will create a primary stage to be shown and populate it with all of the other panes
 * by calling upon the other methods to fill/create those panes.</p>
 *
 * <p>Created: 12/14/21</p>
 *
 * @author Unknown
 */
public class MultipleBounceBall extends Application {

    ArrayList<Ball> balls = new ArrayList<>();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);

        // Add or remove a ball
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * <h1>MultipleBallPane</h1>
     *
     * <p>This class will create the ballPanes and fill them with the balls according to the
     * amount of times the plus or minus buttons are pressed. It will get rid of the
     * largest ball every time the minus button is pressed.</p>
     *
     * <p>Created 12/14/21</p>
     *
     * @author Unknown, Rhett Boatright
     */
    private class MultipleBallPane extends Pane {
        private Timeline animation;

        /**
         * This method will create the timeline for the animation and will play the animation automatically.
         */
        public MultipleBallPane() {
            // Create an animation for moving the ball
            animation = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play(); // Start animation
        }

        /**
         * This method will create a random integer between 2 and 20 for the radius of the balls.
         * @return (rand.nextInt; this will return the random integer to the caller)
         */
        public int randomRadius(){
            Random rand = new Random();
            int maxRand = 20;
            int minRand = 2;
            return rand.nextInt(maxRand - minRand);
        }

        /**
         * This method will add a random sized ball into the animation with a random color.
         */
        public void add() {
            Color color = new Color(Math.random(),
                    Math.random(), Math.random(), 0.5);
            int amountOfBalls = balls.size();
            for(int i = amountOfBalls; i <= amountOfBalls; i++){
                //Create a new ball with a random radius between 2 and 20
                Ball forBall = new Ball(30,30,randomRadius(),color);
                balls.add(i,forBall);//Add the ball to the ArrayList
                getChildren().add(balls.get(i));//Add the ball to the pane
            }
        }

        /**
         * This method will subtract the largest ball from the animation and the ArrayList.
         */
        public void subtract() {
            if (getChildren().size() > 0) {
                //Create variable and for loop to find the largest ball
                Ball r1 = (Ball)(getChildren().get(0));
                for(Node node: getChildren()){
                    if(((Ball)node).getRadius() > r1.getRadius())
                        r1 = (Ball) node;
                }
                getChildren().remove(r1); //Remove the largest ball from the pane
                balls.remove(r1); //Remove the largest ball from the ArrayList
            }
        }


        public void play() {
            animation.play();
        }


        public void pause() {
            animation.pause();
        }

        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.1);
        }

        public void decreaseSpeed() {
            animation.setRate(
                    animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        }

        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }

        /**
         * This method will move the balls so that it looks like it is bouncing off of the pane.
         */
        protected void moveBall() {
            for (Node node: this.getChildren()) {
                Ball ball = (Ball)node;
                // Check boundaries
                if (ball.getCenterX() < ball.getRadius() ||
                        ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1; // Change ball move direction
                }
                if (ball.getCenterY() < ball.getRadius() ||
                        ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1; // Change ball move direction
                }

                // Adjust ball position
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
        }
    }

    /**
     * <h1>Ball</h1>
     *
     * <p>This is the constructor for the Ball object. It is extending circle, and so retains
     * the attributes of a circle.</p>
     *
     * <p>Created: 12/14/21</p>
     *
     * @author Unknown
     */
    class Ball extends Circle {
        private double dx = 1, dy = 1;

        Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            setFill(color); // Set ball color
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
