package org.onlinetaskforce.persistence.domain;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**

 */
@Entity
@Table(name = "gebruiker")
public class Gebruiker extends AbstractAuditPojo{

    /**
     * The user ID that is used when entities are saved by the system itself.
     */
    public static final String SYSTEM_USER_ID = "999999";

    /**
     * Systeembeheerder gebruikersrol
     */
    public static final String ROLE_SYSTEEMBEHEERDER = "ROLE_SYSTEEMBEHEERDER";

    /**
     * Systeemopvolger gebruikersrol
     */
    public static final String ROLE_SYSTEEMOPVOLGER = "ROLE_SYSTEEMOPVOLGER";

    /**
     * Applicatiebeheerder gebruikersrol
     */
    public static final String ROLE_APPLICATIEBEHEERDER = "ROLE_APPLICATIEBEHEERDER";

    /**
     * Lezer gebruikersrol
     */
    public static final String ROLE_LEZER = "ROLE_LEZER";

    /**
     * Agodi gebruikersrol
     */
    public static final String ROLE_AGODI = "ROLE_AGODI";

    /**
     * The insz nummer of this Gebruiker.
     */
    @Column(name = "inszNummer", nullable = true, length = 11)
    private String inszNummer;
    /**
     * The username of this Gebruiker.
     */
    @Column(name = "user_id", nullable = false, length = 50)
    private String username;
    /**
     * The wachtwoord of this Gebruiker.
     */
    @Column(name = "wachtwoord", nullable = false, length = 41)
    private String wachtwoord;
    /**
     * The naam of this Gebruiker.
     */
    @Column(name = "naam", nullable = true, length = 250)
    private String naam;
    /**
     * The voornaam of this Gebruiker.
     */
    @Column(name = "voornaam", nullable = true, length = 250)
    private String voornaam;
    /**
     * Indicates if this current Gebruiker is still an active user.
     */
    @Column(name = "actief", nullable = false)
    private Boolean actief;

    public Boolean getActief() {
        return actief;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    public String getInszNummer() {
        return inszNummer;
    }

    public void setInszNummer(String inszNummer) {
        this.inszNummer = inszNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public boolean match(String username, String password) {
        String passwordMd5 = DigestUtils.shaHex(password);
        return StringUtils.equals(this.username, username) && StringUtils.equals(this.wachtwoord, passwordMd5);
    }
}
