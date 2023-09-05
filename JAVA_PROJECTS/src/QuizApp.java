import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "What is the capital of France?",
                "Which planet is known as the Red Planet?",
                "Who wrote the play 'Romeo and Juliet'?",
        };

        String[][] options = {
                {"A. Paris", "B. London", "C. Berlin", "D. Rome"},
                {"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"},
                {"A. William Shakespeare", "B. Charles Dickens", "C. Jane Austen", "D. Mark Twain"},
        };

        int[] correctAnswers = {0, 1, 0}; // Index of correct option for each question

        int totalQuestions = questions.length;
        int userScore = 0;

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.next().toUpperCase();

            if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
                int selectedOption = userAnswer.charAt(0) - 'A';
                if (selectedOption == correctAnswers[i]) {
                    userScore++;
                }
            } else {
                System.out.println("Invalid option. Skipping question.");
            }
        }

        System.out.println("Quiz completed! Your score: " + userScore + "/" + totalQuestions);

        scanner.close();
    }
}
