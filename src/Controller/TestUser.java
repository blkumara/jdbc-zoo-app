package Controller;

import com.ty.zoo.dao.Userdao;
import com.ty.zoo.dto.User;

import Service.UserService;

public class TestUser {
	public static void main(String[] args) {
		
		UserService service=new UserService();
		User user=new User();
		user.setId(1);
		user.setName("sneha");
		user.setEmail("blkumara@gmail.com");
		user.setPassword("sneha123");
		user.setRole("Manager");
		user.setPhone("7483249668");
		
		Userdao dao=new Userdao();
		
		dao.saveUser(user);
		
	}

}
