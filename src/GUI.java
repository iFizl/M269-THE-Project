
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
//create class
public class GUI extends Application {

    Collection c = new Collection();
    TextField txt_ID, txt_traineeName, txt_traineeAge, txt_traineemajor;
    TextArea txtAr;
    Button btn_addTrainee, btn_removeTrainee, btn_displayData, btn_save, btn_load, btn_clear;
    ComboBox CCBox;

    public void start(Stage myStage) {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11, 11, 11, 11));
        pane.setAlignment(Pos.TOP_CENTER);
        pane.add(new Label("Enter ID of Trainee"), 0, 0);
        txt_ID = new TextField("");
        pane.add(txt_ID, 1, 0);

        pane.add(new Label("Enter Name of Trainee"), 0, 1);
        txt_traineeName = new TextField("");
        pane.add(txt_traineeName, 1, 1);

        pane.add(new Label("Enter Major of Trainee"), 0, 2);
        txt_traineeAge = new TextField("");
        pane.add(txt_traineeAge, 1, 2);

        pane.add(new Label("Enter Age of Trainee"), 0, 3);
        txt_traineemajor = new TextField("");
        pane.add(txt_traineemajor, 1, 3);

        CCBox = new ComboBox();

        CCBox.setPromptText("Choose Course");
        CCBox.getItems().addAll(c.readCourses());

        btn_addTrainee = new Button("Add Trainee");
        btn_removeTrainee = new Button("Remove Trainee");
        btn_displayData = new Button("Display Data");

        FlowPane pane1 = new FlowPane(CCBox, btn_addTrainee, btn_removeTrainee, btn_displayData);
        pane.add(pane1, 1, 4);

        txtAr = new TextArea();
        pane.add(txtAr, 1, 5);
        txtAr.setPrefColumnCount(30);
        txtAr.setPrefRowCount(15);


        btn_clear = new Button("clear");

        pane.add(btn_clear, 1, 6);

        Scene s = new Scene(pane, 700, 500);
        myStage.setScene(s);
        myStage.setTitle("M251 TMA");
        myStage.show();



        btn_addTrainee.setOnAction(new Handler());
        btn_removeTrainee.setOnAction(new Handler());
btn_displayData.setOnAction(new Handler());
        btn_clear.setOnAction(new Handler());
    }

    class Handler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {
 //if statement
            if (e.getSource().equals(btn_addTrainee)) {
               
                
                
                if (txt_ID.getText().equals("") || txt_traineeName.getText().equals("") || txt_traineemajor.getText().equals("")
                        || txt_traineeAge.getText().equals("")) {
                    
                    showDialogBox("you must fill all text boxes!");
                } else {
                    
                
                    Trainee s1941 = new Trainee(txt_ID.getText(), txt_traineeName.getText(), txt_traineemajor.getText(), txt_traineeAge.getText());
                    
                    String combo = "";
                     
                try{
                 
                     c.addTrainee(s1941, CCBox.getValue().toString());
                    showDialogBox("course Added successfully!");
                }catch(Exception ex){
                      showDialogBox("you must choose the course!");
                  }
                
                   
                }

            } else if (e.getSource().equals(btn_removeTrainee)) {

                Trainee s1941 = new Trainee(txt_ID.getText(), txt_traineeName.getText(), txt_traineemajor.getText(), txt_traineeAge.getText());
                if (txt_ID.getText().equals("")) {
                    showDialogBox("you must fill all text boxes!");
                } else {
                    
                    
                    
                     String combo = "";
                try{
                 c.removeTrianee(s1941, CCBox.getValue().toString());
                    showDialogBox("course removed successfully!");
                }catch(Exception ex){
                      showDialogBox("you must choose the course!");
                  }
                
                }

            }
            else if (e.getSource().equals(btn_displayData)) {
                txtAr.setText(c.displayData());
                 
            }
         
             else if (e.getSource().equals(btn_clear)) {
                txt_ID.setText("");
                txt_traineeAge.setText("");
                txt_traineemajor.setText("");
                txt_traineeName.setText("");
                txtAr.setText("");
                
            } //end if statement

        }

        public void showDialogBox(String s) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText(s);
            alert.showAndWait();
        }

        public void showDialogBoxError(String s) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText(s);
            alert.showAndWait();

        }

    }

    public static void main(String[] args) throws Exception {
        GUI.launch(args);
    }
}//end class
