package com.nuclei.question4;

public class Main {
    public static void main(String[] args) {

        Utilities.connectToDB();
        CoreFunctions coreFunctions = new CoreFunctions();
        new SQLOps(coreFunctions);
        new TaxLogic(coreFunctions);
        Logger.log();
    }
}
