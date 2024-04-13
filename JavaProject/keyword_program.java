import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class keyword_program {
    
    public static void find_keywords(String pathname) throws IOException {
        String keywords[] = { "abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "extends", "false",
                "final", "finally", "float", "for", "goto", "if", "implements",
                "import", "instanceof", "int", "interface", "long", "native",
                "new", "null", "package", "private", "protected", "public",
                "return", "Scanner", "short", "static", "strictfp", "String", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "true",
                "try", "void", "volatile", "while" };

        // File file = new File(".\\test\\test_input.java");
        String file_content = Files.readString(Paths.get(pathname));

        System.out.println("2. Finding built-in constructs...");

        for (int i = 0; i < keywords.length; i++) {
            String current_keyword = keywords[i];
            if (file_content.contains(current_keyword)) {
                System.out.println(current_keyword);
            }
        }

        System.out.println();
    }
}