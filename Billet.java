import java.time.LocalDate;

public class Billet implements Publiable {
	private LocalDate datePub;
	private String auteur;
	
	public Billet(LocalDate datePub, String auteur)
	{
		this.datePub=datePub;
		this.auteur=auteur;
	}
	public LocalDate getDatePublication() {
        return datePub;
    }
	public String getAuteur() {
        return auteur;
    }
	public String toString() {
        return "Billet publié le " + datePub + " par " + auteur;
    }

}