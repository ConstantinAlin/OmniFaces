package usecase.componentidparam;

import javax.faces.view.facelets.BehaviorHandler;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.ConverterHandler;
import javax.faces.view.facelets.TagHandlerDelegate;
import javax.faces.view.facelets.TagHandlerDelegateFactory;
import javax.faces.view.facelets.ValidatorHandler;

/**
 *
 * @author Constantin Alin
 */
public class CustomTagHandlerDelegateFactory extends TagHandlerDelegateFactory {

	private TagHandlerDelegateFactory tagHandlerDelegateFactory;

	public CustomTagHandlerDelegateFactory() {
	}

	public CustomTagHandlerDelegateFactory(TagHandlerDelegateFactory tagHandlerDelegateFactory) {
		this.tagHandlerDelegateFactory = tagHandlerDelegateFactory;
	}

	@Override
	public TagHandlerDelegate createComponentHandlerDelegate(ComponentHandler owner) {
		return new CustomTagHandlerDelegate(tagHandlerDelegateFactory.createComponentHandlerDelegate(owner));
	}

	@Override
	public TagHandlerDelegate createValidatorHandlerDelegate(ValidatorHandler owner) {
		return tagHandlerDelegateFactory.createValidatorHandlerDelegate(owner);
	}

	@Override
	public TagHandlerDelegate createConverterHandlerDelegate(ConverterHandler owner) {
		return tagHandlerDelegateFactory.createConverterHandlerDelegate(owner);
	}

	@Override
	public TagHandlerDelegate createBehaviorHandlerDelegate(BehaviorHandler owner) {
		return tagHandlerDelegateFactory.createBehaviorHandlerDelegate(owner);
	}
}
