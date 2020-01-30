package com.nuclei.question4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import static com.nuclei.question1.Utilities.roundOff;

public class Utilities {
    static ApplicationState state = ApplicationState.getInstance();
    static Connection conn = null;
    static Statement statement = null;
    public static void connectToDB(){

        try{
            Class.forName(Constants.JDBC_DRIVER);

            Logger.log("Connecting to database.....");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
            Logger.log("Creating statement....");
            statement = conn.createStatement();


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void display(){
        ArrayList<Item> finalList = state.getItemsWithTax();
        Logger.log("Displaying contents: ");
        Logger.log("Size of finalList: "+ finalList.size());
        for(Item item: finalList){
            Logger.log();
            Logger.log("Item Name: " + item.getName());
            Logger.log("Item Price: " + item.getPrice());
            //Rounding off to two decimal places
            Logger.log("Sales Tax Liability Per Term: " + roundOff(item.getTax()));
            Logger.log("Final Price: " + roundOff(item.getPrice() + item.getTax()));
        }
    }
}
