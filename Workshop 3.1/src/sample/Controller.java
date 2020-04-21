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
import javafx.scene.control.TextField;
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
    private TextField tfAgentId;

    @FXML
    private TextField tfAgentFirstName;

    @FXML
    private TextField tfAgentMiddileInitial;

    @FXML
    private TextField tfAgentLastName;

    @FXML
    private TextField tfAgentPhone;

    @FXML
    private TextField tfAgentEmail;

    @FXML
    private TextField tfAgentPosition;

    @FXML
    private TextField tfAgencyID;

    @FXML
    private Button btnAddAgent;

    @FXML
    private Button btnExitAddAgent;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnExitAddCustomer;

    @FXML
    private TextField tfCustomerId;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustAddress;

    @FXML
    private TextField tfCustCity;

    @FXML
    private TextField tfCustProvince;

    @FXML
    private TextField tfCustPostalCode;

    @FXML
    private TextField tfCustCountry;

    @FXML
    private TextField tfCustHomePhone;

    @FXML
    private TextField tfCustBusinessPhone;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private TextField tfCustAgentId;

    @FXML
    void addAgentClicked(MouseEvent event) {

    }

    @FXML
    void addCustomerClicked(MouseEvent event) {

    }

    @FXML
    void addCustomerExitClicked(MouseEvent event) {
        System.exit(0);


    }


    @FXML
    void editClicked(MouseEvent event) {

    }

    @FXML
    void exitClicked(MouseEvent event) {
        System.exit(0);
    }

        @FXML
        void newAgentExitClicked(MouseEvent event) {
            System.exit(0);


        }


    @FXML
    void rowSelected(MouseEvent event) {

    }

    @FXML
    void tableSelected(MouseEvent event) {

    }

    private ArrayList<String> getAllTables() throws SQLException {
        ArrayList<String> listOfTables = new ArrayList<>();


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
        return listOfTables;


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

    @FXML
    void initialize() throws SQLException {
        assert cmbTable != null : "fx:id=\"cmbTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert lvTable != null : "fx:id=\"lvTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentFirstName != null : "fx:id=\"tfAgentFirstName\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentMiddileInitial != null : "fx:id=\"tfAgentMiddileInitial\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentLastName != null : "fx:id=\"tfAgentLastName\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentPhone != null : "fx:id=\"tfAgentPhone\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentEmail != null : "fx:id=\"tfAgentEmail\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgentPosition != null : "fx:id=\"tfAgentPosition\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfAgencyID != null : "fx:id=\"tfAgencyID\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddAgent != null : "fx:id=\"btnAddAgent\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExitAddAgent != null : "fx:id=\"btnExitAddAgent\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddCustomer != null : "fx:id=\"btnAddCustomer\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExitAddCustomer != null : "fx:id=\"btnExitAddCustomer\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfCustAddress\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCustCity\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustProvince != null : "fx:id=\"tfCustProvince\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustPostalCode != null : "fx:id=\"tfCustPostalCode\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCustCountry\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfCustHomePhone\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustBusinessPhone != null : "fx:id=\"tfCustBusinessPhone\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustAgentId != null : "fx:id=\"tfCustAgentId\" was not injected: check your FXML file 'sample.fxml'.";


        connectDB();

        cmbTable.getItems().addAll(getAllTables());

    }
}


