package org.onlinetaskforce.persistence.dao;

import org.onlinetaskforce.persistence.domain.Gebruiker;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jordens
 * @since 10/03/13
 */
public interface GebruikerDao extends BaseDomainDao<Gebruiker, String> {

    /**
     * Finds the Gebruiker for a given username
     *
     * @param username The username of the person
     * @return The found enitity, <code>null</code> if no result is found.
     */
    Gebruiker getGebruiker(String username);
}
