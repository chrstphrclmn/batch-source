package connectionUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static final Pattern VALID_CURRENCY_REGEX = 
			Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
	
		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
		public static boolean monValid(String money) {
			Matcher matcher = VALID_CURRENCY_REGEX.matcher(money);
			return matcher.find();
		}
}
