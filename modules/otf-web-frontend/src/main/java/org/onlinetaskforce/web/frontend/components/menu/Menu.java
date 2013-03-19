package org.onlinetaskforce.web.frontend.components.menu;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.onlinetaskforce.web.frontend.pages.gebruikersbeheer.CreateUserPage;
import org.onlinetaskforce.web.frontend.pages.HomePage;

/**
 * @author jordens
 * @since 9/03/13
 */
public class Menu extends Panel{
    public Menu(String id) {
        super(id);

        add(new BookmarkablePageLink<HomePage>("home-menu", HomePage.class));
        createGebruikersbeheerMenu();
    }

    private void createGebruikersbeheerMenu() {
        WebMarkupContainer gebruikerbeheerMenu = new WebMarkupContainer("gebruiker-menu");
        add(gebruikerbeheerMenu);
        add(new BookmarkablePageLink<CreateUserPage>("create-user-menu", CreateUserPage.class));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
    }
}
