package com.cg.go.service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.*;
import com.cg.go.entity.Customer;
import com.cg.go.util.*;

public class CustomerServiceImpl implements ICustomerService{
	EntityManager entityManager=JpaUtil.getEntityManager();
	ICustomerRepository daoCustomer=new CustomerRepositoryImpl(entityManager);
	public List<Customer> getAllCustomers(){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Customer> list=new ArrayList<Customer>();
		list=daoCustomer.getAllCustomers();
        transaction.commit();
        return list;
	}
	public Customer addCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=daoCustomer.addCustomer(customer);
        transaction.commit();
        return customerObject;
	}
	public Customer updateCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=daoCustomer.updateCustomer(customer);
        transaction.commit();
        return customerObject;
	}
	public Customer removeCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=daoCustomer.removeCustomer(customer);
        transaction.commit();
        return customerObject;
	}
	public Customer viewCustomer(Customer customer) {
		
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=daoCustomer.viewCustomer(customer);
        transaction.commit();
		return customerObject;
	}
}
