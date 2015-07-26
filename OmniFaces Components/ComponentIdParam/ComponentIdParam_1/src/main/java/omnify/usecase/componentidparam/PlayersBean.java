package omnify.usecase.componentidparam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@SessionScoped
public class PlayersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int favorite = 1;
	private List<Players> players = new ArrayList<>();

	public PlayersBean() {
		players.add(new Players(1, "NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia"));
		players.add(new Players(2, "ROGER FEDERER", (byte) 32, "Basel, Switzerland"));
		players.add(new Players(3, "RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain"));
		players.add(new Players(4, "STANISLAS WAWRINKA", (byte) 28, "Lausanne, Switzerland"));
		players.add(new Players(5, "ANDY MURRAY", (byte) 26, "Dunblane, Scotland"));
	}

	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
}
