/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */
import common.Algorithms;
import common.Library;
import java.util.Locale;
import view.Menu;

/**
 *
 * @author ACER
 */
public class LoginSystem extends Menu<String> {

    static String[] mc = {"Vietnamese", "English","Exit"};

    protected Library library;
    protected Algorithms algorithm;

    public LoginSystem() {
        super("-----LOGIN PROGRAM-----", mc);
        library = new Library();
        algorithm = new Algorithms();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                algorithm.login(algorithm.setLocate("vi"));
                break;
            case 2:
                algorithm.login(algorithm.setLocate("en"));
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }
    }
}
