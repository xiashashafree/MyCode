package lesson1;

public class SystemUtil {
    public static boolean isAdmin(String userId){
        return userId.toLowerCase().equals("admin");
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
