
public class Plantation<T> {

	T typePlantation;
	String adressejardin;
	

	public Plantation(T plant, String ad) {

		this.typePlantation = plant;
		this.adressejardin=ad;
		
	}

	public T getTypePlantation() {
		return typePlantation;
	}

	public void setTypePlantation(T typePlantation) {
		this.typePlantation = typePlantation;
	}

	public String getAdressejardin() {
		return adressejardin;
	}

	public void setAdressejardin(String adressejardin) {
		this.adressejardin = adressejardin;
	}

	@Override
	public String toString() {
		return "Plantation [typePlantation=" + typePlantation + ", adressejardin=" + adressejardin
				+ ", getTypePlantation()=" + getTypePlantation() + ", getAdressejardin()=" + getAdressejardin() + "]";
	}

	

}
