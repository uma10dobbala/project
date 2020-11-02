package com.cg.go.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.CartException;
import com.cg.go.exception.ProductException;
import com.cg.go.service.CartServiceImpl;
import com.cg.go.service.ICartService;
import com.cg.go.service.IProductService;
import com.cg.go.service.ProductServiceImpl;
import com.cg.go.util.JpaUtil;

public class TestCartItem {
	ICartService cartItemService=new CartServiceImpl();
	IProductService productService=new ProductServiceImpl();
	@Test
	public void testAddCart() throws ProductException, CartException {
		
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> productlist=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:productlist) {
			products.put(l,l.getQuantity());
		}
		CartItemEntity cartItemEntity=new CartItemEntity(456,"70",products,507,10);
		CartItemEntity cartItem=cartItemService.addCart(cartItemEntity);
		Assertions.assertEquals(456,cartItem.getCartId());
		Assertions.assertEquals(products,cartItem.getProducts());
	}
	
	
	@Test
	public void testfindCartlist() throws ProductException, CartException {
		
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> productlist=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:productlist) {
			products.put(l,l.getQuantity());
		}
		CartItemEntity cartItemEntity=new CartItemEntity(123,"70",products,491,12);
		cartItemService.addCart(cartItemEntity);
		List<CartItemEntity> cartlist=cartItemService.findCartlist("70");
		Assertions.assertEquals(cartItemEntity,cartlist.get(0));
	}
	
	
	@Test
	public void testUpdateCart() throws ProductException, CartException {
		
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> productlist=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:productlist) {
			products.put(l,l.getQuantity());
		}
		CartItemEntity cartItemEntity=new CartItemEntity(123,"70",products,491,12);
		cartItemService.addCart(cartItemEntity);
		cartItemEntity.setTotalQuantity(4);
		cartItemEntity.setCartTotalPrice(240);
		CartItemEntity cartItem=cartItemService.updateCart(cartItemEntity);
		Assertions.assertEquals(cartItemEntity,cartItem);
	}
	
	
	@Test
	public void testdeleteCartlist() throws ProductException, CartException {
		
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> productlist=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:productlist) {
			products.put(l,l.getQuantity());
		}
		List<CartItemEntity> cartlistItem=new ArrayList<>();
		CartItemEntity cartItemEntity=new CartItemEntity(123,"70",products,491,12);
		CartItemEntity cartItem=new CartItemEntity(456,"246",products,491,12);
		cartItemService.addCart(cartItemEntity);
		cartlistItem.add(cartItemService.addCart(cartItem));
		List<CartItemEntity> cartlist=cartItemService.findCartlist("246");
		Assertions.assertEquals(cartlistItem,cartlist);
	}
	 @AfterAll
	    static void close() {
	        JpaUtil util = JpaUtil.getInstance();
	        util.close();
	    }
}
