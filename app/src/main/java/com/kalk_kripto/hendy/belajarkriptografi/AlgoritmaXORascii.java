package com.kalk_kripto.hendy.belajarkriptografi;

public class AlgoritmaXORascii {
    private String out,penj;
    public AlgoritmaXORascii(String temp, String key, boolean stat){
        this.penj="";
        this.out="";
        try{
            if(stat){
                int i=1,cnt=0;
                do{
                    if(temp.charAt(cnt)==','){
                        i++;
                    }
                    cnt++;
                }while(cnt<temp.length());
                String binary[]=new String[i],xorRes1[]=new String[i];
                int bil[]=new int[i],xorRes[]=new int[i];
                i=1;cnt=0;
                do{
                    if(key.charAt(cnt)==','){
                        i++;
                    }
                    cnt++;
                }while(cnt<key.length());
                String keyAr[]=new String[i];
                int bil1[]=new int[i];
                this.penj+="Melakukan konversi plain text (ASCII)\n";
                i=0;
                for(String s : temp.split(",")){
                    this.penj+="Ubah kode "+s+" ke bilangan Biner:\n";
                    bil[i]=Integer.parseInt(s);
                    xorRes[i]=bil[i];
                    binary[i]=Integer.toBinaryString(bil[i]);
                    while(binary[i].length()<8){
                        binary[i]="0"+binary[i];
                    }
                    xorRes1[i]=binary[i];
                    this.penj+=binary[i]+"\n";
                    i++;
                }
                i=0;
                this.penj+="\nMelakukan konversi kunci (ASCII)\n";
                for(String s : key.split(",")){
                    this.penj+="Ubah kunci kode "+s+" ke bilangan Biner:\n";
                    bil1[i]=Integer.parseInt(s);
                    keyAr[i]=Integer.toBinaryString(bil1[i]);
                    while(keyAr[i].length()<8){
                        keyAr[i]="0"+keyAr[i];
                    }
                    this.penj+=keyAr[i]+"\n";
                    i++;
                }
                this.penj+="\nXOR karakter berbentuk Kode ASCII dalam biner 1 per 1\n";
                for(int x=0;x<binary.length;x++){
                    this.penj+="\nKarakter (ASCII) ke-"+(x+1)+", "+xorRes[x]+" ("+xorRes1[x]+")\n";
                    for(int y=0;y<keyAr.length;y++){
                        this.penj+="XOR kode "+xorRes[x]+" dengan kode kunci "+bil1[y]+"\n";
                        this.penj+=xorRes1[x]+"\n";
                        this.penj+=keyAr[y]+"\n";
                        this.penj+="---------------- XOR\n";
                        xorRes[x]^=bil1[y];
                        xorRes1[x]=Integer.toBinaryString(xorRes[x]);
                        while(xorRes1[x].length()<8){
                            xorRes1[x]="0"+xorRes1[x];
                        }
                        String tmp="";
                        for(int z=0;z<8-Integer.toString(xorRes[x],2).length();z++){
                            tmp+="0";
                        }
                        this.penj+=tmp+Integer.toString(xorRes[x],2)+" "+xorRes[x]+"\n";
                    }
                }
                this.penj+="\nHasil Enkripsi Karakter dalam Kode ASCII:\n";
                for(int x=0;x<xorRes.length;x++){
                    this.penj+=xorRes[x]+" ("+xorRes1[x]+")";
                    this.out+=xorRes[x];
                    if(x<xorRes.length-1){
                        this.penj+=",";
                        this.out+=",";
                    }else{
                        this.penj+="\n";
                    }
                }
            } else if (!stat) {
                int i=1,cnt=0;
                do{
                    if(temp.charAt(cnt)==','){
                        i++;
                    }
                    cnt++;
                }while(cnt<temp.length());
                String binary[]=new String[i],xorRes1[]=new String[i];
                int bil[]=new int[i],xorRes[]=new int[i];
                i=1;cnt=0;
                do{
                    if(key.charAt(cnt)==','){
                        i++;
                    }
                    cnt++;
                }while(cnt<key.length());
                String keyAr[]=new String[i];
                int bil1[]=new int[i];
                this.penj+="Melakukan konversi cipher text (ASCII)\n";
                i=0;
                for(String s : temp.split(",")){
                    this.penj+="Ubah kode "+s+" ke bilangan Biner:\n";
                    bil[i]=Integer.parseInt(s);
                    xorRes[i]=bil[i];
                    binary[i]=Integer.toBinaryString(bil[i]);
                    while(binary[i].length()<8){
                        binary[i]="0"+binary[i];
                    }
                    xorRes1[i]=binary[i];
                    this.penj+=binary[i]+"\n";
                    i++;
                }
                i=0;
                this.penj+="\nMelakukan konversi kunci (ASCII)\n";
                for(String s : key.split(",")){
                    this.penj+="Ubah kunci kode "+s+" ke bilangan Biner:\n";
                    bil1[i]=Integer.parseInt(s);
                    keyAr[i]=Integer.toBinaryString(bil1[i]);
                    while(keyAr[i].length()<8){
                        keyAr[i]="0"+keyAr[i];
                    }
                    this.penj+=keyAr[i]+"\n";
                    i++;
                }
                this.penj+="\nXOR karakter berbentuk Kode ASCII dalam biner 1 per 1\n";
                for(int x=0;x<binary.length;x++){
                    this.penj+="\nKarakter (ASCII) ke-"+(x+1)+", "+xorRes[x]+" ("+xorRes1[x]+")\n";
                    for(int y=keyAr.length-1;y>=0;y--){
                        this.penj+="XOR kode "+xorRes[x]+" dengan kode kunci "+bil1[y]+"\n";
                        this.penj+=xorRes1[x]+"\n";
                        this.penj+=keyAr[y]+"\n";
                        this.penj+="---------------- XOR\n";
                        xorRes[x]^=bil1[y];
                        xorRes1[x]=Integer.toBinaryString(xorRes[x]);
                        while(xorRes1[x].length()<8){
                            xorRes1[x]="0"+xorRes1[x];
                        }
                        String tmp="";
                        for(int z=0;z<8-Integer.toString(xorRes[x],2).length();z++){
                            tmp+="0";
                        }
                        this.penj+=tmp+Integer.toString(xorRes[x],2)+" "+xorRes[x]+"\n";
                    }
                }
                this.penj+="\nHasil Dekripsi Karakter dalam Kode ASCII:\n";
                for(int x=0;x<xorRes.length;x++){
                    this.penj+=xorRes[x]+" ("+xorRes1[x]+")";
                    this.out+=xorRes[x];
                    if(x<xorRes.length-1){
                        this.penj+=",";
                        this.out+=",";
                    }else{
                        this.penj+="\n";
                    }
                }
            }
        }catch(NumberFormatException exc){
            this.penj+="Input Salah Format, bukan Bilangan Kode ASCII!";
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
