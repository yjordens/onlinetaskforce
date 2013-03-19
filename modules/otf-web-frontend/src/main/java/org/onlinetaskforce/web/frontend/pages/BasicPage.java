package org.onlinetaskforce.web.frontend.pages;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.onlinetaskforce.web.frontend.panels.UserPanel;

/**
 * @author jordens
 * @since 8/03/13
 */
public class BasicPage extends AbstractBasicPage {
    private static final CssResourceReference OTF_LOGIN_CSS = new CssResourceReference(HomePage.class, "../css/login.css");

    private UserPanel userPanel;
    protected WebMarkupContainer contentContainer;

    public BasicPage(final PageParameters parameters) {
        super(parameters);

        Application.get().getMarkupSettings().setStripWicketTags(true);

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        userPanel = new UserPanel("user");
        add(userPanel);

        contentContainer = new WebMarkupContainer("content-container");
        add(contentContainer);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(OTF_LOGIN_CSS));
    }

    public UserPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
    }

    public WebMarkupContainer getContentContainer() {
        return contentContainer;
    }

    public void setContentContainer(WebMarkupContainer contentContainer) {
        this.contentContainer = contentContainer;
    }
}
