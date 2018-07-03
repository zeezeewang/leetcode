package Construct.zhenze.learning;

public class Student {
    public String name;

    public String ID;

    public Student(){

    }

    public Student(String name,String ID){
        this.name = name;
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }
}
