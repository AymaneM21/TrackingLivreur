package com.example.trackinglivreur;

public class Produit {
    private String nomProduit ;

    private String prixUnitaire ;

    private String quantité ;

    public Produit() {
    }

    public Produit(String nomProduit, String prixUnitaire, String quantité) {
        this.nomProduit = nomProduit;
        this.prixUnitaire = prixUnitaire;
        this.quantité = quantité;
    }
    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getQuantité() {
        return quantité;
    }

    public void setQuantité(String quantité) {
        this.quantité = quantité;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "Nom_Produit=" + nomProduit +
                ", Prix_Unitaire='" + prixUnitaire + '\'' +
                ", Quantité='" + quantité + '\'' +
                '}';
    }
}
