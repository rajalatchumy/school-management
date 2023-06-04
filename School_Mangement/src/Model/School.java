package Model;

import View.MainWindow;

public class School
{
    public static void main(String args[])
    {
        Students students = new Students();
        
        Student toto = new Student(1,"toto","TOTO",Program.ING,Episode.A2);
        Student titi = new Student(2,"titi","TITI",Program.ING,Episode.A2);
        Student tutu = new Student(3,"tutu","TUTU",Program.ING,Episode.A1);
        Student tata = new Student(4,"tata","TATA",Program.ING,Episode.A1);
        
        students.add(toto);
        students.add(titi);
        students.add(tutu);
        students.add(tata);
        
        students.display();
        
        new MainWindow(students);
        
        titi.setEpisode(Episode.A1);
        students.display();
    }
}
