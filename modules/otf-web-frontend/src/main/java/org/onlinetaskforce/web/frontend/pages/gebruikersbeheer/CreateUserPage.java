package org.onlinetaskforce.web.frontend.pages.gebruikersbeheer;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.onlinetaskforce.web.frontend.authorisation.SecurePage;
import org.onlinetaskforce.web.frontend.pages.BasicPage;
import org.onlinetaskforce.web.frontend.panels.gebruikersbeheer.CreateUserPageContentPanel;

public class CreateUserPage extends BasicPage implements SecurePage {
	private static final long serialVersionUID = 1L;

    private CreateUserPageContentPanel contentPanel;

	public CreateUserPage(final PageParameters parameters) {
		super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        contentPanel = new CreateUserPageContentPanel("content-panel");
        contentContainer.add(contentPanel);

    }
}
