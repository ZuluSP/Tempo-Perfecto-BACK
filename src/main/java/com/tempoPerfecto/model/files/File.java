package com.tempoPerfecto.model.files;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class File {

    @Id
    @GeneratedValue
    private Long id;

    private String ruta;

    private Long userId;

    public File(String ruta, Long userId) {
        this.ruta = ruta;
        this.userId = userId;
    }

    public File() {
    }

    public Long getId() {
        return id;
    }

    public String getRuta() {
        return ruta;
    }

    public long getUserId() {
        return userId;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
