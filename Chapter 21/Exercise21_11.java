package e21_11.exercise2111;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    URL[] rankings = new URL[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];
    String url = "";


    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Exercise21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");

        btFindRanking.setOnAction(e -> {
            try {
                findrankingSite();
            } catch (IOException ex) {
                System.out.println("Website not found.");
            }
        });
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public int findrankingSite() throws IOException {
        int ranking = 0, howManyBoys = 0, howManyGirls = 0;
        String nameForBoy, nameForGirl;
        for(int i = 0; i < rankings.length; i++){
            mapForBoy[i] = new HashMap<String, Integer>();
            mapForGirl[i] = new HashMap<String, Integer>();
            url = "http://liveexample.pearsoncmg.com/data/babynamesranking200"+(i+1)+".txt";
            rankings[i] = new URL(url);
            Scanner input = new Scanner(rankings[i].openStream());
            while(input.hasNext()) {
                ranking = input.nextInt();
                nameForBoy = input.next();
                input.nextInt();
                nameForGirl = input.next();
                input.nextInt();
                mapForBoy[i].put(nameForBoy, ranking);
                mapForGirl[i].put(nameForGirl, ranking);

            }
            System.out.println(mapForBoy[1]);
            System.out.println(mapForGirl[8]);
        }
        return ranking;
    }
}