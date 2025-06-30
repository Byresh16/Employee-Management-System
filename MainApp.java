package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MainApp extends Application{
    @Override public void start(Stage stage)throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("/ui/EmployeeView.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Employee Management (JavaFX)");
        stage.show();
    }
    public static void main(String[] args){launch(args);}
}
