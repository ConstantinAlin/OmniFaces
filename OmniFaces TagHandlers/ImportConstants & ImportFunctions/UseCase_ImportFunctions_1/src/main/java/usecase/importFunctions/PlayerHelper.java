package usecase.importFunctions;

import java.util.Random;

/**
 *
 * @author Constantin Alin
 */
public final class PlayerHelper {

	public static boolean isPlayerAvailable(int rank) {
		// look for player, or at least do something else
		Random rnd = new Random();
		if (rnd.nextInt(10) < 5) {
			return false;
		}
		return true;
	}
}
