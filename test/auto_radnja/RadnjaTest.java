package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma("LASSA1", 15, 150, 50);
		radnja.dodajGumu(ag);
		
		assertEquals(radnja.vratiSveGume().size(), 1);
		assertEquals(radnja.vratiSveGume().get(0), ag);
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(NullPointerException.class, () -> radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuViseGuma() {
		AutoGuma ag1 = new AutoGuma("LASSA1", 15, 160, 50);
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma("LASSA1", 16, 150, 60);
		radnja.dodajGumu(ag2);
		
		assertEquals(radnja.vratiSveGume().size(), 2);
		assertTrue(radnja.vratiSveGume().contains(ag1));
		assertTrue(radnja.vratiSveGume().contains(ag2));
	}
	
	@Test
	void testDodajGumuPostojeca() {
		AutoGuma ag = new AutoGuma("LASSA1", 15, 160, 50);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("LASSA1", 15, 160, 50);
		assertThrows(RuntimeException.class, () -> radnja.dodajGumu(ag2));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiNijedanRezultat() {
		AutoGuma ag = new AutoGuma("LASSA2", 15, 160, 50);
		radnja.dodajGumu(ag);
		
		assertEquals(0, radnja.pronadjiGumu("LASSA1").size());
	}
	
	@Test
	void testPronadjiGumuJednu() {
		AutoGuma ag = new AutoGuma("LASSA1", 15, 160, 50);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("LASSA2", 17, 200, 45);
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> lista = radnja.pronadjiGumu("LASSA2");
		
		assertEquals(1, lista.size());
		assertTrue(lista.contains(ag2));
	}
	
	@Test
	void testPronadjuGumuViseRezultata() {
		AutoGuma ag = new AutoGuma("LASSA1", 17, 210, 40);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("LASSA2", 17, 200, 45);
		radnja.dodajGumu(ag2);
		
		AutoGuma ag3 = new AutoGuma("LASSA2", 18, 180, 40);
		radnja.dodajGumu(ag3);
		
		List<AutoGuma> lista = radnja.pronadjiGumu("LASSA2");
		
		assertEquals(2, lista.size());
		assertTrue(lista.contains(ag2));
		assertTrue(lista.contains(ag3));
	}
	
	@Test
	void testVratiSveGume() {
		AutoGuma ag = new AutoGuma("LASSA1", 15, 160, 50);
		radnja.dodajGumu(ag);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(ag));
	}

}
