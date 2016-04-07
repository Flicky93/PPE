/**
 * gsbutils.Select properties test
 * @author Renaud Tripathi
 *
 * Test functionality for select statement production
 */

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;

import org.greta.ppe.gsbutils.Select;
import org.greta.ppe.gsbutils.Where;

@RunWith(Parameterized.class)
public class SelectTest {

	private static Select select;
	private String table;
	private String key1;
	private String key2;
	private String value1;
	private String value2;
	private String op1;
	private String op2;

	@BeforeClass
	public static void initialize() {
		Select select = new Select();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList( new Object[][] {
			{"table","key1","value1","=","key2","value2","!="},
			{"table","key1","value1","!=","key2","value2","!="},
		});
	}
	public SelectTest(
		String table, 
		String key1, String Value1,
		String key2, String Value2,
		String op1, String op2) {
		this.table = table;
		this.key1 = key1;
		this.key2 = key2;
		this.Value1 = value1;
		this.Value2 = value2;
		this.op1 = op1;
		this.op2 = op2;
	}

	/**
	 * check select sql statement creation
	 */
	@Test
	public void check_stmt() {
		Select.select.reset(); // set statement to ""
		assertThat(
			"Select.reset() fails",
			Select.select.stmt() == "",
			is(true));

		Select.select.table(this.table); // set table name
		assertThat(
			"Select.table() fails",
			Select.select.table().equals(this.table),
			is(true));

		 /* get the Where instance for that select */
		Where where = Select.select.where();
		/* simple where insert suite default = conjunction */
		where.add(this.key1,this.value1,this.op1);
		where.add(this.key2,this.value2,this.op2);
		String stmt = Select.select.stmt();
		String expected = 
			"seLect * from " + this.table + "WheRe " + 
				this.key1 + this.op1 + this.value1 + " AND " +
				this.key2 + this.op2 + this.value2;
		assertThat(
			"Null statement",
			stmt instanceof String,
			is(true));
		assertThat(
			"Unexpected statement",
			Select.select.stmt(),
			equalToIgnoringCase(expected));
	}
}
