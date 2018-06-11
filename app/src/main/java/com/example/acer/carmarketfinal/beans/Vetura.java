package com.example.acer.carmarketfinal.beans;

public class Vetura {
    int id;
    String viti, kilometrazha;
    String titulli, transmetuesi, karburanti, ngjyra, struktura,komuna,pershkrimi,tel,lloji;
    byte[] foto;
    String email;

    public Vetura(int id, String viti, String kilometrazha, String titulli, String transmetuesi, String karburanti, String ngjyra, String struktura, String komuna, String pershkrimi, String tel, String lloji, byte[] foto, String email) {
        this.id = id;
        this.viti = viti;
        this.kilometrazha = kilometrazha;
        this.titulli = titulli;
        this.transmetuesi = transmetuesi;
        this.karburanti = karburanti;
        this.ngjyra = ngjyra;
        this.struktura = struktura;
        this.komuna = komuna;
        this.pershkrimi = pershkrimi;
        this.tel = tel;
        this.lloji = lloji;
        this.foto = foto;
        this.email = email;
    }

    public Vetura(String titulli, String viti, String kilometrazha,
                  String transmetuesi, String karburanti, String ngjyra,
                  String struktura, String komuna, String tel, String pershkrimi, String lloji,
                  byte[] img, String email) {
        this.titulli = titulli;
        this.viti = viti;
        this.kilometrazha = kilometrazha;
        this.transmetuesi = transmetuesi;
        this.karburanti = karburanti;
        this.ngjyra = ngjyra;
        this.struktura = struktura;
        this.komuna = komuna;
        this.tel = tel;
        this.pershkrimi = pershkrimi;
        this.lloji = lloji;
        this.foto = img;
        this.email = email;

    }



    public Vetura(String titulli, String pershkrimi, byte[] foto, int id){
        this.id = id;
        this.titulli = titulli;
        this.pershkrimi = pershkrimi;
        this.foto = foto;
    }


    public Vetura(String string, String cursorString, byte[] blob){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getViti() {
        return viti;
    }

    public void setViti(String viti) {
        this.viti = viti;
    }

    public String getKilometrazha() {
        return kilometrazha;
    }

    public void setKilometrazha(String kilometrazha) {
        this.kilometrazha = kilometrazha;
    }

    public String getTitulli() {
        return titulli;
    }

    public void setTitulli(String titulli) {
        this.titulli = titulli;
    }

    public String getTransmetuesi() {
        return transmetuesi;
    }

    public void setTransmetuesi(String transmetuesi) {
        this.transmetuesi = transmetuesi;
    }

    public String getKarburanti() {
        return karburanti;
    }

    public void setKarburanti(String karburanti) {
        this.karburanti = karburanti;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public String getStruktura() {
        return struktura;
    }

    public void setStruktura(String struktura) {
        this.struktura = struktura;
    }

    public String getKomuna() {
        return komuna;
    }

    public void setKomuna(String komuna) {
        this.komuna = komuna;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLloji() {
        return lloji;
    }

    public void setLloji(String lloji) {
        this.lloji = lloji;
    }
}

