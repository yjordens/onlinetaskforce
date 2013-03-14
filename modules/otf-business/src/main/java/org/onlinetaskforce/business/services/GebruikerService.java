package org.onlinetaskforce.business.services;

import org.onlinetaskforce.persistence.domain.Gebruiker;

/**
 * @author jordens
 * @since 10/03/13
 */
public interface GebruikerService {
    public Gebruiker getGebruiker(String naam, String password);
}
