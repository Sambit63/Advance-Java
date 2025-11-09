package springboot.crud.validation;

import java.math.BigInteger;
import org.springframework.stereotype.Component;

@Component
public class Validate {
	public boolean validMail(String email)
	{
		return email!=null && email.matches("^[a-z][a-z0-9!@#$%^&*+=]+@[ge]mail[.]com$");
	}
	public boolean validName(String username)
	{
		return username!=null && username.matches("^[a-zA-Z]+(?:[\\s'-][a-zA-Z]+)*$");
	}
	public boolean validPhone(BigInteger phno)
	{
		String phone=phno.toString();
		return phone!=null && phone.matches("[6-9][0-9]{9}");
	}
}
