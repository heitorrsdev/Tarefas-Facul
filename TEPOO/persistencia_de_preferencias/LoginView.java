package TEPOO.persistencia_de_preferencias;

import javax.swing.*;

import java.awt.*;

public class LoginView extends JFrame {
  private JTextField txtUsuario;
  private JPasswordField txtSenha;
  private JCheckBox chkRememberMe;
  private JButton btnLogin;
  private LoginController controller;

  public LoginView() {
    setTitle("Login com Preferências");
    setSize(400, 220);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    Font fonteGrande = new Font("Arial", Font.PLAIN, 30);

    JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));
    painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel lblUsuario = new JLabel("Usuário:");
    txtUsuario = new JTextField();

    JLabel lblSenha = new JLabel("Senha:");
    txtSenha = new JPasswordField();

    chkRememberMe = new JCheckBox("Lembrar-me");

    painelCampos.add(lblUsuario);
    painelCampos.add(txtUsuario);
    painelCampos.add(lblSenha);
    painelCampos.add(txtSenha);
    painelCampos.add(new JLabel("")); // espaço vazio
    painelCampos.add(chkRememberMe);

    JPanel painelBotoes = new JPanel();
    btnLogin = new JButton("Entrar");
    painelBotoes.add(btnLogin);

    add(painelCampos, BorderLayout.CENTER);
    add(painelBotoes, BorderLayout.SOUTH);

    setFontRecursively(painelCampos, fonteGrande);
    setFontRecursively(painelBotoes, fonteGrande);

    btnLogin.addActionListener(e -> {
      if (controller != null) {
        controller.handleLogin(
            txtUsuario.getText(),
            new String(txtSenha.getPassword()),
            chkRememberMe.isSelected());
      }
    });
  }

  public void setController(LoginController controller) {
    this.controller = controller;
  }

  public void setRememberedUser(String username) {
    txtUsuario.setText(username);
    chkRememberMe.setSelected(true);
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
}
