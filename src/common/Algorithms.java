/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Algorithms {

    private final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    private Library lib = new Library();

    public Locale setLocate(String laguage) {
        return new Locale(laguage);

    }

    public String checkAccountNumber(String accountNumber, Locale language) {

        if (!accountNumber.matches("\\d+") || accountNumber.length() != 10) {
            return getWordLanguage(language, "errCheckInputAccountNumber");
        }
        return "success";
    }

    public String checkPassword(String password, Locale language) {
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,31}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return "success";
        }
        return getWordLanguage(language, "errCheckLengthAlphaPassword");
    }

    public String generateCaptchaText() {
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate, Locale language) {

        if (captchaInput.equals(captchaGenerate)) {
            return "success";
        }
        return getWordLanguage(language, "errCaptchaIncorrect");
    }

    public void login(Locale language) {
        String accNumber;
        do {
            System.out.print(getWordLanguage(language, "enterAccountNumber"));
            accNumber = lib.getString();
            if (!checkAccountNumber(accNumber, language).equals("success")) {
                System.out.println(checkAccountNumber(accNumber, language));
            }
        } while (!checkAccountNumber(accNumber, language).equals("success"));
        String password;
        do {
            System.out.print(getWordLanguage(language, "enterPassword"));
            password = lib.getString();
            if (!checkPassword(password, language).equals("success")) {
                System.out.println(checkPassword(password, language));
            }
        } while (!checkPassword(password, language).equals("success"));
        String captchaGenerated = generateCaptchaText();
        System.out.println(captchaGenerated);
        System.out.print(getWordLanguage(language, "enterCaptcha"));
        String capchaInput = lib.getString();
        while (true) {
            if (!checkCaptcha(capchaInput, captchaGenerated, language).equals("success")) {
                System.out.println(getWordLanguage(language, "errCaptchaIncorrect"));
                capchaInput = lib.getString();
            } else {
                System.out.println(getWordLanguage(language, "loginSuccess"));
                return;
            }
        }

    }

    public String getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("Language/" + curLocate, curLocate);
        return words.getString(key);
    }
}
