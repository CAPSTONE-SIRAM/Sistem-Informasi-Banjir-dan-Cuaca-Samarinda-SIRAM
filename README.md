# Sistem-Informasi-Banjir-dan-Cuaca-Samarinda-SIRAM
## Anggota Kelompok
- Dwi Pebriyanto Pradana 2409116012
- Najmi Hafizh Mauludan Zain 2409116028
- Rizqy 2409116039
- Jemis Movid 2409116070

# PROGRAM SISTEM INFORMASI BANJIR DAN CUACA SAMARINDA (SIRAM)
Sistem Informasi Banjir dan Cuaca Samarinda atau SIRAM merupakan program yang membantu masyarakat Samarinda dalam mendapatkan informasi cuaca terkini, serta informasi lokasi yang mengalami banjir secara realtime dari laporan banjir pengguna lain yang juga tersedia statusnya apakah masih banjir atau surut. program ini juga melihatkan tindak lanjut yang dilakukan petugas terhadap laporan banjir yang dilaporkan masyarakat Samarinda.


# FLOWCHART DAN USE CASE DIAGRAM
### Flowchart
<details>
  <summary>1. Flowchart Menu Utama</summary>
  <img src="https://github.com/user-attachments/assets/1e8301a3-bea2-4e11-955a-f03f825e55f6"alt="">
</details>

<details>
  <summary>2. Flowchart Registrasi</summary>
  <img src="https://github.com/user-attachments/assets/8d257901-a0f0-4b10-97ec-f9fd852a019e"alt="">
</details>

<details>
  <summary>3. Flowchart Menu User</summary>
  <img src="https://github.com/user-attachments/assets/a93cfc0e-d44e-43a5-a521-6d7e60782548"alt="">
</details>

<details>
  <summary>4. Flowchart Menu Admin</summary>
  <img src="https://github.com/user-attachments/assets/6cc8df40-0a95-4c34-bc0c-f68f829aa728"alt="">
</details>

<details>
  <summary>5. Flowchart Kelola Info Cuaca</summary>
  <img src="https://github.com/user-attachments/assets/40a34d04-54c5-4362-80a5-d25a6bee9a15"alt="">
</details>

<details>
  <summary>6. Flowchart Kelola Laporan Banjir</summary>
  <img src="https://github.com/user-attachments/assets/022cf852-f45d-4ba2-952b-c34a23da56e4"alt="">
</details>

<details>
  <summary>7. Flowchart Tindak Lanjut</summary>
  <img src="https://github.com/user-attachments/assets/42f12114-68ab-48b9-ba80-48889c7ea711"alt="">
</details>

### Use Case Diagram
<details>
  <summary>Use Case Diagram SIRAM</summary>
  <img src="https://github.com/user-attachments/assets/9cecfa4c-c6df-4760-ac14-6cc564a77b21"alt="">
</details>

# FITUR-FITUR PROGRAM

- Tampilan awal: Merupakan tampilan yang menunjukan info cuaca hujan dan cuaca panas. serta menu login dan registrasi.

- Sistem login: Sebagai titik navigasi ke fungsi-utama, Memfasilitasi pemilihan jalur sesuai peran (Admin atau User).
  
- Registrasi: Digunakan untuk membuat akun baru sebagai User. Data user dikumpulkan untuk autentikasi, lalu diarahkan ke Menu User setelah aktif.
  
- Menu User: Halaman utama bagi User setelah login/registrasi. User dapat melihat laporan banjir yang dibuat oleh user lain kemudian tindak lanjut dari admin. user juga dapat melihat info cuaca yang sudah dikelola Admin serta mengirim laporan banjir sebagai informasi ke user lain.
  
- filter Cuaca Sesuai Jenisnya : Pada menu informasi cuaca program memisahkan informasi cuaca berdasarkan cuaca hujan dan cuaca panas sehingga memudahkan user dan memberikan tampilan yang menarik.

- Laporan menampilkan gambar: Dengan adanya fitur laporan banjir user lain dapat terbantu mendapatkan informasi banjir, serta di permudah dengan adanya fitur lihat foto pada setiap laporan.
  
- Menu Admin: Akses khusus bagi peran Admin yang telah berhasil login. Menyediakan kontrol dan manajemen terhadap komponen sistem.
  
