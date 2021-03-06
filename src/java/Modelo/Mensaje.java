/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

/**
 *
 * @author daw205
 */
public class Mensaje {
    int id_men;
    String email_env;
    String enviado_nick;
    String email_rez;
    String asunto;
    String contenido;
    String fecha;
    int leido;
    private byte[] foto;
    private Blob fotoBlob;
    String dir;

    public Mensaje() {
    }

    public Mensaje(int id_men, String email_env, String enviado_nick, String email_rez, String asunto, String contenido, String fecha, int leido, byte[] foto, Blob fotoBlob) {
        this.id_men = id_men;
        this.email_env = email_env;
        this.enviado_nick = enviado_nick;
        this.email_rez = email_rez;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.leido = leido;
        this.foto = foto;
        this.fotoBlob = fotoBlob;
    }

    public Mensaje(int id_men, String email_env, String email_rez, String asunto, String contenido, String fecha, int leido) {
        this.id_men = id_men;
        this.email_env = email_env;
        this.email_rez = email_rez;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.leido = leido;
    }

    public Mensaje(int id_men, String email_env, String enviado_nick, String email_rez, String asunto, String contenido, String fecha, int leido) {
        this.id_men = id_men;
        this.email_env = email_env;
        this.enviado_nick = enviado_nick;
        this.email_rez = email_rez;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.leido = leido;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setId_men(int id_men) {
        this.id_men = id_men;
    }

    public void setEmail_env(String email_env) {
        this.email_env = email_env;
    }

    public void setEnviado_nick(String enviado_nick) {
        this.enviado_nick = enviado_nick;
    }

    public void setEmail_rez(String email_rez) {
        this.email_rez = email_rez;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Blob getFotoBlob() {
        return fotoBlob;
    }

    public void setFotoBlob(Blob fotoBlob) {
        this.fotoBlob = fotoBlob;
    }

    public void setLeido(int leido) {
        this.leido = leido;
    }

    public String getEnviado_nick() {
        return enviado_nick;
    }

    public int getId_men() {
        return id_men;
    }

    public String getEmail_env() {
        return email_env;
    }

    public String getEmail_rez() {
        return email_rez;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public int getLeido() {
        return leido;
    }
    
    public String getFotoimgString() {
        String image =null;
        try {
            byte[] imageBytes = this.fotoBlob.getBytes(1, (int) this.fotoBlob.length());
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            image = "data:image/jpg;base64," + encodedImage;
            
        } catch (SQLException ex) {
        }
        return image;
    }
    
}
