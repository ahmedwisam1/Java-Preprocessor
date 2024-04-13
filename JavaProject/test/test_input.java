package test;
import java.util.Scanner;
public class test_input{
    String studentName;
    String studentLastName;
    // Comment here
    int numberOfCourses;
    test_input[] myCourses; // Comment here
    public void Student(String studentName,String studentLastName,int numberOfCourses)
    {
        /* 
         * Comment here
         */
        this.studentName=studentName;
        this.studentLastName=studentLastName;
        this.numberOfCourses=numberOfCourses;
        this.myCourses = new test_input[numberOfCourses];
    }
    public void createCourses()
   {
        for(int i=0;i<numberOfCourses;i++)
        {
            myCourses[i]=new test_input();
        }
   }
    public void printCourses()
   {
        System.out.println("Student name:"+studentName);
        System.out.println("Studentlast name:"+studentLastName);
        for(int i=0;i<numberOfCourses;i++)
                                     
        {
            myCourses[i].printCourses();

            if (5 == 7) {
                
            }
        }
   }
}