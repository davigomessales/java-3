package challenge;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MainTest {

	@Test
	public void q1() throws Exception {
		assertEquals(164, new Main().q1());
	}

	@Test
	public void q2() throws Exception {
		assertEquals(647, new Main().q2());
	}

	@Test
	public void q3() throws Exception {
		String[] expected = {
				"C. Ronaldo dos Santos Aveiro",
				"Lionel Messi",
				"Neymar da Silva Santos Jr.",
				"Luis Suárez",
				"Manuel Neuer",
				"Robert Lewandowski",
				"David De Gea Quintana",
				"Eden Hazard",
				"Toni Kroos",
				"Gonzalo Higuaín",
				"Sergio Ramos García",
				"Kevin De Bruyne",
				"Thibaut Courtois",
				"Alexis Sánchez",
				"Luka Modrić",
				"Gareth Bale",
				"Sergio Agüero",
				"Giorgio Chiellini",
				"Gianluigi Buffon",
				"Paulo Dybala",
		};

		List<String> result = new Main().q3();

		assertNotNull(result);
		assertEquals(Arrays.asList(expected), result);
	}

	@Test
	public void q4() throws Exception {
		String[] expected = {
				"Neymar da Silva Santos Jr.",
				"Lionel Messi",
				"Luis Suárez",
				"C. Ronaldo dos Santos Aveiro",
				"Eden Hazard",
				"Toni Kroos",
				"Kevin De Bruyne",
				"Antoine Griezmann",
				"Robert Lewandowski",
				"Gareth Bale"
		};

		List<String> result = new Main().q4();

		assertNotNull(result);
		assertEquals(Arrays.asList(expected), result);
	}

	@Test
	public void q5() throws Exception {
		String[] expected = {
				"Barry Richardson",
				"Essam El Hadary",
				"Óscar Pérez",
				"Jimmy Walker",
				"Danny Coyne",
				"Chris Day",
				"Joaquim Manuel Sampaio Silva",
				"Kjetil Wæhler",
				"Timmy Simons",
				"Benjamin Nivet"
		};

		List<String> result = new Main().q5();

		assertNotNull(result);
		assertEquals(Arrays.asList(expected), result);
	}

	@Test
	public void q6() throws Exception {

		Map<Integer, Integer> expected = new HashMap<>();

		expected.put(47, 1);
		expected.put(44, 2);
		expected.put(43, 2);
		expected.put(41, 3);
		expected.put(40, 4);
		expected.put(39, 18);
		expected.put(38, 38);
		expected.put(37, 69);
		expected.put(36, 137);
		expected.put(35, 188);
		expected.put(34, 271);
		expected.put(33, 610);
		expected.put(32, 506);
		expected.put(31, 666);
		expected.put(30, 807);
		expected.put(29, 1127);
		expected.put(28, 1053);
		expected.put(27, 1153);
		expected.put(26, 1199);
		expected.put(25, 1515);
		expected.put(24, 1321);
		expected.put(23, 1395);
		expected.put(22, 1324);
		expected.put(21, 1275);
		expected.put(20, 1252);
		expected.put(19, 1088);
		expected.put(18, 682);
		expected.put(17, 270);
		expected.put(16, 18);

		Map<Integer, Integer> result = new Main().q6();

		assertNotNull(result);
		assertEquals(expected, result);
	}

}
