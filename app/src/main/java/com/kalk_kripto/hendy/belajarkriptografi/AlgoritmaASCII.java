package com.kalk_kripto.hendy.belajarkriptografi;

import java.nio.charset.Charset;

public class AlgoritmaASCII {
    private String out,penj;

    public AlgoritmaASCII(String temp, boolean stat){
        this.penj="";
        if(stat==true){
            Charset characterSet = Charset.forName("US-ASCII");
            String result="";
            byte[] bytes = temp.getBytes(characterSet);
            char[] charStr = temp.toCharArray();
            for(int i=0;i<charStr.length;i++){
                this.penj+="Karakter yang Dikonversi:\n";
                this.penj+=Character.toString(charStr[i])+"\n";
                int a= (int) charStr[i];
                this.penj+="Konversi ke ASCII:\n";
                result+=a;
                if(i!=charStr.length-1){
                    result+=",";
                }
                this.penj+=a+"\n\n";
            }
            this.penj+="Hasil:"+"\n";
            this.penj+=result+"\n";
            this.out=result;
        }else if(stat==false){
            try{
                String result="";
                int result1;
                int i=0;
                for(String s : temp.split(",")){
                    this.penj+="Ubah kode "+s+" ke karakter:\n";
                    result1=Integer.parseInt(s);
                    char res=(char) result1;
                    this.penj+=Character.toString(res)+"\n";
                    result+=res;
                    this.penj+="\n";
                }
                this.penj+="Hasil konversi kode ASCII ke karakter:"+"\n";
                this.penj+=result+"\n";
                this.out=result;
            }catch (NumberFormatException e){
                this.penj+="Salah memasukan input, maka Hasil tidak ada!\n";
            }
        }
    }
    String getResult(){
        return this.out;
    }
    String getPenj(){
        String tmp=this.penj.replaceAll("\\\\n","\n");
        return tmp;
    }
}
