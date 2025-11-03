/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public enum StatusTindak {
    DIPROSES("diproses"),
    SELESAI("selesai");

    private String status;

    StatusTindak(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static StatusTindak fromString(String status) {
        for (StatusTindak s : StatusTindak.values()) {
            if (s.status.equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status tidak ditemukan: " + status);
    }
}

