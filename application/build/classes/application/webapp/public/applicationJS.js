/**
* Arquivo .js, que altera a imagem diretamente no arquivo html.
*/

// variável que guardará o caminho(nome) do gif animado no arquivo.
var path = "";

/**
* Função que é invocada na aplicação java que pega o caminho e o armazena nesse arquivo, na varável "path"
*/
function caminho(caminho){
	path = caminho;
	return path
}

/**
*
*/
function getPath(img){
 
  img.scr("p.gif");
   
   
}

