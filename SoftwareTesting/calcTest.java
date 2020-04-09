import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calcTest {

	@Test
	void test() {
		calc cal = new calc();
		assertEquals(cal.main("2147483647"),2147483647);//inner max boundary test
	}

}