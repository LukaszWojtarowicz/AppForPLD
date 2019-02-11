package View;

import Controller.logowanieController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logowanieView extends JFrame {
    private JPasswordField hasloTF;
    public logowanieView() {
        super("Klient bazy PLD- logowanie");
        setSize(400,250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel container = new JPanel();
        container.setLayout(null);

        JLabel loginLabel= new JLabel();
        loginLabel.setBounds(0,0,50,50);
        loginLabel.setLocation(100,10);
        loginLabel.setText("Login:");
        container.add(loginLabel);

        final JTextField loginTF = new JTextField();
        loginTF.setBounds(0,0,100,25);
        loginTF.setLocation(160,25);
        container.add(loginTF);


        JLabel hasloLabel= new JLabel();
        hasloLabel.setBounds(0,0,50,50);
        hasloLabel.setLocation(100,50);
        hasloLabel.setText("Haslo:");
        container.add(hasloLabel);

        hasloTF = new JPasswordField();
        hasloTF.setBounds(0,0,100,25);
        hasloTF.setLocation(160,65);
        container.add(hasloTF);

        JButton zalogujButton = new JButton();
        JButton nowyUzytkownikButton = new JButton();

        zalogujButton.setText("Zaloguj");
        zalogujButton.setBounds(0,0,200,30);
        zalogujButton.setLocation(100,100);
        final logowanieController controller = new logowanieController(this);
        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            controller.checkUser(loginTF.getText(), new String(hasloTF.getText()));
            if(controller.activeSesion==true){ //jesli sesja jest aktywna to uruchamia sie okno eksperymntu, a zamyka login
                new eksperymentView(controller.activeUser);
                setVisible(false);
            }
            }
        });
        container.add(zalogujButton);

        nowyUzytkownikButton.setText("Stworz konto");
        nowyUzytkownikButton.setBounds(0,0,200,30);
        nowyUzytkownikButton.setLocation(100,150);
        nowyUzytkownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dodajUzytkownikaView();

            }
        });
        container.add(nowyUzytkownikButton);

        this.add(container);
        setVisible(true);
    }

}
