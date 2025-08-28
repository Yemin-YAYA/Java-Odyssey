package odyssey;

import java.util.Scanner;

public class IleConditions {
    public static boolean jouer(Scanner scanner) {
        while (true) {
            System.out.println("🏝️ Île des Conditions");
            System.out.println("Vies restantes : " + JavaOdyssey.afficherVies());
            System.out.println(); // ← saute une ligne proprement
            System.out.println("Écris une condition if pour vérifier si la variable x vaut 10.");
            System.out.print("👉 Tape ton code Java : ");
            String reponse = scanner.nextLine();

            int status = JavaOdyssey.verifierReponse(reponse, new String[]{"if", "x", "== 10"});
            if (status == JavaOdyssey.SUCCESS) {
                System.out.println("✅ Excellent ! Tes conditions sont justes.\n");
                return true;
            } else if (status == JavaOdyssey.RESTART) {
                return false;
            } else {
                System.out.println("❌ Essaie encore. Indice partiel : pense à 'if(x == 10)'.");
            }
        }
    }
}
