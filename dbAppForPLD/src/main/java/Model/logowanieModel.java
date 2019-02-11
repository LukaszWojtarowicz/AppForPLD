package Model;


import java.sql.*;

public class logowanieModel {
    private String login, haslo;
    private Connection con;
    public  int activeId;

    public void setLogin (String login){
        this.login = login;
    }



    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public void getUser (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb","root","");
            System.out.println("polaczono z baza");
            PreparedStatement select = con.prepareStatement("SELECT * FROM uzytkownicy WHERE login = ?");
            select.setString(1, login);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                haslo = rs.getString("haslo");
            }
            else{
                haslo = "";
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");
        }finally {
            {
                try{
                    con.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int findUserID(String login){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            String query = "SELECT uzytkownik_id FROM uzytkownicy WHERE  login='"+login+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){

                activeId = rs.getInt("uzytkownik_id");


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
        return activeId;

    }
}
