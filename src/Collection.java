
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; //to set up an array list it is important to import it
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
//create class
public class Collection {

    Map<String, TreeSet<Trainee>> allList;

    public Collection() {
        allList = new TreeMap<String, TreeSet<Trainee>>();
    }
//define new arraylist called sections
    public ArrayList<String> readCourses() {
        ArrayList<String> courseList = new ArrayList<String>();
        try {
            Scanner input = new Scanner(new File("src/courses.txt"));
                //while statement
            while (input.hasNextLine()) {
                String course = input.nextLine();
                courseList.add(course);
                allList.put(course, null);
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }

        return courseList;
    }

    public void addTrainee(Trainee t, String course) {
        boolean flag = false;
         //for loop with i having initial value=0 
        //iterate by one if condition is satisfied
        TreeSet<Trainee> courseList = new TreeSet<Trainee>();
        for (int i = 0; i < allList.size(); i++) {
//if statement
            if (allList.containsKey(course)) {
                courseList = allList.get(course);
                if (courseList != null) {
                    for (Trainee train : courseList) {
                        if (train.getID().equals(t.getID())) {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    courseList = new TreeSet<Trainee>();
                    flag = false;
                }

            }

        }
        if (flag == false) {
            courseList.add(t);
            System.out.println("Trainee "+ t.getID()  +" has been added!");
            allList.put(course, courseList);
        } else {
            System.out.println("Trainee "+ t.getID()  +" is already exists!");
        }//end if statement
    }

    public void removeTrianee(Trainee t, String course) {
        boolean flag = false;
        TreeSet<Trainee> courseList = new TreeSet<Trainee>();
        for (int i = 0; i < allList.size(); i++) {
 //if statement
            if (allList.containsKey(course)) {
                courseList = allList.get(course);
                if (courseList != null) {
                    for (Trainee train : courseList) {
                        if (train.getID().equals(t.getID())) {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    courseList = new TreeSet<Trainee>();
                    flag = false;
                }//end if statement

            }

        }
         //if statement
        if (flag == true) {
            courseList.remove(t);
            allList.put(course, courseList);
            System.out.println("Trainee "+ t.getID()  +" has been removed!");
        } else {
            System.out.println("Trainee " + t.getID() + " can't be remove because it is not exists!");
        }//end if statement

    }

    public String displayData() {
        String str = "";
        for (String x : allList.keySet()) {
            str += x + ": ";
            if (allList.get(x) != null) {
                for (Trainee y : allList.get(x)) {
                    str += y + " ";
                }
            }
            str += "\n";
        }
        return str;
    }
}//end class
