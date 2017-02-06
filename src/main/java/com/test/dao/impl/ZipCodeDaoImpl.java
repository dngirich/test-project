package com.test.dao.impl;

import java.util.List;
import com.test.domain.AddressResponseEntity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.test.dao.ZipCodeDao;

@Repository
public class ZipCodeDaoImpl implements ZipCodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AddressResponseEntity address) {
        entityManager.persist(address);
    }

    @Override
    public AddressResponseEntity getByZipCode(Integer zipCode) {
        try {
            return (AddressResponseEntity) entityManager
                    .createQuery("from AdressResponse where zipcode=:zipcode")
                    .setParameter("zipcode", zipCode)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AddressResponseEntity> getAllAddresses() {
        return entityManager.createQuery("from AdressResponse").getResultList();
    }

}
