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
        //if(!isInteger && !inAscending) sorter.mergeSortStringDescending(inputFiles, outputFile);
        //if(!isInteger && inAscending)  sorter.mergeSortStringAscending(inputFiles, outputFile);
        if(isInteger && !inAscending) return;//
        if(isInteger && inAscending) return;//Fix later
    }

    private static void printStartMessage(){
        System.out.println("MERGE SORT PROGRAM. Java version 1.8.0_351");
        System.out.println("Usage: testTaskMergeSort.exe [-sorting_mode] [-options] [output_file] [input_files]");
        System.out.println("sorting_mode argument is necessery. sorting_mode include: ");
        System.out.println("\t-s for sorting strings");
        System.out.println("\t-i for sorting integers");
        System.out.println("where options include: ");
        System.out.println("\t-a for sorting in ascending order");
        System.out.println("\t-d for sorting in descending order");
    }
}
