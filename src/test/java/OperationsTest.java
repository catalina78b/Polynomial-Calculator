import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    private static Model model = new Model();
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;

    @BeforeAll
    static void setUpBeforeAll() {
        model = new Model();
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care cu succes " + nrTesteCuSucces);
    }


    @BeforeEach
    void setUp() {

        nrTesteExecutate++;
    }

    @AfterEach
    void tearDown() {
        System.out.println("S-a terminat testul curent!");
    }

    @ParameterizedTest
    @MethodSource("provideInputAdd")
    void testAddition(String p1, String p2, String result) {
        assertEquals(result, model.getResult(model.getPolynomial(p1), model.getPolynomial(p2), "Add"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInputAdd() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x^1-5","x^2-1","+1.0*x^3-1.0*x^2+6.0*x^1-6.0"));
        argumentsList.add(Arguments.of("x^1-7*x^5","-3*x^1+8","-7.0*x^5-2.0*x^1+8.0"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputSubtract")
    void testSubtract(String p1, String p2, String result) {
        assertEquals(result, model.getResult(model.getPolynomial(p1), model.getPolynomial(p2), "Subtract"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInputSubtract() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x^1-5","x^3+x^2-1","-3.0*x^2+6.0*x^1-4.0"));
        argumentsList.add(Arguments.of("5*x^5-13*x^3+2*x^2","7*x^5-3*x^2+1","-2.0*x^5-13.0*x^3+5.0*x^2-1.0"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputMultiply")
    void testMultiply(String p1, String p2, String result) {
        assertEquals(result, model.getResult(model.getPolynomial(p1), model.getPolynomial(p2), "Multiplicate"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInputMultiply() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x^1-5","x^3+x^2-1","+1.0*x^6+1.0*x^5-2.0*x^5+4.0*x^4+5.0*x^3-6.0*x^3-3.0*x^2-6.0*x^1+5.0"));
        argumentsList.add(Arguments.of("2*x^2-3","x^1-1","+2.0*x^3-2.0*x^2-3.0*x^1+3.0"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputDerivative")
    void testDerivative(String p1, String p2, String result) {
        assertEquals(result, model.getResult(model.getPolynomial(p1), model.getPolynomial(p2), "Derivate"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInputDerivative() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x^1-5","","+3.0*x^2-4.0*x^1+6.0"));
        argumentsList.add(Arguments.of("2*x^2-3","","+4.0*x^1"));
        return argumentsList;
    }
    @ParameterizedTest
    @MethodSource("provideInputIntegrate")
    void testIntegrate(String p1, String p2, String result) {
        assertEquals(result, model.getResult(model.getPolynomial(p1), model.getPolynomial(p2), "Integrate"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInputIntegrate() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x^1-5","","+0.25*x^4-0.6666666666666666*x^3+3.0*x^2-5.0*x^1"));
        argumentsList.add(Arguments.of("2*x^2-3","","+0.6666666666666666*x^3-3.0*x^1"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputDivide")
    void testDivide(String p1, String p2, String result) {
        assertEquals(result, model.getResult(model.getPolynomial(p1), model.getPolynomial(p2), "Divide"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInputDivide() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x-5","x^2-1","1.0*x^1-2.0"));
        argumentsList.add(Arguments.of("27*x^3+9*x^2-3*x-10","3*x^1-2","+9.0*x^2+9.0*x^1+5.0"));
        return argumentsList;
    }
}