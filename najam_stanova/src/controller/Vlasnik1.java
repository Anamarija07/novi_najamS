package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.Database;
import model.Stan;
import model.Test;
import model.Vlasnik;
import model.Mjesto;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class Vlasnik1 implements Initializable {

    @FXML
    ChoiceBox vVrstaStana;

    @FXML
    ChoiceBox vMjesto;

    @FXML
    TableColumn tblAdresa;

    @FXML
    TableColumn tblBrojKvadrata;

    @FXML
    TableColumn tblBrojSoba;

    @FXML
    TableColumn tblCijena;

    @FXML
    TableColumn tblVrstaStana;

    @FXML
    TableColumn tblMjesto;


    @FXML
    TableView vlasnikTablica;


    @FXML
    TextField vAdresa;

    @FXML
    TextField vBrojKvadrata;

    @FXML
    TextField vBrojSoba;

    @FXML
    TextField vCijena;

    @FXML
    Button btnDodaj;

    @FXML
    Button btnUkloni;

    @FXML
    Button btnUredi;


    Stan selectedUser = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tblAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        this.tblBrojKvadrata.setCellValueFactory(new PropertyValueFactory<>("brojKvadrata"));
        this.tblBrojSoba.setCellValueFactory(new PropertyValueFactory<>("brojSoba"));
        this.tblCijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        this.tblVrstaStana.setCellValueFactory(new PropertyValueFactory<>("vrstaStana"));
        this.tblMjesto.setCellValueFactory(new PropertyValueFactory<>("mjesto"));


        this.popuniKorisnike();
    }

    private void popuniKorisnike() {
        ObservableList<Vlasnik> vlasnik = (ObservableList<Vlasnik>) Vlasnik.select();
        this.vlasnikTablica.setItems(vlasnik);
    }

    @FXML
    public void urediStan(MouseEvent ev) {
        /*this.btnDodaj.setText("Uredi stan");
        this.selectedUser = (Stan) this.vlasnikTablica.getSelectionModel().getSelectedItem();
        if (this.selectedUser != null) {

            int a = this.selectedUser.getBrojSoba();
            String str1 = Integer.toString(a);

            this.vAdresa.setText(this.selectedUser.getAdresa());
            this.vBrojKvadrata.setText(this.selectedUser.getBrojKvadrata());
            this.vBrojSoba.setText(str1);
            this.vCijena.setText(this.selectedUser.getCijena());
            this.vMjesto.setValue(this.selectedUser.getMjesto());

        }*/
    }

    /*
        @FXML
        public void pobrisiStan(MouseEvent ev) {
            this.btnDodaj.setText("Dodaj stan");
            this.selectedUser = null;
            this.vAdresa.setText("");
            this.vBrojKvadrata.setText("");
            this.vBrojSoba.setText("");
            this.vCijena.setText("");

            this.popuniKorisnike();
        }
    */
    @FXML
    public void dodajStan(ActionEvent ev) throws Exception {
        /*
        String adresa = this.vAdresa.getText();
        String brojKvadrata = this.vBrojKvadrata.getText();
        String brojSoba = this.vBrojSoba.getText();
        String cijena = this.vCijena.getText();
       // String mjesto = this.vMjesto.getText();

        if (adresa.equals("") || brojKvadrata.equals("") || brojSoba.equals(0) || cijena.equals("")) {
            return;
        }

        if (this.selectedUser != null) {
            this.selectedUser.setAdresa(adresa);
            this.selectedUser.setBrojKvadrata(brojKvadrata);
            this.selectedUser.setBrojSoba(this.selectedUser.getBrojSoba());
            this.selectedUser.setCijena(cijena);
            //   this.selectedUser.setMjesto();

            Stan.update(this.selectedUser);
            this.selectedUser = null;
            this.btnDodaj.setText("Dodaj stan");
        } else {
            Stan s = new Stan(adresa, brojKvadrata, this.selectedUser.getBrojSoba(), cijena);
            Stan.add(s);
        }
        this.popuniKorisnike();

        this.vAdresa.setText("");
        this.vBrojKvadrata.setText("");
        this.vBrojSoba.setText("");
        this.vCijena.setText("");

         */
    }


    @FXML
    public void ukloniStan(ActionEvent ev) {
        /*
        Stan stan = (Stan) this.vlasnikTablica.getSelectionModel().getSelectedItem();
        Stan.remove(stan);
        this.popuniKorisnike();

         */
    }
}