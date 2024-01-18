package com.portfolioJerome.CustomerCRUD.DAO;

import com.portfolioJerome.CustomerCRUD.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void save (Customer theCustomer);
    Customer findById (Integer id);
    List<Customer> findAll ();
    List<Customer> findByLastName (String lastName);
    void update (Customer theCustomer);
    void delete (Integer id);
    int deleteAll();
}
