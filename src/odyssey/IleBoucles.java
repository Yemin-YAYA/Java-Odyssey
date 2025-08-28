package odyssey;

import java.util.Scanner;

public class IleBoucles {
    public static boolean jouer(Scanner scanner) {
        while (true) {
            System.out.println("🏝️ Île des Boucles");
            System.out.println("Vies restantes : " + JavaOdyssey.afficherVies());
            System.out.println(); // ← saute une ligne proprement
            System.out.println("Écris une boucle for qui affiche le mot \"Bonjour\" 3 fois.");
            System.out.print("👉 Tape ton code Java : ");
            String reponse = scanner.nextLine();

            int status = JavaOdyssey.verifierReponse(reponse, new String[]{"for", "i = 0", "i < 3"});
            if (status == JavaOdyssey.SUCCESS) {
                System.out.println("✅ Parfait ! Tu as compris la boucle for de base.\n");
                return true;
            } else if (status == JavaOdyssey.RESTART) {
                return false;
            } else {
                System.out.println("❌ Essaie encore. Indice partiel : pense à 'for(int i = 0; i < 3; i++)'.");
            }
        }
    }
}
