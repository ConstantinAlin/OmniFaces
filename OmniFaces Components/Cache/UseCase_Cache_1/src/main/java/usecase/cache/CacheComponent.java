package usecase.cache;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Constantin Alin
 */
@FacesComponent(value = CacheComponent.COMPONENT_TYPE, createTag = true, tagName = "cache", namespace = "http://brainstorming.jsf.org/cache")
public class CacheComponent extends UIComponentBase {

	public static final String COMPONENT_FAMILY = "components.CacheComponent";
	public static final String COMPONENT_TYPE = "brainstorming.jsf.CacheComponent";

	@Override
	public String getFamily() {
		return CacheComponent.COMPONENT_FAMILY;
	}

	@Override
	public boolean getRendersChildren() {
		return false;
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {

		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", this);
		writer.writeAttribute("id", "main_" + this.getClientId(), "id");
		writer.startElement("div", this);
		writer.writeAttribute("id", this.getClientId(), "id");
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		StringBuilder script = new StringBuilder();
		if (!context.isPostback()) {
			script.append("if (typeof(Storage) != 'undefined') {");
			script.append("sessionStorage.removeItem('").append(this.getClientId()).append("');");
			script.append("var serializedDOM = '';");
			script.append("var serializerDOM = new XMLSerializer();");
			script.append("var DOM = document.getElementById('").append(this.getClientId()).append("').childNodes;");
			script.append("for(var i=0;i<DOM.length;i++){");
			script.append("serializedDOM=serializedDOM+(serializerDOM.serializeToString(DOM.item(i)));");
			script.append("}");
			script.append("sessionStorage.setItem('").append(this.getClientId()).append("', serializedDOM);");
			script.append("} else { alert('Cache not supported!');}");

		} else {
			script.append("if (typeof(Storage) != 'undefined') {");
			script.append("document.getElementById('").append(this.getClientId())
					.append("').innerHTML = sessionStorage.getItem('").append(this.getClientId()).append("');");
			script.append("} else { alert('Cache not supported!');}");
		}
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("div");
		writer.startElement("script", this);
		writer.writeAttribute("type", "text/javascript", "type");
		writer.append(script);
		writer.endElement("script");
		writer.endElement("div");
	}

}
