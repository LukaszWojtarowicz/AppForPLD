package Model;

import java.sql.*;
import java.util.ArrayList;


public class probkaModel
{
    private Connection con;
    private Integer material_id;
    private Double promien,grubosc,masaPoczatkowa,masaKoncowa, deltaMasy;
    public  ArrayList<Object>  materialyListaID = new ArrayList<>();
    private  ArrayList<Probka> probkiLista = new ArrayList<>();
    public Double getPromien() {
        return promien;
    }

    public void setPromien(Double promien) {
        this.promien = promien;
    }

    public Double getGrubosc() {
        return grubosc;
    }

    public void setGrubosc(Double grubosc) {
        this.grubosc = grubosc;
    }

    public Double getMasaPoczatkowa() {
        return masaPoczatkowa;
    }

    public void setMasaPoczatkowa(Double masaPoczatkowa) {
        this.masaPoczatkowa = masaPoczatkowa;
    }

    public Double getMasaKoncowa() {
        return masaKoncowa;
    }

    public void setMasaKoncowa(Double masaKoncowa) {
        this.masaKoncowa = masaKoncowa;
    }

    public Double getDeltaMasy() {
        return deltaMasy;
    }

    public void setDeltaMasy(Double deltaMasy) {
        this.deltaMasy = deltaMasy;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }




    public void addProbka(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            System.out.println("polaczono z baza w dodajProbke");
            String query = "INSERT INTO probka (material_id,promien,grubosc,masaPoczatkowa,masaKoncowa,deltaMasy) VALUES(?,?,?,?,?,?)";
            PreparedStatement select = con.prepareStatement(query);
            //to  dodaje  konkretne value z okienka
            select.setInt(1, material_id);
            select.setDouble(2, promien);
            select.setDouble(3, grubosc);
            select.setDouble(4, masaPoczatkowa);
            select.setDouble(5,masaKoncowa);
            select.setDouble(6,deltaMasy);
            select.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
    }
   public Object getMaterialIdList(){
        try {
            int nextId;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT * FROM materialtarczy";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){

                    nextId = rs.getInt("material_id");
                    materialyListaID.add(nextId);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
        return materialyListaID;
    }

    public ArrayList<Probka> listaProbek(){
        try {

            Probka probka;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT * FROM probka";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                probka= new Probka(rs.getInt("probka_id"),rs.getInt("material_id"),rs.getDouble("promien"),rs.getDouble("grubosc"), rs.getDouble("masaPoczatkowa"), rs.getDouble("masaKoncowa"), rs.getDouble("deltaMasy"));
                probkiLista.add(probka);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
        return probkiLista;
    }
}
