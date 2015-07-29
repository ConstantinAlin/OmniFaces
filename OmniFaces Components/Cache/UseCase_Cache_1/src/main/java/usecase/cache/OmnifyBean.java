package usecase.cache;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@ViewScoped
public class OmnifyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	List<String> comps = new ArrayList<>();
	private final String[] more_comps = new String[] { "cache", "commandScript", "componentIdParam",
			"conditionalComment", "deferredScript", "form", "highlight", "messages", "onloadScript", "outputFormat",
			"outputLabel", "param", "resourceInclude", "tree", "viewParam" };

	public OmnifyBean() {
		add();
	}

	public List<String> getComps() {
		return comps;
	}

	public void setComps(List<String> comps) {
		this.comps = comps;
	}

	public void addOmniComponents() throws ParseException {
		add();
	}

	private void add() {
		if (comps.size() >= more_comps.length) {
			comps.add("No more components ...");
		} else {
			comps.add(more_comps[comps.size()]);
		}
	}
}
