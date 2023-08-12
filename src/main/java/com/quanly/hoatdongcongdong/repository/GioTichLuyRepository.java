package com.quanly.hoatdongcongdong.repository;

import com.quanly.hoatdongcongdong.entity.GioTichLuy;
import com.quanly.hoatdongcongdong.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GioTichLuyRepository extends JpaRepository<GioTichLuy, Long> {
    GioTichLuy findByGiangVien_MaTaiKhoan(Long maTk);
    GioTichLuy findByGiangVien_MaTaiKhoanAndNamHoc(Long nguoiDungId, String namHoc);

    @Query("SELECT DISTINCT gio.namHoc FROM GioTichLuy gio WHERE gio.giangVien.taiKhoan.maTaiKhoan = :maTk ORDER BY gio.namHoc DESC")
    List<String> findDistinctNamHocByGiangVien(@Param("maTk") Long maTk);

//    List<GioTichLuy> findByNamHocAndGiangVienTaiKhoan_Quyen(String namHoc, TaiKhoan.Quyen quyen);

    GioTichLuy findByNamHocAndGiangVien_MaTaiKhoan(String namHoc, Long maTk);
}