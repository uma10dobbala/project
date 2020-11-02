package com.cg.go.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.go.dao.*;
import com.cg.go.util.JpaUtil;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;

public class SalesReportServiceImpl implements ISalesReportService{
	EntityManager entityManager=JpaUtil.getEntityManager();
	ISalesReportRepository daoSalesReport=new SalesReportRepositoryImpl(entityManager);
	@Override
	public List<SalesReportEntity> findAllSalesReport() {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<SalesReportEntity> list= entityManager.createQuery("select s from SalesReportEntity s",SalesReportEntity.class).getResultList();
        transaction.commit();
		return list;
	}

	@Override
	public SalesReportEntity findSalesReportByProductId(String productId) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        SalesReportEntity salesReport= daoSalesReport.findByProductId(productId);
        transaction.commit();
		return salesReport;
	}

	@Override
	public void updateProductReport(SalesReportEntity salesReportEntity) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
         String str=salesReportEntity.getProductId();
         Integer integer=salesReportEntity.getQuantitySold();
         Double d= salesReportEntity.getTotalSale();
        daoSalesReport.updateProductReport(str,integer,d);
        transaction.commit();
		//return salesReportObject;
		
	}

	@Override
	public void deleteAllSalesReport() throws SalesReportException {
		EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	     Query q1=entityManager.createQuery("delete from SalesReportEntity");
	     q1.executeUpdate();
	    transaction.commit();
		
	}

	@Override
	public void deleteSalesReportById(Long salesReportId) throws SalesReportException {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query q1=entityManager.createNamedQuery("deleting salesreport").setParameter("salesReportId", salesReportId);
        q1.executeUpdate();
        transaction.commit();
		
	}

}
