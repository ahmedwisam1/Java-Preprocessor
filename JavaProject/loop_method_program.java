import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class loop_method_program {
    public static void find_loops_methods(File file) {
        System.out.println("3. Finding loops and methods...");
        try {
            System.out.println("Methods:-");
            methods(file);

            System.out.println("\nLoops:-");
            loops(file);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Identifying loops
    private static void loops(File input_file) throws FileNotFoundException {
        Scanner scan = new Scanner(input_file);
        int line_count = 1;
        String saved_line = "";

        // Regex pattern object
        String loop_pattern = "(while|for)+[ ]*\\(.*\\)[ ]*";
        Pattern loop_p = Pattern.compile(loop_pattern);

        while(scan.hasNextLine()) {
            String current_line = scan.nextLine();
            Matcher m = loop_p.matcher(current_line);
            if (m.find()) {
                int loop_beginning = line_count;
                saved_line = current_line.trim();

                // We use this counter to keep track of the number of open/closing brackets
                // to find which line the matching bracket for the loop is at.
                int brackets_count = 0;

                // Check if the loop line has the open bracket
                while (true){
                    if (current_line.indexOf("{") > 0) {
                        brackets_count = brackets_count + 1;
                        break;
                    }
                    current_line = scan.nextLine();
                    line_count++;
                }     
                // Check until the corresponding closing bracket is found
                while(scan.hasNextLine()) {
                    if (current_line.indexOf("}") > 0) {
                        brackets_count = brackets_count - 1;
                    }
                    if (brackets_count == 0) {
                        break;
                    }

                    current_line = scan.nextLine();
                    line_count++;

                    if (current_line.indexOf("{") > 0) {
                        brackets_count = brackets_count + 1;
                    }
                }

                System.out.println("Found at lines " + Integer.toString(loop_beginning) + "-" + Integer.toString(line_count) + ": " + saved_line);
            }

            line_count++;
        }

        scan.close();
    }

    // Identifying methods
    private static void methods(File input_file) throws FileNotFoundException {
        Scanner scan = new Scanner(input_file);
        int line_count = 1;
        String saved_line = "";

        // Regex pattern object
        String method_pattern = "([[public|private|protected] | [static|final|abstract|synchronized]] .* (.*))[ ]*\\(.*\\)[ ]*";        
        Pattern method_p = Pattern.compile(method_pattern);

        while(scan.hasNextLine()) {
            String current_line = scan.nextLine();
            Matcher m = method_p.matcher(current_line);
            if (m.find()) {
                int method_beginning = line_count;
                saved_line = current_line.trim();
                // We use this counter to keep track of the number of open/closing brackets
                // to find which line the matching bracket for the method is at.
                int brackets_count = 0;
                // Check if the loop line has the open bracket
                while (true){
                    if (current_line.indexOf("{") > 0) {
                        brackets_count = brackets_count + 1;
                        break;
                    }
                    current_line = scan.nextLine();
                    line_count++;
                }     
                // Check until the corresponding closing bracket is found
                while(scan.hasNextLine()) {
                    if (current_line.indexOf("}") > 0) {
                        brackets_count = brackets_count - 1;
                    }
                    if (brackets_count == 0) {
                        break;
                    }

                    current_line = scan.nextLine();
                    line_count++;

                    if (current_line.indexOf("{") > 0) {
                        brackets_count = brackets_count + 1;
                    }
                }

                System.out.println("Found at lines " + Integer.toString(method_beginning) + "-" + Integer.toString(line_count) + ": " + saved_line);
            }

            line_count++;
        }

        scan.close();
    }
}