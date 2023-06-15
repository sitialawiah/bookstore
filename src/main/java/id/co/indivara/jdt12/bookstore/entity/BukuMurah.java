package id.co.indivara.jdt12.bookstore.entity;

public class BukuMurah {
    private String isbn;
    private String judul;
    private String pengarang;
    private int harga;

    public BukuMurah(String isbn, String judul, String pengarang, int harga) {
        this.isbn = isbn;
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
    }

    public BukuMurah(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}