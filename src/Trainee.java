//create class
public class Trainee implements Comparable {
  
  //declaration
    //define variables having datatype string and double
        private String ID;
        private String name;
        private String major;
        private String age;
//Constructor    
    //initiate: create new object using constructor 
        public Trainee(String ID, String name, String major, String age) {
            //use super to call the super constructor and give it both parameters
        //intialize for the super class attribute that I inherit them
                super();
                this.ID = ID;
                this.name = name;
                this.major = major;
                this.age = age;
        }
 //getter
        public String getID() {
                return ID;
        }//end getter
 //getter
        public String getName() {
                return name;
        }//end getter
 //getter
        public String getMajor() {
                return major;
        }//end getter
 //getter
        public String getAge() {
                return age;
        }//end getter
 //setter
        public void setID(String id) {
                this.ID = ID;
        }//end setter
 //setter
        public void setName(String name) {
                this.name = name;
        }//end setter
 //setter
        public void setMajor(String major) {
                this.major = major;
        }//end setter
 //setter
        public void setAge(String age) {
                this.age = age;
        }//end setter
        
//toString: format the class's contents.
    @Override
    public String toString() {
           //call the toString from the super rather than writing it again using "super."
        return "\n Traineess ID: " + ID + ", Name: " + name + ", Major: " + major + ", Age: " + age ;
    }
    
    public boolean equals(Object obj){
        Trainee tr = (Trainee) obj;
        return ID.equals(tr.ID) && name.equals(tr.name);
    }


    public int compareTo(Object trainee) {
        Trainee tr = (Trainee) trainee;
          return this.ID.compareTo(tr.ID);
    }
    
    
}//end class
