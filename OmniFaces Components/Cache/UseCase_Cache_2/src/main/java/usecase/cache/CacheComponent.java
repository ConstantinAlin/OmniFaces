package usecase.cache;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.ExternalContext;
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
		ExternalContext externalContext = context.getExternalContext();
		Object cacheLiveTime = this.getAttributes().get("time");

		if (!context.isPostback()) {
			addRefreshCacheScript(script);
			if (cacheLiveTime != null) {
				setCacheCookie(externalContext, cacheLiveTime.toString());
			}
		} else {
			if (cacheLiveTime != null) {
				if (checkCacheCookie(externalContext) != null) {
					addFromCacheScript(script);
				} else {
					addRefreshCacheScript(script);
					setCacheCookie(externalContext, cacheLiveTime.toString());
				}
			} else {
				addFromCacheScript(script);
			}
		}
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("div");
		writer.startElement("script", this);
		writer.writeAttribute("type", "text/javascript", "type");
		writer.append(script);
		writer.endElement("script");
		writer.endElement("div");
	}

	private void setCacheCookie(ExternalContext externalContext, String cacheLiveTime) {
		Map<String, Object> props = new HashMap<>();
		props.put("maxAge", Integer.parseInt(cacheLiveTime));
		externalContext.addResponseCookie(this.getClientId().replaceAll(":", "_"), this.getClientId(), props);
	}

	private Object checkCacheCookie(ExternalContext externalContext) {
		return externalContext.getRequestCookieMap().get(this.getClientId());
	}

	private StringBuilder addFromCacheScript(StringBuilder script) {
		script.append("if (typeof(Storage) != 'undefined') {");
		script.append("document.getElementById('").append(this.getClientId())
				.append("').innerHTML = sessionStorage.getItem('").append(this.getClientId()).append("');");
		script.append("} else { alert('Cache not supported!');}");
		return script;
	}

	private StringBuilder addRefreshCacheScript(StringBuilder script) {
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
		return script;
	}
}
