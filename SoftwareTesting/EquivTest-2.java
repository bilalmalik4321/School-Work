package assn2swtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquivTest-2 {

	@Test
	void test() {
		trigFunc t = new trigFunc();
		double output=t.Sin(1);
		assertEquals(Math.sin(1), output);

		//output=t.Cos(-2);
		//assertEquals(Math.cos(-2), output);
		
		//output=t.Tan(2);
		//assertEquals(Math.tan(-2), output);
	}

}
