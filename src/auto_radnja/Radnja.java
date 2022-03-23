package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju sa gumama.
 * Sadrzi operacije dodavanja, pretrage i vracanja svih guma
 * @version 1.0
 * @author Dragica Ljubisavljevic
 *
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u radnju.
	 * 
	 * Guma se dodaje u radnju samo ukoliko nije null i ukoliko ona vec ne postoji u radnji
	 * @param a nova guma koja se dodaje u radnju
	 * @throws java.lang.NullPointerException  ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Pronalazi i vraca listu sa svim gumama iz radnje koje zadovoljavaju uslov pretrage.
	 * Pretraga se vrsi po marki i modelu gume.
	 * @param markaModel - marka i model po kojoj se guma pretrazuje
	 * @return Lista guma koja sadrzi sve gume koje odgovaraju uslovu pretrage.
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	/**
	 * Vraca sve gume iz radnje 
	 * @return Lista sa svim gumama iz radnje
	 */
	List<AutoGuma> vratiSveGume();
}
