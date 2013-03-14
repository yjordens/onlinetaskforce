package org.onlinetaskforce.web.frontend.panels;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.onlinetaskforce.web.frontend.pages.HomePage;
import org.onlinetaskforce.web.frontend.session.OtfWebSession;

import java.util.Date;

/**
 * Reusable basic LoginPanel
 * @author jordens
 * @since 8/03/13
 */
public class LoginPanel extends BasicPanel {
    private String status;
    private Date today;
    private LoginForm loginForm;
    AjaxLink loginLink;

    /**
     * Initializes the view
     *
     * @param id The id
     */
    public LoginPanel(String id) {
        super(id);

        add(new Label("status", Model.of("u bent nog niet aangemeld")));
        today = new Date();
        add(new Label("dateTime", Model.of(today)));
        loginForm = new LoginForm("loginForm");
        add(loginForm);

        loginLink = new AjaxLink("login-link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                OtfWebSession session = (OtfWebSession)Session.get();
                //session.setGebruiker(new Gebruiker());

                if(session.login(loginForm.getUsername(), loginForm.getPassword())) {
                    setResponsePage(HomePage.class);
                } else {
                    error("login.failed");
                }
            }
        };
        loginForm.add(loginLink);
    }

    /**
     * Login components extending the Wicket Form type
     */
    public static final class LoginForm extends Form {

        private String username;
        private String password;

        /**
         * Initializes the view
         *
         * @param id The id
         */
        public LoginForm(String id) {
            super(id);
            setModel(new CompoundPropertyModel(this));
            add(new RequiredTextField("username"));
            add(new PasswordTextField("password"));
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
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

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}

