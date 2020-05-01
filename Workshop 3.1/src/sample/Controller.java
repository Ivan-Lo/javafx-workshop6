package sample;


import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

public class Controller {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddAgent;
    @FXML
    private Button btnExitAddAgent;

    @FXML
    private Button btnAddBooking;

    @FXML
    private Button btnAddCustomer;
    @FXML
    private Button btnExitAddCustomer;

    @FXML
    private Button btnAddProduct;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnReloadPage;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnClear;

    @FXML
    private DatePicker dpBookingDate;

    @FXML
    private TableColumn<Booking, Integer> colBookingId;

    @FXML
    private TableColumn<Booking, Timestamp> colBookingDate;

    @FXML
    private TableColumn<Booking, String> colBookingNumber;

    @FXML
    private TableColumn<Booking, Float> colTravelerCount;

    @FXML
    private TableColumn<Booking, Integer> colCustomerId;

    @FXML
    private TableColumn<Booking, String> colTripTypeId;

    @FXML
    private TableColumn<Booking, Integer> colPackageId;

    @FXML
    private TableColumn<Agent, Integer> agentidColumn;

    @FXML
    private TableColumn<Agent, String> firstNameColumn;

    @FXML
    private TableColumn<Agent, String> middleInitialColumn;

    @FXML
    private TableColumn<Agent, String> lastNameColumn;

    @FXML
    private TableColumn<Agent,String> busPhoneColumn;

    @FXML
    private TableColumn<Agent, String> emailColumn;

    @FXML
    private TableColumn<Agent, String> agtPositionColumn;

    @FXML
    private TableColumn<Agent, Integer> agencyIdColumn;

    @FXML
    private TableColumn<Product, Integer> colProductId;

    @FXML
    private TableColumn<Product, String> colProdName;

    @FXML
    private TableColumn<Customer, Integer> customeridColumn;

    @FXML
    private TableColumn<Customer, String> cfirstNameColumn;

    @FXML
    private TableColumn<Customer, String> clastNameColumn;

    @FXML
    private TableColumn<Customer, String> addressColumn;

    @FXML
    private TableColumn<Customer,String> cityColumn;

    @FXML
    private TableColumn<Customer, String> provColumn;

    @FXML
    private TableColumn<Customer, String> postalColumn;

    @FXML
    private TableColumn<Customer, String> countryColumn;

    @FXML
    private TableColumn<Customer, String> homePhoneColumn;

    @FXML
    private TableColumn<Customer, String> cbusPhoneColumn;

    @FXML
    private TableColumn<Customer, String> cemailColumn;

    @FXML
    private TableColumn<Customer, Integer> agentIdColumn;

    @FXML
    private TableColumn<Package, Timestamp> pkgEndColumn;

    @FXML
    private TableColumn<Package, String> pkgDescColumn;

    @FXML
    private TableColumn<Package, BigDecimal> pkgPriceColumn;

    @FXML
    private TableColumn<Package, BigDecimal> pkgCommColumn;

    @FXML
    private TableColumn<Package, Integer> pkgIdColumn;

    @FXML
    private TableColumn<Package, String> pkgNameColumn;

    @FXML
    private TableColumn<Package, Timestamp> pkgStartColumn;

    @FXML
    private TableView<Booking> tblBookings;

    @FXML
    private TableView<Customer> ctableview;

    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private TableView<Agent> tblAgents;

    @FXML
    private TableView<Package> tblPackages;

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
    private TextField tfBookingId;

    @FXML
    private TextField tfBookingNo;

    @FXML
    private TextField tfTravelerCount;

    @FXML
    private TextField tfCustomerIdBooking;

    @FXML
    private TextField tfTripTypeId;

    @FXML
    private TextField tfPackageId;

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
    private TextField tfProductId;

    @FXML
    private TextField tfProductName;

    @FXML
    private TextField tfPackageIdPackage;

    @FXML
    private TextField tfPackageName;

    @FXML
    private DatePicker dpPkgStart;

    @FXML
    private DatePicker dpPkgEnd;

    @FXML
    private TextArea tfPackageDesc;

