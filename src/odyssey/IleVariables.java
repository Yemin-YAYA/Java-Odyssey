package odyssey;

import java.util.Scanner;

public class IleVariables {
    public static boolean jouer(Scanner scanner) {
        while (true) {
            System.out.println("🏝️ Île des Variables");
            System.out.println("Vies restantes : " + JavaOdyssey.afficherVies());
            System.out.println(); // ← saute une ligne proprement
            System.out.println("Déclare une variable entière 'age' et donne-lui la valeur 20.");
            System.out.print("👉 Tape ton code Java : ");
            String reponse = scanner.nextLine();

            int status = JavaOdyssey.verifierReponse(reponse, new String[]{"int", "age", "20"});
            if (status == JavaOdyssey.SUCCESS) {
                System.out.println("✅ Bravo explorateur ! Tu maîtrises les variables.\n");
                return true;
            } else if (status == JavaOdyssey.RESTART) {
                return false;
            } else {
                System.out.println("❌ Essaie encore. Indice partiel : utilise 'int', 'age' et '20'.");
            }
        }
    }
}
