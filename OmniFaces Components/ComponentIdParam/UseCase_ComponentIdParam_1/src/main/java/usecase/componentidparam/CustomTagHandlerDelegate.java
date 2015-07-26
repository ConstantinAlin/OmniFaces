package usecase.componentidparam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlBody;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.MetaRuleset;
import javax.faces.view.facelets.TagHandlerDelegate;

/**
 *
 * @author Constantin Alin
 */
public class CustomTagHandlerDelegate extends TagHandlerDelegate {

	private TagHandlerDelegate tagHandlerDelegate;

	public CustomTagHandlerDelegate() {
	}

	public CustomTagHandlerDelegate(TagHandlerDelegate tagHandlerDelegate) {
		this.tagHandlerDelegate = tagHandlerDelegate;
	}

	@Override
	public MetaRuleset createMetaRuleset(Class type) {
		return tagHandlerDelegate.createMetaRuleset(type);
	}

	@Override
	public void apply(FaceletContext ctx, UIComponent comp) throws IOException {
		tagHandlerDelegate.apply(ctx, comp);
		if (comp instanceof UIViewRoot) {
			for (UIComponent body : comp.getChildren()) {
				if (body instanceof HtmlBody) {
					if (body.getChildCount() > 0) {
						String renderIds = ctx.getFacesContext().getExternalContext().getRequestParameterMap()
								.get("renderIds");
						if (renderIds != null) {
							List<String> renderIdsList = Arrays.asList(renderIds.split("\\s*,\\s*"));
							final Collection<UIComponent> renderComps = new ArrayList<>();
							for (final String renderId : renderIdsList) {
								comp.visitTree(VisitContext.createVisitContext(ctx.getFacesContext()),
										new VisitCallback() {
											@Override
											public VisitResult visit(VisitContext context, UIComponent target) {
												if (renderId == null) {
													return VisitResult.REJECT;
												}
												System.out.println(target.getClientId());
												if (target.getId().equals(renderId) || target
														.getClientId(context.getFacesContext()).equals(renderId)) {
													renderComps.add(target);
													return VisitResult.COMPLETE;
												}
												return VisitResult.ACCEPT;
											}
										});
							}
							if (!renderComps.isEmpty()) {
								comp.getChildren().remove(body);
								HtmlBody newBody = new HtmlBody();
								newBody.getChildren().addAll(renderComps);
								comp.getChildren().add(newBody);
							}
						}
					}
				}
			}
		}
	}

}
