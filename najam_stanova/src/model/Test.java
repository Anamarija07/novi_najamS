package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Test {
    private Integer ID_stan;
    private String ime;
    private String prezime;
    private String adresa_stan;
    private String broj_Kvadrata;
    private Integer brojSoba;
    private String cijena;
    private String vrstaStana;

    public Test(Integer id_stan, String ime, String prezime, String adresa_stan, String broj_kvadrata, Integer brojSoba, String cijena, String vrstaStana) {
        ID_stan = id_stan;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa_stan = adresa_stan;
        broj_Kvadrata = broj_kvadrata;
        this.brojSoba = brojSoba;
        this.cijena = cijena;
        this.vrstaStana = vrstaStana;


    }

    public Integer getID_stan() {
        return ID_stan;
    }

    public void setID_stan(Integer ID_stan) {
        this.ID_stan = ID_stan;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa_stan() {
        return adresa_stan;
    }

    public void setAdresa_stan(String adresa_stan) {
        this.adresa_stan = adresa_stan;
    }

    public String getBroj_Kvadrata() {
        return broj_Kvadrata;
    }

    public void setBroj_Kvadrata(String broj_Kvadrata) {
        this.broj_Kvadrata = broj_Kvadrata;
    }

    public Integer getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(Integer brojSoba) {
        this.brojSoba = brojSoba;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public String getVrstaStana() {
        return vrstaStana;
    }

    public void setVrstaStana(String vrstaStana) {
        this.vrstaStana = vrstaStana;
    }

    public static List<Test> select() {
        ObservableList<Test> test = FXCollections.observableArrayList();
        try {
            Statement stmnt = Database.CONNECTION.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT ID_stan, vlasnik.ime, vlasnik.prezime, adresa_stan, brojKvadrata, brojSoba, cijena,  vrstastana.vrstaStana\n" +
                    "FROM stan, vlasnik, vrstastana\n" +
                    "WHERE vlasnik_id=vlasnik.ID_vlasnik AND vrstaStana_id=vrstastana.ID_vrstaStana");


            while(rs.next()){
                test.add(new Test(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)

                ));
            }
            return test;
        } catch (SQLException e) {
            System.out.println("Stanovi se ne mogu izvući iz baze: " + e.getMessage());
            return test;
        }
    }


}