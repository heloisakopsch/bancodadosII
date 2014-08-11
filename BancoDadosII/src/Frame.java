
public class Frame {
	public String Dados; /* dados */
	public int Dirt; /* indica se está sujo */
	public int PinCount; /* Contador de acessos */
	public int Page; /* Identificação do bloco */
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
