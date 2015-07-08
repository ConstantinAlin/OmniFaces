package omnify.usecase.selectItemsConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Constantin Alin
 */
@FacesConverter("playerSelectItemsConverter")
public class PlayerSelectItemsConverter extends SelectItemsConverter {

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Player) {
			Long id = ((Player) value).getId();
			if (id != null) {
				String name = ((Player) value).getName();
				String residence = ((Player) value).getResidence();
				int age = ((Player) value).getAge();
				return id + "," + name + "," + residence + "," + age;
			}
		}
		return null;
	}
}
