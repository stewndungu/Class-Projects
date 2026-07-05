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

        if (args.length > 0) {
            try {
                list.load(args[0], false);
                System.out.println("Loaded file: " + args[0]);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        printMenu();

        while (true) {
            System.out.print("---> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 3);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "m":
                    printMenu();
                    break;
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
                case "s":
                    if (parts.length < 2) {
                        System.out.println("Usage: s fileName");
                    } else {
                        list.save(parts[1]);
                        System.out.println("Saved to: " + parts[1]);
                    }
                    break;
                case "a":
                    if (parts.length < 2) {
                        System.out.print("Enter line: ");
                        String line = scanner.nextLine();
                        list.addLine(line);
                    } else {
                        list.addLine(parts[1]);
                    }
                    break;
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
                case "words":
                    System.out.println(list.words());
                    break;
                case "lines":
                    System.out.println(list.lines());
                    break;
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
                case "p":
                    list.print();
                    break;
                case "rep":
                    if (parts.length < 3) {
                        System.out.println("Usage: rep originalWord newWord");
                    } else {
                        list.replace(parts[1], parts[2]);
                    }
                    break;
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
                case "cls":
                    list.empty();
                    System.out.println("Document cleared");
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Type 'm' for menu.");
            }
        }
    }


}
