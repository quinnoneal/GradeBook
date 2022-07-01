package com.kenzie.app;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class GradeBook {
    private String name;
    private int grade;
    private String assignment;
    private int totalPoints;
    private HashMap<String, Integer> assignmentGradeMap;
    //Constructors
    public GradeBook() {
        // default constructor
        this.assignmentGradeMap = new HashMap<>();
    }

    public GradeBook(String assignment, int totalPoints){
        this();
        this.assignment = assignment;
        this.totalPoints = totalPoints;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public HashMap<String, Integer> getAssignmentGradeMap() {
        return assignmentGradeMap;
    }

    public void addGrade(String name, int grade) {
        assignmentGradeMap.put(name, grade);
    }

    public int checkGrade(String name){
        return assignmentGradeMap.get(name);
    }

    public void updateGrade(String name, int grade){
        if (assignmentGradeMap.containsKey(name)) {
            assignmentGradeMap.replace(name, grade);
        }
    }

    public ArrayList<String> getGradesEqualOrBelow(int grade){
        ArrayList<String> listOfGrades = new ArrayList<>();
        for (Map.Entry<String, Integer> currentSet : assignmentGradeMap.entrySet()) {
            if (currentSet.getValue() <= grade) {
                listOfGrades.add(currentSet.getKey());
            }
        }
        return listOfGrades;
    }

    public ArrayList<String> getGradesEqualOrAbove(int grade){
        ArrayList<String> listOfGrades = new ArrayList<>();
        for (Map.Entry<String, Integer> currentSet : assignmentGradeMap.entrySet()) {
            if (currentSet.getValue() >= grade) {
                listOfGrades.add(currentSet.getKey());
            }
        }
        return listOfGrades;
    }
}
