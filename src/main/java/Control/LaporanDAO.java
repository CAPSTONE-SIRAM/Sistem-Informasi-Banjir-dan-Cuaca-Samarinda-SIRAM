/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Laporan;
import java.util.List;
/**
 *
 * @author User
 */
public interface LaporanDAO {
    void tambah(Laporan laporan);
    void perbarui(Laporan laporan);
    void hapus(Laporan laporan);
    Laporan getById(int id);
    List<Laporan> getAll();
}
