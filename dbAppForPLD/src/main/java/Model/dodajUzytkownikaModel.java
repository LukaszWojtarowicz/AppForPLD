package Model;


import java.sql.*;

public class dodajUzytkownikaModel {
    private Connection con;
    private Integer uzytkownik_id;
    private String imie, nazwisko, login, haslo;
    public boolean loginExists=false;

    public Integer getUzytkownik_id() {
        return uzytkownik_id;
    }

    public void setUzytkownik_id(Integer uzytkownik_id) {
        this.uzytkownik_id = uzytkownik_id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void addUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            System.out.println("polaczono z baza w dodajUztkownikow");
            String query = "INSERT INTO uzytkownicy (imie,nazwisko,login,haslo) VALUES(?,?,?,?)";
            PreparedStatement select = con.prepareStatement(query);
            //to  dodaje  konkretne value z okienka
            select.setString(1, imie);
            select.setString(2, nazwisko);
            select.setString(3, login);
            select.setString(4, haslo);
            select.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");

        }
    }


    public boolean CheckLoginExists(String loginZOkna) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plddb", "root", "");
            System.out.println("polaczono z baza w dodajUztkownikow");

            PreparedStatement st = con.prepareStatement("SELECT * FROM uzytkownicy WHERE login = '"+ login+"'");
            ResultSet r1 = st.executeQuery();
            String loginCounter;
            if (r1.next()) {
                loginCounter = r1.getString("login");
                if (loginCounter.equals(loginZOkna));
                {
                   System.out.println("Podany login istnieje!");
                    loginExists = true;
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nie polaczono z baza2");


        }
        return loginExists;
    }
}