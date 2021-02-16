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
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Petros Koutsokeras
 */

public class StudentFrame extends JFrame implements ActionListener {
    private ArrayList<Student>mstudents= new ArrayList<Student>();
    private ArrayList<Lesson>mlessons= new ArrayList<Lesson>();
    private ArrayList<Enroll>menrolls= new ArrayList<Enroll>();
     public StudentFrame(String t){
         super (t);
         JFrame f= new JFrame("Assigment");
        /* Λίστα με τα Αντικείμενα του Μενού */
        JMenu file;
        JMenu Student;
        JMenu Enroll;
        /* Αντικείμενα */
         JMenuItem f1, f2, f3;
         JMenuItem st1,st2,st3,st4;
         JMenuItem e1,e2,e3,e4;
         
       JMenuBar mb=new JMenuBar();
       /* Πρώτο μενού */
       file=new JMenu("Αρχέιο");
       f1=new JMenuItem("Φόρτωση"); 
       f1.addActionListener(this);
       f2=new JMenuItem("Αποθήκευση");
       f2.addActionListener(this);
       f3=new JMenuItem("Έξοδος");
       f3.addActionListener(this);
       file.add(f1); file.add(f2); file.add(f3);
       
      /*Δεύτερο Μενού */
      Student= new JMenu("Μαθητής");
      st1=new JMenuItem("Νέος Μαθητής");
      st1.addActionListener(this);
      st2=new JMenuItem("Δήλωση Μαθήματος");
      st2.addActionListener(this);
      st3=new JMenuItem("Εμφάνιση Μαθητή");
      st3.addActionListener(this);
      st4=new JMenuItem("Διαγραφή Μαθητή");
      st4.addActionListener(this);
      Student.add(st1); Student.add(st2); Student.add(st3); Student.add(st4);
       
      /* Τρίτο Μενού */
      Enroll=new JMenu("Μάθημα");
      e1=new JMenuItem("Νέο Μάθημα");
      e2=new JMenuItem("Εμφάνιση Επιδόσεων");
      e3=new JMenuItem("Επιλογή Εξαμήνου");
      e4=new JMenuItem("Διαγραφή Εξαμήνου");
      Enroll.add(e1); Enroll.add(e2); Enroll.add(e3); Enroll.add(e4);
      mb.add(file);
      mb.add(Student);
      mb.add(Enroll); 
      /* Δημιουργία Μπάρας Μενού*/
      f.setJMenuBar(mb);
      f.setSize(400,400);
      f.setLayout(null);
      f.setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    StudentFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     /* ActionEvent Για το παράθυρο επιλογής αρχείου */
    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
          if (choice.equals("Φόρτωση")) {
         JFileChooser fileCh = new JFileChooser("."); //current folder
         FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
         fileCh.setFileFilter(filter);
           int ret= fileCh.showOpenDialog(this);
           if(ret == JFileChooser.APPROVE_OPTION){
               try{
                   String filename = fileCh.getSelectedFile().getAbsolutePath();
                   FileReader fr=new FileReader(filename);
                   Scanner in= new Scanner(fr);
                   while(in.hasNextLine()){
                       String line = in.nextLine();
                       System.out.println("Grammi : "+line);
                       String x[]=line.split(",");
                       Student student = new Student();
                       Lesson lesson= new Lesson();
                            student.SetName(line);
                            student.SetlastName(line);
                            mstudents.add(student);
                            lesson.setName(line);
                            mlessons.add(lesson);
                            mstudents.add(student);
                      if(in.hasNextInt()){
                           int am = in.nextInt();
                           int eksamino = in.nextInt();
                           student.setAm(am);
                           lesson.setCode(am);
                           lesson.setSemester(eksamino);
                           mstudents.add(student);
                       }
                      
                      
                   }
               } catch (FileNotFoundException ex) {
                 java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             }
           }
      }
               else if(choice.equals("Αποθήκευση")){
                JFileChooser chooser=new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                chooser.setFileFilter(filter);
                int ret=chooser.showSaveDialog(this);
                 if(ret == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                String filename= chooser.getSelectedFile().getAbsolutePath();
                FileWriter fw=new FileWriter(filename);
                PrintWriter pw=new PrintWriter(fw);
                for(Student x: mstudents)
                {
                    pw.println(" "+x);
                }
                fw.close();
            }catch(IOException ex)
            {
                    JOptionPane.showMessageDialog(null, "Error= "+ex.getMessage());
            }
        }
}
               else if (choice.equals("Έξοδος")) {
         System.exit(0);
      }
          else if(choice.equals("Νέος Μαθητής")){
          try {
                    String Name = JOptionPane.showInputDialog("Δώσε Όνομα: ");
                    String Lastname = JOptionPane.showInputDialog("Δώσε Επίθετο:");
                    int Semester = 0;
                    int am = 0;
                    am = (int) Double.parseDouble(
                            JOptionPane.showInputDialog("Δώσε αριθμό μητρώου"));
                    Semester = (int) Double.parseDouble(
                            JOptionPane.showInputDialog("Δώσε εξάμηνο: "));
                    Student X = new Student(Name, Lastname,am,Semester);
                    boolean found = false;
                     mstudents.add(X);
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Πρόβλημα με τα δεδομένα");
                }
      }
           else if(choice.equals("Δήλωση Μαθήματος")){
               String findStudent =JOptionPane.showInputDialog("Δώσε τον μαθητή που αναζητάς:");
               String Lesson = JOptionPane.showInputDialog("Δώσε το μάθημα που θέλεις:");
            int Grade = (int) Double.parseDouble(
                    JOptionPane.showInputDialog("Δώσε τον βαθμό"));
               
           }
           else if(choice.equals("Εμφάνιση Μαθητή")){
              int searcham =  (int) Double.parseDouble(
                            JOptionPane.showInputDialog("Δώσε αριθμό μητρώου του μαθητή"));
                            boolean foundam = false;
                            for(Student x:mstudents){
                                if(x.equals(searcham)){
                                    foundam = true;
                                    System.out.println(x.getAm());
                                }
                            }
                            
           }
          
          
   }
}

   
