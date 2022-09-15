import java.util.Date;

public class Assignment {
    private String id;
    private String description;
    private String courseId;
    private Date dueDate;

    //SETTERS AND GETTERS
    public void setId(String id)
    {
        this.id = id;
    }
    public String getID()
    {
        return id;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }
    public String getCourseId()
    {
        return this.courseId;
    }
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }
    public Date getDueDate()
    {
        return this.dueDate;
    }


    //OVERRIDING TO STRING METHOD
    public String toString()
    {
        StringBuilder st = new StringBuilder();
        st.append("Assignment id: ").append(id).append("\n").append("Course id: ")
                .append(courseId).append("\n").append("Assignment description: ")
                .append(description).append("\n").append("Due date: ").append(dueDate.toString());

        return st.toString();
    }
}
