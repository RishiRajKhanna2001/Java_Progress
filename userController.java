import java.util.*;

class UserDAO {
    String name;
    int passWord;
    String email;

    UserDAO(String name, int passWord, String email) {
        this.name = name;
        this.passWord = passWord;
        this.email = email;
    }
}

public class userController{
    public static void main(String[] args) {
        HashMap<String, UserDAO> mp = new HashMap<>();
        System.out.println("Input the operation to be performed : 1->Show, 2->Update, 3->Delete, 4->Add, 5->Stop");

        try (Scanner sc = new Scanner(System.in)) {
            int a = -1;
            while (a != 5) {
                System.out.print("Enter your choice: ");
                if (sc.hasNextInt()) {
                    a = sc.nextInt();
                    sc.nextLine();  // for not getting mismatch error
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    sc.nextLine(); 
                    continue;
                }

                switch (a) {
                    case 1: {
                        System.out.print("Tell your name: ");
                        String name = sc.nextLine();
                        if (mp.containsKey(name)) {
                            UserDAO user = mp.get(name);
                            System.out.println("Name: " + user.name);
                            System.out.println("Email: " + user.email);
                            System.out.println("password: " + user.passWord);
                            System.out.println("Showed successfully");
                        } else {
                            System.out.println("Enter correct name");
                        }
                        break;
                    }

                    case 2: {
                        System.out.print("Tell your name: ");
                        String name = sc.nextLine();
                        if (mp.containsKey(name)) {
                            System.out.print("Enter your password: ");
                            int passWord = sc.nextInt();
                            sc.nextLine(); 
                            if (mp.get(name).passWord == passWord) {
                                System.out.print("Enter new password: ");
                                int newPassWord = sc.nextInt();
                                sc.nextLine(); 
                                String email = mp.get(name).email;
                                UserDAO newUser = new UserDAO(name, newPassWord, email);
                                mp.put(name, newUser);
                                System.out.println("Updated successfully");
                            } else {
                                System.out.println("Enter correct password");
                            }
                        } else {
                            System.out.println("Enter correct name");
                        }
                        break;
                    }

                    case 3: {
                        System.out.print("Tell your name: ");
                        String name = sc.nextLine();
                        if (mp.containsKey(name)) {
                            System.out.print("Enter your password: ");
                            int passWord = sc.nextInt();
                            sc.nextLine(); 
                            if (mp.get(name).passWord == passWord) {
                                mp.remove(name);
                                System.out.println("Deleted successfully");
                            } else {
                                System.out.println("Enter correct password");
                            }
                        } else {
                            System.out.println("Enter correct name");
                        }
                        break;
                    }

                    case 4: {
                        System.out.print("Tell your name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter your password: ");
                        int passWord = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter your email: ");
                        String email = sc.nextLine();
                        UserDAO newUser = new UserDAO(name, passWord, email);
                        mp.put(name, newUser);
                        System.out.println("Added successfully");
                        break;
                    }

                    default:
                        if (a != 5) {
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        }
                        break;
                }
            }
        }
    }
}
