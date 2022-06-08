package application;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Classe de controle da tela de Login, todas operações dessa cena são feitas aqui.
 * @author Luana de Melo Fraga
 *
 */
public class LoginController {
	
	public LoginController() {
		
	}
	
	@FXML
	private Button botaoLogin;
	
	@FXML
	private TextField usuario;
	
	@FXML
	private PasswordField senha;
	
	@FXML
	private Label mensagem;
	
	/**
	 * Método que é chamado quando o botão "botaoLogin" é clicado, nele há duas verificações: Se algum campo (usuário ou senha) está vazio, 
	 * que pede ao usuário para preencher essas informações caso estejam, e outra que valida o login, ou seja, verifica se o usuário e senha
	 * informados correspondem a algum registrado no sistema, caso haja, o usúario sera encaminhado para a próxima cena(Tela de Adminisrador),
	 * já se não houver, uma mensagem de erro será exibida.
	 * 
	 * @see Main.setTela()
	 * @throws IOException - Exceção do metódo setTela()
	 */
	public void logar() throws IOException {
		
		if(usuario.getText().isEmpty() || senha.getText().isEmpty()) {
			mensagem.setTextFill(Color.RED);
			mensagem.setText("Informe seus dados para continuar");
		}
		Main m = new Main();
		boolean verifica = verificaLogin(usuario.getText(), senha.getText());
		
        if(verifica == true) {
        	mensagem.setTextFill(Color.GREEN);
        	m.setTela("TelaDeAdministrador.fxml");
        }
		else {
			mensagem.setTextFill(Color.RED);
			mensagem.setText("Usuário ou senha incorreta!");
		}
		
	}
	
	/**
	 * Método que, de fato, faz a validação do login, verificando primeiramente se o usuário existe, e depois, se a senha corresponde a registrada.
	 * @see Dados
	 * @param usuario - Username informado.
	 * @param senha - Senha informado.
	 * @return uma variável do tipo boolean, sendo true se o usuário e senha estiverem corretos, e false caso contrário.
	 */
	private boolean verificaLogin(String usuario, String senha) {
		boolean bol = false;
		if(Dados.getInstance().getUsers().containsKey(usuario)) {
			if(Dados.getInstance().getUsers().get(usuario).equals(senha)) {
				bol = true;
			}
		}
		return bol;
	}
}
