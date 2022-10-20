package generic2;

public class Plantation<T1,T2> {

	T1 typePlantation;
	T2 adressejardin;
	

	public Plantation(T1 a,T2 b) {

		this.typePlantation = a;
		this.adressejardin=b;
		
	}

	public T1 getTypePlantation() {
		return typePlantation;
	}

	public void setTypePlantation(T1 typePlantation) {
		this.typePlantation = typePlantation;
	}

	public T2 getAdressejardin() {
		return adressejardin;
	}

	public void setAdressejardin(T2 adressejardin) {
		this.adressejardin = adressejardin;
	}

	@Override
	public String toString() {
		return "Plantation [typePlantation=" + typePlantation + ", adressejardin=" + adressejardin
				+ ", getTypePlantation()=" + getTypePlantation() + ", getAdressejardin()=" + getAdressejardin() + "]";
	}

	

}
