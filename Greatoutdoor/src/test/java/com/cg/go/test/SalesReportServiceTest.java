package com.cg.go.test;
import com.cg.go.util.JpaUtil;
import java.util.*;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;
import com.cg.go.service.ISalesReportService;
import com.cg.go.service.SalesReportServiceImpl;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;

public class SalesReportServiceTest {
	EntityManager entityManager;
	@Test
	public void testForFindingAllSalesReport() {
		ISalesReportService salesReportService=new SalesReportServiceImpl();
		SalesReportEntity salesReportentity=new SalesReportEntity(1,"Ix","iphone",25,10.6);
		//SalesReportEntity s3=new SalesReportEntity(5,"rc3","realme",50,11.6);
		//ISalesReportService s2=new SalesReportServiceImpl();
		//EntityTransaction transaction=entityManager.getTransaction();
		//transaction.begin();
		//entityManager.persist(salesReportentity);
		//transaction.commit();
		//assertEquals(1,s1.deleteSalesReportById(1).get(0));
		//SalesReportEntity salesReport=new SalesReportEntity();
		List<SalesReportEntity> list=salesReportService.findAllSalesReport();
		Assertions.assertEquals(5,list.size());
		SalesReportEntity salesId1=list.get(0);
	     Assertions.assertEquals(1,salesId1.getSalesReportId());
	     
	}/*
	@Test
	public void testforDeletingSalesReport() throws SalesReportException{
		ISalesReportService salesReportService=new SalesReportServiceImpl();
		SalesReportEntity salesReportentity=new SalesReportEntity(1,"Ix","iphone",25,10.6);
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(salesReportentity);
		transaction.commit();
		salesReportService.deleteAllSalesReport();
		Assertions.assertEquals(1, salesReportentity.getQuantitySold());
		
		
		
	}*/
}
