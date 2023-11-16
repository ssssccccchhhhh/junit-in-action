public class CalculatorTest {

    private int nbErrors = 0;

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            testAdd();
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors + "error(s)");
        }
    }

    private static void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }
}