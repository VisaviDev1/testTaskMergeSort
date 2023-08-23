import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class mergeSorter {
    void mergeSortString(ArrayList<String> inputFiles, String outputFile, boolean inAscending, boolean isInteger) throws IOException {
        //Creating of BufferedReader for each file
        BufferedReader[] readers = new BufferedReader[inputFiles.size()];
        for(int i = 0; i < inputFiles.size(); i++){
            readers[i] = new BufferedReader(new FileReader(inputFiles.get(i)));//WHY! LISA! WHY! YOU'RE TEARING ME APART!!!
        }

        //Creating of BufferedWriter for writing of sorted values to new file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        //Creating of PriorityQueue to contain current strings from files in predicted order
        PriorityQueue<Pair> queue;
        if(inAscending) {
            queue = new PriorityQueue<>();
        }
        else{
            queue = new PriorityQueue<>(Collections.reverseOrder());
        }

        //Read the first line form each file and add them to the PriorityQueue
        for(int i = 0; i < inputFiles.size(); i++){
            String line = readers[i].readLine();
            if(line != null){
                if(isInteger){
                    int num = Integer.parseInt(line);
                    queue.add(new Pair(i, num));
                }
                else{
                    queue.add(new Pair(i, line));
                }
            }
        }

        //While PriorityQueue is not empty, get min element and write it to new file
        while(!queue.isEmpty()){
            Pair minPair = queue.poll();

            if(isInteger) writer.write(Integer.toString((Integer)minPair.getValue()));
            else writer.write((String)minPair.getValue());
            writer.newLine();

            String nextLine = readers[minPair.getIndex()].readLine();
            if(nextLine != null){
                if(isInteger) queue.add(new Pair(minPair.getIndex(), Integer.parseInt(nextLine)));
                else queue.add(new Pair(minPair.getIndex(), nextLine));
            }
        }

        //Close all BufferedReader and BufferedWriter
        for(int i = 0; i < inputFiles.size(); i++){
            readers[i].close();
        }
        writer.close();
    }
}


