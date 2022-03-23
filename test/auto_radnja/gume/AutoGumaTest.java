package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	private AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag=null;
	}

	@Test
	void testAutoGuma() {
		assertTrue(ag != null);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Lassa 1", 21, 200, 60);
		assertEquals("Lassa 1", ag.getMarkaModel());
		assertEquals(21, ag.getPrecnik());
		assertEquals(200, ag.getSirina());
		assertEquals(60, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Lassa 1");
		assertEquals("Lassa 1", ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(NullPointerException.class, () -> ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelDuzinaStringa() {
		assertThrows(IllegalArgumentException.class, () -> ag.setMarkaModel(""));
		assertThrows(IllegalArgumentException.class, () -> ag.setMarkaModel("a"));
		assertThrows(IllegalArgumentException.class, () -> ag.setMarkaModel("ab"));
	}
	
	
	@ParameterizedTest
	@CsvSource({ "13", "14", "15", "16","17", "18", "19", "20","21","22" })
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@Test
	void testSetPrecnikVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->ag.setPrecnik(2));
	}
	

	@ParameterizedTest
	@CsvSource({ "140", "160", "180", "200","220", "240", "260", "280","300","320" })
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina, ag.getSirina());
	}
	
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->ag.setSirina(120));
	}

	@ParameterizedTest
	@CsvSource({ "30", "40", "50", "60","70", "80", "90"})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina, ag.getVisina());
	}
	
	@Test
	void testSetVisinaVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->ag.setVisina(10));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Lassa 1");
		ag.setSirina(300);
		ag.setVisina(55);
		ag.setPrecnik(16);
		
		String s = ag.toString();
		assertTrue(s.contains(ag.getMarkaModel()));
		assertTrue(s.contains(ag.getPrecnik()+""));
		assertTrue(s.contains(ag.getVisina()+""));
		assertTrue(s.contains(ag.getSirina()+""));
	}

	@ParameterizedTest
	@CsvSource({
			"LASSA1, LASSA1, 15, 15, 150,150,50,50,true",
			"LASSA1, LASSA2, 15, 15, 150,150,50,50,false",
			"LASSA1, LASSA1, 15, 16, 150,150,50,50,false",
			"LASSA1, LASSA1, 15, 15, 150,160,50,50,false",
			"LASSA1, LASSA1, 15, 15, 150,150,50,51,false",
			"LASSA2, LASSA1, 15, 15, 150,150,50,50,false",
			"LASSA2, LASSA2, 15, 21, 150,150,50,50,false",
			"LASSA1, LASSA2, 15, 15, 150,150,50,50,false",
			"LASSA2, LASSA2, 15, 15, 150,180,50,50,false",
			
	})
	void testEqualsObject(String markaModel1, String markaModel2,
			int precnik1, int precnik2,int sirina1, int sirina2,int visina1, int visina2,boolean eq) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma ag2 = new AutoGuma(markaModel2, precnik2, sirina2, visina2);
		
		assertEquals(eq, ag.equals(ag2));
	}

}
