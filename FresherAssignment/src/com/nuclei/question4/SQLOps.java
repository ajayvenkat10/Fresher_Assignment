package com.nuclei.question4;

import java.sql.*;
import java.util.ArrayList;

public class SQLOps implements Runnable {
    ApplicationState state = ApplicationState.getInstance();

    CoreFunctions core;

    SQLOps(CoreFunctions core) {
        this.core = core;
        new Thread(this, "SQLRead").start();
    }

    @Override
    public void run() {
        Logger.log("SQL thread started");
        ResultSet resultSet = null;
        try {
            resultSet = Utilities.statement.executeQuery(Constants.QUERY);
        } catch (SQLException e) {
            ;
        }
        try {
            while (resultSet.next()) {
                Item item = new Item();
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getFloat("price"));
                item.setQuantity(resultSet.getInt("quantity"));
                item.setType(resultSet.getString("type"));
                core.fetchFromDB(item);
            }
            state.setTerminate(true);
        } catch (Exception e) {
            ;
        }
    }
}
