package odyssey;

import java.util.Scanner;

public class JavaOdyssey {
    static final Scanner scanner = new Scanner(System.in);

    // Statuts de vérification
    public static final int SUCCESS = 1;
    public static final int WRONG   = 0;
    public static final int RESTART = -1;

    // Paramètres du jeu
    static int erreursMax = 2;   // 2 erreurs consécutives déclenchent un restart
    static int viesMax    = 3;   // nombre de vies au départ

    // État courant
    static int score = 0;
    static int erreursConsecutives = 0;
    static int vies = viesMax;   // ✅ variable manquante ajoutée

    public static void main(String[] args) {
        vies = viesMax;

        while (true) {
            boolean termine = startGame();       // joue l’odyssée complète
            if (termine) break;                  // gagné : on sort !

            // Sinon: restart demandé (2 erreurs consécutives sur une île)
            vies--;
            if (vies <= 0) {
                System.out.println("💀 GAME OVER : tu n’as plus de vies.");
                System.out.println("➡️  Relance le programme pour retenter l’odyssée !");
                break;
            } else {
                System.out.println("❤️  Tu perds 1 vie. Vies restantes : " + afficherVies());
                System.out.println("🔁 Reprise au début de l’odyssée...\n");
            }
        }
    }

    public static boolean startGame() {
        score = 0;                  // on repart du début : score remis à 0
        erreursConsecutives = 0;

        System.out.println("🌍 Bienvenue dans Java Odyssey !\n");
        System.out.println("Pars à l’aventure et découvre les mystères du langage Java.");
        System.out.println("Nombre de Vies : " + afficherVies() + "   (2 erreurs d’affilée = -1 vie)\n");

        if (!IleVariables.jouer(scanner)) return false; else score += 10;
        if (!IleConditions.jouer(scanner)) return false; else score += 10;
        if (!IleBoucles.jouer(scanner))   return false; else score += 10;
        if (!IleMethodes.jouer(scanner))  return false; else score += 10;
        if (!IlePOO.jouer(scanner))       return false; else score += 10;

        System.out.println("🎉 Félicitations, explorateur ! Tu as terminé Java Odyssey !");
        System.out.println("✨ Ton score final : " + score + " points");
        return true; // fin normale
    }

    /** Vérifie la réponse de l'île courante : SUCCESS / WRONG / RESTART */
    public static int verifierReponse(String reponse, String[] motsAttendus) {
        for (String mot : motsAttendus) {
            if (!reponse.contains(mot)) {
                erreursConsecutives++;
                if (erreursConsecutives >= erreursMax) {
                    System.out.println("💥 2 erreurs d’affilée !");
                    // On NE décrémente PAS ici les vies : c’est géré dans main() après le retour false.
                    return RESTART;
                }
                System.out.println("➡️ Attention : encore une erreur possible avant de perdre 1 vie.\n");
                return WRONG;
            }
        }
        // Succès : on remet le compteur d’erreurs
        erreursConsecutives = 0;
        return SUCCESS;
    }

    /** Représentation des vies restantes en cœurs (♥) */
    public static String afficherVies() {   // ⚡ passé en public pour que les îles y accèdent
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vies; i++) sb.append("♥");
        for (int i = vies; i < viesMax; i++) sb.append("♡");
        return sb.toString();
    }
}
