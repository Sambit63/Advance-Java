package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	static Pattern p;
	static Matcher m;
	public static boolean isEmailValid(String s)
	{
		String exp="[a-z][a-z0-9!@#$%^&*_+=]+@[ge]mail[.]com";
		 p=Pattern.compile(exp);
		 m=p.matcher(s);
		return m.matches();
	}
	public static boolean isPassValid(String s)
	{
		String exp="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+]).{4,8}";
		 p=Pattern.compile(exp);
		 m=p.matcher(s);
		return m.matches();
	}
	public static boolean isPhoneValid(String s)
	{
		String exp="[9876][0-9]{9}";
		p=Pattern.compile(exp);
		 m=p.matcher(s);
		return m.matches();
	}
}
