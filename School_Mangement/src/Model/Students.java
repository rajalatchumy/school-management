package Model;
import java.util.Iterator;
import java.util.TreeMap;

public class Students
{

    private TreeMap<Integer, Student> students;
    
    public Students()
    {
        this.students = new TreeMap<Integer, Student>();
    }
    
    
    public void add(Student student)
    {
        int id = student.getId();
        if (students.containsKey(id))
        {
            System.err.println("this id : " +id+" is already on the student list");
        }
        else
        {
            students.put(id, student);
            System.out.println("the student with the id : "+id+" has been succesfully added to the list");
        }
    }
    
   public Student get(Integer id)
    {
        Student student = students.get(id);
        if(student == null)
        {
            System.err.println("the id"+id+"was not found in the list");
        }
        return student;
    }
    
    public void remove(int id)
    {
       if( students.remove(id) == null)
       {
           System.err.println("the id "+id+" was not found on the list");
       }
       else
       {
           System.out.println("The student with the id "+id+" was removed from the list");
       }
    }
    
    
    public void display()
    {
        Iterator<Student> i = students.values().iterator();       
        while(i.hasNext())
        {
            Student student = i.next();
            student.display();
        }
    }
    
    public Iterator<Student> iterator()
    {
    	return students.values().iterator();  
    }
}