- Kelola Info Cuaca: Admin dapat melakukan input, edit, atau hapus informasi cuaca yang kemudian ditampilkan ke pengguna untuk mereka mendapatkan informasi cuaca.
  
- Kelola Laporan Banjir: Admin melihat laporan banjir yang disampaikan oleh user, kemudian admin dapat mengambil tindakan ataupun memberi respon terhadapat laporan user.

# PENERAPAN 5 PILAR OOP
### 1. Encapsulation
Konsep membungkus data sensitif berupa property atau method dalam sebuah class agar terlindungi dari akses class lain. Untuk mengakses class tersebut, harus menetapkan modifier ‘private’ pada property terlebih dahulu, kemudian data bisa diakses melalui method getter (penginisialisasian)/setter (pengaksesan) yang bersifat ‘public’.
contohnya:

<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/846682f8-ef83-4dd8-bfb2-1aa2668ea5a5" />


<img width="500" height="400" alt="image" src="https://github.com/user-attachments/assets/4bdfd981-f010-42f7-a095-f58dfbb49815" />

Pada class Users, encapsulation diterapkan dengan menjadikan atribut username, nama_lengkap, email dll bersifat private kemudian diakses melalui method getter dan setter.
Hal ini menjaga keamanan data pengguna serta membuat struktur kode lebih teratur dan mudah dikelola.

### 2. Inheritance
Inheritance merupakan salah satu pilar utama dalam Pemrograman Berorientasi Objek yang memungkinkan suatu class (child) mewarisi property dan method dari class  lain (parent). Inheritance membantu mengurangi penulisan kode secara berulang  (mengurangi redundancy kode). Sebuah kelas (superclass) dapat mewariskan property dan method kepada kelas-kelas turunannya (subclass). Artinya, subclass dapat menggunakan kembali property dan method dari superclass, serta dapat menambahkan property dan method baru atau mengubah perilaku yang sudah ada.
Contoh:

<img width="666" height="263" alt="image" src="https://github.com/user-attachments/assets/0d735785-eca4-496c-ad89-08ee15e41391" />

Class Cuaca dibuat sebagai class abstrak yang menyimpan atribut umum dari semua jenis cuaca, yaitu suhu, kelembapan, tanggal dan kecamatan.
Karena bersifat abstrak, class ini tidak dapat dibuat objek secara langsung, tetapi dapat diwariskan oleh class lain.

<img width="665" height="233" alt="image" src="https://github.com/user-attachments/assets/71220383-391d-4cae-848c-1bf6c1c6bb62" />

Class CuacaHujan mewarisi class Cuaca. Selain itu, class ini memiliki atribut tambahan cuaca yaitu curah_Hujan dan potensi_Banjir

<img width="649" height="221" alt="image" src="https://github.com/user-attachments/assets/687e55c8-c28a-4a80-a19b-c20906394553" />

Sama seperti Cuaca_Hujan, class CuacaPanas juga mewarisi atribut umum dari Cuaca, dan menambahkan atribut untuk kondisi cuaca panas yaitu indeks_UV dan level_Panas

### 3. Abstraction
Abstraksi berarti hanya menaruh karakteristik-karakteristik yang diperlukan oleh sebuah kelas tanpa harus menampilkan detail dari karakteristik tersebut. Dalam abstraction menggunakan abstract class yang merukan kelas abtrak digunakan untuk menentukan karakteristik dari sebuah kelas. Abstract class tidak bisa dibuat menjadi obek secara langsung harus diwariskan.
contoh:

<img width="600" height="58" alt="image" src="https://github.com/user-attachments/assets/c5cf4cc6-54fe-42b3-b9ee-c0f6aa0296db" />

<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/3db06c7a-bf7a-499b-98e8-1d1a7ae6cad1" />

<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/dde50396-fe87-418a-b980-d03ba4bbc147" />

Abstraction pada class Cuaca untuk menampikan tabel digunakan untuk method dasar, sementara detail implementasi menampilkan tabel diatur oleh subclass CuacaHujan dan CuacaPanas.

