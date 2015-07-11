package omnify.usecase.importFunctions;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Constantin Alin
 */
public final class PlayerHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public static boolean isPlayerAvailable(int rank) {
		// look for player, or at least do something else
		Random rnd = new Random();
		if (rnd.nextInt(10) < 5) {
			return false;
		}
		return true;
	}
}
