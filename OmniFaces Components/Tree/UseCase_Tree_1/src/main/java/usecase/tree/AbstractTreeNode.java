package usecase.tree;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Constantin Alin
 */
public class AbstractTreeNode implements Serializable {

	private static final long serialVersionUID = 1L;

	private final List<AbstractTreeNode> descendants;
	private final String label;

	public AbstractTreeNode(String label, AbstractTreeNode... descendants) {
		this.label = label;
		this.descendants = Arrays.asList(descendants);
	}

	public boolean isHasDescendants() {
		return !descendants.isEmpty();
	}

	public List<AbstractTreeNode> getDescendants() {
		return descendants;
	}

	public String getLabel() {
		return label;
	}
}
