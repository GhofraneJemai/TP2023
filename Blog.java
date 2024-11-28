import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Blog {
    private String titre;
    private Publiable[] LBillets;
    private int nbBillets;

    public Blog(String titre, int capacite) {
        this.titre = titre;
        this.LBillets = new Publiable[capacite];
        this.nbBillets = 0;
    }

    public void post(Publiable billet) throws InvalidURLException {
        if (nbBillets >= LBillets.length) {
            System.out.println("Capacité maximale atteinte, impossible de publier le billet.");
            return;
        }

        if (billet instanceof Video) {
            Video video = (Video) billet;
            if (!video.getUrl().startsWith("https")) {
                throw new InvalidURLException("L'URL de la vidéo doit utiliser le protocole HTTPS.");
            }
        }

        LBillets[nbBillets++] = billet;
        System.out.println("Billet publié avec succès.");
    }

    public int getNombreBilletsTaggables() {
        int x = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof BilletTaggable) {
                x++;
            }
        }
        return x;
    }

    public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
    Publiable[] result = new Publiable[nbBillets];
    int index = 0;

    for (int i = 0; i < nbBillets; i++) {
        if (LBillets[i] instanceof BilletTaggable && LBillets[i].getAuteur().equals(auteur)) {
            result[index++] = LBillets[i];
        }
    }


    return result; 
	} 


    public Publiable getPlusRécentBillet() {
    if (nbBillets == 0) return null;

    Publiable plusRecent = LBillets[0];
    for (int i = 1; i < nbBillets; i++) {
        if (LBillets[i].getDatePublication().compareTo(plusRecent.getDatePublication()) > 0) {
            plusRecent = LBillets[i];
        }
    }
    return plusRecent;
	}

    public Publiable[] RechercheBilletsParContenu(String[] mots) {
    Publiable[] result = new Publiable[nbBillets];
    int index = 0;

    for (int i = 0; i < nbBillets; i++) {
        String contenu = LBillets[i].toString();
        boolean contientTousLesMots = true;
        
        for (String mot : mots) {
            if (contenu.indexOf(mot) == -1) { 
                contientTousLesMots = false;
                break;
            }
        }
        
        if (contientTousLesMots) {
            result[index++] = LBillets[i];
        }
    }

    return result;
	}


    @Override
    public String toString() {
        return "Blog [titre=" + titre + ", LBillets=" + Arrays.toString(LBillets) + ", nbBillets=" + nbBillets + "]";
    }
}
