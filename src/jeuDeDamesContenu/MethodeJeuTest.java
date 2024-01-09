//package jeuDeDamesContenu;
//
//
//
//    import org.junit.jupiter.api.Test;
//    import org.testng.annotations.Test;
//
//    import static org.junit.Assert.*;
//
//public class MethodeJeuTest {
//        @Test
//        public void testDansTerrain() {
//            assertTrue(MethodeJeu.dansTerrain(5, 5));
//            assertTrue(MethodeJeu.dansTerrain(0, 0));
//            assertTrue(MethodeJeu.dansTerrain(9, 9));
//            assertFalse(MethodeJeu.dansTerrain(-1, 5));
//            assertFalse(MethodeJeu.dansTerrain(5, -1));
//            assertFalse(MethodeJeu.dansTerrain(10, 5));
//            assertFalse(MethodeJeu.dansTerrain(5, 10));
//            assertTrue(MethodeJeu.dansTerrain(0, 9));
//            assertTrue(MethodeJeu.dansTerrain(9, 0));
//        }
//
//        @Test
//        public void testEstSurRangéeOpposée() {
//            Pion pion = new Pion(0, 0, 3); // Crée un pion noir sur la rangée 0
//            assertTrue(pion.estSurRangéeOpposée());
//            assertTrue(pion.estDame());
//
//            Pion pion2 = new Pion(9, 9, 2); // Crée un pion blanc sur la rangée 9
//            assertTrue(pion2.estSurRangéeOpposée());
//            assertTrue(pion2.estDame());
//
//            Pion pion3 = new Pion(0, 5, 3); // Crée un pion noir sur une rangée différente de 0
//            assertFalse(pion3.estSurRangéeOpposée());
//            assertFalse(pion3.estDame());
//
//            Pion pion4 = new Pion(0, 0, 4); // Crée un pion avec une couleur invalide
//            assertFalse(pion4.estSurRangéeOpposée());
//            assertFalse(pion4.estDame());
//
//            Pion pion5 = new Pion(-1, 5, 3); // Crée un pion avec des coordonnées invalides
//            assertFalse(pion5.estSurRangéeOpposée());
//            assertFalse(pion5.estDame());
//    }
//
//}
