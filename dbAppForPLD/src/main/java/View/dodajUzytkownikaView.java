package View;

import javax.swing.*;

import Controller.dodajUzytkownikaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dodajUzytkownikaView extends JFrame {


    private final dodajUzytkownikaController controllerUzytkownika;

    public dodajUzytkownikaView(){
        super("Klient bazy PLD - Tworzenie konta użytkownika");
        setSize(350,300);
        setResizable(false);
      // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controllerUzytkownika = new dodajUzytkownikaController(this);
        JPanel uzyktownikContainer = new JPanel();
        uzyktownikContainer.setLayout(null);

        JLabel imieLabel = new JLabel();
        JLabel nazwiskolabel = new JLabel();
        JLabel loginLabel =  new JLabel();
        JLabel hasloLabel  = new JLabel();
        JButton stworzButton = new JButton();


        final JTextField imieTF = new JTextField();
        final JTextField nazwiskoTF = new JTextField();
        final JTextField loginTF = new JTextField();
        final JPasswordField hasloTF = new JPasswordField();


        imieLabel.setText("Imię:");
        imieLabel.setBounds(0,0,70,25);
        imieLabel.setLocation(10,10);
        uzyktownikContainer.add(imieLabel);

        imieTF.setSize(150,30);
        imieTF.setLocation(100,10);
        uzyktownikContainer.add(imieTF);

        nazwiskolabel.setText("Nazwisko:");
       nazwiskolabel.setBounds(0,0,70,25);
       nazwiskolabel.setLocation(10,60);
       uzyktownikContainer.add(nazwiskolabel);

       nazwiskoTF.setBounds(0,0,150,30);
       nazwiskoTF.setLocation(100,60);
       uzyktownikContainer.add(nazwiskoTF);

       loginLabel.setText("Login:");
       loginLabel.setBounds(0,0,70,25);
       loginLabel.setLocation(10,110);
       uzyktownikContainer.add(loginLabel);

       loginTF.setBounds(0,0,150,30);
       loginTF.setLocation(100,110);
       uzyktownikContainer.add(loginTF);

        hasloLabel.setText("Hasło:");
        hasloLabel.setBounds(0,0,70,25);
        hasloLabel.setLocation(10, 160);
        uzyktownikContainer.add(hasloLabel);

        hasloTF.setBounds(0,0,150,30);
        hasloTF.setLocation(100,160);
        uzyktownikContainer.add(hasloTF);

        stworzButton.setBounds(0,0,250,30);
        stworzButton.setLocation(50,210);
        stworzButton.setText("Stwórz konto");
        stworzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerUzytkownika.dodajUzytkownika(imieTF.getText(), nazwiskoTF.getText(), loginTF.getText(), hasloTF.getText());
                dispose();

            }
        });
        uzyktownikContainer.add(stworzButton);

        this.add(uzyktownikContainer);
        setVisible(true);
    }
}
