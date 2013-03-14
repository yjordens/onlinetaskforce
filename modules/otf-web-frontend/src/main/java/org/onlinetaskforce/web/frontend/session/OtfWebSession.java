package org.onlinetaskforce.web.frontend.session;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.onlinetaskforce.persistence.domain.Gebruiker;

/**
 * @author jordens
 * @since 10/03/13
 */
public class OtfWebSession extends WebSession{
    private Gebruiker gebruiker;

    /**
     * Constructor. Note that {@link org.apache.wicket.request.cycle.RequestCycle} is not available until this constructor returns.
     *
     * @param request The current request
     */
    public OtfWebSession(Request request) {
        super(request);
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public boolean login(String username, String password) {
        if (gebruiker != null && gebruiker.match(username, password)) {
            return true;
        }
        return false;
    }
}
