package assn2swtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquivTest {

	@Test
	void test() {
		trigFunc t = new trigFunc();
		double output=t.Sin(Math.PI);
		assertEquals(Math.sin(Math.PI), output);

		//output=t.Cos(-2);
		//assertEquals(Math.cos(2), output);
		
		//double output=t.Tan(-2);
		//assertEquals(Math.tan(2), output);
	}

}
