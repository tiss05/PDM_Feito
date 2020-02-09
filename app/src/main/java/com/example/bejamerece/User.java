package com.example.bejamerece;

import android.widget.ImageView;

public class User {
    private String Name;
    private String Number;
    private String Email;
    private String Localidade;
    private String Freguesia;
    private String Rua;
    private String Foto;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLocalidade() {
        return Localidade;
    }

    public void setLocalidade(String localidade) {
        Localidade = localidade;
    }

    public String getFreguesia() {
        return Freguesia;
    }

    public void setFreguesia(String freguesia) {
        Freguesia = freguesia;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public User() {

    }
}
