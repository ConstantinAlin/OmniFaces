package usecase.cache;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.MetaRuleset;
import javax.faces.view.facelets.TagHandlerDelegate;

/**
 *
 * @author Constantin Alin
 */
public class CacheTagHandlerDelegate extends TagHandlerDelegate {

	private TagHandlerDelegate tagHandlerDelegate;

	public CacheTagHandlerDelegate() {
	}

	public CacheTagHandlerDelegate(TagHandlerDelegate tagHandlerDelegate) {
		this.tagHandlerDelegate = tagHandlerDelegate;
	}

	@Override
	public MetaRuleset createMetaRuleset(Class type) {
		return tagHandlerDelegate.createMetaRuleset(type);
	}

	@Override
	public void apply(FaceletContext ctx, UIComponent comp) throws IOException {

		if (ctx.getFacesContext().isPostback()) {
			if (comp instanceof usecase.cache.CacheComponent == false) {
				tagHandlerDelegate.apply(ctx, comp);
			} else {
				Object cacheLiveTime = comp.getAttributes().get("time");
				if (cacheLiveTime != null) {
					ExternalContext externalContext = ctx.getFacesContext().getExternalContext();
					Object cookieForComp = externalContext.getRequestCookieMap().get(comp.getClientId());
					if (cookieForComp == null) {
						tagHandlerDelegate.apply(ctx, comp);
					}
				}
			}
		} else {
			tagHandlerDelegate.apply(ctx, comp);
		}
	}

}
