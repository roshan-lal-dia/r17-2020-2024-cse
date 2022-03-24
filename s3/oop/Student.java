//Assignment 1 -OOP by Roshan Lal J -41

//v 1.0 java program for getting name and roll no.
//v 2.0 getting marks and calculating total and sum
//v 3.0 calculating and displaying grade
import java.util.Scanner; // library containing Scanner
class Student
{
//getting details as inputs v 1.0
String name;
int Rollno;
//getting marks as inputs v 2.0
int one, two, three, four, five;
//variables for total and average
int tot;
float avg;
Scanner sc = new Scanner(System.in);
void Input()
{
System.out.println("Enter Student Name :");
name = sc.nextLine(); //nextLine for reading text until end of line
System.out.println("Enter Rollno :");
Rollno = sc.nextInt();
//getting marks as inputs
System.out.println("\n[Note] Enter Marks in the Range 0-100 \n");

 System.out.println("Enter marks of subject one :");
one = sc.nextInt();
System.out.println("Enter marks of subject two :");
two = sc.nextInt();
System.out.println("Enter marks of subject three :");
three = sc.nextInt();
System.out.println("Enter marks of subject four :");
four = sc.nextInt();
System.out.println("Enter marks of subject five :");
five = sc.nextInt();

//Calculationg total
tot = one + two + three + four + five;
//calculating average
avg = tot/5;
}
//Calculating total
void Calculate ()
{
//Calculationg total
tot = one + two + three + four + five;
//calculating average
avg = tot/5;
}
void Display() //Displaying outputs
{
System.out.println(" Student Name " + name);
System.out.println(" Rollno is " + Rollno);
System.out.println("Total Marks = " + tot);
System.out.println("Average = " + avg);
}
//grade calculation
void Grade ()
{
if ( avg > 90	)	{
System.out.println("Grade A");
}
else if ( avg > 80 )	{
System.out.println("Grade B");
}
else if ( avg > 70)	{
System.out.println("Grade C");
}
else if ( avg > 60)	{
System.out.println("Grade D");
}
else if ( avg >= 45)	{
System.out.println("Grade E");
}
else if ( avg < 45 )	{
System.out.println("Fail");
}
else if ( avg > 100 )	{
System.out.println("The Entered marks don't make average to 100% ");
}
}
public static void main (String arg[]) {
Student S = new Student();
S.Input( );
S.Calculate();
S.Display();
S.Grade( ); }
}
