import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Student
{
    String name;

    int marks;

    public Student(String name , int marks)
    {
        this.name = name;

        this.marks = marks;
    }
}


class nameCompare implements Comparator<Student>
{

    public int compare(Student s1, Student s2)
    {
        return s1.name.compareTo(s2.name);
    }
}


class marksCompare implements Comparator<Student>
{

    public int compare(Student s1, Student s2)
    {
        return s2.marks - s1.marks;
    }
}

public class Rankingproducts
{
    public static void main(String[] args)throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader("file.text"));

 

        ArrayList<Student> studentRecords = new ArrayList<Student>();

        //BufferedWriter writer = new BufferedWriter(new FileWriter("file1.text"));



        String currentLine = reader.readLine();

        while (currentLine != null)
        {
            String[] studentDetail = currentLine.split(", ");

            Arrays.toString(studentDetail);

            String name = studentDetail[0]; 

            int marks = Integer.parseInt(studentDetail[1]);
            studentRecords.add(new Student(name, marks));
            currentLine = reader.readLine();
        }
        Collections.sort(studentRecords, new marksCompare());
        BufferedWriter writer = new BufferedWriter(new FileWriter("file1.text"));

        int rank = 1;
        int numOfLine = 0;
        int temporary = 0;
        int mark = 0;
        for (Student student : studentRecords)
        {
            if(numOfLine ==  0) {
                temporary = student.marks;
                writer.write("" + rank);
                writer.write(", " + student.name);
                numOfLine += 1;
            }
            else {
                mark = student.marks;
                if(temporary == mark) {
                    writer.write("" + rank);
                    writer.write(", " + student.name);
                    numOfLine += 1;
                    temporary = mark;
                }
                else {
                    numOfLine += 1;
                    writer.write("" + numOfLine);
                    writer.write(", " + student.name);
                    rank = numOfLine;
                    temporary = student.marks;
                }
            }
            writer.newLine();
        }
        reader.close();
        writer.close();

        BufferedReader reader1 = new BufferedReader(new FileReader("file1.text"));
        String currentLine1;
        while((currentLine1 = reader1.readLine()) != null) {
            System.out.println(currentLine1);
        }

        //Closing the resources


        reader1.close();

    }
}