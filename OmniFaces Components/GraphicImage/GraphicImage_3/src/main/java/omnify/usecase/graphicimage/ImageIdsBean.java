package omnify.usecase.graphicimage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class ImageIdsBean {

	private List<String> ids = Arrays.asList("tom", "dog", "jerry");

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String id() {
		return ids.get(new Random().nextInt(3));
	}
}
