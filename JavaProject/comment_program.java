import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class comment_program {
    public static void remove_comments(File file, String output_path) throws FileNotFoundException, IOException{
		
        System.out.println("1. Finding comments...");

        String buffer = "";

		Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            String current_line = scan.nextLine();
            
            // Case 1: Single-line comment
            int comment_pos = current_line.indexOf("//");
            if (comment_pos > 0) {
                // System.out.println(current_line.substring(0, comment_pos));
                buffer += (current_line.substring(0, comment_pos) + "\n");
                continue;
            }

            // Case 2: Multi-line comment
            comment_pos = current_line.indexOf("/*");
            if (comment_pos > 0) {
                System.out.println(current_line.substring(0, comment_pos) + "\n");

                while (true) {
                    current_line = scan.nextLine();
                    comment_pos = current_line.indexOf("*/");
                    if (comment_pos > 0) {
                        // System.out.println(current_line.substring(comment_pos + 2, current_line.length()));
                        buffer += (current_line.substring(comment_pos + 2, current_line.length()) + "\n");
                        break;
                    }
                }
                continue;
            }

            // Case 3: No comment
            // System.out.println(current_line);
            buffer += (current_line + "\n");
        }

        scan.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(output_path));
	    bw.write(buffer);
	    bw.close();

        System.out.println("Comments removed and file output written successfully.\n");
    }
}