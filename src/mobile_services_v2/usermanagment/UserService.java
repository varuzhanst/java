package mobile_services_v2.usermanagment;



import mobile_services_v2.models.User;

import java.util.ArrayList;

public class UserService {
    /**
     * User authentication
     * @param username
     * @param password
     * @return
     */
    public static User loginByUsernamePassword(String username, String password) {
        User PossibleUser = getUserByUsername(username);
        if (PossibleUser == null) return null;
        if (password.equals(PossibleUser.getPassword()))
            return PossibleUser;
        else return null;
    }

    /**
     * if all provided info are valid then new User is being returned
     * @param fullName
     * @param username
     * @param email
     * @param password
     * @return
     */
    public static User newUserRegistration(String fullName, String username, String email, String password) {
        if (!Validate.isFullNameValid(fullName)) {
            System.out.println("Check your full name.");
            return null;
        }else if (!Validate.isUsernameValid(username)) {
            System.out.println("Check your username.");
            return null;
        }else if (!Validate.isEmailValid(email)){
            System.out.println("Check your email.");
            return null;
        } else if(!Validate.isPasswordValid(password)){
            System.out.println("Check your password.");
            return null;
        } else return new User(fullName,username,email, MD5.getMd5(password));

    }

    /**
     * getting a user by provided username
     * @param username
     * @return
     */
    public static User getUserByUsername(String username) {
        ArrayList<String> UsersList;
        try {
            UsersList = UserFileService.readAll();
            for (String userString :
                    UsersList) {
                String[] user = userString.split(",");
                if (user[1].equals(username))
                    return new User(user[0], user[1], user[2], user[3]);
            }
        } catch (Exception e) {
            System.out.println("Read operation failure.");
        }

        return null;
    }

    /**
     * printing welcome message by provided user
     * @param user
     */
    public static void welcomeMessage(User user){
        System.out.println("Hi, " + user.getFull_name());
        System.out.println("Your Email is " + user.getEmail());
    }

}
