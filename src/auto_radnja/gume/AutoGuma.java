package auto_radnja.gume;
/**
 * Predstavlja gumu automobila koja ima svoju marku i model, precnik, sirinu i visinu
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class AutoGuma {
	/**
	 * Marka i model gume
	 */
	private String markaModel = null;
	/**
	 * Precnik gume
	 */
	private int precnik = -1;
	/**
	 * Sirina gume
	 */
	private int sirina = -1;
	/**
	 * Visina gume
	 */
	private int visina = -1;
	/**
	 * Neparametrizovani konstruktor klase AutoGuma koji postavlja vrednosti atributa na predefinisane vrednosti.
	 */
	public AutoGuma() {
	}
	/**
	 * Parametrizovani konstruktor klase AutoGuma koji postavlja marku i model, precnik, sirinu i visinu na unete vrednosti.
	 * 
	 * @param markaModel nova marka i model
	 * @param precnik novi precnik
	 * @param sirina nova sirina
	 * @param visina nova visina
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	/**
	 * Vraca marku i model automobilske gume
	 * @return marka i model automobilske gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	/**
	 * Postavlja  novu vrednost za atribut markaModel
	 * @param markaModel nova marka i model gume
	 * @throws java.lang.NullPointerException ako je uneta markaModel null
	 * @throws java.lang.IllegalArgumentException ako je uneta markaModel String duzine manje od 3
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	/**
	 * Vraca precnik gume
	 * @return precnik gume kao int
	 */
	public int getPrecnik() {
		return precnik;
	}
	/**
	 * Postavlja novu vrednost za atribut precnik
	 * @param precnik novi precnik gume
	 * @throws java.lang.IllegalArgumentException ako je uneti precnik van opsega, odnosno manji od 13, a veci od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}
	/**
	 * Vraca sirinu gume
	 * @return sirina gume kao int
	 */
	public int getSirina() {
		return sirina;
	}
	/**
	 * Postavlja novu vrednost za atribut sirina
	 * @param sirina nova sirina gume
	 * @throws java.lang.IllegalArgumentException ako je uneta sirina van opsega, odnosno manja od 135, a veca od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}
	/**
	 * Vraca visinu gume
	 * @return visina gume kao int
	 */
	public int getVisina() {
		return visina;
	}
	/**
	 * Postavlja novu vrednost za atribut visina
	 * @param visina nova visina gume
	 * @throws java.lang.IllegalArgumentException ako je uneta visina van opsega, odnosno manja od 25, a veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}
	/**
	 * Vraca sve podatke o gumi u jednom String-u.
	 * @return String sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}
	/**
	 * Poredi dve gume po atributima markaModel, precnik, visina i sirina
	 * 
	 * @return
	 * <ul>
	 * <li>true - ako su markaModel, visina, sirina i precnik isti</li>
	 * <li>false - ako to nije slucaj</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
