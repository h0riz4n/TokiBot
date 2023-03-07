package WebApp.WebSite.utils;

/*
 * @author h0riz4n m1d1
 */
public class Utils {

    public static boolean validData(String login, String password)
    {
        if (!login.equals("") && !password.equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
