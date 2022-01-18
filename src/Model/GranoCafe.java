package Model;

public class GranoCafe {

	private int nGranos = 0;

	//Obtiene el numero de granos de cafe
	public int getnGranos() {
		return this.nGranos;
	}

	//Aumena el número de granos de café conforme los trabajadores los van contando
	public int incrementa() {
		this.nGranos++;
		return nGranos;
	}

}
