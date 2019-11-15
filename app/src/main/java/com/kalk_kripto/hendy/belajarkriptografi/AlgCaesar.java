package com.kalk_kripto.hendy.belajarkriptografi;

public class AlgCaesar {
    private String out,penj;
    public AlgCaesar(String msg,int shft,boolean stat){
        this.penj="";
        msg=msg.toUpperCase();
        if(stat){
            String Emsg="";
            this.penj+="Pesan yang ingin dienkripsi:\n";
            this.penj+=msg+"\n";
            this.penj+="Jumlah peregeseran untuk enkripsi:\n";
            this.penj+=shft+"\n\n";
            shft%=26;
            for(int i=0;i<msg.length();i++){
                this.penj+="Karakter ke-"+(i+1)+" dari pesan tersebut = '"+msg.charAt(i)+"'\n";
                if((int)msg.charAt(i)>=65 && (int)msg.charAt(i)<=90){
                    char letter=(char)(msg.charAt(i)+shft);
                    if((int)letter>90){
                        letter=(char)(msg.charAt(i)+shft-26);
                    }
                    this.penj+="Hasil enkripsi setelah digeser "+shft+"x = '"+letter+"'\n";
                    Emsg+=letter;
                }else{
                    Emsg+=msg.charAt(i);
                }
                this.penj+="\n";
            }
            this.penj+="Hasil enkripsi kata/kalimat:\n"+Emsg;
            this.out=Emsg;
        }else if(!stat){
            String Dmsg="";
            this.penj+="Pesan yang ingin didekripsi:\n";
            this.penj+=msg+"\n";
            this.penj+="Jumlah peregeseran untuk dekripsi:\n";
            this.penj+=shft+"\n\n";
            shft%=26;
            for(int i=0;i<msg.length();i++){
                this.penj+="Karakter ke-"+(i+1)+" dari pesan tersebut = '"+msg.charAt(i)+"'\n";
                if((int)msg.charAt(i)>=65 && (int)msg.charAt(i)<=90){
                    char letter=(char)(msg.charAt(i)-shft);
                    if((int)letter<65){
                        letter=(char)(msg.charAt(i)-shft+26);
                    }
                    this.penj+="Hasil dekripsi setelah digeser "+shft+"x = '"+letter+"'\n";
                    Dmsg+=letter;
                }else{
                    Dmsg+=msg.charAt(i);
                }
                this.penj+="\n";
            }
            this.penj+="\nHasil dekripsi kata/kalimat:\n"+Dmsg;
            this.out=Dmsg;
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
