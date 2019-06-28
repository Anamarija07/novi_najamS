package model;

import controller.Vlasnik1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Vlasnik {
    private int ID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String uloga;
    private String brojTelefona;
    private String adresa;
    private String mjesto;
    private String cijena;
    private String vrstaStana;
    private int brojSoba;
    private String brojKvadrata;


    public Vlasnik(int ID, String ime, String prezime, String korisnickoIme, String lozinka, String uloga, String brojTelefona, String adresa) {
        this.ID = ID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
    }

    public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
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

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public String getBrojKvadrata() {
        return brojKvadrata;
    }

    public void setBrojKvadrata(String brojKvadrata) {
        this.brojKvadrata = brojKvadrata;
    }

    public Vlasnik(int ID, String adresa, String mjesto, String cijena, String vrstaStana, int brojSoba, String brojKvadrata) {
        this.ID = ID;
        this.adresa = adresa;
        this.mjesto = mjesto;
        this.cijena = cijena;
        this.vrstaStana = vrstaStana;
        this.brojSoba = brojSoba;
        this.brojKvadrata = brojKvadrata;
    }

    public Vlasnik(int ID, String anamarija, String dumančić, String s, String admin, String s1) {

    }


    public Vlasnik() {
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) throws Exception {
        if (uloga.toLowerCase().equals("admin") || uloga.toLowerCase().equals("vlasnik") || uloga.toLowerCase().equals("klijent"))
            this.uloga = uloga.toUpperCase();
        else
            throw new Exception("Molim Vas izaberite novu korisničku ulogu");
    }

    public static Vlasnik add(Vlasnik v) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("INSERT INTO vlasnik VALUES (null, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmnt.setString(1, v.getIme());
            stmnt.setString(2, v.getPrezime());
            stmnt.setString(3, v.getKorisnickoIme());
            stmnt.setString(4, v.getLozinka());
            stmnt.setString(5, v.getUloga());
            stmnt.setString(6, v.getBrojTelefona());
            stmnt.setString(7, v.getAdresa());
            stmnt.executeUpdate();

            ResultSet rs = stmnt.getGeneratedKeys();
            if (rs.next()) {
                v.setID(rs.getInt(1));
            }
            return v;
        } catch (SQLException e) {
            System.out.println("Korisnik nije dodan: " + e.getMessage());
            return null;
        }
    }

    public static boolean remove(Vlasnik v) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("DELETE FROM vlasnik WHERE ID_vlasnik=?");
            stmnt.setInt(1, v.getID());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Korisnik nije obrisan: " + e.getMessage());
            return false;
        }
    }


    public static boolean update(Vlasnik v) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("UPDATE vlasnik set ime=?, prezime=?, korisnickoIme=?, lozinka=?, uloga=?, brojTelefona=?, adresa=? WHERE ID_vlasnik=?");
            stmnt.setString(1, v.getIme());
            stmnt.setString(2, v.getPrezime());
            stmnt.setString(3, v.getIme());
            stmnt.setString(4, v.getLozinka());
            stmnt.setString(5, v.getUloga());
            stmnt.setString(6, v.getBrojTelefona());
            stmnt.setString(7, v.getAdresa());
            stmnt.setInt(8, v.getID());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Korisnik nije ureden: " + e.getMessage());
            return false;
        }
    }
    public static List<Vlasnik> select() {
        ObservableList<Vlasnik> vlasnik = FXCollections.observableArrayList();
        try {
            Statement stmnt = Database.CONNECTION.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT ID_stan, adresa_stan, brojKvadrata, brojSoba, cijena,  vrstastana.vrstaStana, mjesto.nazivMjesta\n" +
                    "FROM stan, mjesto, vrstastana\n" +
                    "WHERE mjesto_id=mjesto.id AND vrstaStana_id=vrstastana.ID_vrstaStana");


            while(rs.next()){
                vlasnik.add(new Vlasnik(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)


                ));
            }
            return vlasnik;
        } catch (SQLException e) {
            System.out.println("Stanovi se ne mogu izvući iz baze: " + e.getMessage());
            return vlasnik;
        }
    }




    public static Vlasnik get (int ID) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("SELECT * FROM vlasnik WHERE ID_vlasnik=?");
            stmnt.setInt(1, ID);
            ResultSet rs = stmnt.executeQuery();


            if (rs.next()){
                return new Vlasnik(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Nisam uspio izvuci korisnika iz baze: " + e.getMessage());
            return null;
        }
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
