package org.onlinetaskforce.web.frontend.authorisation;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.request.component.IRequestableComponent;
import org.onlinetaskforce.web.frontend.pages.HomeLoginPage;
import org.onlinetaskforce.web.frontend.session.OtfWebSession;

/**
 * @author jordens
 * @since 10/03/13
 */
public class AuthorisationStrategy implements IAuthorizationStrategy{
    @Override
    public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> componentClass) {
        if (!Page.class.isAssignableFrom(componentClass)) {
            return true;
        }
        if (!SecurePage.class.isAssignableFrom(componentClass)) {
            return true;
        }
        if (((OtfWebSession)Session.get()).getGebruiker() == null) {
            throw new RestartResponseAtInterceptPageException(HomeLoginPage.class);
        }
        return true;
    }

    @Override
    public boolean isActionAuthorized(Component component, Action action) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
