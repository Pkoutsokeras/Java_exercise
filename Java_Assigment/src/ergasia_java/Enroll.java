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
public class Enroll {
    private int codeStudent,codeLesson,codeSemester;

    Enroll(){
        this.codeStudent=0;
        this.codeLesson=0;
        this.codeSemester=0;
    }

    Enroll(int cst,int cl,int cse){
        this.codeStudent=cst;
        this.codeLesson=cl;
        this.codeSemester=cse;
    }
    public void setCodeStudent(int in){
        this.codeStudent=in;
    }
    public int getCodeStudent(){
        return  this.codeStudent;
    }
    public  void setCodeLesson(int in){
        this.codeLesson=in;
    }
    public int getCodeLesson(){
        return this.codeLesson;
    }
    public void setCodeSemester(int in){
        this.codeLesson=in;
    }
    public int getCodeSemester(){
        return this.codeSemester;
    }
    public String toString(){
        return codeStudent + "," + codeLesson + "," + codeSemester + ","+" ";
    }
}

