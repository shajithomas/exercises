/*
Grocery store sells butter
3 sizes - 10 gms
5 gms
1 gm

inventory
x - 10
y - 5
z - 1

customer wants to by N gms of butter\
Calculate how many packs of each
*/

import org.junit.Test;

public class GuideWire2 {

    public static void main(String[] args) {
        int N = 126;

        //inventory
        int x = 10;
        int y = 5;
        int z = 1;

        int xQuantity = N / 10; // num of x packs
        if (xQuantity > x) {
            xQuantity = x;
        }
        int yQuantity = (N - 10 * xQuantity) / 5;
        if (yQuantity > y) {
            yQuantity = y;
        }
        int zQuantity = N - (xQuantity * 10 + yQuantity * 5);
        if (zQuantity > z) {
            System.out.println("Error: Unable to fulfill the order");
        }
        System.out.println("xQuantity: " + xQuantity);
        System.out.println("yQuantity: " + yQuantity);
        System.out.println("zQuantity: " + zQuantity);

    }

    @Test
    public void testDeadlock() {
        System.out.println("Hello World");
    }


}




/*
SQL test from Guidewire
-----------------------
school
student name
grade level

catalog
course name

registration info


student table
------------
id - pk
name
grade

course
id - pk
course name


registration table
regId
studentId
course Id


Find the grade level that most students got.

    CREATE TABLE STUDENTS(Id integer PRIMARY KEY, Name text, grade integer);

    INSERT INTO STUDENTS VALUES(1,'Tom', 2);
    INSERT INTO STUDENTS VALUES(2,'Lucy',3);
    INSERT INTO STUDENTS VALUES(3,'Frank',3);
    INSERT INTO STUDENTS VALUES(4,'Jane',2);
    INSERT INTO STUDENTS VALUES(5,'Robert',2);
    COMMIT;


select grade, max(g_count) from (
select grade, count(grade) g_count from students
group by grade
)

 */

