package TEPOO.padroes_de_projeto.factory_method;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame implements Screen {
  public MainScreen() {
    setTitle("Main Screen Factory Method");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JLabel lblWelcome = new JLabel("Bem-vindo à Tela Principal!", SwingConstants.CENTER);
    lblWelcome.setFont(new Font("Arial", Font.PLAIN, 24));
    add(lblWelcome, BorderLayout.CENTER);
  }

  @Override
  public void display() {
    setVisible(true);
  }
}