    @FXML
    private TextField tfPackagePrice;

    @FXML
    private TextField tfPackageComm;

    public Controller() {
    }

    @FXML
    void reloadPageClicked(MouseEvent event) throws SQLException {
        tfAgentId.setText("");
        tfAgentFirstName.setText("");
        tfAgentMiddileInitial.setText("");
        tfAgentLastName.setText("");
        tfAgentPhone.setText("");
        tfAgentEmail.setText("");
        tfAgentPosition.setText("");
        tfAgencyID.setText("");
        tfBookingId.setText("");
        tfBookingNo.setText("");
        tfTravelerCount.setText("");
        tfCustomerIdBooking.setText("");
        tfTripTypeId.setText("");
        tfPackageId.setText("");
        tfCustomerId.setText("");
        tfCustFirstName.setText("");
        tfCustLastName.setText("");
        tfCustAddress.setText("");
        tfCustCity.setText("");
        tfCustProvince.setText("");
        tfCustPostalCode.setText("");
        tfCustCountry.setText("");
        tfCustHomePhone.setText("");
        tfCustBusinessPhone.setText("");
        tfCustEmail.setText("");
        tfCustAgentId.setText("");
        tfProductId.setText("");
        tfProductName.setText("");
        tfPackageName.setText("");
        tfPackageDesc.setText("");
        tfPackagePrice.setText("");
        tfPackageComm.setText("");
        populateAgentTable();
        populateProductTable();
        populateBookingTable();
        populateCustomerTable();
        populatePackageTable();


    }

    @FXML
    void productsTableClicked(MouseEvent event) {

    }

