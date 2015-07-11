package omnify.usecase.importConstants;

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

	public PlayerEnum getSelectedPlayerEnum() {
		return selectedPlayerEnum;
	}

	public void setSelectedPlayerEnum(PlayerEnum selectedPlayerEnum) {
		this.selectedPlayerEnum = selectedPlayerEnum;
	}
}
