import java.util.ArrayList;
import java.util.HashMap;


public class Storage {
	public String Dados; /* dados */
    public int Dirt; /* indica se est� sujo */
    public int PinCount; /* Contador de acessos */
    public int Page; /* Identifica��o do bloco */
    public int UltimoAcesso; /* �ltimo Acesso MRU e LRU*/
    public ArrayList<String> Memoria;
    public HashMap<Integer, String> BancoDados;

    public Storage()
    {
        Memoria = new ArrayList<String>();
        BancoDados = new HashMap<Integer, String>();
    }
    
    public void Loadpage(int page)
    {
    	Memoria.add(BancoDados.get(page));     
    }        
    /* carrega pagina na mem�ria */

    private void SavePage(int page, String dados)
    {

    }
    /* salva p�gina no disco */

    private void ChangePage(int page, String dados)
    {

    }
    /* altera a bloco.. marca sujo */

    private void ListaPages()
    {
    	for (Dados item : Memoria) {
			System.out.println(item.Dados);
			System.out.println(item.Page);
		}    	
    }
    /* lista as p�ginas na mem�ria, 
        Page, pin-count e dirt */
}
