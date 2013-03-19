package org.onlinetaskforce.business.services;

import org.onlinetaskforce.persistence.dao.GebruikerDao;
import org.onlinetaskforce.persistence.domain.Gebruiker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jordens
 * @since 10/03/13
 */
@Service
@Transactional
public class GebruikerServiceImpl extends BaseOtfServiceImpl implements GebruikerService{
    private GebruikerDao gebruikerDao;

    @Override
    public Gebruiker getGebruiker(String naam) {
        return gebruikerDao.getGebruiker(naam);
    }

    @Override
    public void savePicture(Gebruiker gebruiker) {
        gebruikerDao.saveOrUpdate(gebruiker);
    }

    @Autowired
    public void setGebruikerDao(GebruikerDao gebruikerDao) {
        this.gebruikerDao = gebruikerDao;
    }
}
