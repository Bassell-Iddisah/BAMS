package com.example.tryfx;


import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private TextField acc;

    @FXML
    private Text namelabel;

    @FXML
    private  Text acclabel;

    @FXML
    private  Text accountlabel;

    @FXML
    private ComboBox<String> dropdown;

    @FXML
    private TextField name;

    @FXML
    private TextField takeAmount;

    @FXML
    private Checkbox enablePicker;

    @FXML
    private DatePicker selectMaturityDate;

    @FXML
    private DatePicker getCurrentBalance;

    @FXML
    void handleCheckBoxToggle(ActionEvent event) {
//        System.out.println(enableMaturity.getState());enableMaturity.getState()
        selectMaturityDate.setDisable(true);
    }




    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    dropdown.setItems(FXCollections.observableArrayList(
            "Savings Account","Current Account","Fixed Deposit Account"
    ));
    }

    @FXML
    void getCurrentBalance(ActionEvent event) {
        if (currentAccount != null) {

        }
    }

    private Account currentAccount;

  @FXML
    public void handleSubmit(javafx.event.ActionEvent actionEvent) {
        String accName= name.getText();
        String accNumber=acc.getText();
        String accType = dropdown.getSelectionModel().getSelectedItem();
        LocalDate maturity = selectMaturityDate.getValue();


        acclabel.setText(accNumber);
        accountlabel.setText(accType);
        namelabel.setText(accName);

        // Validate maturity date data, creating object accordingly
        if (maturity == null) {
            switch (accType) {
                case "Savings Account":
                    currentAccount =  new SavingsAccount(accNumber, accName);
                    break;
                case "Current Account":
                    currentAccount =  new CurrentAccount(accNumber, accName);
                    break;
            }
        } else {
            String maturityDate = maturity.toString();
            currentAccount =  new FixedDepositAccount(accNumber, accName, maturity);
            currentAccount.currentBalance += 1000;
        }
    }

    public void withdrawhandle(ActionEvent actionEvent) {
        double amount = Double.parseDouble(takeAmount.getText());

    }

    public void depositHandle(ActionEvent actionEvent) {
    }
}
