package sample;


import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Controller {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    final ObservableList options = FXCollections.observableArrayList();

    @FXML
    private TableView<Agents> tableview;

    @FXML
    private TableColumn<Agents, Integer> agentidColumn;

    @FXML
    private TableColumn<Agents, String> firstNameColumn;

    @FXML
    private TableColumn<Agents, String> middleInitialColumn;

    @FXML
    private TableColumn<Agents, String> lastNameColumn;

    @FXML
    private TableColumn<Agents,String> busPhoneColumn;

    @FXML
    private TableColumn<Agents, String> emailColumn;

    @FXML
    private TableColumn<Agents, String> agtPositionColumn;

    @FXML
    private TableColumn<Agents, Integer> agencyIdColumn;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Products> tblProducts;

    @FXML
    private TableColumn<Products, Integer> colProductId;

    @FXML
    private TableColumn<Products, String> colProdName;

    @FXML
    void productsTableClicked(MouseEvent event) {

    }

    @FXML
    private ListView<String> lvTable;

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

    //THIS IS THE LISTVIEW EVENT LISTENER
    @FXML
    void rowSelected(MouseEvent event) {

    }

    //THIS IS THE COMBOBOX EVENT LISTENER
    @FXML
    void tableSelected(MouseEvent event) {

    }

    private ObservableList<String> items = FXCollections.observableArrayList();


    private ArrayList<String> getAllTables() throws SQLException {
        ArrayList<String> listOfTables = new ArrayList<>();


        ResultSet rs = null;
        DatabaseMetaData meta = conn.getMetaData();
        rs = meta.getTables(null, null, null, new String[]{
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



    private ObservableList<Agents>data;
    private DbConnection dc;
    @FXML
    void initialize() throws SQLException {

        assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'sample.fxml'.";
        assert agentidColumn != null : "fx:id=\"agentidColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert firstNameColumn != null : "fx:id=\"firstNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert middleInitialColumn != null : "fx:id=\"middleInitialColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastNameColumn != null : "fx:id=\"lastNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert busPhoneColumn != null : "fx:id=\"busPhoneColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert emailColumn != null : "fx:id=\"emailColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert agtPositionColumn != null : "fx:id=\"agtPositionColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert agencyIdColumn != null : "fx:id=\"agencyIdColumn\" was not injected: check your FXML file 'sample.fxml'.";
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

        data= FXCollections.observableArrayList();

        agentidColumn.setCellValueFactory(new PropertyValueFactory<>("AgentId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("AgtFirstName"));
        middleInitialColumn.setCellValueFactory(new PropertyValueFactory<>("AgtMiddleInitial"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("AgtLastName"));
        busPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("AgtBusPhone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("AgtEmail"));
        agtPositionColumn.setCellValueFactory(new PropertyValueFactory<>("AgtPosition"));
        agencyIdColumn.setCellValueFactory(new PropertyValueFactory<>("AgencyId"));
        try{
            String query = "select * from Agents";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Agents(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getInt(8)));
                tableview.setItems(data);
            }
            pst.close();
            rs.close();
        } catch(SQLException ex){
            System.err.println("Error" + ex);
        }


    }
    }

