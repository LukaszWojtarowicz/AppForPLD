package Model;

import java.sql.*;
import java.util.ArrayList;

public class eksperymentModel {
    private Connection con;
    private int eksperyment_id, probka_id,  czestotliwosc, dlugoscFali;
    public int iloscStrzalow;
    private String atmosfera, uwagi, materialBazy,uzytkownik_id;
    private double mocLasera, polePowierzchniPlamki, ubytekMasyNaStrzal;
    private String dataWykonania;
    public ArrayList<Object> probkiListaID = new ArrayList<>();
    private  ArrayList<Eksperyment> eksperymentLista = new ArrayList<>();
    public double znalezionaDeltaMasyProbki;
    public double ubytek;

    public int getEksperyment_id() {
        return eksperyment_id;
    }

    public void setEksperyment_id(int eksperyment_id) {
        this.eksperyment_id = eksperyment_id;
    }

    public int getProbka_id() {
        return probka_id;
    }

    public void setProbka_id(int probka_id) {
        this.probka_id = probka_id;
    }



    public int getIloscStrzalow() {
        return iloscStrzalow;
    }

    public void setIloscStrzalow(int iloscStrzalow) {
        this.iloscStrzalow = iloscStrzalow;
    }

    public int getCzestotliwosc() {
        return czestotliwosc;
    }

    public void setCzestotliwosc(int czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }

    public String getAtmosfera() {
        return atmosfera;
    }

    public void setAtmosfera(String atmosfera) {
        this.atmosfera = atmosfera;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public String getMaterialBazy() {
        return materialBazy;
    }

    public void setMaterialBazy(String materialBazy) {
        this.materialBazy = materialBazy;
    }

    public double getMocLasera() {
        return mocLasera;
    }

    public void setMocLasera(double mocLasera) {
        this.mocLasera = mocLasera;
    }

    public int getDlugoscFali() {
        return dlugoscFali;
    }

    public void setDlugoscFali(int dlugoscFali) {
        this.dlugoscFali = dlugoscFali;
    }

    public double getPolePowierzchniPlamki() {
        return polePowierzchniPlamki;
    }

    public void setPolePowierzchniPlamki(double polePowierzchniPlamki) {
        this.polePowierzchniPlamki = polePowierzchniPlamki;
    }

    public double getUbytekMasyNaStrzal() {
        return ubytekMasyNaStrzal;
    }

    public void setUbytekMasyNaStrzal(double ubytekMasyNaStrzal) {
        this.ubytekMasyNaStrzal = ubytekMasyNaStrzal;
    }

    public String getDataWykonania() {
        return dataWykonania;
    }

    public void setDataWykonania(String dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public void setUzytkownik_id(String uzytkownik_id) {
        this.uzytkownik_id = uzytkownik_id;
    }

    public void addEksperyment() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // wczytanie sterownika
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");//polaczenie z baza danych
            //sformulowanie zapytania sql
            String query = "INSERT INTO eksperyment (probka_id,atmosfera,mocLasera,dlugoscFali," +
                    "czestotliwosc,polePowierzchniPlamki,iloscStrzalow,ubytekMasyNaStrzal," +
                    "materialBazy,dataWykonania,uzytkownik_id,uwagi) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement select = con.prepareStatement(query);
            //dodawanie poszczegolnych zmiennych w odpowiednie kolumny tabeli
            select.setInt(1, probka_id);
            select.setString(2, atmosfera);
            select.setDouble(3, mocLasera);
            select.setInt(4, dlugoscFali);
            select.setInt(5, czestotliwosc);
            select.setDouble(6, polePowierzchniPlamki);
            select.setInt(7, iloscStrzalow);
            select.setDouble(8, ubytekMasyNaStrzal);
            select.setString(9, materialBazy);
            select.setDate(10, Date.valueOf(dataWykonania));
            select.setString(11, uzytkownik_id);
            select.setString(12, uwagi);
            select.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
    }

    public Object getProbkaIdList() {
        try {
            int nextId;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT * FROM probka";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                nextId = rs.getInt("probka_id");
                probkiListaID.add(nextId);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");
        }
        return probkiListaID;
    }

    public double getDeltaMasProbki(Integer id) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT deltaMasy FROM probka WHERE  probka_id='" + id + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                znalezionaDeltaMasyProbki = rs.getDouble("deltaMasy");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");
        }
        return znalezionaDeltaMasyProbki;
    }




    public ArrayList<Eksperyment> listaEksperymentow(){
        try {

            Eksperyment eksperyment;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT * FROM eksperyment";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                eksperyment= new Eksperyment(rs.getInt("eksperyment_id"),rs.getInt("probka_id"),
                        rs.getString("atmosfera"),rs.getDouble("mocLasera"),
                        rs.getInt("dlugoscFali"), rs.getInt("czestotliwosc"),
                        rs.getDouble("polePowierzchniPlamki"),rs.getInt("iloscStrzalow"),rs.getDouble("ubytekMasyNaStrzal"),
                        rs.getString("materialBazy"),rs.getDate("dataWykonania"),rs.getString("uzytkownik_id"),
                        rs.getString("uwagi"));
                eksperymentLista.add(eksperyment);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
        return eksperymentLista;
    }
}