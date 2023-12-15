package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Klasa: Shape Collector Test Suite")
class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tworzenie obiektow")
    class AddAndRemoveShapes {
        private ShapeCollector shapeCollector;
        private Shape circle;
        private Shape square;
        private Shape triangle;

        @BeforeEach
        void setUp() {
            shapeCollector = new ShapeCollector();
            circle = new Circle(5);
            square = new Square(4);
            triangle = new Triangle(12, 8);
        }

        @Test
        @DisplayName("TEST 1: Dodawanie ksztaltu figury do kolekcji")
        void testAddFigure() {
            // Given
            shapeCollector.addFigure(circle);

            // When
            String figures = shapeCollector.showFigures();

            // Then
            assertEquals("koło,", figures);
        }

        @Test
        @DisplayName("TEST 2: Obliczanie pola figury")
        void testCalculateField() {
            // Given
            Shape square = new Square(4);
            double expectedFieldSquare = 16.0;

            // When
            double calculatedField = square.getField();

            // Then
            assertEquals(expectedFieldSquare, calculatedField);
        }
    }
}
