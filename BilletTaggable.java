import java.time.LocalDate;
import java.util.Arrays;

public class BilletTaggable extends Billet implements Taggable {
    private String[] tags; 
    private int nbTags;

    public BilletTaggable(LocalDate datePub, String auteur, int capacite) {
        super(datePub, auteur); 
        this.tags = new String[capacite];
        this.nbTags = 0;
    }

    public void ajoutTag(String tag) {
        if (nbTags >= tags.length) {
            System.out.println("Capacité maximale atteinte, impossible d'ajouter le tag : " + tag);
            return;
        }
        for (int i = 0; i < nbTags; i++) {
            if (tags[i].equals(tag)) {
                System.out.println("Le tag \"" + tag + "\" est déjà présent.");
                return;
            }
        }
        tags[nbTags++] = tag;
        System.out.println("Le tag \"" + tag + "\" a été ajouté.");
    }

    public void supprimeTag(String tag) {
        int index = rechercheTag(tag);
        if (index == -1) {
            System.out.println("Le tag \"" + tag + "\" n'existe pas.");
            return;
        }
        for (int i = index; i < nbTags - 1; i++) {
            tags[i] = tags[i + 1];
        }
        tags[--nbTags] = null;
    }

    public int nombreTags() {
        return nbTags;
    }

    public int rechercheTag(String tag) {
        for (int i = 0; i < nbTags; i++) {
            if (tags[i].equals(tag)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "BilletTaggable [tags=" + Arrays.toString(tags) + ", nbTags=" + nbTags 
                + ", datePub=" + getDatePublication() + ", auteur=" + getAuteur() + "]";
    }
}
