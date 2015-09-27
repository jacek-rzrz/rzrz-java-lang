package rzrz.java.lang;

import org.junit.Assert;
import org.junit.Test;
import rzrz.java.lang.Exceptions.UnsupportedOperation;

public class ExceptionsTest {

	private void assertMsgEquals(String expectedMsg, Exception ex) {

		String actualMsg = ex.getMessage();

		Assert.assertEquals(expectedMsg, actualMsg);
	}

	/**
	 * Verifies that exception constructor doesn't attempt
	 * to format a message when no format arguments are provided,
	 * therefore allowing unescaped '%' characters.
	 */
	@Test
	public void justMessageDoesntInvokeFormat() {

		String expectedMsg = "%";

		UnsupportedOperation ex = new UnsupportedOperation(expectedMsg);

		assertMsgEquals(expectedMsg, ex);
	}

	/**
	 * Verifies that messages are correctly constructed from
	 * message format and arguments.
	 */
	@Test
	public void messageFormatArgsAreProcessed() {

		String msgFormat = "%s = %d";
		Object[] msgArgs = new Object[] { "X", 10 };

		String expectedMsg = String.format(msgFormat, msgArgs);

		UnsupportedOperation ex = new UnsupportedOperation(msgFormat, msgArgs);

		assertMsgEquals(expectedMsg, ex);
	}

}