import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public  List<String> readFile(String filePath){
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null){
                strings.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại! ");
        }
        return strings;
    }

    public void writerFile(String filePath, String ch){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("The copied: " + ch);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String CopyText(List<String> arr){
        String string = "";
        for (int i = 0; i < arr.size() ; i++) {
            string += arr.get(i) + "\n";
        }
        return string;
    }

    public static void main(String[] args) {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        List<String> strings = readAndWrite.readFile("string.txt");
        String str = CopyText(strings);
        readAndWrite.writerFile("file.txt", str);
    }


}
