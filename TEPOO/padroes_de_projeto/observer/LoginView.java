package TEPOO.padroes_de_projeto.observer;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
  private JButton btnLogin;
  private JLabel statusLabel;
  private JPasswordField txtSenha;
  private JTextArea logArea;
  private JTextField txtUsuario;
  private LoginSubject subject;

  public LoginView() {
    setTitle("Login Observer");
    setSize(350, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    Font fonteGrande = new Font("Arial", Font.PLAIN, 30);

    // ajuste o tamanho da tela para suportar 4 linhas e 2 colunas
    JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
    painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel lblUsuario = new JLabel("Usuário:");
    txtUsuario = new JTextField();

    JLabel lblSenha = new JLabel("Senha:");
    txtSenha = new JPasswordField();

    JTextArea logArea = new JTextArea(5, 20);
    logArea.setEditable(false);
    this.logArea = logArea;

    JScrollPane scrollPane = new JScrollPane(logArea);
    add(scrollPane, BorderLayout.EAST);
    
    this.statusLabel = new JLabel("Status: Aguardando login...");
    add(this.statusLabel, BorderLayout.NORTH);

    painelCampos.add(lblUsuario);
    painelCampos.add(txtUsuario);
    painelCampos.add(lblSenha);
    painelCampos.add(txtSenha);
    painelCampos.add(this.statusLabel);
    painelCampos.add(scrollPane);

    JPanel painelBotoes = new JPanel();
    btnLogin = new JButton("Entrar");
    painelBotoes.add(btnLogin);

    add(painelCampos, BorderLayout.CENTER);
    add(painelBotoes, BorderLayout.SOUTH);

    setFontRecursively(painelCampos, fonteGrande);
    setFontRecursively(painelBotoes, fonteGrande);

    // Ação do botão vai chamar o subject
    btnLogin.addActionListener(e -> {
      if (subject != null) {
        subject.handleLogin(txtUsuario.getText(), new String(txtSenha.getPassword()));
      }
    });

  }

  public void setSubject(LoginSubject subject) {
    this.subject = subject;
  }

  public void showMessage(String message, String title) {
    JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
  }


  public LoginSubject getSubject() {
    return this.subject;
  }

  public JTextArea getLogArea() {
    return this.logArea;
  }

  public JLabel getStatusLabel() {
    return this.statusLabel;
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
