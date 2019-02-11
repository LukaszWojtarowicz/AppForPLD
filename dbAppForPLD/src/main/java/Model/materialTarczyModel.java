package Model;

import java.sql.*;
import java.util.ArrayList;

public class materialTarczyModel {
    private Double gestosc;
    private String symbol;
    private Integer id;
    private Connection connectionMaterial;

    private  ArrayList<Material>  materialyLista = new ArrayList<>();

    public double getGestosc() {
        return this.gestosc;
    }
    public void setGestosc(Double gestosc) {
        this.gestosc = gestosc;
    }
    public String getSymbol() {
        return this.symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public void add() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connectionMaterial = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            System.out.println("polaczono z baza w materiale");
            String query = "INSERT INTO materialtarczy (symbol,gestosc) VALUES(?,?)";
            PreparedStatement select = connectionMaterial.prepareStatement(query);
             //to  dodaje  konkretne value z okienka
            select.setString(1,symbol);
            select.setDouble(2,gestosc);
            select.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
    }

    public ArrayList<Material> listaMaterialow(){
        try {

            Material material;
            Class.forName("com.mysql.jdbc.Driver");
            connectionMaterial = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT * FROM materialtarczy";
            Statement st = connectionMaterial.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                material= new Material(rs.getInt("material_id"),rs.getString("symbol"),rs.getDouble("gestosc"));
                materialyLista.add(material);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
        return materialyLista;
    }




}