package org.onlinetaskforce.web.frontend.panels;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.onlinetaskforce.web.frontend.pages.HomeLoginPage;
import org.onlinetaskforce.web.frontend.session.OtfWebSession;

import java.util.Date;

/**
 * Reusable basic UserPanel
 * @author jordens
 * @since 8/03/13
 */
public class UserPanel extends BasicPanel {
    private String status;
    private Date today;
    AjaxLink signOutLnk;

    /**
     * Initializes the view
     *
     * @param id The id
     */
    public UserPanel(String id) {
        super(id);

        final OtfWebSession session = (OtfWebSession) Session.get();
        add(new Label("status", Model.of("Welkom " + session.getGebruiker().getFullName())));
        today = new Date();
        add(new Label("dateTime", Model.of(today)));

        signOutLnk = new AjaxLink("sign-out-lnk") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                session.setGebruiker(null);
                setResponsePage(HomeLoginPage.class);
            }
        };
        add(signOutLnk);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
}

