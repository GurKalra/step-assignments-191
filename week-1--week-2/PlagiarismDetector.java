import java.util.*;

public class PlagiarismDetector {

    static HashMap<String, Set<String>> index = new HashMap<>();

    public static void addDocument(String id, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 4; i++) {

            String gram = words[i] + " " + words[i + 1] + " " + words[i + 2] + " " + words[i + 3] + " " + words[i + 4];

            index.putIfAbsent(gram, new HashSet<>());
            index.get(gram).add(id);
        }
    }

    public static void analyzeDocument(String id, String text) {

        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 4; i++) {

            String gram = words[i] + " " + words[i + 1] + " " + words[i + 2] + " " + words[i + 3] + " " + words[i + 4];

            if (index.containsKey(gram)) {
                matches++;
            }
        }

        System.out.println("Document " + id + " → Matching n-grams: " + matches);
    }

    public static void main(String[] args) {

        addDocument("essay_089", "this is a simple essay written by a student for testing plagiarism detection system");

        analyzeDocument("essay_123", "this is a simple essay written by a student for testing plagiarism detection system");
    }
}