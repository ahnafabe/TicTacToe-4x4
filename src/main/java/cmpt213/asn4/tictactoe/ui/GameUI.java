/**
 * The GameUI class represents the graphical user interface for the Tic-Tac-Toe game.
 * It includes a 4x4 grid of buttons for player moves and a "New Game" button.
 * The class handles user interactions, updates the game state, and refreshes the UI accordingly.
 *
 * <p>The UI features images for X and O pieces, displayed on buttons in the grid.
 * It provides feedback through pop-up dialogs for victory, draw, and the option to start a new game.
 * Users can make moves by clicking on the buttons in the grid, and the UI reflects the current state
 * of the Tic-Tac-Toe game.</p>
 *
 * <p>The class utilizes JavaFX for building the graphical user interface and interacts with the
 * underlying Tic-Tac-Toe game logic provided by the {@link ca.cmpt213.asn4.tictactoe.game.Game} class.</p>
 *
 * <p>Images for X and O pieces are loaded from files ("x_lebron.png" and "o_lebron.png"), and the UI
 * components are arranged within a {@link javafx.scene.layout.GridPane} for a clean and organized layout.</p>
 *
 * <p>Instances of this class can be integrated into JavaFX applications to provide a visually appealing
 * and interactive Tic-Tac-Toe gaming experience.</p>
 *
 * @author Ahnaf Abeyed
 * @version 1.0
 * @see ca.cmpt213.asn4.tictactoe.game.Game
 * @see javafx.scene.layout.GridPane
 */
package cmpt213.asn4.tictactoe.ui;

import java.util.Optional;

import ca.cmpt213.asn4.tictactoe.game.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameUI {
    private final GridPane gridPane;
    private final Button[][] buttons;
    private final Game game;

    private final Image imageX;
    private final Image imageO;

    private final ImageView imageXview;
    private final ImageView imageOview;

    public GameUI() {
        gridPane = new GridPane();
        buttons = new Button[4][4];
        game = new Game();

        // Insert try-catch block for image loading
        try {
            imageX = new Image(
                    "x_lebron.png");
            imageXview = new ImageView(imageX);
            imageXview.setFitHeight(99);
            imageXview.setFitWidth(99);

            imageO = new Image(
                    "/o_lebron.png");
            imageOview = new ImageView(imageO);
            imageOview.setFitHeight(99);
            imageOview.setFitWidth(99);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading images");
        }

        initializeUI();
    }

    public GridPane createContent() {
        return gridPane;
    }

    private void initializeUI() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Button button = new Button();
                button.setMinSize(100, 100);

                buttons[row][col] = button;

                final int finalRow = row;
                final int finalCol = col;

                // Add event handler for button click
                button.setOnAction(event -> handleButtonClick(finalRow, finalCol));
                gridPane.add(button, col, row);
            }
        }

        Button newGameButton = new Button("New Game");

        newGameButton.setOnAction(event -> startNewGame());

        HBox hBox = new HBox(newGameButton);
        hBox.setAlignment(Pos.CENTER);
        gridPane.add(hBox, 0, 4, 4, 1);
    }

    private void showPopup(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Create New Game button
        ButtonType newGameButtonType = new ButtonType("New Game");
        alert.getButtonTypes().setAll(newGameButtonType);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == newGameButtonType) {
            startNewGame();
        }
    }

    private void handleButtonClick(int row, int col) {
        if (game.makeMove(row, col)) {
            System.out.println("Button Clicked");
            updateUI();
            if (game.isGameWon()) {
                showPopup("Victory", "Game Over, Player: " + game.getPlayerAt(row, col) + " won!");

            } else if (game.isGameDraw()) {
                showPopup("Draw", "Draw! Feel free to start a new game.");

            }
        }
    }

    private void startNewGame() {
        game.reset();
        updateUI();
        System.out.println("New game started");
    }

    private void updateUI() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int player = game.getPlayerAt(row, col);

                ImageView gamePiece = null;
                if (player == 1) {
                    gamePiece = new ImageView(imageX);
                } else if (player == 2) {
                    gamePiece = new ImageView(imageO);
                }

                if (gamePiece != null) {
                    gamePiece.setFitHeight(buttons[row][col].getHeight());
                    gamePiece.setFitWidth(buttons[row][col].getWidth());
                }

                buttons[row][col].setGraphic(gamePiece);
            }
        }
    }

}
