package sample;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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
    private ComboBox<String> cmbTable;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnExit;

    @FXML
    void editClicked(MouseEvent event) {

    }

    @FXML
    void exitClicked(MouseEvent event) {

    }

    @FXML
    void rowSelected(MouseEvent event) {

    }

    @FXML
    void tableSelected(MouseEvent event) {

    }

    private ArrayList<String> getAllTables() throws SQLException {
        ArrayList<String> listOfTables = new ArrayList<>();

        PreparedStatement selectIDs = null;

        ResultSet rs = null;
            DatabaseMetaData meta = conn.getMetaData();
            rs = meta.getTables(null, null, null, new String[] {
                    "TABLE"
            });
            int count = 0;
            System.out.println("All table names are in test database:");
            while (rs.next()) {
                String tblName = rs.getString("TABLE_NAME");
                listOfTables.add(rs.getString("TABLE_NAME"));

                System.out.println(tblName);
                count++;
            }
        //selectIDs.close();
        return listOfTables;


    }









/*    public ArrayList<Integer> fillComboBox() throws SQLException {

        ArrayList<Integer> AgentIDs = new ArrayList<>();
        String selectQuery = "SELECT AgentId from agents"; //select * from sysobjects where xtype = 'U'

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
    }*/

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

    @FXML
    void initialize() throws SQLException {
        assert lvTable != null : "fx:id=\"lvTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert cmbTable != null : "fx:id=\"cmbTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";

        connectDB();

        cmbTable.getItems().addAll(getAllTables());

    }
}
