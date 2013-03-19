package org.onlinetaskforce.business.services;

import org.onlinetaskforce.persistence.domain.Gebruiker;

/**
 * @author jordens
 * @since 10/03/13
 */
public interface GebruikerService {
    /**
     * Loads a Gebruiker with the given name
     * @param naam the name of the Gebruiker to load
     * @return Gebruiker or null
     */
    public Gebruiker getGebruiker(String naam);

    /**
     * Adds a picture to the Gebruiker
     * @param gebruiker the Gebruiker to save
     */
    public void savePicture(Gebruiker gebruiker);
}
