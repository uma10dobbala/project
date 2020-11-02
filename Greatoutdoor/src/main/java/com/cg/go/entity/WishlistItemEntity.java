package com.cg.go.entity;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.Objects;
@Entity
public class WishlistItemEntity {
	@Id
	private long wishlistId;
	private String userId;
	@ElementCollection
	private List<String> productId;
	public WishlistItemEntity(long wishlistId, String userId, List<String> productId) {
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
	}
	public WishlistItemEntity() {
 	}
	public long getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getProductId() {
		return productId;
	}
	public void setProductId(List<String> productId) {
		this.productId = productId;
	}
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(wishlistId);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistItemEntity other = (WishlistItemEntity) obj;
		if (wishlistId != other.wishlistId)
			return false;
		return true;
	}
	
}
