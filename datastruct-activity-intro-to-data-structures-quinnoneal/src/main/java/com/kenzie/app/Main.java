package com.kenzie.app;

import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static GradeBook createHomeworkGradeBook(){
        GradeBook homework1GradeBook = new GradeBook("Homework 1", 100);
        homework1GradeBook.addGrade("Lisa", 100);
        homework1GradeBook.addGrade("Bart", 80);
        homework1GradeBook.addGrade("Maggie", 0);
        homework1GradeBook.addGrade("Homer", 75);
        return homework1GradeBook;
    }

    public static GradeBook changeGrade(GradeBook gradeBook, String name, int points){
        int currentGrade = gradeBook.checkGrade(name);
        if (currentGrade != 0) {
            if (currentGrade + points < gradeBook.getTotalPoints())
            gradeBook.updateGrade(name, currentGrade + points);
            else {
                gradeBook.updateGrade(name, gradeBook.getTotalPoints());
            }
        }
        return gradeBook;
    }

    public static void main(String[] args) {
        GradeBook homeworkGrades = createHomeworkGradeBook();
        if (homeworkGrades != null) {
            System.out.println(homeworkGrades.getAssignmentGradeMap().entrySet());
            homeworkGrades = changeGrade(homeworkGrades,"Bart",10);
            System.out.println("Add 10 points to Bart: " + homeworkGrades.getAssignmentGradeMap().entrySet());
            homeworkGrades = changeGrade(homeworkGrades,"Bart",20);
            System.out.println("Add 20 points to Bart, max rule: " + homeworkGrades.getAssignmentGradeMap().entrySet());
            homeworkGrades = changeGrade(homeworkGrades,"Homer",-10);
            System.out.println("Minus 10 points to Homer: " + homeworkGrades.getAssignmentGradeMap().entrySet());
            homeworkGrades = changeGrade(homeworkGrades,"Maggie",20);
            System.out.println("Did not add 20 points to Maggie, zero rule: " + homeworkGrades.getAssignmentGradeMap().entrySet());
            homeworkGrades = changeGrade(homeworkGrades,"Lisa",20);
            System.out.println("Did not add 20 points to Lisa, total point rule: " + homeworkGrades.getAssignmentGradeMap().entrySet());
            System.out.println("These students have grades 50 or below:");
            System.out.println(homeworkGrades.getGradesEqualOrBelow(50));
            System.out.println("These students have grades 70 or above:");
            System.out.println(homeworkGrades.getGradesEqualOrAbove(70));
        }
    }
}
