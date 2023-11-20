
/**
 * The TicTac class serves as the entry point for the Tic-Tac-Toe application.
 * It extends the JavaFX {@link javafx.application.Application} class to launch the application.
 *
 * <p>The main method {@link #main(String[])} is the starting point of the application, calling
 * the {@link #start(Stage)} method to initialize the graphical user interface.</p>
 *
 * <p>The {@link #start(Stage)} method creates an instance of the {@link GameUI} class,
 * representing the graphical interface for the Tic-Tac-Toe game. It sets up a JavaFX {@link Scene}
 * with the created UI content and displays it on the primary stage with a specified title.</p>
 *
 * <p>This class enables the execution of the Tic-Tac-Toe game through a simple JavaFX application,
 * providing a window with a 4x4 grid for user interactions and gameplay.</p>
 *
 * @author Ahnaf Abeyed
 * @version 1.0
 * @see GameUI
 * @see javafx.application.Application
 * @see javafx.scene.Scene
 * @see javafx.stage.Stage
 */

package cmpt213.asn4.tictactoe.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTac extends Application {
    /**
     * The main method to launch the Tic-Tac-Toe application.
     * 
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method initializes the primary stage, creates the {@link GameUI}
     * instance,
     * and sets up the JavaFX scene for the Tic-Tac-Toe game.
     * 
     * @param primaryStage The primary stage for the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        GameUI GameUI = new GameUI();
        Scene scene = new Scene(GameUI.createContent());
        primaryStage.setTitle("4x4 Lebron James Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
