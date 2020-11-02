package com.cg.go.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.cg.go.dao.*;
import com.cg.go.dao.GrowthReportRepositoryImpl;
import com.cg.go.dao.IGrowthReportRepository;
import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;
import com.cg.go.util.JpaUtil;

public class OrderServiceImpl implements IOrderService {
	EntityManager entityManager=JpaUtil.getEntityManager();
	IOrderRepository daoOrder=new OrderRepositoryImpl(entityManager);
	public List<OrderEntity> findOrdersByUserId(String userId){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<OrderEntity> list= daoOrder.findOrdersByUserId(userId);
        transaction.commit();
		return list;
	}

	public List<OrderEntity> findAllOrders(){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<OrderEntity> list= daoOrder.findAllOrders();
        transaction.commit();
		return list;
	}

	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        OrderEntity order=daoOrder.addOrder(orderEntity);
        transaction.commit();
		return order;
	}

	public void deleteAllOrders() throws OrderException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoOrder.deleteAllOrders();
        transaction.commit();
	}

	public void deleteOrderById(String orderId) throws OrderException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoOrder.deleteOrderById(orderId);
        transaction.commit();
	}

	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoOrder.updateDate(orderId, dispatchDate, arrivalDate);
        transaction.commit();
	}

}
