package com.cg.go.service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.IProductRepository;
import com.cg.go.dao.ProductRepositoryImpl;
import com.cg.go.entity.Customer;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;
import com.cg.go.util.JpaUtil;

public class ProductServiceImpl implements IProductService{
	
	EntityManager entityManager=JpaUtil.getEntityManager();

	IProductRepository daoProduct=new ProductRepositoryImpl(entityManager);

	public List<ProductEntity> findAllProducts()
	{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<ProductEntity> list=new ArrayList<ProductEntity>();
        list=daoProduct.findAllProducts();
        transaction.commit();
        return list;
          
	}

  public ProductEntity findByProductId(String id)
	{
	  EntityTransaction transaction = entityManager.getTransaction();
      transaction.begin();
      ProductEntity productObject=daoProduct.findByProductId(id);
      transaction.commit();
		return productObject;
	}

	public List<ProductEntity> findByProductCategory(String productCategory)
	{
		  EntityTransaction transaction = entityManager.getTransaction();
	      transaction.begin();
	        List<ProductEntity> list=(List<ProductEntity>) daoProduct.findByProductId(productCategory);
	      transaction.commit();
		  //List<ProductEntity> productObject;
		return list;
		
	}

	public ProductEntity addProduct(ProductEntity productEntity) throws ProductException
	{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProductEntity productObject=daoProduct.addProduct(productEntity);
        transaction.commit();
		return productObject;
	}

	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException
	{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProductEntity productObject=daoProduct.updateProduct(productEntity);
        transaction.commit();
		return productObject;
	}

	public void updateProductQuantity(Integer quantity,String productId)
	{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoProduct.updateProductQuantity(quantity,productId);
        transaction.commit();

	}

	public void deleteByProductId(String id) throws ProductException
	{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoProduct.deleteByProductId(id);
        transaction.commit();
	}

	public List<ProductEntity> search(String keyword)
	{
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        list = daoProduct.search(keyword);
        transaction.commit();
		return list;
	}

	public List<ProductEntity> filter(double maxPrice)
	{
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        list = daoProduct.filter(maxPrice);
        transaction.commit();
        return  list;
	}
}
