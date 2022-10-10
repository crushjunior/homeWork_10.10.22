package Data;
public class Data {
    private static final String VALID_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    private Data() {

    }

    public static boolean validate(String login, String password, String confirmPassword) {
    try {
        check(login, password, confirmPassword);
    }
    catch (WrongLoginException | WrongPasswordException e) {
        System.out.println(e.getMessage());
        return false;
    }
    return true;
    }

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!validateCheck(login)) {
            throw new WrongLoginException("Логин содержит не допустимые символы!");
        }
        if (!validateCheck(password)) {
            throw new WrongPasswordException("Пароль содержит не допустимые символы!");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }

    public static boolean validateCheck (String s) {
        if (s.length() > 20 && s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_SYMBOLS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
