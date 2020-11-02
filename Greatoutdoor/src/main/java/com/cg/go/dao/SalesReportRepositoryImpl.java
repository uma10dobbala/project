package com.cg.go.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;

public class SalesReportRepositoryImpl implements ISalesReportRepository{
	private EntityManager entityManager;
	public SalesReportRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public void updateProductReport(String productId,Integer quantity,double totalSale) throws SalesReportException {
		SalesReportEntity salesReportEntity=(SalesReportEntity) entityManager.createNamedQuery("update salesReport").setParameter("productId", productId).setParameter("quantitySold",quantity ).setParameter("totalSale", totalSale).getSingleResult();
		//List<SalesReportEntity> list=entityManager.createQuery
		if(salesReportEntity==null) {
			throw new SalesReportException("obj can not be null");
		}
			
		entityManager.merge(salesReportEntity);
		
	}
	public boolean existsByProductId(String productId) {
		SalesReportEntity salesReportEntity=entityManager.find(SalesReportEntity.class,productId);
		if(salesReportEntity==null)
			return false;
		return true;
	}
	public SalesReportEntity findByProductId(String productId) {
		SalesReportEntity salesReportEntity=entityManager.find(SalesReportEntity.class,productId);
		return salesReportEntity;
	}
}
