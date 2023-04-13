public abstract class Barang {
   protected final String nama;
   protected int jumlah;
   protected double berat;
   protected String tujuan;
   protected double biaya;

   public double getBiaya() {
      return biaya;
   }

   public void setBiaya(double biaya) {
      this.biaya = biaya;
   }

   public String getNama() {
      return nama;
   }

   public int getJumlah() {
      return jumlah;
   }

   public void setJumlah(int jumlah) {
      this.jumlah = jumlah;
   }

   public double getBerat() {
      return berat;
   }

   public void setBerat(double berat) {
      this.berat = berat;
   }

   public String getTujuan() {
      return tujuan;
   }

   public void setTujuan(String tujuan) {
      this.tujuan = tujuan;
   }

   public Barang(final String nama, int jumlah, double berat, String tujuan, double biaya) {
      this.nama = nama;
      this.jumlah = jumlah;
      this.berat = berat;
      this.tujuan = tujuan;
      this.biaya = biaya;
   }

   // Fungsi override
   public void info() {
      System.out.println("Nama Barang : " + this.nama);
      System.out.println("Jumlah Barang : " + this.jumlah);
      System.out.println("Berat Barang : " + this.berat + " Kg");
      System.out.println("Tujuan Barang : " + this.tujuan);
      System.out.println("Biaya Barang : " + this.biaya);
   }

   // Overloading method info untuk mencetak informasi pengiriman
   public void info(String jenisLayanan, double biaya) {
      System.out.println("Nama Barang : " + this.nama);
      System.out.println("Jumlah Barang : " + this.jumlah);
      System.out.println("Berat Barang : " + this.berat + " Kg");
      System.out.println("Tujuan Barang : " + this.tujuan);
      System.out.println("Jenis Layanan : " + jenisLayanan);
      System.out.println("Biaya : " + biaya);
   }

}