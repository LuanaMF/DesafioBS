package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Classe main da aplicação, responsável por iniciar o programa, com a tela de login, e também 
 * contém o método de trocar(setar) a tela.
 * @author Luana de Melo Fraga
 *
 */

public class Main extends Application {
	
	private static Stage palco; // Usado para facilitar a mudança de tela no programa
	
	/**
	 * Método padrão start, usado pelo JavaFX, que inicia a aplicação em termos de interface,
	 *  onde se cria a tela inicial(login) e logo em seguida a exibe.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		palco = primaryStage;
		palco.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("LoginBrasilSoftware.fxml"));
		Scene scene = new Scene(root,600,400);
		palco.setScene(scene);
		palco.show();
	}
	
	/**
	 * Método de setar (mudar) a tela, que basicamente cria uma nova cena, dado um arquivo fxml.
	 * @param fxml - Arquivo fxml que será usado na criação da nova cena.
	 * @throws IOException - Exceção sugerida pela classe "Parent".
	 */
	public void setTela(String fxml) throws IOException {
		Parent r = FXMLLoader.load(getClass().getResource(fxml));
		palco.getScene().setRoot(r);
	}
	/**
	 * Método padrão da main, que inicia a aplicação em termos de operação do sistema. Nela foi criado o usuário padrão.
	 * @see Dados
	 * @param args
	 */
	public static void main(String[] args) {
		
		Dados.getInstance().getUsers().put("admin", "1234"); // usuário padrão
		launch(args);
	}
}
