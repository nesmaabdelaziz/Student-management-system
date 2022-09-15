public class PersonType {
    public person getPersonType(String inputString)
    {
        if (inputString == null)
        {
            return null;
        }
        else if (inputString.equals("Admin"))
        {
            return new Admin();
        }
        else if (inputString.equals("Teacher"))
        {
            return new Teacher();
        }
        else if (inputString.equals("Student"))
        {
            return new Student();
        }

        return null;
    }
}
