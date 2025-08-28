package odyssey;

import java.util.Scanner;

public class IleMethodes {
    public static boolean jouer(Scanner scanner) {
        while (true) {
            System.out.println("🏝️ Île des Méthodes");
            System.out.println("Vies restantes : " + JavaOdyssey.afficherVies());
            System.out.println(); // ← saute une ligne proprement
            System.out.println("Écris une méthode qui additionne deux entiers a et b.");
            System.out.print("👉 Tape ton code Java : ");
            String reponse = scanner.nextLine();

            int status = JavaOdyssey.verifierReponse(reponse, new String[]{"int", "addition", "return", "a", "b"});
            if (status == JavaOdyssey.SUCCESS) {
                System.out.println("✅ Bravo ! Tu sais créer des méthodes.\n");
                return true;
            } else if (status == JavaOdyssey.RESTART) {
                return false;
            } else {
                System.out.println("❌ Essaie encore. Indice partiel : méthode qui renvoie un int et retourne a+b.");
            }
        }
    }
}
