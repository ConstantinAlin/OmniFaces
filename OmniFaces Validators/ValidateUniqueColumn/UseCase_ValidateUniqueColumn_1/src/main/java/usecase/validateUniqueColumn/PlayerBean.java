package usecase.validateUniqueColumn;

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

	private List<Player> players;

	@PostConstruct
	public void init() {
		players = new ArrayList<>();
		players.add(new Player("Nadal, Rafael", "rafa@yahoo.com"));
		players.add(new Player("Djokovic, Novak", "novak@yahoo.com"));
		players.add(new Player("Murray, Andy", "andy@yahoo.com"));
		players.add(new Player("Cilic, Marin", "marin@tahoo.com"));
		players.add(new Player("Lopez, Feliciano", "feliciano@yahoo.com"));
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
