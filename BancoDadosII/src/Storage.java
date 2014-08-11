import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Storage {

	public HashMap<Integer, Frame> Memoria;
	public HashMap<Integer, Frame> BancoDados;
	public HashMap<Integer, String> Disco;
	private LinkedList<String> Mru;
	private LinkedList<String> Lru;

	public Storage() {
		Disco = new HashMap<Integer, String>();
		Mru = new LinkedList<String>();
		Lru = new LinkedList<String>();
		
		Memoria = new HashMap<Integer, Frame>();
		for (int i = 0; i < 10; i++) {
			Frame frame = new Frame();
			frame.Page = i;
			frame.Dirt = 0;
			frame.PinCount = 0;
			Memoria.put(i, frame);
		}

		BancoDados = new HashMap<Integer, Frame>();
		File file = new File("C:\\Users\\heloisa.kopsch\\git\\bancodadosII\\BancoDadosII\\src\\BDfixo.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			int page = 0;
			while ((text = reader.readLine()) != null) {
				Frame frameBD = new Frame();
				frameBD.Page = page;
				frameBD.Dados = text;
				BancoDados.put(page, frameBD);
				page++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void Loadpage(int page) {
		Frame dado = BancoDados.get(page);
		if (!Memoria.containsValue(dado)) {
			for (Frame frame : Memoria.values()) {
				if (frame.PinCount == 0) {
					if (frame.Dirt == 0) {
						Memoria.put(frame.Page, dado);
						ChangePage(frame);
					} else {
						SavePage(frame.Page, frame.Dados);
						frame.Dirt = 0;
						Memoria.put(page, dado);
						frame.PinCount++;
					}
					break;
				}
			}
		}
		else
		{
			for (Frame frame : Memoria.values()) {
				if (frame == dado) {
					if (frame.PinCount == 0) {
						if (frame.mru) {
							Mru.remove(frame.Dados);
						}
						else
						{
							Lru.remove(frame.Dados);
						}					
					
						frame.PinCount++;
					}
					
				}
			}
			
			
		}

	}
	/* carrega pagina na memória */

	private void SavePage(int page, String dados) {
		Disco.put(page, dados);
	}
	/* salva página no disco */

	private void ChangePage(Frame frame) {
		frame.Dirt = 1;
	}
	/* altera a bloco.. marca sujo */

	public void ListaPages() {
		for (Frame item : Memoria.values()) {
			if (item.Dados != null) {
				System.out.println("Página: " + item.Page);
				System.out.println("Dirt: " +item.Dirt);
				System.out.println("PinCount: " +item.PinCount);
				System.out.println("Dados: " +item.Dados);
			}		
		}
	}
	/*
	 * lista as páginas na memória, Page, pin-count e dirt
	 */
}
