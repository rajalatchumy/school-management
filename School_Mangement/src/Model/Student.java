package Model;
public class Student
{
    private int id;
    private String name;
    private String firstname;
    private Program program;
    private Episode episode;

    public Student(int id, String name, String firstname, Program program, Episode episode)
    {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.program = program;
        this.episode = episode;
    }

    
    
     public void display()
    {
        System.out.println("id : "+id + " " + name + " " + firstname + " " + program + " " + episode);
    }
    
    
    //Start GetterSetterExtension Source Code
    /**GET Method Propertie id*/
    public int getId(){
        return this.id;
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id = id;
    }//end method setId

    /**GET Method Propertie name*/
    public String getName(){
        return this.name;
    }//end method getName

    /**SET Method Propertie name*/
    public void setName(String name){
        this.name = name;
    }//end method setName

    /**GET Method Propertie firstname*/
    public String getFirstname(){
        return this.firstname;
    }//end method getFirstname

    /**SET Method Propertie firstname*/
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }//end method setFirstname

    /**GET Method Propertie program*/
    public Program getProgram(){
        return this.program;
    }//end method getProgram

    /**SET Method Propertie program*/
    public void setProgram(Program program){
        this.program = program;
    }//end method setProgram

    /**GET Method Propertie episode*/
    public Episode getEpisode(){
        return this.episode;
    }//end method getEpisode

    /**SET Method Propertie episode*/
    public void setEpisode(Episode episode){
        this.episode = episode;
    }//end method setEpisode

    //End GetterSetterExtension Source Code
}//End class !
