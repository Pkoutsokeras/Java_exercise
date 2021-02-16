/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergasia_java;

/**
 *
 * @author kouts
 */
public class Student {
    private String name,lastName;
    private int am,semester;

    Student(){
        this.name="";
        this.lastName="";
        this.am=0;
        this.semester=0;
    }

    Student(String n,String l,int a,int s){
        this.name=n;
        this.lastName=l;
        this.am=a;
        this.semester=s;
    }

    Student(String Name, String Lastname, int Semester) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void SetName(String in){
        this.name=in;
    }

    public String getName(){
        return this.name;
    }

    public void SetlastName(String in){
        this.lastName=in;
    }

    public String setLastName(){
        return this.lastName;
    }

    public void setAm(int in){
        this.am=in;
    }

    public int getAm(){
        return this.am;
    }

    public void setSemester(int in){
        this.semester=in;
    }

    public int getSemester(){
        return this.semester;
    }

    public String toString(){
        return name + "," + lastName + "," + am + "," + semester + " ";
    }
}

