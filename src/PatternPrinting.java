public class PatternPrinting {
    public static  void main(String args[]){
        int n = 3;

        for (int i = 0; i<n ; i++) {

            for (int j = 0; j < n * 2 - 2 - (i * 2); j++) {
                System.out.print('-');
            }
            char cur = (char) (97 + n - 1);
            for (int j = 0; j <= i * 2; j++) {
                if (j < i) {
                    System.out.print(cur--);
                } else {
                    System.out.print(cur++);
                }
                if (j != i * 2) {
                    System.out.print('-');
                }
            }
            for (int j = 0; j < n * 2 - 2 - (i * 2); j++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }


    public long distinctPairs(int n, int[] x, int[] y){
        long count = 0;
        for(int i= 0; i<n; i++){
            for (int j= i+1; j<n; j++){
                if(x[i]!=x[j] && y[i]!=y[j]){
                    count ++;
                }
            }
        }
        return count;
    }

//    public long distinctPairs(int n, int[] x, int[] y){
//        long count = 0;
//        for(int i= 0; i<n; i++){
//            for (int j= i+1; j<n; j++){
//                if(x[i]!=x[j] && y[i]!=y[j]){
//                    count ++;
//                }
//            }
//        }
//        return count;
//    }



//[2,4,3,3,3]
//    [4,2,3,3,3]
//  [0,2,-3,4,3]
    private void arrayMod(int[] arr, int n){

        for(int i = 0;i<arr.length; i++){
            while(arr[i] != i+1 && arr[i]>0){
                int temp = arr[arr[i]-1]; // temp =4
                if(arr[i] == temp){
                    arr[temp -1] = -2;
                    arr[i] = 0;
                    break;
                }
                if(temp<0){
                    arr[arr[i]-1]--;
                    arr[i] = 0;
                    break;
                }
                arr[arr[i]-1] = arr[i]; //
                arr[i] = temp;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == i+1){
                System.out.println(String.format("%s -> 1",i+1));
            } else if(arr[i]<0){
                System.out.println(String.format("%s -> %s",i+1,Math.abs(arr[i])));
            }
            else {
                System.out.println(String.format("%s -> 0", i + 1));
            };
        }
}

class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
}

   private int treeReplacer(TreeNode node){
       int rightVal = 0;
       int leftVal = 0;
       if(node.left == null && node.right == null) {
           int temp = node.val;
           node.val =0;
           return temp;
       }
        if(node.left != null){
            leftVal = treeReplacer(node.left);
        }
        if(node.right!= null){
            rightVal =treeReplacer(node.right);
        }
        int temp = leftVal +  rightVal + node.val;
        node.val = leftVal +rightVal;
        return temp;
   }




}

/*
 * Click `Run` to execute the snippet below!
 */

//import java.io.*;
//    import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

//class Solution {
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());
//
//        for (String string : strings) {
//            System.out.println(string);
//        }}
//
//    void copyChangedBlocks(Block[] changedBlocks, Reader reader, Writer writer) {
//
//    }
//}
//
//class ReaderThread implements Runnable {
//    Reader reader;
//    Block block;
//
//    ReaderThread(Reader reader, Block block){
//        this.reader = reader;
//        this.block = block;
//    }
//
//    public void run(){
//        byte[] array = reader.read( block.start,block.start - block.end );
//        Storage.add(array, block.start);
//    }
//}
//
//class Storage{
//    static Map<Integer, byte[]> byteStorage;
//
//    public synchronized static void add(byte[] array, int offset){
//        byteStorage.put(offset, array);
//    }
//
//    public synchronized static byte[] peek(int offset){
//        return byteStorage.get(offset);
//    }
//
//    public synchronized static void remove(int offset){
//        byteStorage.remove(offset);
//    }
//
//
//}
//
//class Block {
//    int start, end;
//}
//
//interface Reader {
//    // Reads n bytes starting from offset.
//    byte[] read(int offset, int n);
//}
//
///*
//Your previous Plain Text content is preserved below:
//
//This is just a simple shared plaintext pad, with no execution capabilities.
//
//When you know what language you'd like to use for your interview,
//simply choose it from the dropdown in the top bar.
//
//You can also change the default language your pads are created with
//in your account settings: https://app.coderpad.io/settings
//
//Enjoy your interview!
//
//interface Reader {
//    // Reads n bytes starting from offset.
//    byte[] read(int offset, int n);
//}
//interface Writer {
//    // write given data starting from the offset.
//    void write(byte[] data, int offset);
//}
//// Represents a block of data with start inclusive and
//// end exclusive.
//class Block {
//    int start, end;
//}
//void copyChangedBlocks(Block[] changedBlocks, Reader reader, Writer writer) {
//    // implement here
//}
//
// */
//
//
//// 1- Thread pool to parallelize
//// 2- Each thread call reader function
//// 3- Give the data and close
//// 4 - Main thread to get the byte array from the threads and write the same
//// 5 - Assuming no memory constraints
//
//
