package usecase.genericEnumConverter;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class PlayerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PlayerEnum> players;
	private PlayerEnum selectedPlayerEnum;

	public List<PlayerEnum> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerEnum> players) {
		this.players = players;
	}

	public PlayerEnum getSelectedPlayerEnum() {
		return selectedPlayerEnum;
	}

	public void setSelectedPlayerEnum(PlayerEnum selectedPlayerEnum) {
		this.selectedPlayerEnum = selectedPlayerEnum;
	}
}
