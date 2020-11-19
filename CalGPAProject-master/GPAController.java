package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.text.DecimalFormat;

public class GPAController implements ActionListener {
    private JTextField[] grade;
    private JTextField calGrade;
    
    public GPAController(JTextField[] grade, JTextField calGrade){
        this.grade = new JTextField[grade.length];
        for(int i = 0; i< grade.length; i++){
            this.grade[i] = grade[i];
        }
        this.calGrade = calGrade;
    }
    
    public void actionPerformed(ActionEvent e){
        double[] intGrade = new double[6];
        for(int i = 0; i< grade.length; i++){
            switch (grade[i].getText().toLowerCase()){
                case "a": 
                    intGrade[i] = 4;
                    break;
                case "b+": 
                    intGrade[i] = 3.5;
                    break;
                case "b": 
                    intGrade[i] = 3;
                    break;
                case "c+": 
                    intGrade[i] = 2.5;
                    break;
                case "c": 
                    intGrade[i] = 2;
                    break;
                case "d+": 
                    intGrade[i] = 1.5;
                    break;
                case "d": 
                    intGrade[i] = 1;
                    break;
                case "f":
                    intGrade[i] = 0;
                    break;
   
            }
        }
        
        double grade = 0;
        for(int i = 0; i< intGrade.length; i++){
            grade += (intGrade[i] * 3); 
        }
        
        DecimalFormat dmf = new DecimalFormat("#.00"); 
        grade = grade/18d;
        calGrade.setText(dmf.format(grade));
    }
    
}
