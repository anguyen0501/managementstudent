USE [master]
GO
/****** Object:  Database [Student]    Script Date: 11/8/2022 6:34:34 AM ******/
CREATE DATABASE [Student]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Student', FILENAME = N'C:\SQLSEVER\MSSQL15.MSSQLSERVER\MSSQL\DATA\Student.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Student_log', FILENAME = N'C:\SQLSEVER\MSSQL15.MSSQLSERVER\MSSQL\DATA\Student_log.ldf' , SIZE = 3840KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Student] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Student].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Student] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Student] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Student] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Student] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Student] SET ARITHABORT OFF 
GO
ALTER DATABASE [Student] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Student] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Student] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Student] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Student] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Student] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Student] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Student] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Student] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Student] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Student] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Student] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Student] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Student] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Student] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Student] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Student] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Student] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Student] SET  MULTI_USER 
GO
ALTER DATABASE [Student] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Student] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Student] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Student] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Student] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Student] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Student', N'ON'
GO
ALTER DATABASE [Student] SET QUERY_STORE = OFF
GO
USE [Student]
GO
/****** Object:  Table [dbo].[tblDangNhap]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDangNhap](
	[fldTenDangNhap] [nvarchar](50) NOT NULL,
	[fldMatKhau] [nvarchar](20) NOT NULL,
	[fldHoTen] [nvarchar](50) NULL,
	[fldEmail] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblDangNhap] PRIMARY KEY CLUSTERED 
(
	[fldTenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDiem]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDiem](
	[fldMaSV] [nvarchar](10) NOT NULL,
	[fldMaMH] [nvarchar](10) NOT NULL,
	[fldLanThi] [tinyint] NOT NULL,
	[fldHeSo] [tinyint] NULL,
	[fldDiem] [float] NULL,
	[fldTrangThai] [bit] NULL,
 CONSTRAINT [PK_tblDiem] PRIMARY KEY CLUSTERED 
(
	[fldMaSV] ASC,
	[fldMaMH] ASC,
	[fldLanThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblGiangVien]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblGiangVien](
	[fldMaGV] [nvarchar](10) NOT NULL,
	[fldHoTenGV] [nvarchar](70) NOT NULL,
	[fldMaMH] [nvarchar](10) NOT NULL,
	[fldNgaySinh] [datetime] NULL,
	[fldGioiTinh] [bit] NULL,
	[fldEmail] [nvarchar](50) NULL,
	[fldDiaChi] [nvarchar](70) NULL,
	[fldSDT] [nvarchar](15) NULL,
 CONSTRAINT [PK_tblGiangVien] PRIMARY KEY CLUSTERED 
(
	[fldMaGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblKhoa]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKhoa](
	[fldMaKhoa] [nvarchar](10) NOT NULL,
	[fldTenKhoa] [nvarchar](50) NOT NULL,
	[fldSDT] [nvarchar](15) NULL,
 CONSTRAINT [PK_tblKhoa] PRIMARY KEY CLUSTERED 
(
	[fldMaKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblLop]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblLop](
	[fldMaLop] [nvarchar](10) NOT NULL,
	[fldTenLop] [nvarchar](50) NOT NULL,
	[fldMaKhoa] [nvarchar](10) NOT NULL,
	[fldKhoaHoc] [nvarchar](20) NULL,
 CONSTRAINT [PK_tblLop] PRIMARY KEY CLUSTERED 
(
	[fldMaLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblMonHoc]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMonHoc](
	[fldMaMH] [nvarchar](10) NOT NULL,
	[fldTenMH] [nvarchar](20) NOT NULL,
	[fldSoTrinh] [int] NULL,
	[fldHinhThucThi] [nvarchar](20) NULL,
	[fldHocKy] [int] NULL,
	[fldPhongHoc] [nvarchar](10) NULL,
 CONSTRAINT [PK_tblMonHoc] PRIMARY KEY CLUSTERED 
(
	[fldMaMH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSinhVien]    Script Date: 11/8/2022 6:34:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSinhVien](
	[fldMaSV] [nvarchar](10) NOT NULL,
	[fldHoTen] [nvarchar](70) NOT NULL,
	[fldMaLop] [nvarchar](10) NOT NULL,
	[fldHeDaoTao] [nvarchar](50) NOT NULL,
	[fldNgaySinh] [datetime] NULL,
	[fldDiaChi] [nvarchar](100) NULL,
	[fldGioiTinh] [bit] NULL,
	[fldSDT] [nvarchar](15) NULL,
 CONSTRAINT [PK_tblSinhVien] PRIMARY KEY CLUSTERED 
(
	[fldMaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblDangNhap] ([fldTenDangNhap], [fldMatKhau], [fldHoTen], [fldEmail]) VALUES (N'admin', N'123456789', N'Administrator', N'adminn@gmail.com')
INSERT [dbo].[tblDangNhap] ([fldTenDangNhap], [fldMatKhau], [fldHoTen], [fldEmail]) VALUES (N'ducphu', N'123456', N'duc phu', N'ducphu@gmail.com')
INSERT [dbo].[tblDangNhap] ([fldTenDangNhap], [fldMatKhau], [fldHoTen], [fldEmail]) VALUES (N'thaian', N'123456', N'thai an', N'thaian@gmail.com')
GO
INSERT [dbo].[tblDiem] ([fldMaSV], [fldMaMH], [fldLanThi], [fldHeSo], [fldDiem], [fldTrangThai]) VALUES (N'20H1120185', N'CN001', 5, 4, 9, 1)
GO
INSERT [dbo].[tblGiangVien] ([fldMaGV], [fldHoTenGV], [fldMaMH], [fldNgaySinh], [fldGioiTinh], [fldEmail], [fldDiaChi], [fldSDT]) VALUES (N'GV001', N'Nguyễn Văn A', N'MH001', CAST(N'1978-01-01T00:00:00.000' AS DateTime), 0, N'anv@gmail.com', N'TPHCM', N'123345')
INSERT [dbo].[tblGiangVien] ([fldMaGV], [fldHoTenGV], [fldMaMH], [fldNgaySinh], [fldGioiTinh], [fldEmail], [fldDiaChi], [fldSDT]) VALUES (N'GV002', N'Phạm Văn B', N'MH002', CAST(N'1987-08-02T00:00:00.000' AS DateTime), 1, N'bnv@gmail.com', N'TPHCM', N'1233456')
INSERT [dbo].[tblGiangVien] ([fldMaGV], [fldHoTenGV], [fldMaMH], [fldNgaySinh], [fldGioiTinh], [fldEmail], [fldDiaChi], [fldSDT]) VALUES (N'GV003', N'Nguyễn Văn C', N'MH002', CAST(N'1982-08-05T00:00:00.000' AS DateTime), 1, N'cnv@gmail.com', N'TPHCM', N'1233457')
INSERT [dbo].[tblGiangVien] ([fldMaGV], [fldHoTenGV], [fldMaMH], [fldNgaySinh], [fldGioiTinh], [fldEmail], [fldDiaChi], [fldSDT]) VALUES (N'GV004', N'Trần Văn D', N'MH002', CAST(N'1980-12-05T00:00:00.000' AS DateTime), 0, N'dtv@gmail.com', N'TPHCM', N'123345677')
INSERT [dbo].[tblGiangVien] ([fldMaGV], [fldHoTenGV], [fldMaMH], [fldNgaySinh], [fldGioiTinh], [fldEmail], [fldDiaChi], [fldSDT]) VALUES (N'GV006', N'Nguyễn Thị L', N'MH001', CAST(N'1982-01-22T00:00:00.000' AS DateTime), 0, N'lnt@gmail.com', N'TPHCM', N'123456789')
GO
INSERT [dbo].[tblKhoa] ([fldMaKhoa], [fldTenKhoa], [fldSDT]) VALUES (N'CNTT', N'Công Nghệ Thông Tin', N'123456789')
INSERT [dbo].[tblKhoa] ([fldMaKhoa], [fldTenKhoa], [fldSDT]) VALUES (N'KT', N'Kế Toán', N'123456789')
INSERT [dbo].[tblKhoa] ([fldMaKhoa], [fldTenKhoa], [fldSDT]) VALUES (N'LG', N'Logitics', N'0123456789')
INSERT [dbo].[tblKhoa] ([fldMaKhoa], [fldTenKhoa], [fldSDT]) VALUES (N'QTKD', N'Quản Trị Kinh Doanh', N'0123456780')
INSERT [dbo].[tblKhoa] ([fldMaKhoa], [fldTenKhoa], [fldSDT]) VALUES (N'TCNH', N'Tài Chính Ngân Hàng', N'123456789')
GO
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN1', N'Công nghệ thông tin 1', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN2', N'Công nghệ thông tin 2', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN3', N'Công nghệ thông tin 3', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN4', N'Công nghệ thông tin 4', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN5', N'Công nghệ thông tin 5', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN6', N'Công nghệ thông tin 6', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'CN7', N'Công nghệ thông tin 7', N'CNTT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'KT1', N'Kế toán tổng hợp', N'KT', N'2020 - 2024')
INSERT [dbo].[tblLop] ([fldMaLop], [fldTenLop], [fldMaKhoa], [fldKhoaHoc]) VALUES (N'LG1', N'Logitics', N'LG', N'2020 - 2024')
GO
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'CN001', N'Java Swing', 3, N'Thi Thực Hành', 2, N'B101')
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'CN002', N'Python', 2, N'Thi Thực Hành', 1, N'B102')
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'MH001', N'JavaBasic', 2, N'Thi Thực Hành', 3, N'B305')
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'MH002', N'.NET', 3, N'Thi Thực Hành', 5, N'B307')
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'MH003', N'Tiếng Anh', 1, N'Thi Viết', 1, N'B305')
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'MH006', N'LTTT', 4, N'Thi Thực Hành', 3, N'B209')
INSERT [dbo].[tblMonHoc] ([fldMaMH], [fldTenMH], [fldSoTrinh], [fldHinhThucThi], [fldHocKy], [fldPhongHoc]) VALUES (N'MH007', N'Thương mại điện tử', 4, N'Thực Hành', 3, N'B309')
GO
INSERT [dbo].[tblSinhVien] ([fldMaSV], [fldHoTen], [fldMaLop], [fldHeDaoTao], [fldNgaySinh], [fldDiaChi], [fldGioiTinh], [fldSDT]) VALUES (N'20H1120185', N'Nguyễn Thái An', N'CN1', N'Chính Quy', CAST(N'2002-01-05T00:00:00.000' AS DateTime), N'TPHCM', 1, N'0328006072')
INSERT [dbo].[tblSinhVien] ([fldMaSV], [fldHoTen], [fldMaLop], [fldHeDaoTao], [fldNgaySinh], [fldDiaChi], [fldGioiTinh], [fldSDT]) VALUES (N'20H1120186', N'Nguyễn Văn Z', N'CN1', N'Chính Quy', CAST(N'2002-11-11T00:00:00.000' AS DateTime), N'TPHCM', 0, N'123456789')
INSERT [dbo].[tblSinhVien] ([fldMaSV], [fldHoTen], [fldMaLop], [fldHeDaoTao], [fldNgaySinh], [fldDiaChi], [fldGioiTinh], [fldSDT]) VALUES (N'20H1120187', N'Nguyễn Văn B', N'CN3', N'Chính Quy', CAST(N'2002-01-05T00:00:00.000' AS DateTime), N'TPHCM', 1, N'1233456675')
INSERT [dbo].[tblSinhVien] ([fldMaSV], [fldHoTen], [fldMaLop], [fldHeDaoTao], [fldNgaySinh], [fldDiaChi], [fldGioiTinh], [fldSDT]) VALUES (N'20H1120188', N'Nguyễn Trường Vinh', N'CN2', N'Chính Quy', CAST(N'2002-08-22T00:00:00.000' AS DateTime), N'TPHCM', 1, N'123456789')
INSERT [dbo].[tblSinhVien] ([fldMaSV], [fldHoTen], [fldMaLop], [fldHeDaoTao], [fldNgaySinh], [fldDiaChi], [fldGioiTinh], [fldSDT]) VALUES (N'20H1120189', N'Phạm Cao Khánh Duy', N'CN2', N'Chính Quy', CAST(N'2002-08-22T00:00:00.000' AS DateTime), N'TPHCM', 1, N'123456789')
INSERT [dbo].[tblSinhVien] ([fldMaSV], [fldHoTen], [fldMaLop], [fldHeDaoTao], [fldNgaySinh], [fldDiaChi], [fldGioiTinh], [fldSDT]) VALUES (N'20H1120190', N'Nguyễn Vãn C', N'CN3', N'Chính Quy', CAST(N'2002-12-12T00:00:00.000' AS DateTime), N'TPHCM', 1, N'123345456')
GO
ALTER TABLE [dbo].[tblDiem]  WITH CHECK ADD  CONSTRAINT [FK_tblDiem_tblMonHoc] FOREIGN KEY([fldMaMH])
REFERENCES [dbo].[tblMonHoc] ([fldMaMH])
GO
ALTER TABLE [dbo].[tblDiem] CHECK CONSTRAINT [FK_tblDiem_tblMonHoc]
GO
ALTER TABLE [dbo].[tblDiem]  WITH CHECK ADD  CONSTRAINT [FK_tblDiem_tblSinhVien] FOREIGN KEY([fldMaSV])
REFERENCES [dbo].[tblSinhVien] ([fldMaSV])
GO
ALTER TABLE [dbo].[tblDiem] CHECK CONSTRAINT [FK_tblDiem_tblSinhVien]
GO
ALTER TABLE [dbo].[tblGiangVien]  WITH CHECK ADD  CONSTRAINT [FK_tblGiangVien_tblMonHoc] FOREIGN KEY([fldMaMH])
REFERENCES [dbo].[tblMonHoc] ([fldMaMH])
GO
ALTER TABLE [dbo].[tblGiangVien] CHECK CONSTRAINT [FK_tblGiangVien_tblMonHoc]
GO
ALTER TABLE [dbo].[tblLop]  WITH CHECK ADD  CONSTRAINT [FK_tblLop_tblKhoa] FOREIGN KEY([fldMaKhoa])
REFERENCES [dbo].[tblKhoa] ([fldMaKhoa])
GO
ALTER TABLE [dbo].[tblLop] CHECK CONSTRAINT [FK_tblLop_tblKhoa]
GO
ALTER TABLE [dbo].[tblSinhVien]  WITH CHECK ADD  CONSTRAINT [FK_tblSinhVien_tblLop] FOREIGN KEY([fldMaLop])
REFERENCES [dbo].[tblLop] ([fldMaLop])
GO
ALTER TABLE [dbo].[tblSinhVien] CHECK CONSTRAINT [FK_tblSinhVien_tblLop]
GO
USE [master]
GO
ALTER DATABASE [Student] SET  READ_WRITE 
GO
