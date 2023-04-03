package com.example.trackinglivreur;

public class Crédit {
    private String montant ;

    private String dureecredit ;

    private String etatcredit ;

    public Crédit() {
    }

    public Crédit(String montant,String dureecredit, String etatcredit) {
        this.montant = montant;
        this.dureecredit = dureecredit;
        this.etatcredit = etatcredit;
    }
    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDureecredit() {
        return dureecredit;
    }

    public void setDureecredit(String datecredit) {
        this.dureecredit = dureecredit;
    }

    public String getEtatcredit() {
        return etatcredit;
    }

    public void setPrixTotal(String etatcredit) {
        this.etatcredit = etatcredit;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "Montant=" + montant +
                ", Date_Crédit='" + dureecredit + '\'' +
                ", Etat_Crédit='" + etatcredit + '\'' +
                '}';
    }
}