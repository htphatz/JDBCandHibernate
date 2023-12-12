package test;

import java.util.Date;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCatDAO {
	public static void main(String[] args) {
		CatDAO catDAO = new CatDAO();
		
		// Test selectAll()
		// List<Cat> listCats = catDAO.selectAll();
		// for(Cat cat: listCats) {
		//	System.out.println(cat.toString());
		// }
		
		// Test selectById()
		// Cat cat = new Cat();
		// cat.setId(2);
		// Cat selectedCat = catDAO.selectById(cat);
		// System.out.println(selectedCat.toString());
		
		// Test insert(), tương tự update mà thôi
		// Cat cat = new Cat(6, "Huy", new java.sql.Date(System.currentTimeMillis()), true);
		// catDAO.insert(cat);
		
		// Test delete();
		Cat cat = new Cat(4);
		catDAO.delete(cat);
		
	}
}
