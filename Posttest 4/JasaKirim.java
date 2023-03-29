public class JasaKirim extends Barang {
    protected String jenisLayanan;
    protected double biaya;

    public JasaKirim(String nama, int jumlah, double berat, String tujuan, String jenisLayanan, double biaya,
            double waktuPengiriman) {
        super(nama, jumlah, berat, tujuan);
        this.jenisLayanan = jenisLayanan;
        this.biaya = biaya;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public double getBiaya() {
        return biaya;
    }

    // Fungsi override untuk mencetak informasi pengiriman
    @Override
    public void info() {
        super.info();
        System.out.println("Jenis Layanan : " + this.jenisLayanan);
        System.out.println("Biaya : " + this.biaya);
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    // Overloading method info untuk mencetak informasi pengiriman dengan biaya yang
    // berbeda
    public void info(double biaya) {
        super.info();
        System.out.println("Jenis Layanan : " + this.jenisLayanan);
        System.out.println("Biaya : " + biaya);
    }

    // subclass inheritance single
    public static class JasaPengirimanEkspress extends JasaKirim {
        private int waktuPengiriman;

        public JasaPengirimanEkspress(String nama, int jumlah, double berat, String tujuan, String jenisLayanan,
                double biaya, int waktuPengiriman) {
            super(nama, jumlah, berat, tujuan, jenisLayanan, biaya, biaya);
            this.waktuPengiriman = waktuPengiriman;
        }

        public int getWaktuPengiriman() {
            return waktuPengiriman;
        }

        public void setWaktuPengiriman(int waktuPengiriman) {
            this.waktuPengiriman = waktuPengiriman;
        }
    }
}