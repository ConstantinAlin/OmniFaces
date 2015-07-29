package omnify.usecase.tree;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.model.tree.ListTreeModel;
import org.omnifaces.model.tree.TreeModel;

/**
 *
 * @author Constantin Alin
 */
@Named
@ViewScoped
public class TreeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeModel<String> tree;

	@PostConstruct
	public void init() {
		tree = new ListTreeModel<>(); // replace ListTreeModel with
									  // SortedTreeModel for getting the
									  // sorted version of the tree
		tree.addChild("Components Showcase").addChild("OutputFamily").addChild("ResourceInclude").addChild("example 1")
				.addChild("source code").getParent().getParent().addChild("example 2").addChild("source code")
				.getParent().getParent().getParent().addChild("Conditional Comment").addChild("...").getParent()
				.getParent().getParent().addChild("UtilFamily").addChild("MoveComponent").getParent().addChild("...");
	}

	public TreeModel<String> getTree() {
		return tree;
	}
}
