package org.example.services;

import org.example.models.MathExample;
import org.example.models.UserProgress;
import org.example.repositories.MathExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class MathExampleService {
    private final MathExampleRepository mathExampleRepository;

    @Autowired
    public MathExampleService(MathExampleRepository mathExampleRepository) {
        this.mathExampleRepository = mathExampleRepository;
    }
    public MathExample saveExample(MathExample example) {
        return mathExampleRepository.save(example);
    }
    private final UserProgress userProgress = new UserProgress();
    private final Set<String> generatedQuestions = new HashSet<>();

    private MathExample generateStandardExample() {
        int number1, number2;
        char operator = randomOperator(new char[]{'+', '-', '*', '/'});


        if (operator == '*' || operator == '/') {
            number1 = (int) (Math.random() * 10 + 1);
            number2 = (int) (Math.random() * 10 + 1);

            if (operator == '/') {
                number1 = number1 * number2;
            }
        } else {
            number1 = (int) (Math.random() * 1000 + 1);
            number2 = (int) (Math.random() * 1000 + 1);
        }
        int correctAnswer = calculateAnswer(number1, number2, operator);

        if (operator == '-' && correctAnswer < 0) {
            return generateStandardExample();
        }
        String operatorSymbol = String.valueOf(operator);
        if (operator == '/') {
            operatorSymbol = ":";
        }
        String question = number1 + " " + operatorSymbol + " " + number2;

        if (generatedQuestions.contains(question)) {
            return generateStandardExample();
        }
        generatedQuestions.add(question);
        return new MathExample(question, correctAnswer);
    }
        private char randomOperator(char[] operators) {
            return operators[(int) (Math.random() * operators.length)];
        }

    public MathExample generateFirstGradeExample() {
        int number1 = (int) (Math.random() * 20 + 1);
        int number2 = (int) (Math.random() * 20 + 1);
        char operator = randomOperator(new char[]{'+', '-'});
        int correctAnswer = calculateAnswer(number1, number2, operator);

        if(operator == '-' && correctAnswer < 0) {
            return generateFirstGradeExample();
        }
        String question = number1 + " " + operator + " " + number2;
        return new MathExample(question, correctAnswer);
    }

    public MathExample generateSecondGradeExample() {
        int number1, number2;
        char operator = randomOperator(new char[]{'+', '-'});

        if (operator == '+') {
            number1 = (int) (Math.random() * 100);
            number2 = (int) (Math.random() * (100 - number1));
        } else {
            number1 = (int) (Math.random() * 100);
            number2 = (int) (Math.random() * number1 + 1);

        }
        int correctAnswer = calculateAnswer(number1, number2, operator);
        String question = number1 + " " + operator + " " + number2;
        return new MathExample(question, correctAnswer);
    }

    public MathExample generateThirdGradeExample() {
        int number1, number2;
        char operator = randomOperator(new char[] {'+', '-', '*', '/'});

        if (operator == '*' || operator == '/') {
            number1 = (int) (Math.random() * 10 + 1);
            number2 = (int) (Math.random() * 10 + 1);

            if (operator == '/') {
                number1 = number1 * number2;
            }
        } else {
            number1 = (int) (Math.random() * 10 + 1);
            number2 = (int) (Math.random() * 10 + 1);
        }
        int correctAnswer = calculateAnswer(number1, number2, operator);

        if (operator == '-' && correctAnswer < 0) {
            return generateThirdGradeExample();
        }
        String operatorSymbol = String.valueOf(operator);
        if (operator == '/') {
            operatorSymbol = ":";
        }
        String question = number1 + " " + operatorSymbol + " " + number2;
        return new MathExample(question, correctAnswer);


    }

    public MathExample generateFourthGradeExample() {
        if (Math.random() < 0.5) {
            return generateStandardExample();
        } else {
            return generateUnitConversionExample();
        }
    }

    private MathExample generateUnitConversionExample() {
        String[] units = {"kilometers to meters", "meters to kilometers", "meters to centimeters", "centimeters to meters",
        "liters to mililiters", "milliliters to liters"};

        String unit = units[(int) (Math.random() * units.length)];
        int number = (int)(Math.random() * 100 + 1);
        double correctAnswer;

        switch (unit) {
            case "kilometers to meters" -> correctAnswer = number * 1000;
            case "meters to kilometers" -> correctAnswer = number / 1000.0;
            case "meters to centimeters" -> correctAnswer = number * 100;
            case "centimeters to meters" -> correctAnswer =  number / 100.0;
            case "liters to mililiters" -> correctAnswer = number * 1000;
            case "milliliters to liters" -> correctAnswer = number / 1000.0;
            default -> throw new IllegalArgumentException("unknown unit conversion: " + unit);
        }
        String question = "convert " + number + " " + unit;
        return new MathExample(question, correctAnswer);
    }

    public MathExample generateExample() {
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);
        char operator = randomOperator();

        String question = number1 + " " + operator + " " + number2;
        int correctAnswer = calculateAnswer(number1, number2, operator);
        return new MathExample(question, correctAnswer);
    }
    private char randomOperator() {
        char[] operators = {'+', '-', '*', '/'};
        return operators[(int) (Math.random() * operators.length)];
    }

    private int calculateAnswer(int number1, int number2, char operator) {
        switch (operator) {
            case '+' -> {
                return number1 + number2;
            }
            case '-' -> {
                return number1 - number2;
            }
            case '*' -> {
                return number1 * number2;
            }
            case '/' -> {
                return number2 != 0 ? number1 / number2 : 0;
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    // Upravená metoda na přijímání double místo int
    public MathExample analyzeAnswer(MathExample example, double userAnswer) {
        example.setUserAnswer(userAnswer);
        if (example.isCorrect()) {
            userProgress.incrementCorrectAnswers();
        } else {
            userProgress.incrementIncorrectAnswers();
        }
        return example;
    }

    public UserProgress getUserProgress() {
        return userProgress;
    }
    public String getProgressMessage() {
        int correctAnswers = userProgress.getCorrectAnswers();
        int incorrectAnswers = userProgress.getIncorrectAnswers();
        int totalQuestions = correctAnswers + incorrectAnswers;
        return "Správne odpovede: " + correctAnswers + "/" + totalQuestions + " Ďakujeme, že ste sa hrali!";
    }
}