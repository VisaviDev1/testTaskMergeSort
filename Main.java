import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static boolean isInteger   = true;
    private static boolean inAscending = true;
    private static String  outputFile;
    private static ArrayList<String> inputFiles = new ArrayList<>();

    //Setters and getters of variables
    public static void setIsInteger(boolean setIsInteger){
        isInteger = setIsInteger;
    }
    public static boolean getIsInteger(){
        return isInteger;
    }
    public static void setInAscending(boolean setInAscending){
        inAscending = setInAscending;
    }
    public static boolean getInAscending(){
        return  inAscending;
    }
    public static void setOutputFile(String setOutputFile){
        outputFile = setOutputFile;
    }
    public static String getOutputFile(){
        return outputFile;
    }
    public static void setInputFiles(ArrayList<String> setInputFiles){
        inputFiles = setInputFiles;
    }

    public static void main(String[] args) throws IOException {
        argumentsAnalyzer analyzer = new argumentsAnalyzer();
        mergeSorter sorter = new mergeSorter();

        //Analyzing of console arguments and exiting in case of wrong arguments
        if(!analyzer.analyzeArguments(args)) return;

        sorter.mergeSortString(inputFiles, outputFile, inAscending, isInteger);
    }
}
