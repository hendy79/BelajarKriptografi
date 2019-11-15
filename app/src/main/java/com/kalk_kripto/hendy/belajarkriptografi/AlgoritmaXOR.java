package com.kalk_kripto.hendy.belajarkriptografi;

import java.nio.charset.Charset;

public class AlgoritmaXOR {
    private String out,penj;
    public AlgoritmaXOR(String temp, String key, boolean stat){
        this.out="";
        this.penj="";
        Charset characterSet = Charset.forName("US-ASCII");
        byte[] bytes;
        char[] charStr = temp.toCharArray();
        char[] charKey = key.toCharArray();
        String tmp="";
        String result="",result1="";
        String res = "";
        if(stat){
            this.penj+="Konversi Plain Text ke Kode Ascii (Biner):\n";
            String[] StrBin=new String[100],KeyBin=new String[100];
            for(int h=0;h<charStr.length;h++){
                tmp=Character.toString(charStr[h]);
                bytes = tmp.getBytes(characterSet);
                for(int i=0;i<bytes.length;i++){
                    this.penj+="Konversi Karakter "+tmp+" ke Kode ASCII dalam Biner, Hasil :\n";
                    res=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
                    this.penj+=res+"\n";
                    result+=res;
                }
                StrBin[h]=res;
                this.penj+="\n";
                if(h!=charStr.length-1)
                    result+=",";
            }
            this.penj+="Hasil konversi Plain Text:\n";
            this.penj+=result+"\n\n";

            this.penj+="Konversi Key Text ke Kode Ascii (Biner):\n";
            for(int h=0;h<charKey.length;h++){
                tmp=Character.toString(charKey[h]);
                bytes = tmp.getBytes(characterSet);
                for(int i=0;i<bytes.length;i++){
                    this.penj+="Konversi Karakter "+tmp+" ke Kode ASCII dalam Biner, Hasil:\n";
                    res=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
                    this.penj+=res+"\n";
                    result1+=res;
                }
                KeyBin[h]=res;
                this.penj+="\n";
                if(h!=charKey.length-1)
                    result1+=",";
            }
            this.penj+="Hasil konversi kunci ke biner:\n";
            this.penj+=result1+"\n\n";

            this.penj+="Encrypt dengan Key Terurut, XOR Karakter Satu Per Satu:\n";

            char[] xorRes=temp.toCharArray();
            res="";
            String encrypted="";

            for(int h=0;h<charStr.length;h++){
                this.penj+="Karakter "+charStr[h]+" ("+StrBin[h]+")\n";
                for(int i=0;i<charKey.length;i++){
                    this.penj+="di XOR dengan "+charKey[i]+" ("+KeyBin[i]+"):\n";
                    xorRes[h]=(char) (xorRes[h]^charKey[i]);
                    tmp=Character.toString(xorRes[h]);
                    bytes = tmp.getBytes(characterSet);
                    for(int j=0;j<bytes.length;j++){
                        res=String.format("%8s", Integer.toBinaryString(bytes[j] & 0xFF)).replace(' ','0');
                    }
                    this.penj+=", menghasilkan karakter:\n"+xorRes[h]+" ("+res+")\n\n";
                }//no solution for encrypting blank character
                this.penj+="Jadi, hasil XOR untuk karakter "+charStr[h]+" adalah "+xorRes[h]+" ("+res+")\n";
                encrypted+=xorRes[h];
                this.penj+="\n";
            }
            this.penj+="Hasil Enkripsi Setelah digabung menjadi Cipher Text:\n";
            this.out=encrypted;
            this.penj+=encrypted+"\n";
        }else if(!stat){
            this.penj+="Konversi Cipher Text ke Kode Ascii (Biner):\n";
            String[] StrBin=new String[100],KeyBin=new String[100];
            for(int h=0;h<charStr.length;h++){
                tmp=Character.toString(charStr[h]);
                bytes = tmp.getBytes(characterSet);
                for(int i=0;i<bytes.length;i++){
                    this.penj+="Konversi Karakter "+tmp+" ke Kode ASCII dalam Biner, Hasil:\n";
                    res=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
                    this.penj+=res+"\n";
                    result+=res;
                }
                StrBin[h]=res;
                this.penj+="\n";
                if(h!=charStr.length-1)
                    result+=",";
            }
            this.penj+="Hasil konversi Cipher Text:\n";
            this.penj+=result+"\n\n";

            this.penj+="Konversi Key Text ke Kode Ascii (Biner):\n";
            for(int h=0;h<charKey.length;h++){
                tmp=Character.toString(charKey[h]);
                bytes = tmp.getBytes(characterSet);
                for(int i=0;i<bytes.length;i++){
                    this.penj+="Konversi Karakter "+tmp+" ke Kode ASCII dalam Biner, Hasil:\n";
                    res=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
                    this.penj+=res+"\n";
                    result1+=res;
                }
                KeyBin[h]=res;
                this.penj+="\n";
                if(h!=charKey.length-1)
                    result1+=",";
            }
            this.penj+="Hasil konversi kunci ke biner:\n";
            this.penj+=result1+"\n\n";

            this.penj+="Decrypt dengan Key Terurut, XOR Karakter Satu Per Satu:\n";

            char[] xorRes=temp.toCharArray();
            res="";
            String decr="";

            for(int h=0;h<charStr.length;h++){
                this.penj+="Karakter "+charStr[h]+" ("+StrBin[h]+")\n";
                for(int i=charKey.length-1;i>=0;i--){
                    this.penj+="di XOR dengan "+charKey[i]+" ("+KeyBin[i]+"):\n";
                    xorRes[h]=(char) (xorRes[h]^charKey[i]);
                    tmp=Character.toString(xorRes[h]);
                    bytes = tmp.getBytes(characterSet);
                    for(int j=0;j<bytes.length;j++){
                        res=String.format("%8s", Integer.toBinaryString(bytes[j] & 0xFF)).replace(' ','0');
                    }
                    this.penj+=", menghasilkan karakter:\n"+xorRes[h]+" ("+res+")\n\n";
                }
                this.penj+="Jadi, hasil XOR karakter "+charStr[h]+" adalah "+xorRes[h]+" ("+res+")\n";
                decr+=xorRes[h];
                this.penj+="\n";
            }
            this.penj+="Hasil Decrypt Setelah digabung menjadi Plain Text :\n";
            this.out=decr;
            this.penj+=decr+"\n";
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
