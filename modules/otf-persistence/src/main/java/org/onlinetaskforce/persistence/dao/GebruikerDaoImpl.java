package org.onlinetaskforce.persistence.dao;

import org.onlinetaskforce.persistence.domain.Gebruiker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;

/**
 * Concrete DAO implementation of BaseDomainDao's <T> objects.
 *
 * @author jordens
 * @since 15/03/13
 */
@Repository("gebruikerDao")
@Transactional
public class GebruikerDaoImpl extends BaseDomainDaoImpl<Gebruiker, String> implements GebruikerDao {

    /**
     * Instantiates a new generic dao hibernate impl.
     */
     public GebruikerDaoImpl() {
        super(Gebruiker.class);
    }

    @Override
    public Gebruiker getGebruiker(String username) {
        String hql = "select gbr from Gebruiker gbr where gbr.username = :username";
        Gebruiker result = (Gebruiker) getCurrentSession()
                .createQuery(hql)
                .setString("username", username)
                .uniqueResult();
        return result;
    }
}
