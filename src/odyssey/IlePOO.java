package odyssey;

import java.util.Scanner;

public class IlePOO {
    public static boolean jouer(Scanner scanner) {
        while (true) {
            System.out.println("🏝️ Île de la POO");
            System.out.println("Vies restantes : " + JavaOdyssey.afficherVies());
            System.out.println(); // ← saute une ligne proprement
            System.out.println("Crée une classe Personne avec un attribut 'nom' et une méthode sePresenter().");
            System.out.print("👉 Tape ton code Java : ");
            String reponse = scanner.nextLine();

            int status = JavaOdyssey.verifierReponse(reponse, new String[]{"class Personne", "String nom", "sePresenter"});
            if (status == JavaOdyssey.SUCCESS) {
                System.out.println("✅ Fantastique ! Tu maîtrises les bases de la POO.\n");
                return true;
            } else if (status == JavaOdyssey.RESTART) {
                return false;
            } else {
                System.out.println("❌ Pas tout à fait. Indice partiel : pense à 'class Personne' et 'String nom'.");
            }
        }
    }
}