### 4. Polymorphism
Polymorphism adalah kondsi dimana kita dapat membuat ssuatu method dengan nama yang sama namun memiliki variasi kegunaan yang berbeda.
contoh:
- Overloading
  
  <img width="564" height="298" alt="image" src="https://github.com/user-attachments/assets/5c0acff0-6e63-46e1-bcb8-4313d6814044" />

  Overloading GUI infocuacaU yang dimana terdapat 2 method InfoCuacaU namun yang satu punya parameter id user dan satunya tidak. 

- Overriding
- 
<img width="600" height="58" alt="image" src="https://github.com/user-attachments/assets/c5cf4cc6-54fe-42b3-b9ee-c0f6aa0296db" />

<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/3db06c7a-bf7a-499b-98e8-1d1a7ae6cad1" />

<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/dde50396-fe87-418a-b980-d03ba4bbc147" />

Overiding pada method tampil() yang dioverride dari class abstrak Cuaca. Setiap subclass seperti CuacaHujan dan CuacaPanas memiliki implementasi tampil() sendiri, sehingga sistem dapat menampilkan data sesuai jenis cuaca tanpa mengubah struktur utama.

### 5. Interface
Interface adalah kelas yang mengimplementasikannya wajib menyediakan semua method yang ada di dalamnya.
contoh:

<img width="404" height="313" alt="image" src="https://github.com/user-attachments/assets/e16648ec-a266-40cd-a6b2-c031048d8c55" />

<img width="936" height="489" alt="image" src="https://github.com/user-attachments/assets/9c4a6cb4-46ea-479e-8ad2-266ac0f783f9" />

Interface CuacaDAO digunakan sebagai blueprint operasi database cuaca seperti insert, update, delete, dan get. Dengan interface ini, sistem menjadi lebih fleksibel karena implementasi akses data dapat diubah tanpa mempengaruhi logika utama aplikasi.

# PENJELASAN STRUKTUR PACKAGES
<img width="637" height="682" alt="image" src="https://github.com/user-attachments/assets/59f757f5-87db-4fd3-b514-49e64f205939" />

### 1. Source Packages

Bagian ini berisi seluruh kode utama program. Di dalamnya terdapat beberapa package yang memiliki fungsi berbeda namun saling berkaitan.

- Control
Package ini berfungsi sebagai pengatur alur logika program antara tampilan dan data. Class yang ada di dalamnya mengelola proses seperti login, input laporan, validasi data, dan komunikasi antara antarmuka pengguna dengan database.

- GUI
Package ini berisi komponen tampilan antarmuka yang digunakan oleh pengguna. Seluruh halaman seperti menu utama, form login, registrasi, menu admin, dan menu user terdapat di dalam bagian ini.

- Koneksi
Package ini bertugas mengatur koneksi antara aplikasi dengan database. Di dalamnya terdapat class yang mengatur konfigurasi driver dan koneksi menggunakan framework Hibernate.

- Model
Package ini menyimpan class-class yang merepresentasikan data atau entitas yang ada di dalam database, seperti User, Laporan, Cuaca, dan Daerah. Bagian ini menangani proses pengolahan data seperti penyimpanan, pembaruan, penghapusan, dan pengambilan data (CRUD).

- Util
Package ini berfungsi sebagai penyedia class pendukung atau helper yang membantu proses kerja aplikasi, misalnya pengaturan format, validasi input, atau fungsi tambahan lain yang digunakan di berbagai bagian program.

### 2. Test Packages

Bagian ini digunakan untuk menyimpan file pengujian atau testing terhadap fungsi-fungsi program. Tujuannya adalah memastikan bahwa setiap fitur utama dalam aplikasi dapat berjalan sesuai dengan kebutuhan dan bebas dari error.

### 3. Other Sources

Terdapat file hibernate.cfg.xml yang digunakan sebagai konfigurasi Hibernate, meliputi pengaturan nama database, username, password, serta driver koneksi. Selain itu, terdapat juga folder Logo yang berisi aset gambar yang digunakan dalam tampilan antarmuka (GUI).
  
### 4. Dependencies

Bagian ini berisi library eksternal (file .jar) yang dibutuhkan agar program dapat berjalan dengan baik, di antaranya:

- hibernate-core yang digunakan untuk menghubungkan objek Java dengan database melalui konsep ORM.
  
- mysql-connector-j untuk menghubungkan aplikasi dengan database MySQL.
  
