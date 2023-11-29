package src.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine extends Dictionary {
    public static void showAllWords() {
        System.out.printf("%-6s%c %-20s%c %-60s%n", "No", '|', "English", '|', "Vietnamese");
        for (int i = 0; i < wordArrayList.size(); i++) {
            System.out.printf("%-6s%c %-20s%c %-60s%n", i + 1, '|', wordArrayList.get(i).getWord_target(), '|', wordArrayList.get(i).getWord_explain());
        }
    }

    public static void dictionaryBasic() throws IOException {
        DictionaryManagement.insertFromCommandline();
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
        DictionaryManagement.dictionaryEditWord();
        DictionaryManagement.dictionaryDeleteWord();
        DictionaryManagement.dictionaryExportToFile();
        showAllWords();
    }

    public static void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tra cứu: ");
        String findString = scanner.nextLine();
        ArrayList<Word> searchArray = new ArrayList<Word>();
        searchArray = DictionaryManagement.searchWord(findString);
        for (Word word : searchArray) {
            word.printWord();
        }
    }

    public static void  dictionaryAdvanced() {
        try {
            while (true) {
                System.out.println("Welcome to My Application!");
                System.out.println("[0] Exit");
                System.out.println("[1] Add");
                System.out.println("[2] Remove");
                System.out.println("[3] Update");
                System.out.println("[4] Display");
                System.out.println("[5] Lookup");
                System.out.println("[6] Search");
                System.out.println("[7] Game");
                System.out.println("[8] Import from file");
                System.out.println("[9] Export to file");
                System.out.println("Your action:");
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                switch (num) {
                    case 0: return;
                    case 1: DictionaryManagement.insertFromCommandline();
                            break;
                    case 2: DictionaryManagement.dictionaryDeleteWord();
                            break;
                    case 3: DictionaryManagement.dictionaryEditWord();
                            break;
                    case 4: showAllWords();
                            break;
                    case 5: DictionaryManagement.dictionaryLookup();
                            break;
                    case 6: DictionaryCommandLine.dictionarySearcher();
                            break;
                    case 7:
                            break;
                    case 8: DictionaryManagement.insertFromFile();
                            break;
                    case 9: DictionaryManagement.dictionaryExportToFile();
                            break;
                    default:
                        System.out.println("Action not supported");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
