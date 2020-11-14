package com.pa.strategy.solutionStrategy;

/*
 *@author patriciamacedo
 */
public class MainStrategy {

    public static void main(String[] args) {

        Course c1 = new Course(1, "PA", 6);
        Course c2 = new Course(2, "PI", 2);
        Course c3 = new Course(3, "IP", 6);
        Course c4 = new Course(4, "GT", 5);

        Student st1 = new Student(1, new StrategyNormal());
        st1.addCourse(c1,c2,c3,c4);
        st1.setGrade(1,10);
        st1.setGrade(2,20);
        System.out.printf(" \nStudent %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
        st1.setStrategy(new StrategyWorker());
        System.out.printf(" \nStudent as Worker %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
        st1.setStrategy(new StrategyEXTERN());
        System.out.printf(" \nStudent as Extern Student %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
    }
}
