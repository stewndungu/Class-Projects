/** 
* 
* Student name:  Stewart Ndung'u
* Completion date: 7/5/2026
*
* Student tasks: implement LineEditor
*
* LineEditor class is a for the command line interface for the LineList class. 
* It allows users to load, save, and manipulate text files using various commands.
*
*/


import java.util.Scanner;

public class LineEditor {

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("m - Show menu");
        System.out.println("load fileName appendOption(1-append, 0-new list)");
        System.out.println("p - Print document");
        System.out.println("lines - Display number of lines");
        System.out.println("line lineNumber - Display a specific line");
        System.out.println("words - Count words");
        System.out.println("del lineNumber - Delete a line");
        System.out.println("a - Append line");
        System.out.println("i lineNumber text - Insert line");
        System.out.println("cls - Clear document");
        System.out.println("rep originalWord newWord - Replace words");
        System.out.println("s fileName - Save to a file");
        System.out.println("quit - Exit");
    }




    public static void main(String[] args) {
        LineList list = new LineList();
        Scanner scanner = new Scanner(System.in);

        //checks to see if there is an initial argument when starting the LineEditor class
        if (args.length > 0) {
            try {
                list.load(args[0], false);
                System.out.println("Loaded file: " + args[0]);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        // Auto print the menu when the program starts
        printMenu();

        //until keyword quit is entered or CTRL + C is pressed, the program will continue to prompt for commands
        while (true) {
            System.out.print("---> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            // Split the input into command and arguments
            String[] parts = input.split("\\s+", 3);
            String command = parts[0].toLowerCase();

            switch (command) {

                //prints menu command
                case "m":
                    printMenu();
                    break;

                //load command, loads a file into the LineList. If appendOption is 1, it appends to the existing list; if 0, it creates a new list.
                case "load":
                    if (parts.length < 3) {
                        System.out.println("Usage: load fileName appendOption(1-append, 0-new list)");
                    } else {
                        try {
                            boolean append = Integer.parseInt(parts[2]) == 1;
                            list.load(parts[1], append);
                            System.out.println("Loaded file: " + parts[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("appendOption must be 0 or 1");
                        }
                    }
                    break;

                //save command, saves the current list to a specified file.
                case "s":
                    if (parts.length < 2) {
                        System.out.println("Usage: s fileName");
                    } else {
                        list.save(parts[1]);
                        System.out.println("Saved to: " + parts[1]);
                    }
                    break;
                
                //append command, adds a new line to the end of the list. 
                case "a":
                    if (parts.length < 2) {
                        System.out.print("Enter line: ");
                        String line = scanner.nextLine();
                        list.addLine(line);
                    } else {
                        list.addLine(parts[1]);
                    }
                    break;

                //insert command, adds a new line at a specified position in the list.
                case "i":
                    if (parts.length < 2) {
                        System.out.println("Usage: i lineNumber");
                    } else {
                        try {
                            int n = Integer.parseInt(parts[1]);
                            System.out.print("Type a line: ");
                            String line = scanner.nextLine();
                            list.addLine(line, n);
                        } catch (NumberFormatException e) {
                            System.out.println("lineNumber must be an integer");
                        }
                    }
                    break;

                //words command, counts and displays the total number of words in the list.
                case "words":
                    System.out.println(list.words());
                    break;

                 //lines command, counts and displays the total number of lines in the list.   
                case "lines":
                    System.out.println(list.lines());
                    break;

                //delete command, deletes a specified line from the list.
                case "del":
                    if (parts.length < 2) {
                        System.out.println("Usage: del lineNumber");
                    } else {
                        try {
                            list.delete(Integer.parseInt(parts[1]));
                        } catch (NumberFormatException e) {
                            System.out.println("lineNumber must be an integer");
                        }
                    }
                    break;

                //print command, displays all lines in the list with their line numbers.    
                case "p":
                    list.print();
                    break;

                //replace command, replaces all occurrences of a specified word with another word in the list.
                case "rep":
                    if (parts.length < 3) {
                        System.out.println("Usage: rep originalWord newWord");
                    } else {
                        list.replace(parts[1], parts[2]);
                    }
                    break;

                //line command, displays a specific line from the list based on the provided line number.
                case "line":
                    if (parts.length < 2) {
                        System.out.println("Usage: line lineNumber");
                    } else {
                        try {
                            list.line(Integer.parseInt(parts[1]));
                        } catch (NumberFormatException e) {
                            System.out.println("lineNumber must be an integer");
                        }
                    }
                    break;

                //clear command, clears all lines from the list.
                case "cls":
                    list.empty();
                    System.out.println("Document cleared");
                    break;

                //quit command, exits the program gracefully.
                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                //default case, handles unknown commands and prompts the user to refer to the menu.
                default:
                    System.out.println("Unknown command. Type 'm' for menu.");
            }
        }
    }


}
