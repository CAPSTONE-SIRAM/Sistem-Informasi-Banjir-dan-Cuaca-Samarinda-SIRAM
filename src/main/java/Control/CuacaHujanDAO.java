/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.CuacaHujan;
import java.util.List;
/**
 *
 * @author User
 */
public interface CuacaHujanDAO {
    void insert(CuacaHujan ch);
    void update(CuacaHujan ch);
    void delete(int idCuaca);
    List<CuacaHujan> getAll();
}
