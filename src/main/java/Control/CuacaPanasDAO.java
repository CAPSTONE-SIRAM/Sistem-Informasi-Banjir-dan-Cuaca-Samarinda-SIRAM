/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.CuacaPanas;
import java.util.List;
/**
 *
 * @author User
 */
public interface CuacaPanasDAO {
    void insert(CuacaPanas cp);
    void update(CuacaPanas cp);
    void delete(int idCuaca);
    List<CuacaPanas> getAll();
}
