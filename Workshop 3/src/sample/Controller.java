package sample;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class Controller {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> lvTable;

    @FXML
    private ComboBox<String> cmbTable;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnNew;

    @FXML
    void editClicked(MouseEvent event) {

    }

    @FXML
    void exitClicked(MouseEvent event) {

    }

    @FXML
    void newClicked(ActionEvent event) {

    }

    @FXML
    void rowSelected(MouseEvent event) {

    }

    @FXML
    void tableSelected(MouseEvent event) {

    }





    private void connectDB() {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "Sander", "P@ssw0rd");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Vector getAgentIDs() {
        // TODO Auto-generated method stub
        Vector<String> agents = new Vector<String>();
        try {
            rs = stmt.executeQuery("select agentid from agents");
            while (rs.next())
            {
                agents.add(rs.getString("agentid"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return agents;
    }
    @FXML
    void initialize() {












        assert lvTable != null : "fx:id=\"lvTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert cmbTable != null : "fx:id=\"cmbTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
