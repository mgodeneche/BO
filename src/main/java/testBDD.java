import com.epsi.tpecommerce.entity.User;
import com.epsi.tpecommerce.service.UserService;

public class testBDD {

	public static void main(String[] args) {
		UserService userService = new UserService();
		
		for(User user : userService.getTwelveLastUsers()){
			System.out.println(user.getLogin());
		}

	}

}
