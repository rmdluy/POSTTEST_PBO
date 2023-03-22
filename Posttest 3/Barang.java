public class Barang {
   protected String nama;
   protected int jumlah;
   protected double berat;
   protected String tujuan;


   public String getNama() {
      return nama;
   }

   public void setNama(String nama) {
      this.nama = nama;
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

   public Barang(String nama, int jumlah, double berat, String tujuan ) {
       this.nama = nama ;
       this.jumlah = jumlah ;
       this.berat = berat ;
       this.tujuan = tujuan ;
   }

}


