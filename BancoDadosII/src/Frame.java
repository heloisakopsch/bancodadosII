
public class Frame {
	public String Dados; /* dados */
	public int Dirt; /* indica se est� sujo */
	public int PinCount; /* Contador de acessos */
	public int Page; /* Identifica��o do bloco */
	public boolean  mru;
	
	public void decrementPin_count(int dirty, boolean mru) {
		if (PinCount != 0)
		{
			PinCount--;
			Dirt = dirty;
			this.mru = mru;
		}
	}
}
