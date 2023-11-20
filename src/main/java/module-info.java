module com.example {
    requires transitive javafx.controls;
    // requires javafx.fxml;

    // opens cmpt213.asn4.tictactoe.ui to javafx.fxml;

    exports cmpt213.asn4.tictactoe.ui;
    exports ca.cmpt213.asn4.tictactoe.game;

}
