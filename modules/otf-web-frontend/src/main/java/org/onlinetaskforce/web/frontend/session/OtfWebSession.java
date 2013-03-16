package org.onlinetaskforce.web.frontend.session;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.onlinetaskforce.business.services.GebruikerService;
import org.onlinetaskforce.persistence.domain.Gebruiker;

/**
 * @author jordens
 * @since 10/03/13
 */
public class OtfWebSession extends WebSession{
    @SpringBean
    private GebruikerService gebruikerService;
    private Gebruiker gebruiker;

    /**
     * Constructor. Note that {@link org.apache.wicket.request.cycle.RequestCycle} is not available until this constructor returns.
     *
     * @param request The current request
     */
    public OtfWebSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public boolean login(String username, String password) {
        gebruiker = gebruikerService.getGebruiker(username);
        if (gebruiker != null && gebruiker.match(username, password)) {
            return true;
        }
        return false;
    }
}
