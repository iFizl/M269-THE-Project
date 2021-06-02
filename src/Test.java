//create class

public class Test {

    public static void main(String[] args) {
        
        Collection c = new Collection();
        c.readCourses();
//define data
       Trainee s1941 = new Trainee("s1941", "Abdulrahman","IT", "19");
        Trainee s1942 = new Trainee("s1942", "Waleed", "English", "18");
        Trainee s1943 = new Trainee("s1943", "Malak", "Markting", "23");
        Trainee s1944 = new Trainee("s1944", "Shayma", "CS", "21");
        Trainee s1945 = new Trainee("s1945", "Nawaf", "Business Administration", "22");
        Trainee s1946 = new Trainee("s1946", "Ahmed", "Networking", "20");
       Trainee s1947 = new Trainee("s1947", "Ibrahem", "Markting", "22");
        Trainee s1948 = new Trainee("s1948", "Khaled", "CS", "19");

        //add trainee to course
        c.addTrainee(s1946, "M269");
        c.addTrainee(s1942, "M269");
        c.addTrainee(s1941, "M269");
        c.addTrainee(s1943, "M269");
        c.addTrainee(s1944, "M269");
        c.addTrainee(s1945, "M269");
        c.addTrainee(s1945, "M269");
        
        c.addTrainee(s1941, "AR112");
        c.addTrainee(s1941, "M106");
        c.addTrainee(s1946, "TM354");
        c.addTrainee(s1946, "TM105");
        //remove trainee from course
        c.removeTrianee(s1941, "A269");
        c.removeTrianee(s1946, "M106");
       c.removeTrianee(s1941, "M269");

      
        System.out.println(  c.displayData());
    }
}//end class
