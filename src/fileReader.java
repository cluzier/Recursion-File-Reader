import java.io.File;

public class fileReader {
    public static void main(String[] args) {
        String userDir = "C:\\Users\\Conner\\Documents\\phpmyadmin";
        File dir = new File(userDir);
        if(dir.exists() && dir.isDirectory()) {
            // first line of the output, tells the user which directory it is looking into
            System.out.println("Displaying files in directory : " + dir);
            File arr[] = dir.listFiles();
            Recursion(arr,0,0);
        }
    }

    static void Recursion(File[] arr, int index, int layer) {
        if(index == arr.length)
            return;
        for (int i = 0; i < layer; i++)
            // using \t to show tabs, if you used \n it would just start a new line
            System.out.print("\t");

        if(arr[index].isFile())
            System.out.println(arr[index].getName());
        else if(arr[index].isDirectory()) {
            // printing the name of the folder
            // format: <name>
            System.out.println("<" + arr[index].getName() + ">");
            Recursion(arr[index].listFiles(), 0, layer + 1);
        }
        Recursion(arr,++index, layer);
    }
}