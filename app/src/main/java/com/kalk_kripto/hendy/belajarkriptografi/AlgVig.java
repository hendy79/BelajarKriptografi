package com.kalk_kripto.hendy.belajarkriptografi;

public class AlgVig {
    private String out,penj;
    public AlgVig(String Message,String Key,boolean stat){
        this.penj="";
        Message = Message.toUpperCase();
        Key = Key.toUpperCase();
        if(stat){
            String EMessage = "";
            this.penj+="Pesan yang ingin dienkripsi:\n";
            this.penj+=Message+"\n";
            this.penj+="Kunci yang digunakan untuk melakukan enkripsi:\n";
            this.penj+=Key+"\n\n";
            for (int i = 0, j = 0; i < Message.length(); i++) {
                char letter = Message.charAt(i);
                if((int)letter>=65 && (int)letter<=90){
                    this.penj+="Karakter sebelum dienkripsi = '"+letter+"'\n";
                    this.penj+="Karakter key yang digunakan untuk enkripsi = '"+Key.charAt(j)+"'\n";
                    this.penj+="Jumlah pergeseran karakter (Jarak huruf A dengan "+Key.charAt(j)+") = "+(Key.charAt(j)-65)+"\n";
                    EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
                    this.penj+="Karakter sesudah dienkripsi = '"+EMessage.charAt(i)+"'\n";
                    j = ++j % Key.length();
                    this.penj+="\n";
                }else{
                    EMessage+=letter;
                }
            }
            this.out=EMessage;
            this.penj+="Hasil kata/kalimat setelah dienkripsi:\n"+EMessage;
        }else if(!stat){
            String DMessage = "";
            Message = Message.toUpperCase();
            this.penj+="Pesan yang ingin didekripsi:\n";
            this.penj+=Message+"\n";
            this.penj+="Kunci yang digunakan untuk melakukan dekripsi:\n";
            this.penj+=Key+"\n\n";
            for (int i = 0, j = 0; i < Message.length(); i++) {
                char letter = Message.charAt(i);
                if((int)letter>=65 && (int)letter<=90){
                    this.penj+="Karakter sebelum didekripsi = '"+letter+"'\n";
                    this.penj+="Karakter key yang digunakan untuk dekripsi = '"+Key.charAt(j)+"'\n";
                    this.penj+="Jumlah pergeseran karakter (Jarak huruf A dengan "+Key.charAt(j)+") = "+(Key.charAt(j)-65)+"\n";
                    DMessage += (char)((letter - Key.charAt(j) + 26) % 26 + 65);
                    this.penj+="Karakter sesudah didekripsi = '"+DMessage.charAt(i)+"'\n";
                    j = ++j % Key.length();
                    this.penj+="\n";
                }else{
                    DMessage+=letter;
                }
            }
            this.out=DMessage;
            this.penj+="Hasil kata/kalimat setelah didekripsi:\n"+DMessage;
        }
    }
    public String getResult(){
        return this.out;
    }
    public String getPenj(){
        String text=this.penj.replaceAll("\\\\n","\n");
        return text;
    }
}