- jakarta.persistence-api dan jakarta.transaction-api untuk mendukung proses transaksi dan penyimpanan data.
  
- AbsoluteLayout untuk membantu pengaturan tata letak tampilan antarmuka / GUI.
  
- protobuf-java yang berfungsi dalam pengolahan data tambahan.

# PENERAPAN NILAI TAMBAHAN
### Menggunakan metode tertentu untuk koneksi ke database

<img width="815" height="508" alt="image" src="https://github.com/user-attachments/assets/3f536d0a-386c-4b3f-808d-dcdb885dcdb8" />

Class LaporanDAOImpl mengimplementasikan fungsi tambah() untuk menyimpan data laporan ke database menggunakan Hibernate. Proses dilakukan dengan transaksi agar data tersimpan aman, dan sesi ditutup otomatis untuk mencegah kebocoran koneksi.

### Menerapkan struktur MVC

<img width="274" height="113" alt="image" src="https://github.com/user-attachments/assets/95a06d9e-f2fe-4ff7-ac71-8ea838cf4606" />

pada program ini menggunakan struktur MVC yaitu
- Model terdapat pada package model yang berisi class untuk model setiap entitas yang ada di database
- View terdaat pada package GUI yang berfungsi sebagai tampilan antar muka untuk pengguna
- Control terdapat pada package Control yang berfungsii sebagai method yang dijalankan.

### Mengimplementasikan framework ORM

<img width="1299" height="574" alt="image" src="https://github.com/user-attachments/assets/7485953a-449b-4328-a324-49c835ed7057" />

File hibernate.cfg.xml berfungsi untuk mengatur koneksi Hibernate ke database MySQL serta melakukan mapping antara class model dan tabel database. Pengaturan ini memudahkan proses CRUD tanpa harus menulis query SQL secara langsung.

# LIBRARY ATAU FRAMEWORK YANG DIGUNAKAN
- Hibernate
  
  Hibernate digunakan sebagai framework ORM untuk menghubungkan class Java dengan tabel pada database sehingga CRUD dapat dilakukan secara otomatis tanpa banyak SQL manual.   Dengan Hibernate, data entity seperti Laporan dapat langsung dipetakan ke tabel laporan.
  
- MYSQL & JBDC Driver
  
  MySQL digunakan sebagai penyimpanan data aplikasi sedangkan JDBC Driver berfungsi sebagai penghubung antara Java dan MySQL agar query dapat berjalan dengan baik.            Kombinasi ini memungkinkan aplikasi menyimpan laporan cuaca secara langsung ke database.
  
- Java Swing
  
  Java Swing digunakan untuk membangun tampilan antarmuka aplikasi desktop seperti form input, tabel data, dan dialog notifikasi agar pengguna dapat berinteraksi dengan       mudah.
  
- FileInputStream, JFileChooser
  
  JFileChooser memungkinkan pengguna memilih file gambar, sedangkan FileInputStream membaca file tersebut sebagai stream sebelum disimpan ke database. Teknologi ini           digunakan untuk unggah foto bukti laporan.
  
- LocalDate, java.sql.Date
  
  LocalDate digunakan untuk mengelola tanggal dalam aplikasi, dan java.sql.Date dipakai untuk mengubah format agar dapat disimpan ke database MySQL dengan benar.
  
- Java Enum
  
  Java Enum dipakai untuk data yang memiliki pilihan terbatas seperti status cuaca sehingga input lebih konsisten dan mudah dikelola.
  
# CARA MENGGUNAKAN PROGRAM
### Halaman Utama
<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/c594c2eb-b680-495a-b93d-f8ac2c5d798e" />

Halaman utama SIRAM menampilkan informasi cuaca terkini di Samarinda, baik kondisi hujan maupun panas. Pengguna dapat memilih jenis cuaca untuk melihat data seperti suhu, kelembapan, curah hujan, indeks UV, serta potensi banjir atau level panas. Pengguna dapat login untuk mengakses fitur lanjutan atau melakukan registrasi jika belum memiliki akun.

### Membuat Akun
<img width="1196" height="948" alt="image" src="https://github.com/user-attachments/assets/cf27c323-6f75-4931-a2a1-601b1d78238d" />

