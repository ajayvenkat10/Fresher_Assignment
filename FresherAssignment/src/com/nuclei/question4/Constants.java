package com.nuclei.question4;

/**
 * The interface Constants.
 */
public interface Constants {
    /**
     * The constant MAXIMUM_RECORDS_LIMIT.
     */
    int MAXIMUM_RECORDS_LIMIT = 100;
    /**
     * The constant BORDER_LENGTH.
     */
    int BORDER_LENGTH = 50;
    /**
     * The constant MAXIMUM_TYPE_VALUE.
     */
    int MAXIMUM_TYPE_VALUE = 3;
    /**
     * The constant MINIMUM_TYPE_VALUE.
     */
    int MINIMUM_TYPE_VALUE = 1;
    /**
     * The constant MINIMUM_FINAL_COST.
     */
    int MINIMUM_FINAL_COST = 100;
    /**
     * The constant MAXIMUM_FINAL_COST.
     */
    int MAXIMUM_FINAL_COST = 200;
    /**
     * The constant ROUND_OFF_CONSTANT.
     */
    double ROUND_OFF_CONSTANT = 100D;

    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    String DB_URL =  "jdbc:mysql://localhost/itemDB";

    String USERNAME = "root";

    String PASSWORD = "123wiki&*(";

    String QUERY = "select * from item;";
}
