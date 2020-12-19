package Day8;

import Day8.models.User;
import Day8.service.FileService;
import Day8.service.MD5;
import Day8.service.UserService;
import Day8.service.Validate;

import java.util.Scanner;
import java.util.StringJoiner;

public class LoginRegistration {
    public static void main(String[] args) {
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login & registration form");
        while (isActive) {
            int choice = -1;
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("0. Exit");
            System.out.print(">>");
            String possibleChoice = scanner.next();
            if (Character.isDigit(possibleChoice.charAt(0)))
                choice = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));

            switch (choice) {
                case 1: {
                    User loggedInUser;
                    String username, password;
                    do {

                        System.out.print("Username (or -1 to exit) : ");
                        username = scanner.next();
                        if (username.equals("-1")) break;
                        System.out.print("Password : ");
                        password = scanner.next();
                        loggedInUser = UserService.loginByUsernamePassword(username, MD5.getMd5(password));
                        if (loggedInUser != null) {
                            System.out.println("Congratulations! You are successfully logged in!");
                            UserService.welcomeMessage(loggedInUser);
                        } else System.out.println("Wrong username and/or password");
                    } while (loggedInUser == null);

                    break;
                }
                case 2: {
                    User registeredUser;
                    String fullName, username, email, password;
                    do {
                        System.out.print("Full name (-1 to exit): ");
                        scanner.nextLine();
                        fullName = scanner.nextLine();
                        if(fullName.equals("-1")) break;
                        System.out.print("Username : ");
                        username = scanner.next();
                        System.out.print("Email : ");
                        email = scanner.next();
                        System.out.print("Password : ");
                        password = scanner.next();
                        registeredUser = UserService.newUserRegistration(fullName, username, email, password);
                        if (registeredUser != null) {
                            System.out.println("Congratulations! You are successfully registered!");
                            StringJoiner userInfo = new StringJoiner(",");
                            userInfo.add(registeredUser.getFull_name());
                            userInfo.add(registeredUser.getUsername());
                            userInfo.add(registeredUser.getEmail());
                            userInfo.add(registeredUser.getPassword());
                            try {
                                FileService.write("\n"+userInfo.toString());
                            } catch (Exception e) {
                                System.out.println("Write operation failure.");
                            }
                            UserService.welcomeMessage(registeredUser);
                        }
                    } while (registeredUser == null);
                    break;
                }
                case 0: {
                    System.out.println("Session is terminated");
                    isActive = false;
                    break;
                }
                default: {
                    System.out.println("Invalid selection");
                    break;
                }
            }

        }
    }
}
