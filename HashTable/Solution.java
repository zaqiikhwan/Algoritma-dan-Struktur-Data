package ASD_AOP.ASD.HashTable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class HashTable {
    int length;
    LinkedList<String>[] ll;

    HashTable(int length) {
        this.length = length;
        ll = new LinkedList[length];
        for (int i = 0; i < length; i++) {
            ll[i] = new LinkedList<String>();
        }
    }

    void insert(String data) {
        //Isi sendiri
        char[] lastWord = data.toLowerCase().toCharArray();
        int indeks = ((lastWord[data.length() - 1]) - 97) % length;
        ll[indeks].add(data.toLowerCase());
    }

    int[] getSearchedIndex(String data) {
        //Isi sendiri
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ll[i].size(); j++) {
                if (ll[i].get(j).equals(data.toLowerCase())) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hashTableLength = in.nextInt();
        HashTable hashTable = new HashTable(hashTableLength);
        int testCases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < testCases; i++) {
            hashTable.insert(in.nextLine());
        }
        String searchable = in.nextLine();
        System.out.println(Arrays.toString(hashTable.getSearchedIndex(searchable)));
    }
}