Halaman Buat Akun digunakan untuk proses registrasi pengguna baru pada aplikasi SIRAM. Pengguna mengisi data pribadi seperti nama, email, nomor HP, username, dan password. Setelah data tervalidasi, sistem menyimpan informasi tersebut ke database agar pengguna dapat melakukan login ke dalam sistem.

### Role User/Pengguna
#### Login
<img width="1175" height="887" alt="image" src="https://github.com/user-attachments/assets/43a4a804-8ec6-4e1a-a730-de2926e93304" />

Halaman login digunakan untuk autentikasi pengguna pada aplikasi SIRAM. Pengguna memasukkan username/email dan password untuk mengakses sistem. Jika login berhasil, sistem menampilkan pesan sambutan dan mengarahkan pengguna ke menu user.

#### Menu User
<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/31148e54-5f52-48a0-9a52-9b2744a547c3" />

Tampilan utama bagi pengguna setelah berhasil login ke aplikasi SIRAM. Pengguna dapat melihat informasi cuaca terkini melalui menu Info Cuaca atau melaporkan kondisi banjir melalui menu Laporan Banjir. Disediakan juga tombol Logout untuk keluar dari akun.

#### Info Cuaca
<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/9d3bb03a-0648-4a83-b907-3cda75d54f93" />

Halaman ini menampilkan daftar wilayah yang mengalami hujan, lengkap dengan data suhu, kelembapan, curah hujan, dan potensi banjir. Pengguna dapat mengganti kategori cuaca melalui menu dropdown dan kembali ke dashboard dengan tombol ‘Kembali’.

<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/44378a67-4ecf-490d-9163-c3f5bd2da4f2" />

Halaman ini menampilkan daftar wilayah yang mengalami cuaca panas disertai suhu, kelembapan, dan indeks UV. Tampilan berwarna cerah memberikan kesan hangat, dan pengguna dapat mengganti kategori cuaca atau kembali ke dashboard melalui tombol navigasi.

#### Laporan Banjir
<img width="1203" height="946" alt="Cuplikan layar 2025-11-01 042234" src="https://github.com/user-attachments/assets/8565a56b-d960-4c32-bad8-522e906a02b0" />
<img width="1180" height="923" alt="image" src="https://github.com/user-attachments/assets/ab9e8c40-907f-4283-84e4-7cc9ceb3268f" />

Halaman ini menampilkan daftar laporan banjir yang berisi informasi pelapor, lokasi, tinggi air, status, dan foto kondisi lapangan. Pengguna dapat melihat foto laporan melalui tombol ‘Lihat Foto’ atau menambah laporan baru melalui tombol ‘Buat Laporan’. Tampilan ini membantu pemantauan banjir secara cepat dan informatif.

#### Buat Laporan
<img width="1182" height="891" alt="image" src="https://github.com/user-attachments/assets/62a7a2dd-e65e-4ceb-87de-cefa292dc253" />

Halaman form laporan digunakan untuk memasukkan data kejadian banjir seperti tinggi air, kecamatan, lokasi, dan foto bukti sebelum dikirim ke sistem.

<img width="1173" height="892" alt="image" src="https://github.com/user-attachments/assets/0e94c701-af05-416b-9092-6a00167f91db" />

Jendela pemilihan file muncul ketika pengguna mengunggah foto bukti banjir. Fitur ini memastikan laporan dilengkapi dengan dokumentasi visual dari lapangan.

<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/655b4a93-94c7-4f9a-a6b8-5e0d5072f2aa" />

Setelah laporan dikirim, data akan otomatis tersimpan dan muncul di daftar laporan banjir. Pengguna dapat memverifikasi hasil kiriman dan melihat status laporan secara langsung.

### Lihat Tindak Lanjut
<img width="1182" height="891" alt="image" src="https://github.com/user-attachments/assets/79dfd79b-7444-4c9b-8eb4-afd72734566a" />

Halaman ini menampilkan hasil tindak lanjut dari laporan banjir yang telah dikirim. Pengguna dapat melihat status penyelesaian dan deskripsi tindakan yang dilakukan oleh pihak terkait pada lokasi yang dilaporkan.

