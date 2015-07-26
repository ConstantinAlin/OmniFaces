package omnify.usecase.componentidparam;

import java.io.Serializable;

/**
 *
 * @author Constantin Alin
 */
public class Players implements Serializable {

	private static final long serialVersionUID = 1L;

	private String player;
	private byte age;
	private String birthplace;
	private int ranking;

	public Players() {
		// NOOP
	}

	public Players(int ranking, String player, byte age, String birthplace) {
		this.ranking = ranking;
		this.player = player;
		this.age = age;
		this.birthplace = birthplace;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
