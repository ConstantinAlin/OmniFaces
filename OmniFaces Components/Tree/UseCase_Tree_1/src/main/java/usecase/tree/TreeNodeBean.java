package usecase.tree;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class TreeNodeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AbstractTreeNode root = new AbstractTreeNode("Components ShowCase",
			new AbstractTreeNode("OutputFamily",
					new AbstractTreeNode("ResourceInclude",
							new AbstractTreeNode("example 1", new AbstractTreeNode("source code")),
							new AbstractTreeNode("example 2", new AbstractTreeNode("source code"))),
					new AbstractTreeNode("ConditionalComment", new AbstractTreeNode("..."))),
			new AbstractTreeNode("UtilFamily", new AbstractTreeNode("MoveComponent"), new AbstractTreeNode("...")));

	public AbstractTreeNode getRoot() {
		return root;
	}
}
