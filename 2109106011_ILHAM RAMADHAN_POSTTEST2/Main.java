import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.println("========= MENU UTAMA =========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Ubah Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilihan anda: ");

            int pilihan = Integer.parseInt(br.readLine());
            
            if (pilihan == 1) {
                tambahBarang();
            } else if (pilihan == 2){
                lihatDaftarBarang();
            } else if (pilihan == 3){
                ubahBarang();
            } else if (pilihan == 4){
                hapusBarang();
            } else if (pilihan == 5){
                System.out.println("Anda Telah Keluar");
                System.exit(0);
            } else {
                System.out.println("Pilihan Tidak Tersedia");
                br.readLine();
                System.out.print("\033[H\033[2J");
            }
        }
    }

    static void tambahBarang() throws NumberFormatException, IOException {
        System.out.print("\033[H\033[2J");
        System.out.println("========= TAMBAH BARANG =========");
        System.out.print("Masukkan nama barang: ");
        String nama = br.readLine();
        System.out.print("Masukkan jumlah barang: ");
        int jumlah = Integer.parseInt(br.readLine());
        System.out.print("Masukkan berat barang: ");
        double berat = Double.parseDouble(br.readLine());
        System.out.print("Masukkan Tujuan barang: ");
        String tujuan = br.readLine();

        Barang barang = new Barang(nama, jumlah, berat, tujuan);

        daftarBarang.add(barang);
    }

    static void lihatDaftarBarang() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.println("========= DAFTAR BARANG =========");
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang yang tersedia.");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println("Id barang-" + (i+1));
                System.out.println("Nama Barang: " + daftarBarang.get(i).getNama());
                System.out.println("Jumlah Barang: " + daftarBarang.get(i).getJumlah());
                System.out.println("Berat Barang: " + daftarBarang.get(i).getBerat());
                System.out.println("Tujuan Barang: " + daftarBarang.get(i).getTujuan());
                System.out.println("===========================");
            }
        }
        br.readLine();
        System.out.print("\033[H\033[2J");
    }

    static void ubahBarang() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.println("========= UBAH BARANG =========");
        System.out.print("Masukkan ID barang yang ingin diubah: ");
        int id = Integer.parseInt(br.readLine());
    
        if (id-1 < daftarBarang.size()) {
            Barang barang = daftarBarang.get(id-1);
            System.out.print("Masukkan nama barang baru:");
            String namaBaru = br.readLine();
            barang.setNama(namaBaru);
            System.out.print("Masukkan jumlah barang baru: ");
            int jumlahBaru = Integer.parseInt(br.readLine());
            barang.setJumlah(jumlahBaru);
            System.out.print("Masukkan berat barang baru: ");
            double beratBaru = Double.parseDouble(br.readLine());
            barang.setBerat(beratBaru);
            System.out.print("Masukkan nama tujuan baru:");
            String tujuanBaru = br.readLine();
            barang.setTujuan(tujuanBaru);
    
            System.out.println("Barang berhasil diubah!");
        } else {
            System.out.println("Barang tidak ditemukan!");
        }
        br.readLine();
        System.out.print("\033[H\033[2J");
    }
    
    static void hapusBarang() throws NumberFormatException, IOException {
        System.out.print("\033[H\033[2J");
        System.out.println("========= HAPUS BARANG =========");
        System.out.print("Masukkan ID barang yang ingin dihapus: ");
        int id = Integer.parseInt(br.readLine());
    
        if (id-1 < daftarBarang.size()) {
            daftarBarang.remove(id-1);
            System.out.println("Barang berhasil dihapus!");
        } else {
            System.out.println("ID Barang tidak ditemukan!");
        }
        br.readLine();
        System.out.print("\033[H\033[2J");
    }
    

}