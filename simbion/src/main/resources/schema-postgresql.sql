CREATE SCHEMA simbion;

CREATE TABLE SIMBION.PENGGUNA (
	username varchar (20) not null,
	password varchar (20) not null,
	primary key (username)
);

CREATE TABLE SIMBION.DONATUR  (
	nomor_identitas varchar (20) not null,
	email varchar (50) not null,
	nama varchar (50) not null,
	npwp char (20) not null,
	no_telp varchar (20),
	alamat varchar (100) not null,
	username varchar (50) not null,
	primary key (nomor_identitas),
	foreign key (username) references PENGGUNA (username) on update cascade on delete cascade
);

CREATE TABLE SIMBION.ADMIN (
	username varchar(50) not null,
	primary key (username),
	foreign key (username) references PENGGUNA (username) on update cascade on delete cascade
);

CREATE TABLE SIMBION.INDIVIDUAL_DONOR (
	nik char(16) not null,
	nomor_identitas_donatur varchar(20) not null,
	primary key (nik),
	foreign key (nomor_identitas_donatur) references DONATUR (nomor_identitas) on update cascade on delete cascade
);

CREATE TABLE SIMBION.MAHASISWA (
	npm varchar(20) not null,
	email varchar(50) not null,
	nama varchar(50) not null,
	no_telp varchar(20),
	alamat_tinggal varchar(50) not null,
	alamat_domisili varchar(50) not null,
	nama_bank varchar(50) not null,
	no_rekening varchar(20) not null,
	nama_pemilik varchar(50) not null,
	username varchar(50) not null,
	primary key (npm),
	foreign key (username) references PENGGUNA (username) on update cascade on delete cascade
);

CREATE TABLE SIMBION.YAYASAN (
	no_sk_yayasan varchar (20) not null,
	email varchar (50) not null,
	nama varchar (50) not null,
no_telp_cp varchar (20),
nomor_identitas_donatur char(16) not null,
	primary key (no_sk_yayasan),
	foreign key (nomor_identitas_donatur) references DONATUR(nomor_identitas) on update cascade on delete cascade
);


CREATE TABLE SIMBION.RIWAYAT_AKADEMIK (
	no_urut int not null,
	npm varchar (20) not null,
	semester char (1) not null,
tahun_ajaran char (9) not null,
jumlah_sks int not null,
IPS double precision not null,
lampiran varchar (200) not null,
	primary key (no_urut, npm),
	foreign key (npm) references MAHASISWA(npm) on update cascade on delete cascade
);

CREATE TABLE SIMBION.SKEMA_BEASISWA (
	kode int not null,
	nama varchar (50) not null,
	jenis varchar (50) not null,
	deskripsi varchar (100) not null,
	nomor_identitas_donatur char (16) not null,
	primary key (kode),
	foreign key (nomor_identitas_donatur) references DONATUR(nomor_identitas) on update cascade on delete cascade
);

CREATE TABLE SIMBION.SYARAT_BEASISWA (
	kode_beasiswa int not null,
	syarat varchar (50) not null,
	primary key (kode_beasiswa, syarat),
	foreign key (kode_beasiswa) references SKEMA_BEASISWA(kode) on update cascade on delete cascade
);

CREATE TABLE SIMBION.SKEMA_BEASISWA_AKTIF (
	kode_skema_beasiswa int not null,
	no_urut int not null,
	tgl_mulai_pendaftaran date not null,
	tgl_tutup_pendaftaran date not null,
	periode_penerimaan varchar (20) not null,
	status varchar (20) not null,
	jumlah_pendaftar int not null,
	total_pendaftar INTEGER,
	total_pembayaran INTEGER,
	unique (kode_skema_beasiswa, no_urut),
	primary key (kode_skema_beasiswa , no_urut),
	foreign key (kode_skema_beasiswa) references SKEMA_BEASISWA(kode) on update cascade on delete cascade
);

CREATE TABLE SIMBION.PENDAFTARAN(
	no_urut int not null,
	kode_skema_beasiswa int not null,
	npm varchar(20) not null,
	waktu_daftar timestamp not null,
	status_daftar varchar(20) not null,
	status_terima varchar(20) not null,
	primary key (no_urut, kode_skema_beasiswa, npm),
	foreign key (kode_skema_beasiswa) references SKEMA_BEASISWA (kode) on update cascade on delete cascade,
	foreign key (npm) references MAHASISWA(npm) on update cascade on delete cascade
);

CREATE TABLE SIMBION.PEMBAYARAN(
	urutan int not null,
	kode_skema_beasiswa int not null,
	no_urut_skema_beasiswa_aktif int not null,
	npm varchar(20) not null,
	keterangan varchar(20) not null,
	tgl_bayar date not null,
	nominal int not null,
	unique(urutan, kode_skema_beasiswa,no_urut_skema_beasiswa_aktif),
	primary key (urutan, kode_skema_beasiswa, no_urut_skema_beasiswa_aktif, npm),
	foreign key (npm) references MAHASISWA(npm) on update cascade on delete cascade
);

CREATE TABLE SIMBION.TEMPAT_WAWANCARA(
	kode int not null,
	nama varchar(20) not null,
	lokasi varchar(50) not null,
	primary key (kode)
);

CREATE TABLE SIMBION.WAWANCARA(
	no_urut_skema_beasiswa_aktif int not null,
	kode_skema_beasiswa int not null,
	jadwal varchar(20) not null,
	kode_tempat_wawancara int not null,
	unique (no_urut_skema_beasiswa_aktif,kode_skema_beasiswa),
	primary key (no_urut_skema_beasiswa_aktif, kode_skema_beasiswa, jadwal)
	);

CREATE TABLE SIMBION.PENGUMUMAN(
	tanggal date not null,
	no_urut_skema_beasiswa_aktif int not null,
	kode_skema_beasiswa int not null,
	username varchar(20) not null,
	judul varchar(20) not null,
	isi varchar(255) not null,
	unique (no_urut_skema_beasiswa_aktif,kode_skema_beasiswa,username),
	primary key (tanggal, no_urut_skema_beasiswa_aktif, kode_skema_beasiswa, username),
	foreign key (username) references PENGGUNA(username) on update cascade on delete cascade
);
