package src.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    private static final String filePath = "src/resource/dictionaries.txt";
    private static final String outPath = "src/resource/out_dictionaries.txt";

    public static void insertFromCommandline() {
        try {
            Scanner commandLine = new Scanner(System.in);
            Scanner commandLineInt = new Scanner(System.in);
            System.out.print("Nhập số từ cần điền: ");
            int num = commandLineInt.nextInt();
            for (int i = 0; i < num; i++) {
                System.out.print("Từ: ");
                String target = commandLine.nextLine();
                System.out.print("Định nghĩa: ");
                String explain = commandLine.nextLine();
                if (alreadyIn(target)) {
                    System.out.println("Từ thêm vào đã có trong bộ dữ liệu");
                } else {
                    addWord(target, explain);
                    System.out.println("Đã thêm " + target + " vào bộ dữ liệu");
                }
            }
            Collections.sort(wordArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertFromFile() {
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] wordLine = line.split(":");
                String target = wordLine[0];
                String explain = wordLine[1];
                if (alreadyIn(target)) {
                    System.out.println("Từ " + target + " đã có trong bộ dữ liệu.");
                } else {
                    addWord(target, explain);
                }
            }
            Collections.sort(wordArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm kiếm: ");
        String findWord = scanner.nextLine();
        System.out.println(lookUpWord(findWord));
    }

    public static void dictionaryEditWord() {
        System.out.println("Điền từ cần sửa: ");
        Scanner scanner= new Scanner(System.in);
        String editWord = scanner.nextLine();
        int index = dictionaryLookupIndex(editWord);
        if (!wordArrayList.get(index).getWord_target().equals(editWord)) {
            System.out.println("Từ cần sửa không có trong bộ dữ liệu.");
        } else {
            System.out.println(editWord(editWord, scanner.nextLine()));
        }
    }

    public static void dictionaryDeleteWord() {
        System.out.println("Điền từ cần xoá: ");
        Scanner scanner= new Scanner(System.in);
        String deleteWord = scanner.nextLine();
        System.out.println(deleteWord(deleteWord));
    }

    public static int dictionaryLookupIndex(String findWord) {
        int stIndex = 0;
        int endIndex = wordArrayList.size();
        int index = (stIndex + endIndex) / 2;
        while ((index != stIndex && index != endIndex)) {
            if (wordArrayList.get(index).getWord_target().compareTo(findWord) > 0) {
                endIndex = index;
                index = (stIndex + endIndex) / 2;
            } else {
                stIndex = index;
                index = (stIndex + endIndex) / 2;
            }
        }
        return index;
    }

    public static void dictionaryExportToFile() {
        try {
            File file=new File(outPath);
            FileWriter fileWriter= new FileWriter(file);

            for (Word word : wordArrayList) {
                fileWriter.write(word.getWord_target() + ":" + word.getWord_explain() + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static boolean alreadyIn(String word) {
        int index = dictionaryLookupIndex(word);
        if (!wordArrayList.get(index).getWord_target().equals(word)) {
            return false;
        }
        return true;
    }

    public static ArrayList<Word> searchWord(String findString) {
        ArrayList<Word> searchArray = new ArrayList<Word>();
        for (Word word : wordArrayList) {
            if (word.getWord_target().startsWith(findString)) {
                searchArray.add(word);
            }
        }
        return searchArray;
    }

    public static void addWord(String target, String explain) {
        wordArrayList.add(new Word(target, explain));
    }

    public static void sorting() {
        Collections.sort(wordArrayList);
    }

    public static String lookUpWord(String target) {
        int index = dictionaryLookupIndex(target);
        if (!wordArrayList.get(index).getWord_target().equals(target)) {
            return "Từ không có trong bộ dữ liệu.";
        } else {
            return wordArrayList.get(index).getWord_explain();
        }
    }

    public static String editWord(String target, String explain) {
        int index = dictionaryLookupIndex(target);
        if (!wordArrayList.get(index).getWord_target().equals(target)) {
            return "Từ không có trong bộ dữ liệu.";
        } else {
            wordArrayList.get(index).setWord_explain(explain);
            return target + " : " + explain;
        }
    }

    public static String deleteWord(String target) {
        int index = dictionaryLookupIndex(target);
        if (!wordArrayList.get(index).getWord_target().equals(target)) {
            return "Từ không có trong bộ dữ liệu.";
        } else {
            wordArrayList.remove(index);
            return "Đã xoá từ " + target + " khỏi bộ dữ liệu.";
        }
    }
}
