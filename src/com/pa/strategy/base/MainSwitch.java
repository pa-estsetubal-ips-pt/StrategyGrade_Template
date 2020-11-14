package com.pa.strategy.base;


/*
 *@author patriciamacedo
 */
public class MainSwitch {

    public static void main(String[] args) {

        Course c1 = new Course(1, "PA", 6);
        Course c2 = new Course(2, "PI", 2);
        Course c3 = new Course(3, "IP", 6);
        Course c4 = new Course(4, "GT", 5);

        Student st1 = new Student(1, Student.TYPE.NORMAL);
        st1.addCourse(c1,c2,c3,c4);
        st1.setGrade(1,10);
        st1.setGrade(2,20);
        System.out.printf(" \nStudent %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
        st1.setType(Student.TYPE.WORKER);
        System.out.printf(" \nStudent as Worker %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
        st1.setType(Student.TYPE.EXTERN);
        System.out.printf(" \nStudent as Extern Student %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
    }
}
