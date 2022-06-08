package Service;

import static com.ty.zoo.util.AppConstant.SECRETE_KEY;

import com.ty.zoo.dao.visitorDao;
import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.AES;

public class VisitorService {
	visitorDao dao=new visitorDao();
	public int saveVisitor(Visitor visitor)
	{
		String encName=AES.encrypt(visitor.getName(),SECRETE_KEY );
		String encEmail=AES.encrypt(visitor.getEmail(),SECRETE_KEY );
		String encPhone=AES.encrypt(visitor.getPhone(),SECRETE_KEY );
		
		visitor.setName(encName);
		visitor.setEmail(encEmail);
		visitor.setPhone(encPhone);
		return dao.saveVisitor(visitor);
		
	}
}
