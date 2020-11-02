package com.cg.go.dao;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.go.entity.*;
import com.cg.go.exception.SalesReportException;
import com.cg.go.service.CustomerServiceImpl;
import com.cg.go.service.ICustomerService;
import com.cg.go.service.ISalesReportService;
import com.cg.go.service.SalesReportServiceImpl;
public class Test {

	public static void main(String[] args) {
			EntityManagerFactory factory= Persistence.createEntityManagerFactory("MyPU");
			EntityManager entityManager = factory.createEntityManager();
			long a=1;
			SalesReportEntity salesReportEntity1=new SalesReportEntity(a,"Ix","iphone",25,10.6);
			SalesReportEntity salesReportEntity2=new SalesReportEntity(5,"rc3","realme",50,11.6);
			ISalesReportService salesReportService=new SalesReportServiceImpl();
			List<SalesReportEntity> list2=new ArrayList<>();
			/*EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(salesReportEntity1);
			entityManager.persist(salesReportEntity2);
			transaction.commit();*/
			salesReportService.findAllSalesReport();
			System.out.println("Added Sucessfully");
			salesReportService.updateProductReport(salesReportEntity2);
			System.out.println("Updated sucessfully");
	}
	
}