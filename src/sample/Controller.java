package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public void run() {
        DateFormatter();
    }



    @FXML
    private TableColumn<?, ?> day1Column;

    @FXML
    private static Button add;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        System.out.println("Button clicked");
        //add.setText("ADD");

    }

    public static String getWeekStartDate() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        Format dateFormat = new SimpleDateFormat("EEE MM-dd");
        String res = dateFormat.format(calendar.getTime());
        return res;
    }

    public static String getWeekEndDate() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, 1);
        }
        calendar.add(Calendar.DATE, -1);
        Format dateFormat = new SimpleDateFormat("EEE MM/dd");
        String res = dateFormat.format(calendar.getTime());
        return res;
    }
    public String DateFormatter(){
       String weekStartDate = getWeekStartDate();
       String weekEndDate = getWeekEndDate();
       String dateOf = weekStartDate + "- " + weekEndDate;
       return dateOf;
    }

    @FXML
    private Label weekOfLabel;


    private void init() {
        String weekDate = DateFormatter();
        weekOfLabel.setText(weekDate);
    }

    public static void Add(){
       // Parent root = FXMLLoader.load(getClass().getResource("\"sample.fxml\""))
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        //Add();
      //  add.setOnAction(this::handleButtonClick);
    }


}

