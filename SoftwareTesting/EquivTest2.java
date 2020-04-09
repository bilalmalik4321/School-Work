package assn2swtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquivTest2 {

	@Test
	void test() {
		trigFunc t = new trigFunc();
		double output=t.Sin(0);
		assertEquals(Math.sin(0), output);

		//double output=t.Cos(0);
		//assertEquals(Math.cos(0), output);
		
		//output=t.Tan(0);
		//assertEquals(Math.tan(2), output);
	}

}
