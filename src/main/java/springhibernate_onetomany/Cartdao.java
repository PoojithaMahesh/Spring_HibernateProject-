package springhibernate_onetomany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




@Component
@Scope(value = "prototype")
public class Cartdao {
	@Autowired
	Scanner scanner;
	@Autowired
	List<Item> list;
	@Autowired
	private EntityManager entityManager;
	public void saveCart(Cart cart) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(cart);
		entityTransaction.commit();
		System.out.println("saved sucessfully");
	}
	public void updateCart(int id,Cart cart) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Cart cart2=entityManager.find(Cart.class,id);
		if(cart2!=null) {
			entityTransaction.begin();
			cart.setId(id);
			entityManager.merge(cart);
			entityTransaction.commit();
			System.out.println("updated successfully");
		}
		else {
			System.out.println("id not present");
		}
	}
	public void updateItem(int id,Item  item) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Item item2=entityManager.find(Item.class,id);
		if(item2!=null) {
			entityTransaction.begin();
			item.setId(id);
			entityManager.merge(item);
			entityTransaction.commit();
			System.out.println("updated successfully");
		}
		else {
			System.out.println("id not present");
		}
	}
	public void deleteCart(int id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Cart cart=entityManager.find(Cart.class,id);
		if(cart!=null) {
			entityTransaction.begin();
			entityManager.remove(cart);
			entityTransaction.commit();
		}
		else {
			System.out.println("id not present");
		}
	}
	public void getCart(int id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Cart cart=entityManager.find(Cart.class,id);
		System.out.println(cart);
		
	}
	public void getAllCart() {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select p from Person p");
		List<Cart> list=query.getResultList();
		System.out.println(list);
		
	}


}
