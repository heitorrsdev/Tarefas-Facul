package TEPOO.padroes_de_projeto.strategy;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
  private JTextField txtUsuario;
  private JPasswordField txtSenha;
  private JButton btnLogin;
  private JComboBox<String> cmbStrategy;
  private LoginController controller;

  public LoginView() {
    setTitle("Login Strategy");
    setSize(400, 250);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    Font fonteGrande = new Font("Arial", Font.PLAIN, 30);

    JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5)); // 3 linhas para usuário, senha e estratégia
    painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel lblUsuario = new JLabel("Usuário:");
    txtUsuario = new JTextField();

    JLabel lblSenha = new JLabel("Senha:");
    txtSenha = new JPasswordField();

    JLabel lblStrategy = new JLabel("Estratégia:");
    cmbStrategy = new JComboBox<>(new String[] { "SimpleAuth", "RegexAuth" });

    painelCampos.add(lblUsuario);
    painelCampos.add(txtUsuario);
    painelCampos.add(lblSenha);
    painelCampos.add(txtSenha);
    painelCampos.add(lblStrategy);
    painelCampos.add(cmbStrategy);

    JPanel painelBotoes = new JPanel();
    btnLogin = new JButton("Entrar");
    painelBotoes.add(btnLogin);

    add(painelCampos, BorderLayout.CENTER);
    add(painelBotoes, BorderLayout.SOUTH);

    setFontRecursively(painelCampos, fonteGrande);
    setFontRecursively(painelBotoes, fonteGrande);
    btnLogin.setFont(fonteGrande);

    // Ação do botão vai chamar o controller
    btnLogin.addActionListener(e -> {
      if (controller != null) {
        controller.handleLogin(
          txtUsuario.getText(),
          new String(txtSenha.getPassword()),
          (String) cmbStrategy.getSelectedItem()
        );
      }
    });
  }

  public void setController(LoginController controller) {
    this.controller = controller;
  }

  public void showMessage(String message, String title) {
    JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  // Método utilitário para aplicar fonte a todos os componentes de um container
  private void setFontRecursively(Container container, Font font) {
    for (Component comp : container.getComponents()) {
      comp.setFont(font);
      if (comp instanceof Container) {
        setFontRecursively((Container) comp, font);
      }
    }
  }

  public String getSelectedStrategy() {
    return (String) cmbStrategy.getSelectedItem();
  }
}
