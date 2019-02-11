package Controller;

import Model.logowanieModel;
import View.eksperymentView;
import View.logowanieView;

import javax.swing.*;

public class logowanieController {
    private logowanieView view;
    private logowanieModel model;
    public boolean activeSesion;
    public String  activeUser;

    public logowanieController(logowanieView view){
        this.view = view;
        model = new logowanieModel();
    }
    public void checkUser(String login, String haslo){
        model.setLogin(login);
        model.getUser();
        if(haslo.equals(model.getHaslo())){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Zalogowano jako: " + login);
            activeSesion = true;
            activeUser = login;
            wpiszIdUzytkownika(activeUser);
        }  else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Login lub haslo niepoprawne!");
        }
    }

    public int wpiszIdUzytkownika(String wykonujacy){
        int znaleziony;
        znaleziony = model.findUserID(wykonujacy);
       return znaleziony;
    }

}
