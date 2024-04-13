import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main_program {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String input_path = ".\\test\\test_input.java";
        String output_path = ".\\test\\test_output.java";
        File input_file;
        try {
            input_file = new File(input_path);

            comment_program.remove_comments(input_file, output_path);
            keyword_program.find_keywords(input_path);
            loop_method_program.find_loops_methods(input_file);
        }
        catch (Exception e) {
            System.out.println("Exception found:\n" + e.getMessage());
        }
    }
}