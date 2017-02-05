package com.test.dao.impl;

import java.util.List;
import com.test.dao.ZipCodeDao;
import com.test.domain.AdressResponseEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ZipCodeDaoImpl implements ZipCodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AdressResponseEntity location) {
        entityManager.persist(location);
    }

    @Override
    public List<AdressResponseEntity> getByZipCode(Integer zipCode) {
        return (List<AdressResponseEntity>) entityManager
                .createQuery("from AdressResponseEntity where zipcode=:zipcode")
                .setParameter("zipcode", zipCode)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AdressResponseEntity> getAll() {
        return entityManager.createQuery("from AdressResponseEntity").getResultList();
    }

}
