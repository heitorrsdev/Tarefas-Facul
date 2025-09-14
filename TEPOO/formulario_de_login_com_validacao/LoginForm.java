package TEPOO.formulario_de_login_com_validacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginForm extends JFrame {

  private JTextField txtUsuario;
  private JPasswordField txtSenha;
  private JButton btnLogin;

  public LoginForm() {
    // Configuração básica da janela
    setTitle("Formulário de Login");
    setSize(350, 200);
    setLocationRelativeTo(null); // Centraliza a tela
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    Font fonteGrande = new Font("Arial", Font.PLAIN, 30);

    // Painel de campos
    JPanel painelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
    painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel lblUsuario = new JLabel("Usuário:");
    txtUsuario = new JTextField();

    JLabel lblSenha = new JLabel("Senha:");
    txtSenha = new JPasswordField();

    painelCampos.add(lblUsuario);
    painelCampos.add(txtUsuario);
    painelCampos.add(lblSenha);
    painelCampos.add(txtSenha);

    // Aplica a fonte a todos os componentes do painel
    setFontRecursively(painelCampos, fonteGrande);

    // Painel do botão
    JPanel painelBotoes = new JPanel();
    btnLogin = new JButton("Entrar");
    painelBotoes.add(btnLogin);

    // Aplica a fonte ao botão
    btnLogin.setFont(fonteGrande);

    // Adiciona os painéis à janela
    add(painelCampos, BorderLayout.CENTER);
    add(painelBotoes, BorderLayout.SOUTH);

    // Ação do botão
    btnLogin.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        validarLogin();
      }
    });
  }

  private void showMessage(String message, String title, int messageType) {
    JLabel label = new JLabel(message);
    label.setFont(new Font("Arial", Font.PLAIN, 30));
    JOptionPane.showMessageDialog(this, label, title, messageType);
  }

  private void validarLogin() {
    String usuario = txtUsuario.getText().trim();
    String senha = new String(txtSenha.getPassword()).trim();

    if (usuario.isEmpty() && senha.isEmpty()) {
      showMessage("Usuário e senha não podem estar vazios.", "Erro", JOptionPane.ERROR_MESSAGE);
    } else if (usuario.isEmpty()) {
      showMessage("O campo Usuário não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    } else if (senha.isEmpty()) {
      showMessage("O campo Senha não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    if (usuario.equals("admin") && senha.equals("123")) {
      showMessage("Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } else {
      showMessage("Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
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