    @FXML
    void addAgentClicked(MouseEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "INSERT INTO Agents (AgentId, AgtFirstName, AgtMiddleInitial, AgtLastName, AgtBusPhone, AgtEmail, AgtPosition, AgencyId) VALUES(?,?,?,?,?,?,?,?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, tfAgentId.getText());
            stmt.setString(2, tfAgentFirstName.getText());
            stmt.setString(3, tfAgentMiddileInitial.getText());
            stmt.setString(4, tfAgentLastName.getText());
            stmt.setString(5, tfAgentPhone.getText());
            stmt.setString(6, tfAgentEmail.getText());
            stmt.setString(7, tfAgentPosition.getText());
            stmt.setString(8, tfAgencyID.getText());



            if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                        "Customer Inserted Successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                        "Customer Insert Failed", ButtonType.CLOSE).showAndWait();
            }
            tfAgentId.setText("");
            tfAgentFirstName.setText("");
            tfAgentMiddileInitial.setText("");
            tfAgentLastName.setText("");
            tfAgentPhone.setText("");
            tfAgentEmail.setText("");
            tfAgentPosition.setText("");
            tfAgencyID.setText("");
            conn.close();
        }
        catch (ClassNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }



    }
    @FXML
    void SubmitClicked(MouseEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "INSERT INTO Packages (PackageId, PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, PkgCommission) VALUES(?,?,?,?,?,?,?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, tfPackageIdPackage.getText());
            stmt.setString(2, tfPackageName.getText());
            stmt.setString(3, dpPkgStart.getValue().toString());
            stmt.setString(4, dpPkgEnd.getValue().toString());
            stmt.setString(5, tfPackageDesc.getText());
            stmt.setString(6, tfPackagePrice.getText());
            stmt.setString(7, tfPackageComm.getText());

            if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                        "Customer Inserted Successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                        "Customer Insert Failed", ButtonType.CLOSE).showAndWait();
            }
            tfPackageId.setText("");
            tfPackageName.setText("");
            tfPackageDesc.setText("");
            tfPackagePrice.setText("");
            tfPackageComm.setText("");
            conn.close();
        }
        catch (ClassNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }

    }

    @FXML
    void addBookingClicked(MouseEvent event) {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "INSERT INTO Bookings (BookingId, BookingDate, BookingNo, TravelerCount, CustomerId, TripTypeId, PackageId) VALUES(?,?,?,?,?,?,?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, tfBookingId.getText());
            stmt.setString(2, dpBookingDate.getValue().toString());
            stmt.setString(3, tfBookingNo.getText());
            stmt.setString(4, tfTravelerCount.getText());
            stmt.setString(5, tfCustomerIdBooking.getText());
            stmt.setString(6, tfTripTypeId.getText());
            stmt.setString(7, tfPackageId.getText());


            if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                        "Customer Inserted Successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                        "Customer Insert Failed", ButtonType.CLOSE).showAndWait();
            }
            tfBookingId.setText("");
            tfBookingNo.setText("");
            tfTravelerCount.setText("");
            tfCustomerIdBooking.setText("");
            tfTripTypeId.setText("");
            tfPackageId.setText("");
            conn.close();
        }
        catch (ClassNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }


    }


    @FXML
    void addCustomerClicked(MouseEvent event) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "INSERT INTO Customers (CustomerId, CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustPostal, CustCountry, CustHomePhone, CustBusPhone, CustEmail, AgentId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, tfCustomerId.getText());
            stmt.setString(2, tfCustFirstName.getText());
            stmt.setString(3, tfCustLastName.getText());
            stmt.setString(4, tfCustAddress.getText());
            stmt.setString(5, tfCustCity.getText());
            stmt.setString(6, tfCustProvince.getText());
            stmt.setString(7, tfCustPostalCode.getText());
            stmt.setString(8, tfCustCountry.getText());
            stmt.setString(9, tfCustHomePhone.getText());
            stmt.setString(10, tfCustBusinessPhone.getText());
            stmt.setString(11, tfCustEmail.getText());
            stmt.setString(12, tfCustAgentId.getText());

            if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                        "Customer Inserted Successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                        "Customer Insert Failed", ButtonType.CLOSE).showAndWait();
            }
            tfCustomerId.setText("");
            tfCustFirstName.setText("");
            tfCustLastName.setText("");
            tfCustAddress.setText("");
            tfCustCity.setText("");
            tfCustProvince.setText("");
           tfCustPostalCode.setText("");
            tfCustCountry.setText("");
            tfCustHomePhone.setText("");
            tfCustBusinessPhone.setText("");
            tfCustEmail.setText("");
           tfCustAgentId.setText("");
            conn.close();
        }
        catch (ClassNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
    }


    @FXML
    void addProductClicked(MouseEvent event) throws SQLException {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "INSERT INTO Products (ProductId, ProdName) VALUES(?,?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, tfProductId.getText());
            stmt.setString(2, tfProductName.getText());
            if (stmt.executeUpdate() > 0)
            {

                 Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Product Inserted Successfully", ButtonType.CLOSE);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();

            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Product Insert Failed", ButtonType.CLOSE);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();
            }
            tfProductId.setText("");
            tfProductName.setText("");
            conn.close();
        }
        catch (ClassNotFoundException ex) {
             Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
    }

    @FXML
    void btnExit(MouseEvent event) {
        System.exit(0);

    }

    private ObservableList<Booking> populateBookingTable() throws SQLException {
        ObservableList<Booking> data;
        data = FXCollections.observableArrayList();

        colBookingId.setCellValueFactory(new PropertyValueFactory<>("BookingId"));
        colBookingDate.setCellValueFactory(new PropertyValueFactory<>("BookingDate"));
        colBookingNumber.setCellValueFactory(new PropertyValueFactory<>("BookingNo"));
        colTravelerCount.setCellValueFactory(new PropertyValueFactory<>("TravelerCount"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colTripTypeId.setCellValueFactory(new PropertyValueFactory<>("TripTypeId"));
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("PackageId"));
        try {
            String query = "select * from Bookings";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Booking(rs.getInt(1), rs.getTimestamp(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getString(6), rs.getInt(7)));
                tblBookings.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        return data;
    }
private ObservableList<Agent> populateAgentTable() throws SQLException {
    ObservableList<Agent> data;
    data = FXCollections.observableArrayList();

    agentidColumn.setCellValueFactory(new PropertyValueFactory<>("AgentId"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("AgtFirstName"));
    middleInitialColumn.setCellValueFactory(new PropertyValueFactory<>("AgtMiddleInitial"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("AgtLastName"));
    busPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("AgtBusPhone"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("AgtEmail"));
    agtPositionColumn.setCellValueFactory(new PropertyValueFactory<>("AgtPosition"));
    agencyIdColumn.setCellValueFactory(new PropertyValueFactory<>("AgencyId"));
    try {
        String query = "select * from Agents";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

        PreparedStatement pst = conn.prepareStatement(query);
        rs = pst.executeQuery();

        while (rs.next()) {
            data.add(new Agent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getInt(8)));
            tblAgents.setItems(data);
        }
        pst.close();
        rs.close();
    } catch (SQLException ex) {
        System.err.println("Error" + ex);
    }
    return data;
}
    private ObservableList<Product> populateProductTable() throws SQLException {
        ObservableList<Product> data;
        data = FXCollections.observableArrayList();

        colProductId.setCellValueFactory(new PropertyValueFactory<>("ProductId"));
        colProdName.setCellValueFactory(new PropertyValueFactory<>("ProdName"));

        try {
            String query = "select * from Products";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Product(rs.getInt(1), rs.getString(2)));
                tblProducts.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        return data;
    }

    private ObservableList<Customer> populateCustomerTable() throws SQLException {
        ObservableList<Customer> data;
        data = FXCollections.observableArrayList();

        customeridColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        cfirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CustFirstName"));
        clastNameColumn.setCellValueFactory(new PropertyValueFactory<>("CustLastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("CustCity"));
        provColumn.setCellValueFactory(new PropertyValueFactory<>("CustProv"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("CustPostal"));
        homePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("CustCountry"));
        cbusPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("CustHomePhone"));
        cemailColumn.setCellValueFactory(new PropertyValueFactory<>("CustBusPhone"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("CustEmail"));
        agentIdColumn.setCellValueFactory(new PropertyValueFactory<>("AgentId"));
        try {
            String query = "select * from Customers";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12)));
                ctableview.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        return data;
    }

    private ObservableList<Package> populatePackageTable() throws SQLException {
        ObservableList<Package> data;
        data = FXCollections.observableArrayList();

        pkgIdColumn.setCellValueFactory(new PropertyValueFactory<>("PackageId"));
        pkgNameColumn.setCellValueFactory(new PropertyValueFactory<>("PkgName"));
        pkgStartColumn.setCellValueFactory(new PropertyValueFactory<>("PkgStartDate"));
        pkgEndColumn.setCellValueFactory(new PropertyValueFactory<>("PkgEndDate"));
        pkgDescColumn.setCellValueFactory(new PropertyValueFactory<>("PkgDesc"));
        pkgPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PkgBasePrice"));
        pkgCommColumn.setCellValueFactory(new PropertyValueFactory<>("PkgAgencyCommission"));

        try {
            String query = "select * from Packages";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                data.add(new Package(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),
                        rs.getBigDecimal(6), rs.getBigDecimal(7)));

            tblPackages.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        return data;
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

        assert btnAddBooking != null : "fx:id=\"btnAddBooking\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddProduct != null : "fx:id=\"btnAddProduct\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddBooking != null : "fx:id=\"btnAddBooking\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfBookingId != null : "fx:id=\"tfBookingId\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfTravelerCount != null : "fx:id=\"tfTravelerCount\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfCustomerIdBooking != null : "fx:id=\"tfCustomerIdBooking\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfTripTypeId != null : "fx:id=\"tfTripTypeId\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfPackageId != null : "fx:id=\"tfPackageId\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddProduct != null : "fx:id=\"btnAddProduct\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfProductId != null : "fx:id=\"tfProductId\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfProductName != null : "fx:id=\"tfProductName\" was not injected: check your FXML file 'sample.fxml'.";
        assert tblAgents != null : "fx:id=\"tableview\" was not injected: check your FXML file 'sample.fxml'.";
        assert agentidColumn != null : "fx:id=\"agentidColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert firstNameColumn != null : "fx:id=\"firstNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert middleInitialColumn != null : "fx:id=\"middleInitialColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastNameColumn != null : "fx:id=\"lastNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert busPhoneColumn != null : "fx:id=\"busPhoneColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert emailColumn != null : "fx:id=\"emailColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert agtPositionColumn != null : "fx:id=\"agtPositionColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert agencyIdColumn != null : "fx:id=\"agencyIdColumn\" was not injected: check your FXML file 'sample.fxml'.";
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
        assert tblBookings != null : "fx:id=\"tblBookings\" was not injected: check your FXML file 'sample.fxml'.";
        assert colBookingId != null : "fx:id=\"colBookingId\" was not injected: check your FXML file 'sample.fxml'.";
        assert colBookingDate != null : "fx:id=\"colBookingDate\" was not injected: check your FXML file 'sample.fxml'.";
        assert colBookingNumber != null : "fx:id=\"colBookingNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert colTravelerCount != null : "fx:id=\"colTravelerCount\" was not injected: check your FXML file 'sample.fxml'.";
        assert colCustomerId != null : "fx:id=\"colCustomerId\" was not injected: check your FXML file 'sample.fxml'.";
        assert colTripTypeId != null : "fx:id=\"colTripTypeId\" was not injected: check your FXML file 'sample.fxml'.";
        assert colPackageId != null : "fx:id=\"colPackageId\" was not injected: check your FXML file 'sample.fxml'.";
        assert ctableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'sample.fxml'.";
        assert customeridColumn != null : "fx:id=\"customeridColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert cfirstNameColumn != null : "fx:id=\"firstNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert clastNameColumn != null : "fx:id=\"lastNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert addressColumn != null : "fx:id=\"addressColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert cityColumn != null : "fx:id=\"cityColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert provColumn != null : "fx:id=\"provColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert postalColumn != null : "fx:id=\"postalColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert countryColumn != null : "fx:id=\"countryColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert homePhoneColumn != null : "fx:id=\"homePhoneColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert cbusPhoneColumn != null : "fx:id=\"busPhoneColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert cemailColumn != null : "fx:id=\"emailColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert agentIdColumn != null : "fx:id=\"agentIdColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfPackageName != null : "fx:id=\"tfPackageName\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfPackageDesc != null : "fx:id=\"tfPackageDesc\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfPackagePrice != null : "fx:id=\"tfPackagePrice\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfPackageComm != null : "fx:id=\"tfPackageComm\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgIdColumn != null : "fx:id=\"pkgId\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgNameColumn != null : "fx:id=\"pkgName\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgStartColumn != null : "fx:id=\"pkgStart\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgEndColumn != null : "fx:id=\"pkgEnd\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgDescColumn != null : "fx:id=\"pkgDesc\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgPriceColumn != null : "fx:id=\"pkgPrice\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgCommColumn != null : "fx:id=\"pkgComm\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSubmit != null : "fx:id=\"btnSubmit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert tblPackages != null : "fx:id=\"tblPackages\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgIdColumn != null : "fx:id=\"pkgIdColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgNameColumn != null : "fx:id=\"pkgNameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgStartColumn != null : "fx:id=\"pkgStartColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgEndColumn != null : "fx:id=\"pkgEndColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgDescColumn != null : "fx:id=\"pkgDescColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgPriceColumn != null : "fx:id=\"pkgPriceColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert pkgCommColumn != null : "fx:id=\"pkgCommColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert tfPackageIdPackage != null : "fx:id=\"tfPackageIdPackage\" was not injected: check your FXML file 'sample.fxml'.";
        assert dpPkgEnd != null : "fx:id=\"dpPkgEnd\" was not injected: check your FXML file 'sample.fxml'.";
        assert dpPkgStart != null : "fx:id=\"dpPkgStart\" was not injected: check your FXML file 'sample.fxml'.";

        populateAgentTable();
        populateProductTable();
        populateBookingTable();
        populateCustomerTable();
        populatePackageTable();

    }
    }

