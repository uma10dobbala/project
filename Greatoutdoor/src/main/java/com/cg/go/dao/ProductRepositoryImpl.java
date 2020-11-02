package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.cg.go.entity.Customer;
import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.ProductException;
import com.cg.go.exception.WishlistException;

public class ProductRepositoryImpl implements IProductRepository{

	private EntityManager entityManager;

	public ProductRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<ProductEntity> findAllProducts(){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select * from ProductEntity").getResultList();
		return list;
	}
	public ProductEntity findByProductId(String id) {
		ProductEntity productEntity=entityManager.find(ProductEntity.class,id);
		return productEntity;
	}

	public List<ProductEntity> findByProductCategory(String productCategory){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select * from ProductEntity where category='productCategory'").setParameter("productCategory",productCategory).getResultList();
		return list;
	}

	public ProductEntity addProduct(ProductEntity productEntity) throws ProductException{
		if(productEntity==null) {
			throw new ProductException("productEntity not found");
		}
		else {
				entityManager.persist(productEntity);
				return productEntity;
			}
	}

	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException{
		if(productEntity==null) {
			throw new ProductException("productEntity not found");
		}
		else {
				entityManager.merge(productEntity);
				return productEntity;
			}
	}

	public void updateProductQuantity(Integer quantity,String productId) {
		ProductEntity productEntity=entityManager.find(ProductEntity.class,productId);
		productEntity.setQuantity(quantity);
	}

	public void deleteByProductId(String id) throws ProductException{
		ProductEntity productEntity=entityManager.find(ProductEntity.class,id);
		if(productEntity==null) {
			throw new ProductException("productEntity not found");
		}
		else {
				entityManager.remove(productEntity);
			}
	}

	public List<ProductEntity> search(String keyword){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select * from ProductEntity where productName='productName'").setParameter("productName",keyword).getResultList();
		return list;
	}

	public List<ProductEntity> filter(double maxPrice){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select * from ProductEntity where price<='maxPrice'").setParameter("maxPrice",maxPrice).getResultList();
		return list;
	}
}
