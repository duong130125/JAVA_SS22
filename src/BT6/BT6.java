package BT6;

public class BT6 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "copy.txt";
        String content = "Hello World! This is a test string.";

        FileHandler.writeToFile(inputFile, content);

        String originalContent = FileHandler.readFromFile(inputFile);
        String reversedContent = StringReverser.reverse(originalContent);

        FileHandler.writeToFile(outputFile, reversedContent);

        String result = FileHandler.readFromFile(outputFile);
        System.out.println("Nội dung trong file copy.txt: " + result);
    }
}
