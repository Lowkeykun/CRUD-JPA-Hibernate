package com.portfolioJerome.CustomerCRUD.DAO;

import com.portfolioJerome.CustomerCRUD.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImp implements CustomerDAO{

    private EntityManager entityManager;

    public CustomerDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        entityManager.persist(theCustomer);
    }

    @Override
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        //Entity class
        TypedQuery<Customer> myCustomer = entityManager.createQuery("FROM Customer ORDER BY lastName", Customer.class);
        return myCustomer.getResultList();
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        TypedQuery<Customer> myCustomer = entityManager.createQuery("FROM Customer WHERE lastName =:data", Customer.class);

        myCustomer.setParameter("data", lastName);

        return myCustomer.getResultList();
    }

    @Override
    @Transactional
    public void update(Customer theCustomer) {
        entityManager.merge(theCustomer);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Customer myCustomer = entityManager.find(Customer.class, id);
        entityManager.remove(myCustomer);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberRows = entityManager.createQuery("DELETE FROM Customer").executeUpdate();
        return numberRows;
    }

}
