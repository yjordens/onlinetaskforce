package org.onlinetaskforce.web.frontend.pages;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.onlinetaskforce.web.frontend.panels.LoginPanel;

public class HomeLoginPage extends AbstractBasicPage {
	private static final long serialVersionUID = 1L;
    private static final CssResourceReference OTF_LOGIN_CSS = new CssResourceReference(HomeLoginPage.class, "../css/login.css");

    private LoginPanel loginPanel;

	public HomeLoginPage(final PageParameters parameters) {
		super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        loginPanel = new LoginPanel("login");
        add(loginPanel);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(OTF_LOGIN_CSS));
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }
}
