package org.onlinetaskforce.business.services;

import org.onlinetaskforce.persistence.domain.Gebruiker;
import org.springframework.stereotype.Service;

/**
 * @author jordens
 * @since 10/03/13
 */
@Service
public class GebruikerServiceImpl implements GebruikerService{
    @Override
    public Gebruiker getGebruiker(String naam, String password) {
        return new Gebruiker();
    }
}
