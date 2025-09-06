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
    lblUsuario.setFont(fonteGrande);
    txtUsuario = new JTextField();
    txtUsuario.setFont(fonteGrande);

    JLabel lblSenha = new JLabel("Senha:");
    lblSenha.setFont(fonteGrande);
    txtSenha = new JPasswordField();
    txtSenha.setFont(fonteGrande);

    painelCampos.add(lblUsuario);
    painelCampos.add(txtUsuario);
    painelCampos.add(lblSenha);
    painelCampos.add(txtSenha);

    // Painel do botão
    JPanel painelBotoes = new JPanel();
    btnLogin = new JButton("Entrar");
    btnLogin.setFont(fonteGrande);
    painelBotoes.add(btnLogin);

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
}
