package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.Vlasnik;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin1 implements Initializable {

    @FXML
    TableColumn korisnikID;

    @FXML
    TableColumn korisnikIme;

    @FXML
    TableColumn korisnikPrezime;

    @FXML
    TableColumn korisnickoIme;

    @FXML
    TableColumn korisnikLozinka;

    @FXML
    TableColumn korisnikUloga;

    @FXML
    TableColumn korisnikBroj;

    @FXML
    TableColumn korisnikAdresa;

    @FXML
    TableView korisnikTablica;

    @FXML
    TextField kImeTxt;

    @FXML
    TextField kPrezimeTxt;

    @FXML
    TextField kKimeTxt;

    @FXML
    TextField kLozinkaTxt;

    @FXML
    TextField kUlogaTxt;

    @FXML
    TextField kBrojTxt;

    @FXML
    TextField kAdresaTxt;

    @FXML
    Button dodajBtn;




    Vlasnik selectedUser = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.korisnikID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.korisnikIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        this.korisnikPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        this.korisnickoIme.setCellValueFactory(new PropertyValueFactory<>("korisnickoIme"));
        this.korisnikLozinka.setCellValueFactory(new PropertyValueFactory<>("lozinka"));
        this.korisnikUloga.setCellValueFactory(new PropertyValueFactory<>("uloga"));
        this.korisnikBroj.setCellValueFactory(new PropertyValueFactory<>("brojTelefona"));
        this.korisnikAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));

        this.popuniKorisnike();
    }

    private void popuniKorisnike() {
        ObservableList<Vlasnik> vlasnici = (ObservableList<Vlasnik>) Vlasnik.select();
        this.korisnikTablica.setItems(vlasnici);
    }

    @FXML
    public void odaberiKorisnika(MouseEvent ev) {
        this.dodajBtn.setText("Uredi korisnika");
        this.selectedUser = (Vlasnik) this.korisnikTablica.getSelectionModel().getSelectedItem();
        if (this.selectedUser != null) {
            this.kImeTxt.setText(this.selectedUser.getIme());
            this.kPrezimeTxt.setText(this.selectedUser.getPrezime());
            this.kKimeTxt.setText(this.selectedUser.getKorisnickoIme());
            this.kLozinkaTxt.setText(this.selectedUser.getLozinka());
            this.kUlogaTxt.setText(this.selectedUser.getUloga());
            this.kBrojTxt.setText(this.selectedUser.getBrojTelefona());
            this.kAdresaTxt.setText(this.selectedUser.getAdresa());
        }
    }


    @FXML
    public void skloniKorisnika(MouseEvent ev) {
        this.dodajBtn.setText("Dodaj korisnika");
        this.selectedUser = null;
        this.kImeTxt.setText("");
        this.kPrezimeTxt.setText("");
        this.kKimeTxt.setText("");
        this.kLozinkaTxt.setText("");
        this.kUlogaTxt.setText("");
        this.kBrojTxt.setText("");
        this.kAdresaTxt.setText("");

        this.popuniKorisnike();
    }

    @FXML
    public void dodajKorisnika(ActionEvent ev) throws Exception {
        String ime = this.kImeTxt.getText();
        String prezime = this.kPrezimeTxt.getText();
        String kIme = this.kKimeTxt.getText();
        String lozinka = this.kLozinkaTxt.getText();
        String uloga = this.kUlogaTxt.getText();
        String brojTelefona = this.kBrojTxt.getText();
        String adresa = this.kAdresaTxt.getText();
        if (ime.equals("") || prezime.equals("") || kIme.equals("") || lozinka.equals("")) {
            return;
        }

        if (this.selectedUser != null) {
            this.selectedUser.setIme(ime);
            this.selectedUser.setPrezime(prezime);
            this.selectedUser.setKorisnickoIme(kIme);
            this.selectedUser.setLozinka(lozinka);
            this.selectedUser.setUloga(uloga);
            this.selectedUser.setBrojTelefona(brojTelefona);
            this.selectedUser.setAdresa(adresa);

            Vlasnik.update(this.selectedUser);
            this.selectedUser = null;
            this.dodajBtn.setText("Dodaj korisnika");
        } else {
            Vlasnik v = new Vlasnik(0, ime, prezime, kIme, lozinka, uloga, brojTelefona, adresa);
            Vlasnik.add(v);
        }
        this.popuniKorisnike();

        this.kImeTxt.setText("");
        this.kPrezimeTxt.setText("");
        this.kKimeTxt.setText("");
        this.kLozinkaTxt.setText("");
        this.kUlogaTxt.setText("");
        this.kBrojTxt.setText("");
        this.kAdresaTxt.setText("");
    }


    @FXML
    public void pobrisiKorisnika(ActionEvent ev) {
        Vlasnik vlasnik = (Vlasnik) this.korisnikTablica.getSelectionModel().getSelectedItem();
        Vlasnik.remove(vlasnik);
        this.popuniKorisnike();
    }
}


