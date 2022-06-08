package Controller;

import com.ty.zoo.dao.visitorDao;
import com.ty.zoo.dto.Visitor;

import Service.VisitorService;

public class TestVisitor {
	public static void main(String[] args) {
		
	VisitorService service=new VisitorService();
	Visitor visitor=new Visitor();
	visitor.setId(3);
	visitor.setName("pavan");
	visitor.setEmail("pavan@gmail.com");
	visitor.setPhone("741144185");
	visitor.setGender("male");
	visitor.setAge(23);
	
	visitorDao dao=new visitorDao();
	dao.saveVisitor(visitor);
	
	}

}
