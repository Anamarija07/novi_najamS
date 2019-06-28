package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import model.Klijent;
import model.Stan;
import model.Vlasnik;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import model.Test;

public class Klijent1 implements Initializable {


    @FXML
    TableColumn tblImeVlasnika;

    @FXML
    TableColumn tblPrezimeVlasnika;

    @FXML
    TableColumn tblAdresaStana;

    @FXML
    TableColumn tblBrojKvadratak;

    @FXML
    TableColumn tblBrojSobak;

    @FXML
    TableColumn tblVrstaStanak;


    @FXML
    TableColumn tblCijenak;

    @FXML
    TableView klijentTablica;


    @FXML
    Button btnOdaberi;

    @FXML
    Button btnUgovor;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tblImeVlasnika.setCellValueFactory(new PropertyValueFactory<>("ime"));
        this.tblPrezimeVlasnika.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        this.tblAdresaStana.setCellValueFactory(new PropertyValueFactory<>("adresa_stan"));
        this.tblBrojKvadratak.setCellValueFactory(new PropertyValueFactory<>("broj_Kvadrata"));
        this.tblBrojSobak.setCellValueFactory(new PropertyValueFactory<>("brojSoba"));
        this.tblCijenak.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        this.tblVrstaStanak.setCellValueFactory(new PropertyValueFactory<>("vrstaStana"));



        this.popuniStanove();
    }

    private void popuniStanove() {
        ObservableList<Test> test = (ObservableList<Test>) Test.select();
        this.klijentTablica.setItems(test);
    }

    @FXML
    private void odaberiStan(MouseEvent ev){
        this.btnOdaberi.setText("Odaberi stan");

    }
    @FXML
    private void prikaziUgovor(MouseEvent ev){
        this.btnUgovor.setText("Ugovor");
    }

}



