package usecase.importConstants;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Constantin Alin
 */
@ManagedBean
@RequestScoped
public class PlayerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PlayerEnum selectedPlayerEnum;
	public static final String NAME_C = "Rafael Nadal";
	private String NAME;

	public String getNAME() {
		return NAME_C;
	}

	public <T> T getPlayerEnum(int item, boolean ranknr) {
		PlayerEnum rank = PlayerEnum.values()[item - 1];
		if (ranknr) {
			return (T) rank.getRank();
		}
		return (T) rank;
	}

	public PlayerEnum[] getPlayerEnum() {
		return PlayerEnum.values();
	}

	public PlayerEnum getSelectedPlayerEnum() {
		return selectedPlayerEnum;
	}

	public void setSelectedPlayerEnum(PlayerEnum selectedPlayerEnum) {
		this.selectedPlayerEnum = selectedPlayerEnum;
	}
}
