package com.cg.go.dao;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;

public interface ISalesReportRepository {
	void updateProductReport(String productId,Integer quantity,double totalSale) throws SalesReportException;
	boolean existsByProductId(String productId);
	SalesReportEntity findByProductId(String productId);
}
