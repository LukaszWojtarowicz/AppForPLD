package Controller;
import Model.dodajUzytkownikaModel;
import View.dodajUzytkownikaView;

import javax.swing.*;



public class dodajUzytkownikaController {

    private dodajUzytkownikaView viewUzytkownik;
    private dodajUzytkownikaModel modelUzykownika;

   private boolean zablokuj=false;
    public dodajUzytkownikaController(dodajUzytkownikaView viewUzytkownik) {
        this.viewUzytkownik = viewUzytkownik;
        modelUzykownika = new dodajUzytkownikaModel();
    }

    public void dodajUzytkownika(String imie, String  nazwisko, String login, String haslo){

           modelUzykownika.setImie(imie);
           modelUzykownika.setNazwisko(nazwisko);
           modelUzykownika.setLogin(login);
           modelUzykownika.setHaslo(haslo);
           zablokuj = modelUzykownika.CheckLoginExists(login);

           if(zablokuj==false){
           modelUzykownika.addUser();
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Stworzono konto!");
           }
           else{
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Podany login istnieje!");
           viewUzytkownik.dispose();
           new dodajUzytkownikaView();
            }

    }

}
