package id.co.indivara.jdt12.bookstore.controller;
import id.co.indivara.jdt12.bookstore.entity.Book;
import id.co.indivara.jdt12.bookstore.entity.BukuMahal;
import id.co.indivara.jdt12.bookstore.entity.BukuMurah;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
public class BookController {

    //(cara 2))
    //contoh pemanggilan path variable (hanya berlaku untuk get, tidak untuk yang lain)
    @GetMapping("/book/{isbn}/{judul}/{pengarang}")
    public Book tampilkanBuku(
            @PathVariable("isbn") String isbn,
            @PathVariable("judul") String judul,
            @PathVariable("pengarang") String pengarang){
        return new Book(isbn,judul,pengarang);
    }

//    @PostMapping("/simpan")
//    public Book simpanBuku(@RequestBody Book jsonData) {
//        Book b=jsonData;
//        b.setPengarang(b.getPengarang()+"INI DARI JSON LHO...");
//        return b;
//    }

    @PostMapping("/simpan")
    public BukuMahal simpanBuku(@RequestBody Book jsonData){
        Book b=jsonData;
        BukuMahal bm=new BukuMahal();
        bm.setIsbn(b.getIsbn());
        bm.setJudul(b.getJudul());
        bm.setPengarang(b.getPengarang());
        bm.setKemasan("Kotak Kayu");
        bm.setCover("besi");
        return bm;
    }

    @GetMapping("/all")
    public ArrayList<Book> findAllBook(){
        ArrayList<Book> list=new ArrayList<Book>();
        list.add(new Book("1111","Cara Ini","agus"));
        list.add(new Book("2222","Cara Itu","budi"));
        list.add(new Book("3333","Cara Begini","charlie"));
        return list;
    }

    @PostMapping("/termahal")
    public BukuMurah findBukuTermahal(@RequestBody ArrayList<BukuMurah> list){
        BukuMurah buku=list.get(1); //ambil elemen petama yang akan kita bandingkan
        for (BukuMurah b:list){
            if (b.getHarga() < buku.getHarga()){
                buku=b;
            }
        }
        return buku;
    }
}


//contoh pemanggilan query params ((cara 1))
//    @GetMapping("/book")
//    public Book SalamGet(
//            @RequestParam(value = "isbn", defaultValue = "978-602-8519-93-9") String isbn,
//            @RequestParam(value = "judul", defaultValue = "Hello World") String judul,
//            @RequestParam(value = "pengarang", defaultValue = "Siti") String pengarang) {
//        return new Book(isbn, "ini merupakann judul " +judul, "Buku ini ditulis oleh Get " +pengarang);
//    }

//    @PostMapping("/book")
//    public Book SalamPost(
//            @RequestParam(value = "isbn", defaultValue = "978-602-8519-93-9") String isbn,
//            @RequestParam(value = "judul", defaultValue = "Hello World") String judul,
//            @RequestParam(value = "pengarang", defaultValue = "Siti") String pengarang) {
//        return new Book(isbn, "ini merupakann judul " +judul, "Buku ini ditulis oleh Post " +pengarang);
//    }
//
//    @PutMapping("/book")
//    public Book SalamPut(
//            @RequestParam(value = "isbn", defaultValue = "978-602-8519-93-9") String isbn,
//            @RequestParam(value = "judul", defaultValue = "Hello World") String judul,
//            @RequestParam(value = "pengarang", defaultValue = "Siti") String pengarang) {
//        return new Book(isbn, "ini merupakann judul " +judul, "Buku ini ditulis oleh Put " +pengarang);
//    }
//
//    @PatchMapping("/book")
//    public Book SalamPatch(
//            @RequestParam(value = "isbn", defaultValue = "978-602-8519-93-9") String isbn,
//            @RequestParam(value = "judul", defaultValue = "Hello World") String judul,
//            @RequestParam(value = "pengarang", defaultValue = "Siti") String pengarang) {
//        return new Book(isbn, "ini merupakann judul " +judul, "Buku ini ditulis oleh Patch " +pengarang);
//    }
//
//    @DeleteMapping("/book")
//    public Book SalamDelete(
//            @RequestParam(value = "isbn", defaultValue = "978-602-8519-93-9") String isbn,
//            @RequestParam(value = "judul", defaultValue = "Hello World") String judul,
//            @RequestParam(value = "pengarang", defaultValue = "Siti") String pengarang) {
//        return new Book(isbn, "ini merupakann judul " +judul, "Buku ini ditulis oleh Delete " +pengarang);
//    }
//}
