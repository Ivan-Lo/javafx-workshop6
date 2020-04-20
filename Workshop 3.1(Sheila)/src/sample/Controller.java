package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    final ObservableList options = FXCollections.observableArrayList();






    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> lvTable;

    @FXML
    private ComboBox<Integer> cmbTable;

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
    void newClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addRows.fxml"));
        /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void rowSelected(MouseEvent event) {

    }

    @FXML
    void tableSelected(MouseEvent event) {

    }


    public ArrayList<Integer> fillComboBox() throws SQLException {

        ArrayList<Integer> AgentIDs = new ArrayList<>();
        String selectQuery = "SELECT AgentId from agents";
        PreparedStatement selectIDs = null;
        try {
            selectIDs = conn.prepareStatement(selectQuery);
            ResultSet rset = selectIDs.executeQuery(selectQuery);
            while (rset.next()) {
                AgentIDs.add(rset.getInt("AgentId"));
            }
            System.out.println("Agent IDs loaded to the ComboBox");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            selectIDs.close();
        }
        return AgentIDs;
    }


    private void connectDB() {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    private Vector getAgentIDs() {
//        // TODO Auto-generated method stub
//        Vector<String> agents = new Vector<String>();
//        try {
//            rs = stmt.executeQuery("select agentid from agents");
//            while (rs.next())
//            {
//                agents.add(rs.getString("agentid"));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return agents;
   // }
    @FXML
    void initialize() throws SQLException {
        assert lvTable != null : "fx:id=\"lvTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert cmbTable != null : "fx:id=\"cmbTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'sample.fxml'.";

        //cmbTable = new ComboBox<String>(options);
       // cmbTable.setMaxHeight(30);
        connectDB();
        cmbTable.getItems().addAll(fillComboBox());



    }
}
