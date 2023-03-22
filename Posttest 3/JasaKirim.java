public class JasaKirim extends Barang {
    protected String jenisLayanan;
    protected double biaya;

    public JasaKirim(String nama, int jumlah, double berat, String tujuan, String jenisLayanan, double biaya, double waktuPengiriman) {
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

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }
        // subclass inheritance single
        public static class JasaPengirimanEkspress extends JasaKirim {
            private int waktuPengiriman;
            
            public JasaPengirimanEkspress(String nama, int jumlah, double berat, String tujuan, String jenisLayanan, double biaya, int waktuPengiriman) {
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