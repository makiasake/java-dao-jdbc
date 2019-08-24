package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); 
		
		System.out.println("Seller findById");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println("Seller findByDepartment");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller s: list) {
			System.out.println(s);
		}
		
		System.out.println("Seller findAll");
		list = sellerDao.findAll();
		for (Seller s: list) {
			System.out.println(s);
		}
		
		System.out.println("Seller insert");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id: " + newSeller.getId());
	}
}
