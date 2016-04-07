/**
 * Intrespection utility test
 * @author Renaud Tripathi
 */

import java.lang.reflect.Field;

import java.util.Collection;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import org.greta.ppe.gsbview.GSBLoginBeta;
import org.greta.ppe.gsbutils.Reflector;

@RunWith(Parameterized.class)
public class ReflectorTest {

	private String publicName;
	private String privateName;
	private static GSBLoginBeta gui;
	private static Reflector reflector;

	@SuppressWarnings("unchecked")
	@BeforeClass
	public static void initialize() {
		ReflectorTest.gui = new GSBLoginBeta();
		ReflectorTest.reflector = new Reflector(ReflectorTest.gui);
	}

	public ReflectorTest(String publicName, String privateName) {
		this.publicName = publicName;
		this.privateName = privateName;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"s1","panel"},{"s2","decoy"},{"s3","radio"}
		});
	}

	@Test
	/**
	 * Check public field existence in an object by its name.
	 */
	public void get_public_field_test() {
		Field field = ReflectorTest.reflector.get_public_field(this.publicName);
		assertNotNull(field);
	}

	@Test
	/**
	 * Check private field existence in an object by its name.
	 */
	public void get_private_field_test() {
		Field field = ReflectorTest.reflector.get_private_field(this.privateName);
		assertNotNull(field);
	}
}
