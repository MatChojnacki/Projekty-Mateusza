import com.kodilla.stream.ExpressionExecutor;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {

    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

// 7.1 Zadanie - Upiększacz tekstów =======================================================================================================================
        System.out.println("Zadanie 7.1");

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String textToBeautify = "Mateusz Chojnacki";

        poemBeautifier.beautify(textToBeautify, String::toUpperCase);
        poemBeautifier.beautify(textToBeautify, String::toLowerCase);
        poemBeautifier.beautify(textToBeautify, s -> "ABC " + s + " ABC");
        poemBeautifier.beautify(textToBeautify, s -> s.replaceAll("Chojnacki", "Ch"));

    }
}











