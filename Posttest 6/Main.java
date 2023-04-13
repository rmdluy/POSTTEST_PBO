import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

interface Level2 {
    void tambahBarang() throws IOException;

    void lihatDaftarBarang() throws IOException;

    void ubahBarang() throws IOException;

    void hapusBarang() throws NumberFormatException, IOException;
}

abstract class User {
    String username;
    String Password;
}

class Admin extends User implements Level2 {
    static ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void tambahBarang() throws IOException {
        System.out.println("========= TAMBAH BARANG =========");

        System.out.print("Nama Barang: ");
        String nama = br.readLine();
        System.out.print("Jumlah Barang: ");
        int jumlah = Integer.parseInt(br.readLine());
        System.out.print("Berat Barang (Kg): ");
        double berat = Double.parseDouble(br.readLine());
        System.out.print("Tujuan Barang: ");
        String tujuan = br.readLine();

        System.out.print("Jenis Layanan Regular/Ekspress (y/n): ");
        String jenisLayanan = br.readLine();

        if (jenisLayanan.equalsIgnoreCase("y")) {
            jenisLayanan = "Ekspress";
        }

        System.out.print("Biaya: ");
        double biaya = Double.parseDouble(br.readLine());

        if (jenisLayanan.equalsIgnoreCase("Ekspress")) {
            // Lakukan sesuatu jika jenis layanan adalah "Ekspress"
            System.out.print("Waktu Pengiriman: ");
            int waktuPengiriman = Integer.parseInt(br.readLine());
            JasaKirim barang = new JasaKirim.JasaPengirimanEkspress(nama, jumlah, berat, tujuan, jenisLayanan, biaya,
                    waktuPengiriman);
            daftarBarang.add(barang);
        } else {
            Barang barang = new Barang(nama, jumlah, berat, tujuan, biaya) {

                @Override
                public void info() {
                    System.out.println("Nama Barang : " + this.nama);
                    System.out.println("Jumlah Barang : " + this.jumlah);
                    System.out.println("Berat Barang : " + this.berat + " Kg");
                    System.out.println("Tujuan Barang : " + this.tujuan);
                    System.out.println("Biaya Barang: " + this.biaya);
                }
            };
            daftarBarang.add(barang);
        }
    }

    public void lihatDaftarBarang() throws IOException {
        System.out.println("========= DAFTAR BARANG =========");

        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang yang tersedia.");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println("=================================");
                System.out.println("Id barang-" + (i + 1));
                System.out.println("Nama Barang: " + daftarBarang.get(i).getNama());
                System.out.println("Jumlah Barang: " + daftarBarang.get(i).getJumlah());
                System.out.println("Berat Barang: " + daftarBarang.get(i).getBerat());
                System.out.println("Tujuan Barang: " + daftarBarang.get(i).getTujuan());
                System.out.println("Biaya : " + daftarBarang.get(i).getBiaya());

                if (daftarBarang.get(i) instanceof JasaKirim) {
                    JasaKirim jasaKirim = (JasaKirim) daftarBarang.get(i);
                    System.out.println("Jenis Layanan: " + jasaKirim.getJenisLayanan());
                    System.out.println("Biaya: " + jasaKirim.getBiaya());

                    if (daftarBarang.get(i) instanceof JasaKirim.JasaPengirimanEkspress) {
                        JasaKirim.JasaPengirimanEkspress jasaPengirimanEkspress = (JasaKirim.JasaPengirimanEkspress) daftarBarang
                                .get(i);

                        System.out
                                .println("Waktu Pengiriman: " + jasaPengirimanEkspress.getWaktuPengiriman() + " hari");
                    }
                }
            }
        }
        System.out.println("=================================");
        System.out.println("Tekan Enter");
        br.readLine();
    }

    public void ubahBarang() throws IOException {
        System.out.println("========= UBAH BARANG =========");
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang yang tersedia.");
        } else {
            System.out.print("Masukkan ID barang yang akan diubah: ");
            int idBarang = Integer.parseInt(br.readLine());
            if (idBarang <= daftarBarang.size()) {
                Barang barang = daftarBarang.get(idBarang - 1);

                System.out.print("Masukkan jumlah barang baru (kosongkan jika tidak diubah): ");
                String strJumlah = br.readLine();
                if (!strJumlah.isEmpty()) {
                    int jumlah = Integer.parseInt(strJumlah);
                    barang.setJumlah(jumlah);
                }
                System.out.print("Masukkan berat barang baru (kosongkan jika tidak diubah): ");
                String strBerat = br.readLine();
                if (!strBerat.isEmpty()) {
                    double berat = Double.parseDouble(strBerat);
                    barang.setBerat(berat);
                }
                System.out.print("Masukkan Tujuan barang baru (kosongkan jika tidak diubah): ");
                String tujuan = br.readLine();
                if (!tujuan.isEmpty()) {
                    barang.setTujuan(tujuan);
                }
                if (barang instanceof JasaKirim) {
                    JasaKirim jasaKirim = (JasaKirim) barang;
                    System.out.print("Masukkan jenis layanan kirim baru (kosongkan jika tidak diubah): ");
                    String jenisLayanan = br.readLine();
                    if (!jenisLayanan.isEmpty()) {
                        jasaKirim.setJenisLayanan(jenisLayanan);
                    }
                    System.out.print("Masukkan biaya layanan kirim baru (kosongkan jika tidak diubah): ");
                    String strBiaya = br.readLine();
                    if (!strBiaya.isEmpty()) {
                        double biaya = Double.parseDouble(strBiaya);
                        jasaKirim.setBiaya(biaya);
                    }
                }
                System.out.println("Barang dengan ID " + idBarang + " berhasil diubah.");
            } else {
                System.out.println("ID barang tidak tersedia.");
            }
        }
        System.out.println("=================================");
        System.out.println("Tekan Enter");
        br.readLine();
    }

    public void hapusBarang() throws NumberFormatException, IOException {
        System.out.println("========= HAPUS BARANG =========");
        System.out.print("Masukkan ID barang yang ingin dihapus: ");
        int id = Integer.parseInt(br.readLine());

        if (id - 1 < daftarBarang.size()) {
            daftarBarang.remove(id - 1);
            System.out.println("Barang berhasil dihapus!");
        } else {
            System.out.println("ID Barang tidak ditemukan!");
        }
        System.out.println("=================================");
        System.out.println("Tekan Enter");
        br.readLine();
    }

}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Admin ilham = new Admin();

    public static void main(String[] args) throws NumberFormatException, IOException {
        while (true) {
            System.out.println("========= MENU UTAMA =========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Ubah Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilihan anda: ");

            int pilihan = Integer.parseInt(br.readLine());

            if (pilihan == 1) {
                ilham.tambahBarang();
            } else if (pilihan == 2) {
                ilham.lihatDaftarBarang();
            } else if (pilihan == 3) {
                ilham.ubahBarang();
            } else if (pilihan == 4) {
                ilham.hapusBarang();
            } else if (pilihan == 5) {
                System.out.println("Anda Telah Keluar");
                System.exit(0);
            } else {
                System.out.println("Pilihan Tidak Tersedia");
                br.readLine();

            }
        }
    }

}