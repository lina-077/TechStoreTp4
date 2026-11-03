package techstore;

public class Element {
    private Article article;
    private long quantite;

    public Element(Article article, long quantite) {
        this.article = article;
        this.quantite = (quantite >= 0) ? quantite : 0;
    }
    public Element(String nom, double prix, long quantite) {
        this.article = new Article(nom, prix);
        this.quantite = (quantite >= 0) ? quantite : 0;
    }
    public Article getArticle() {
        return article;
    }
    public long getQuantite() {
        return quantite;
    }
    public String getReferenceArticle() {
        return article.getReference();
    }
    public String getNomArticle() {
        return article.getNom();
    }
    public double getPrixArticle() {
        return article.getPrix();
    }
    public void setArticle(Article article) {
        this.article = article;
    }
    public void setQuantite(long quantite) {
        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }
    public void incrementerQuantite(long q) {
        if (q > 0) {
            this.quantite += q;
        }
    }
    public void decrementerQuantite(long q) {
        if (q > 0 && q <= this.quantite) {
            this.quantite -= q;
        }
    }
    public void modifier(String nom, double prix, long quantite) {
        this.article = new Article(nom, prix);
        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }
    public boolean equals(String reference) {
        return this.article.getReference().equalsIgnoreCase(reference);
    }
    public boolean equals(Article article) {
        if (article == null) return false;
        return this.article.getReference().equalsIgnoreCase(article.getReference());
    }
    @Override
    public String toString() {
        return "Element [" + article.toString() + ", quantite=" + quantite + "]";
    }
}