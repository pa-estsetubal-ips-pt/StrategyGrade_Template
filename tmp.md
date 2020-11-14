```java
public class Student {

    public enum TYPE {NORMAL,WORKER,EXTERN};
    private TYPE type;
    private int id;
    //...

    public Student(int id, Student.TYPE type) {
        this.id = id;
        this.type=type;
        /....
    }
    public float calculateFinalGrade()    {
        float result=0.0f, finalGrade=0.0f;
        int count=0;

        switch (type) {
            case NORMAL:
                // weighted average considering ECTS and all registered courses           
            case WORKER:
                // weighted average,   considering ECTS and all assessed  courses
                break;
            case EXTERN:
               //simple average considering all assessed  courses            
                break;
        }
        return finalGrade;
    }

}
```


###Solução 1 - estender switch case
- Adicionar mais um valor ao enumerado
- Adicionar mais um case no método`` public float calculateFinalGrade() ``
###Solução 2 – Polimorfismo

- Definir a classe Student como abstrata e o método  `` public float calculateFinalGrade() `` 
como abstrato e retirar o enumerado e o atributo type
- Implementar uma classe por cada tipo de estudante onde o método   `` public float calculateFinalGrade() `` é implementado






Enquanto que com a solução 1 é possivel fazer
```java
 Student st1 = new Student(1, Student.TYPE.NORMAL);
 st1.addCourse(c1,c2,c3,c4);
 st1.setGrade(1,10);
 st1.setGrade(2,20);
 System.out.printf(" \nStudent %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
 st1.setType(Student.TYPE.WORKER);
 System.out.printf(" \nStudent as Worker %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
```
### Problema do Polimorfismo
Não seria possivel o estudante mudar de estatuto a meio. Ou seja se o estudante mudasse para estatuto de trabalhador estudante, a informação sobre o estudante inicial seria perdida

```java
 Student st1 = new StudentNormal(1);
 st1.addCourse(c1,c2,c3,c4);
 st1.setGrade(1,10);
 st1.setGrade(2,20);
 System.out.printf(" \nStudent %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
 st1 = new StudentWorker(1); 
 System.out.printf(" \nStudent as Worker %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
```


```java
public interface Strategy {
    float calculateFinalGrade(Map<Course,Integer> gradeList, Map<Integer,Course> courseList);
    boolean isApproved(Map<Course,Integer> gradeList, Map<Integer,Course> courseList);
}
```

```java
public class StrategyNormal implements Strategy {
    @Override
    public float calculateFinalGrade(Map<Course, Integer> grades, Map<Integer, Course> courseList) {
        float result = 0.0f, finalGrade = 0.0f;
        int count = 0;

        for (Course c : courseList.values()) {
            if (grades.containsKey(c))
                result += (grades.get(c) * c.getECTS());
            count += c.getECTS();
        }
        finalGrade = result / count;
        return finalGrade;
    }
```
```java
public class StrategyExtern implements Strategy {
    @Override
    public float calculateFinalGrade(Map<Course, Integer> grades, Map<Integer, Course> courseList) {
        float result = 0.0f, finalGrade = 0.0f;
        int count = 0;
        for (Course c : courseList.values()) {
            if (grades.containsKey(c)) {
                result += (grades.get(c));
                count++;
            }
        }
        finalGrade = result / count;
        return finalGrade;
    }
```
```java
public class Student {

    private Strategy strategy;
    private int id;
    private Map<Integer, Course> courseList;
    private Map<Course, Integer> grades;

    public Student(int id,Strategy strategy) {
        this.id = id;
        courseList= new HashMap<>();
        grades= new HashMap<>();
        this.strategy=strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public float calculateFinalGrade()    {
        float finalGrade=strategy.calculateFinalGrade(grades,courseList);
        return finalGrade;
    }
```


```java
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
        System.out.printf(" \nStudent %d Final grade:%.1f " , st1.getId(), st1.calculateFinalGrade());
        st1.setStrategy(new StrategyWorker());
        System.out.printf(" \nStudent %d Final grade:%.1f ",st1.getId(), st1.calculateFinalGrade());
    }
}


```