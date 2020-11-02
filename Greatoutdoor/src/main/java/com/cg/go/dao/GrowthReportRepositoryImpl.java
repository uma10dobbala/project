package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.cg.go.entity.Customer;
import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.exception.ProductException;
import com.cg.go.exception.SalesReportException;

public class GrowthReportRepositoryImpl implements IGrowthReportRepository{
	private EntityManager entityManager;

	public GrowthReportRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<GrowthReportEntity> findAllGrowthReport(){
		List<GrowthReportEntity> list=new ArrayList<GrowthReportEntity>();
		list=entityManager.createQuery("select * from GrowthReportEntity").getResultList();
		return list;
	}
	public void addGrowthReport() throws SalesReportException{
		/*GrowthReportEntity growthReportEntity=entityManager.find(GrowthReportEntity.class,growthReportId);
		if(growthReportEntity==null) {
			throw new GrowthReportException("growthReportEntity not found");
		}
		else {
			entityManager.persist(growthReportEntity);
		}*/
		//ToDo
	}

	public void deleteAllGrowthReport() throws GrowthReportException{
		//ToDo
	}

	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException{
		GrowthReportEntity growthReportEntity=entityManager.find(GrowthReportEntity.class,growthReportId);
		if(growthReportEntity==null) {
			throw new GrowthReportException("growthReportEntity not found");
		}
		else {
			entityManager.remove(growthReportEntity);
		}
	}
}
