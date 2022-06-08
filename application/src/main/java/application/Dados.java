package application;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por armazenar os dados que serão usados na aplicação. Para garantir que haverá apenas uma instancia dessa classe 
 * em todo o programa, foi implementado o padrão de design Singleton. Atualmente é armazenado apenas os usuários.
 * 
 * @author Luana de Melo Fraga
 *
 */
public class Dados {
	
	private Map<String, String> users = new HashMap<String, String>(); 
	private static Dados instance; // instancia única da classe
	
	private Dados() {
		
	}
	/**
	 * Método referente ao padrão Singleton, é ele que é chamado quando se quer instanciar essa classe. Nele, primeiramente, é verificado 
	 * se a instancia(única) já foi criada, se sim, ele a retorna, caso contrário, a instancia é criada.
	 * @return
	 */
	public static synchronized Dados getInstance() {
		if(instance == null) {
			instance = new Dados();
		}
		return instance;
	}
	
	// getters e setters da classe
	public Map<String, String> getUsers() {
		return users;
	}
	public void setUsers(Map<String, String> users) {
		this.users = users;
	}

}
