public class Course {
    private String id;
    private String name;

    //SETTERS AND GETTERS
    public void setId(String id)
    {
        this.id = id;
    }
    public String getId()
    {
        return this.id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }


    //OVERRIDING TO STRING METHOD
    public String toString()
    {
        StringBuilder st = new StringBuilder();
        st.append("Course id: ").append(id).append("\n").append("Course name: ")
                .append(name).append("\n");

        return st.toString();
    }
}
