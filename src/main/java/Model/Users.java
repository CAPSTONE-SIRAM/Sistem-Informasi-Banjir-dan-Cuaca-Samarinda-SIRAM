/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 *
 * @author User
 */

@Entity
@Table(name = "users")
public class Users {

    public enum Peran {
        USER,
        ADMIN
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private String username;
    private String email;
    private String password;
    private String nama_lengkap;
    private String no_hp;
    
    @Enumerated(EnumType.STRING)
    private Peran peran;

    public Users() {
    }

    public Users(String username, String email, String password, String nama_lengkap, String no_hp, Peran peran) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.nama_lengkap = nama_lengkap;
    this.no_hp = no_hp;
    this.peran = peran;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public Peran getPeran() {
        return peran;
    }

    public void setPeran(Peran peran) {
        this.peran = peran;
    }

    
}
