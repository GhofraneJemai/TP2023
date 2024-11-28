import java.time.LocalDate;

public class Image extends BilletTaggable {
    private String url;

    // Constructeur
    public Image(LocalDate datePub, String auteur, int capacité, String url) {
        super(datePub, auteur, capacité);  // Appel au constructeur de la classe parente
        this.url = url;
    }

    // Accesseur pour l'URL
    public String getUrl() {
        return url;
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "Image [" + super.toString() + ", url=" + url + "]";
    }
}
