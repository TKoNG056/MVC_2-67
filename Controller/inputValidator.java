package Controller;
import Model.*;

public class inputValidator {
    
        public static boolean isValidSuitId(String suitId) {
            return suitId.matches("[1-9]\\d{5}");
        }
    
        public static boolean isSuitHere(String suitId) {
          //check by pass to the model
            Suit suit = new Suit();
            return suit.getSuitTypeById(suitId) != null;
    }
}
