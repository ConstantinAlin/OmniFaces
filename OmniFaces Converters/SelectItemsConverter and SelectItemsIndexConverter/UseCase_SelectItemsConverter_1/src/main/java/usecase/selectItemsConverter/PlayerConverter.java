package usecase.selectItemsConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Constantin Alin
 */
@FacesConverter("playerConverter")
public class PlayerConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		String[] parts = value.split(",");
		Player player = new Player(Long.parseLong(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
		return player;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return value.toString();
		}
		return "";
	}
}
