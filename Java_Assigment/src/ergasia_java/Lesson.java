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
public class Lesson {

    private String Name;
    private int code,Semester;

    Lesson(){
        this.code=0;
        this.Name="";
        this.Semester=0;
    }

    Lesson(String n,int c,int s){
        this.Name=n;
        this.code=c;
        this.Semester=c;
    }

    public void setName(String in){
        this.Name=in;
    }

    public  String getName(){
        return  this.Name;
    }

    public  void  setCode(int in){
        this.code=in;
    }

    public int getCode(){
        return this.code;
    }

    public void setSemester(int in){
        this.Semester=in;
    }

    public int getSemester(){
        return this.Semester;
    }

    public String toString(){
        return Name + "," + code + "," + Semester + ","+" ";
    }
}
