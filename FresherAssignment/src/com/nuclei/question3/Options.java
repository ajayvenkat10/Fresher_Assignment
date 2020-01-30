package com.nuclei.question3;


import java.util.InputMismatchException;
import java.util.Scanner;

import static com.nuclei.question3.Inputs.enterID;

/**
 * The type Options.
 */
public class Options {

    /**
     * The Input.
     */
    static Scanner input = new Scanner(System.in);
    /**
     * The Id.
     */
    static int id, /**
     * The Parent id.
     */
    parentId, /**
     * The Child id.
     */
    childId;

    /**
     * Options.
     */
    public static void options() {

        while (true) {

            Functions functions = new Functions();
            Logger.log("Welcome to Family Tree!");
            Logger.log("1.Get Parents of a Node\n2.Get Children of a Node\n3.Get Ancestors of a Node\n4.Get Descendants of a Node\n5.Delete Dependency\n6.Delete Node\n7.Add Dependency\n8.Add Node\n9.Exit");
            Logger.logp("Enter your choice: ");
            try {
                int choice = input.nextInt();
                String name;
                switch (choice) {
                    case 1:
                        id = enterID();
                        if (Validation.validateId(id)) {
                            functions.getParents(id);
                        }
                        break;

                    case 2:
                        id = enterID();
                        if (Validation.validateId(id)) {
                            functions.getChildren(id);
                        }
                        break;

                    case 3:
                        id = enterID();
                        if (Validation.validateId(id)) {
                            functions.getAncestors(id);
                        }
                        break;

                    case 4:
                        id = enterID();
                        if (Validation.validateId(id)) {
                            functions.getDescendants(id);
                        }
                        break;

                    case 5:
                        parentId = enterID("parent");
                        childId = enterID("child");
                        if (Validation.validateParentAndChildIds(parentId, childId)) {
                            if(Validation.validateDependency(parentId, childId)) {
                                functions.deleteDependency(parentId, childId);
                            }
                            else{
                                ExceptionHandler.handleGenericException("Dependency does not exist!");
                            }
                        }
                        break;

                    case 6:
                        id = enterID();
                        if (Validation.validateId(id)) {
                            functions.deleteNode(id);
                        }
                        break;

                    case 7:
                        parentId = enterID("parent");
                        childId = enterID("child");
                        if (Validation.validateParentAndChildIds(parentId, childId)) {
                            if(!Validation.validateDependency(parentId, childId)) {
                                functions.addDependency(parentId, childId);
                            }
                            else{
                                ExceptionHandler.handleGenericException("Given dependency already exists!");
                            }
                        }
                        break;

                    case 8:
                        id = enterID();
                        Logger.logp("Enter node name: ");
                        name = input.next();
                        if (Validation.validateNewId(id)) {
                            functions.addNode(id, name);
                        }
                        break;

                    case 9:
                        System.exit(0);

                    default:

                }

            }catch (InputMismatchException e){
                ExceptionHandler.handleGenericException("Invalid input! Numbers only!");
                input.next();
            }
        }
    }
}
