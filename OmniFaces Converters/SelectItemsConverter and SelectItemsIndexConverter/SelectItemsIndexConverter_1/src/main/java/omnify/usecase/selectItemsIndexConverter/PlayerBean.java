package omnify.usecase.selectItemsIndexConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@ViewScoped
public class PlayerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Player selected;
	private List<Player> topfive;

	@PostConstruct
	public void init() {
		topfive = new ArrayList<>();
		topfive.add(new Player(1L, "NOVAK DJOKOVIC", "Monte-Carlo", 27));
		topfive.add(new Player(2L, "ROGER FEDERER", "Bottmingen", 33));
		topfive.add(new Player(3L, "ANDY MURRAY", "London", 27));
		topfive.add(new Player(4L, "MILOS RAONIC", "Monte Carlo", 24));
		topfive.add(new Player(5L, "TOMAS BERDYCH", "Monte Carlo", 29));
	}

	public List<Player> getTopfive() {
		return topfive;
	}

	public void setTopfive(List<Player> topfive) {
		this.topfive = topfive;
	}

	public Player getSelected() {
		return selected;
	}

	public void setSelected(Player selected) {
		this.selected = selected;
	}
}
