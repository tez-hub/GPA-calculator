package view;

import controller.GPAController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeView {
    private JFrame gradeFrame;
    private JLabel[] headLabel;
    private JLabel[] courseLabel;
    private JTextField[] grade;
    private JLabel[] credit;
    private JLabel gpaLabel;
    private JTextField avgGrade;
    private JButton calGrade;
    
    public GradeView(){
        
        this.gradeFrame = new JFrame("GPA calculator");
        //head row
        this.headLabel = new JLabel[]{new JLabel("Course"),new JLabel("Grade"), new JLabel("Credit")};
        //course title
        this.courseLabel = new JLabel[]{new JLabel("INT105"),new JLabel("INT106"), new JLabel("INT107"), 
            new JLabel("GEN111"), new JLabel("MTH111"), new JLabel("LNG103")};
        //grade
        this.grade = new JTextField[]{new JTextField("F/A"),new JTextField("F/A"),new JTextField("F/A"),new JTextField("F/A"),
            new JTextField("F/A"),new JTextField("F/A")};
        //credit
        this.credit = new JLabel[]{new JLabel("3"),new JLabel("3"),new JLabel("3"),new JLabel("3"),new JLabel("3"),new JLabel("3")};
        
        //calculate
        this.gpaLabel = new JLabel("GPA");
        this.avgGrade = new JTextField("x.xx");
        this.calGrade = new JButton("Calculate");
        
    }
    
    public void loadGradeForm(){
        JPanel gradePanel = new JPanel();
        
        GridLayout grid = new GridLayout(8,3);
        gradePanel.setLayout(grid);
        
        // add header row (Course, Grade, Credit)        
        gradePanel.add(headLabel[0]);
        gradePanel.add(headLabel[1]);
        gradePanel.add(headLabel[2]);
        
        // add 2nd - 7th row
        for(int i = 0; i < 6; i++){
            gradePanel.add(courseLabel[i]);
            gradePanel.add(grade[i]);
            gradePanel.add(credit[i]);
  
        }
        
        // add GPA row
        gradePanel.add(gpaLabel);
        gradePanel.add(avgGrade);
        
        //create FlowLayout for button
        JPanel calPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        calPanel.add(calGrade);
        
        //create Event (ActionListener) when click the button
        GPAController gpaListener = new GPAController(grade,avgGrade);
        calGrade.addActionListener(gpaListener);
        
        calPanel.add(calGrade);
        
        //add panel in frame
        gradeFrame.add(gradePanel, BorderLayout.NORTH);
        gradeFrame.add(calPanel, BorderLayout.CENTER);
        
        gradeFrame.setSize(400,260);
        gradeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gradeFrame.setVisible(true);
  
    }
    
    
    
}
