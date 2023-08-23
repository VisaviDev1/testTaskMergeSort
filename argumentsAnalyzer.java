import java.util.ArrayList;

public class argumentsAnalyzer {
    boolean analyzeArguments(String args[]){
        if(args.length < 3){
            System.out.println("Error. Invalid number of arguments.");
            return false;
        }

        int numOfArgs   = 0;

        for(int i = 0; i < 2; i++){
            if("-s".equals(args[i]) || "-i".equals(args[i])){
                if("-s".equals(args[i])) Main.setIsInteger(false);
                ++numOfArgs;
            }
            else if("-a".equals(args[i]) || "-d".equals(args[i])){
                if("-d".equals(args[i])) Main.setInAscending(false);
                ++numOfArgs;
            }
            else {
                System.out.println("Error. Invalid arguments");
                return false;
            }
        }

        if(args[numOfArgs].endsWith(".txt") && args[numOfArgs].length() > 4)
            Main.setOutputFile(args[numOfArgs++]);
        else{
            System.out.println("Error. Invalid name of output file.");
            return false;
        }

        ArrayList<String> inputFiles = new ArrayList<>();
        for(int i = numOfArgs - 1; i < args.length - 1; i++) {
            if(args[numOfArgs].endsWith(".txt") && args[numOfArgs].length() > 4)
                inputFiles.add(args[numOfArgs++]);
            else{
                System.out.println("Error. Invalid name of input file.");
                return false;
            }
        }
        Main.setInputFiles(inputFiles);

        return true;
    }
}
