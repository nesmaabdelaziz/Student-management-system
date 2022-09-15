import java.text.ParseException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        //GET THE ONE INSTANCE OF THE DATABASE
        Database database = Database.getDatabase();
        //RUN APP
        while (true)
        {
            System.out.println("Enter user role: (Admin, Teacher, Student)");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();

            PersonType personType = new PersonType();
            person p1 = personType.getPersonType(inputString);
            p1.choose(database);

            System.out.println("To quit, enter 0. To resume, enter 1");
            inputString = scanner.nextLine();
            if (inputString.equals("0"))
                break;
        }
    }
}