### Role Admin
#### Login
<img width="1177" height="883" alt="image" src="https://github.com/user-attachments/assets/979f5785-ab6f-4078-bf62-e6d37a54407a" />
Halaman login digunakan untuk autentikasi admin pada aplikasi SIRAM. admin memasukkan username/email dan password untuk mengakses sistem. Jika login berhasil, sistem menampilkan pesan sambutan dan mengarahkan admin ke menu admin.

#### Menu Admin
<img width="1182" height="891" alt="image" src="https://github.com/user-attachments/assets/a00a3cfa-4f55-4ac2-99bc-394c23dd81c3" />
Tampilan utama bagi admin setelah berhasil login ke aplikasi SIRAM. admin dapat mengelola informasi cuaca melalui Kelola Info Cuaca atau mengelola laporan banjir melalui menu kelola Laporan Banjir. Disediakan juga tombol Logout untuk keluar dari akun.

#### Kelola Info Cuaca
<img width="1199" height="944" alt="image" src="https://github.com/user-attachments/assets/c28664b5-ba8a-4483-84b1-bb30a66b6130" />

<img width="1207" height="950" alt="image" src="https://github.com/user-attachments/assets/2bf5c5ab-c30d-4827-a958-e13cddc5ed64" />

Halaman ini memungkinkan admin untuk mengelola informasi cuaca seperti suhu, kelembapan, curah hujan, dan indeks UV di berbagai wilayah. Admin dapat menambah, memperbarui, atau menghapus data sesuai kondisi cuaca yang tercatat.


1. Tambah Info Cuaca
   <img width="1203" height="943" alt="image" src="https://github.com/user-attachments/assets/24921194-76ad-41c9-8312-079a9bfc1791" />

   Tampilan ini menunjukkan proses penambahan data cuaca baru oleh admin. Admin mengisi form yang berisi:
   - Tanggal cuaca
   - Kecamatan
   - Suhu
   - Kelembapan
   - Curah hujan

    Setelah semua data diisi dan tombol Tambah ditekan, sistem menampilkan notifikasi “Data has been inserted successfully” sebagai tanda bahwa data berhasil disimpan.

2. Perbarui Info Cuaca
   <img width="1196" height="942" alt="image" src="https://github.com/user-attachments/assets/07a149de-acf1-4c04-a0db-e05e7afdf9cb" />

   Pada tampilan ini admin melakukan pembaruan (update) terhadap data cuaca yang sudah ada. Langkah-langkahnya:
   - Pilih baris data yang ingin diperbarui dari tabel.
   - Ubah informasi yang perlu disesuaikan.
   - Tekan tombol Perbarui.

    Setelah itu muncul pesan “Data has been updated successfully” yang menandakan proses update berhasil dilakukan.

3. Hapus Info Cuaca
   <img width="1203" height="944" alt="image" src="https://github.com/user-attachments/assets/47e13290-616d-4cd4-87e8-224a107b7996" />

   Tampilan ini digunakan untuk menghapus data cuaca. Admin memilih data yang ingin dihapus lalu menekan tombol Hapus. Sistem menampilkan pesan konfirmasi “Apakah yakin ingin menghapus data ini?” untuk memastikan tindakan tersebut. Jika admin menekan Yes, maka data akan dihapus dari tabel dan tidak lagi tampil dalam daftar.

#### Kelola Laporan Banjir
<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/e82bc710-5194-4dd2-aac0-c11f6b29e47e" />

  Kelola laporan banjir adalah salah satu menu utama untuk admin. Di menu ini, admin bisa mengelola data-data informasi terkait laporan banjir yang kemudian juga bisa dilakukan tindak lanjut terhadap laporan tersebut.

<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/8c0f2bea-143a-405b-9f40-69b7860abbba" />

  Di menu kelola laporan banjir ini, admin juga bisa melakukan preview dulu dari laporan yang disampaikan. Misalnya di sini admin melihat foto lokasi, kejadian, dan lain-lainnya sebagai bukti laporan.

1. Ubah Status Banjir
   <img width="1194" height="944" alt="image" src="https://github.com/user-attachments/assets/1cc93ec9-4140-444b-a4e4-b014a73023e7" />

   <img width="1209" height="947" alt="image" src="https://github.com/user-attachments/assets/ea1595b3-94b8-4293-97e2-cc29f2ff3316" />

   Pada tampilan ini, sang admin melakukan pembaruan data (update) pada bagian status laporan yang diberikan user. Adapun langkah-langkahnya:
   - Admin memasukan id dari laporan.
   - Kemudian admin menekan tombol "Ubah Status"

