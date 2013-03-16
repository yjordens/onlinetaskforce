package org.onlinetaskforce.web.frontend.pages;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.onlinetaskforce.web.frontend.authorisation.SecurePage;
import org.onlinetaskforce.web.frontend.components.menu.Menu;
import org.onlinetaskforce.web.frontend.panels.UserPanel;

public class HomePage extends BasicPage implements SecurePage {
	private static final long serialVersionUID = 1L;
    private static final CssResourceReference OTF_LOGIN_CSS = new CssResourceReference(HomePage.class, "../css/login.css");

    private UserPanel userPanel;

	public HomePage(final PageParameters parameters) {
		super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        menu = new Menu("menu_container");
        add(menu);

        userPanel = new UserPanel("user");
        add(userPanel);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(OTF_LOGIN_CSS));
    }
}
