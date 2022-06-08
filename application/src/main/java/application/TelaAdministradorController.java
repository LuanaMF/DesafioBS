package application;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFileChooser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Classe de controle da tela de Administrador, todas operações dessa cena são feitas aqui.
 * @author Luana de Melo Fraga
 *
 */
public class TelaAdministradorController {
	
	@FXML
	private TextField imagemPath;
	@FXML
	private Button adicionaImg;
	@FXML
	private Button geraLink;
	@FXML
	private TextField link;
	@FXML
	private String caminhoFoto; // Onde é salvo o caminhos dos gifs.
	
	/**
	 * Método que é acionado quando o botão "adicionaImg" é clicado, e nele, com ajuda da classe JFileChooser, é aberto o explorador de arquivos 
	 * no computador do usuário para que ele consiga selecionar o gif desejado, depois esse caminho é salvo e exibido num campo de texto.
	 * @see JFileChooser
	 */
	public void adiciona(){
		
		JFileChooser arquivo = new JFileChooser();
		arquivo.setDialogTitle("Selecione o GIF");
		arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int op = arquivo.showOpenDialog(null);
		
		if (op == 1){
			imagemPath.setText("");
	    } else {
	    	File file = arquivo.getSelectedFile();
			setCaminhoFoto(file.getAbsolutePath());
			imagemPath.setText(file.getPath());
	    }
	}
	
	/**
	 * Método que é acionado quando o botão "geraLink", e nele, primeiramente, é criado é "importado" o gif para dentro do sistema, 
	 * depois, com ajuda de algumas classes é "importado" um arquivo .js, contendo a função "caminho", que é invocada para guardar
	 * o nome do gif naquele arquivo - applicationJS.js. Depois disso, o link é exbido num campo de texto.
	 * 
	 * @see applicationJS.js
	 * @see ScriptEngine
	 * @see ScriptEngineManager
	 * @see Invocable
	 * 
	 * @throws IOException
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 */
	public void gera() throws IOException, ScriptException, NoSuchMethodException {
		
		File gif = new File(caminhoFoto);
		 
		carregaImagem(gif); 

		link.setText(link());
	}
	
	/**
	 * Método usado em "gera()" para carregar a pagina web e retorna seu link.
	 * @return o link da página
	 */
	private String link() { 
		 URI link = null;
		try{
		    link = new URI("http://localhost:8080/application/public/Pagina.html");
		        Desktop.getDesktop().browse(link);
		    }catch(Exception erro){
		            System.out.println(erro);
		        
		    }
		return link.toString();
	}
	
	/**
	 * Método que "importa" a imagem .gif para o sistema para ser adicionada a página web. Dado o gif e um caminho, é criado um buffer para 
	 * ajudar a "escrever" o gif na nova pasta.
	 * @param gif - Gif a ser importado
	 * @throws IOException
	 */
	private void carregaImagem(File gif) throws IOException {
		
		 FileOutputStream fileOut = new FileOutputStream("C:\\eclipse-workspace\\estagio\\application\\src\\main\\java\\application\\webapp\\public\\p.gif"); //destino do gif
		 FileInputStream fileIn = new FileInputStream(gif); // gif
	     BufferedInputStream in = new BufferedInputStream(fileIn);
	     BufferedOutputStream out = new BufferedOutputStream(fileOut);

	     byte[] buffer = new byte[10240];
	     int len = 0;

	     while((len = in.read(buffer)) > 0) // "ler" o gif e o "escreve" no caminho
	     {
	          out.write(buffer, 0 , len);
	     }

	     in.close();
	     out.close();
	}
	
	// método set para atributo "caminhoFoto"
	private void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}
}