3. Hapus Laporan Banjir
   <img width="1197" height="943" alt="image" src="https://github.com/user-attachments/assets/de5f117b-cb48-4f9e-a8eb-731d0da0266d" />

   Mirip dengan hapus info cuaca, bagian tampilan ini sang admin melakukan penghapusan data laporan banjir dengan terlebih dahulu memasukan id laporan lalu kemudian menekan tombol "Hapus". Kemudian, sistem akan menampilkan pesan konfirmasi sebelum dihapus. Jika admin memilih Yes, maka akan dihapus. jika memilih No, maka proses batal. (Catatan: Laporan yang memiliki laporan tindak lanjut tidak dapat dihapus).

#### Tindak Lanjut Laporan
<img width="1203" height="946" alt="image" src="https://github.com/user-attachments/assets/6e5c792e-daed-4139-a895-c3c986503c1e" />

  Ini adalah tampilan utama dari menu Tindak Lanjut Laporan. Pada menu inilah sang admin bisa melakukan pengelolan data lebih lanjut terkait penanganan banjir. Dari sini admin bisa melakukan tambah data sesuai id laporan, memperbarui status penanganan, dan menghapus data.

1. Tambah Tindak Lanjut Laporan
   <img width="1205" height="943" alt="image" src="https://github.com/user-attachments/assets/8fe1a022-c1f7-4021-af8a-e4b87320b2e7" />

   Ini adalah tampilan proses penambahan data tindak lanjut laporan. Adapun langkah-langkah dalam melakukannya adalah:
   - Admin memilih id laporan dari laporan yang ingin ditindaklanjuti.
   - Untuk id tindak lanjut dan tanggal dibiarkan kosong karena akan diisi otomatis oleh program (sebab di sini kita hanyak menambahkan data). Untuk bagian tanggal, tanggalnya akan diisi sesuai dengan waktu dan tanggal admin
   - Setelah itu admin akan mengisi bagian bentuk penanganan yang bisa berisi deskripsi singkat.
   - Kemudian, tekan tombol tambah dan data pun berhasil ditambahkan.

3. Perbarui Tindak Lanjut Laporan
   <img width="1200" height="947" alt="image" src="https://github.com/user-attachments/assets/2f4875e3-8598-4da8-8bf7-eab2ded8c698" />

   Ini adalah tampilan dari proses memperbarui datanya. Adapun langkah-langkah dalam melakukannya adalah:
   - Admin memilih baris data yang ingin diperbarui.
   - Kemudian, akan muncul id tindak lanjut, id laparan, tanggal, dan deskripsi. Dari sini, admin bisa mengubah isi dari data tersebut.
   - Setelahnya admin hanya perlu menekan tombol perbarui dan data berhasil perbarui.

5. Ubah Status
   <img width="1195" height="948" alt="image" src="https://github.com/user-attachments/assets/db926753-e15b-40be-8317-873110dc3baf" />

   Tampilan ini adalah tampilan ubah status tindak lanjut.

   <img width="1193" height="939" alt="image" src="https://github.com/user-attachments/assets/f18cf86e-53d8-4e62-9e8a-212864043044" />

   Sama dengan Ubah Status Banjir, bagian tampilan ini memungkina admin untuk mengubah status dari penanganan tindak lanjut. Di sini admin hanya perlu memilih baris dari data atau informasi yang ingin diuba lalu menekan ubah status. Maka kemudia program akan mengubah status laporan penanganan tindak lanjut.

6. Hapus Tindak Lanjut
   <img width="1200" height="943" alt="image" src="https://github.com/user-attachments/assets/d69eec45-e005-44f4-9d60-e10396671fd4" />

   Sama seperti yang sebelum-sebelumnya, bagian ini adalah menu untuk menghapus isi datanya. Admin hanya perlu memilih baris dari data yang ingin dihapus, kemudian tekan tombol hapus. Program akan memberikan pesan peringatan sebelum dihapus dan jika admin memilih Yes, maka data akan dihapus dan jika memilih No, maka proses akan dibatalkan.





