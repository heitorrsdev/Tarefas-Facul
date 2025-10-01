package TEPOO.padroes_de_projeto.decorator;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
  private JTextField txtUsuario;
  private JPasswordField txtSenha;
  private JButton btnLogin;
  private JCheckBox chkLog;
  private LoginController controller;

  public LoginView() {
    setTitle("Login Decorator");
    setSize(370, 240);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    Font fonteGrande = new Font("Arial", Font.PLAIN, 30);

    JPanel painelCampos = new JPanel(new GridBagLayout());
    painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel lblUsuario = new JLabel("Usuário:");
    txtUsuario = new JTextField();
    JLabel lblSenha = new JLabel("Senha:");
    txtSenha = new JPasswordField();
    chkLog = new JCheckBox("Exibir log no console");
    chkLog.setFont(new Font("Arial", Font.BOLD, 22));

    // Linha 1
    gbc.gridx = 0;
    gbc.gridy = 0;
    painelCampos.add(lblUsuario, gbc);
    gbc.gridx = 1;
    painelCampos.add(txtUsuario, gbc);

    // Linha 2
    gbc.gridx = 0;
    gbc.gridy = 1;
    painelCampos.add(lblSenha, gbc);
    gbc.gridx = 1;
    painelCampos.add(txtSenha, gbc);

    // Linha 3 - Checkbox ocupa as duas colunas
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    painelCampos.add(chkLog, gbc);
    gbc.gridwidth = 1;

    JPanel painelBotoes = new JPanel();
    btnLogin = new JButton("Entrar");
    painelBotoes.add(btnLogin);

    add(painelCampos, BorderLayout.CENTER);
    add(painelBotoes, BorderLayout.SOUTH);

    setFontRecursively(painelCampos, fonteGrande);
    setFontRecursively(painelBotoes, fonteGrande);

    // Ação do botão vai chamar o controller
    btnLogin.addActionListener(e -> {
      if (controller != null) {
        boolean log = chkLog.isSelected();
        controller.handleLogin(txtUsuario.getText(), new String(txtSenha.getPassword()), log);
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
}
