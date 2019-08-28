package com.kalk_kripto.hendy.belajarkriptografi;

public class AlgoritmaBiner {
    private String out,penj;
    public AlgoritmaBiner(String temp, boolean stat){
        this.penj="";
        if(stat==true){
            try{
                int temp1=Integer.parseInt(temp);
                String result=Integer.toBinaryString(temp1);
                char[] charStr=result.toCharArray();
                for(int i=0;i<charStr.length;i++){
                    int x=charStr.length-i-1;
                    int lol=i+1;
                    int a=1;
                    if(i!=charStr.length-1){
                        for(int j=0;j<x;j++){
                            a*=2;
                        }
                    }else{
                        a=1;
                    }
                    if(charStr[i]=='1'){
                        this.penj+=temp1+" - 1 x 2^"+x+"\n";
                        temp1-=a;
                    }else{
                        this.penj+="Karena "+temp1+"<"+a+", maka\n";
                        this.penj+=temp1+" - 0 x 2^"+x+"\n";
                    }
                    this.penj+="Hasil ke-"+lol+":\n";
                    this.penj+=temp1+"\n";
                    this.penj+="dan Hasil biner ke-"+lol+":\n";
                    this.penj+=charStr[i]+"\n\n";
                }
                this.penj+="Hasil setelah Disatukan:\n";
                this.out=result;
                this.penj+=result+"\n";
            }catch(NumberFormatException e){
                this.penj="INPUT ANDA SALAH, MOHON MASUKAN ULANG!\n";
                return;
            }
        }else if(stat==false){
            boolean check=true;
            for(char c:temp.toCharArray()){
                if(!(c=='0'||c=='1')){
                    check=false;
                    break;
                }
            }
            if(check==false){
                this.penj="INPUT ANDA SALAH, MOHON MASUKAN ULANG!";
                return;
            }else{
                int cnt=0,cntr=0;
                char[] charStr=temp.toCharArray();
                this.penj+="Susunan bilangan biner dibalik!\n";
                this.penj+="Setelah dibalik, kalikan dengan bilangan 2 berurutan dari pangkat 0!\n\n";
                for(int i=charStr.length-1;i>=0;i--){
                    int a= Character.getNumericValue(charStr[i]);
                    int j=0;
                    if(cntr!=0){
                        if(a!=0){
                            this.penj+=a+" x 2^"+cntr+"\n";
                            while (j<cntr){
                                a*=2;
                                j++;
                            }
                        }else{
                            this.penj+="0 x 2^"+cntr+"\n";
                        }
                    } else{
                        if(a!=0){
                            this.penj+=a+" x 2^"+cntr+"\n";
                        }else{
                            this.penj+="0 x 2^"+cntr+"\n";
                        }
                    }
                    cntr++;
                    this.penj+="Hasil ke-"+cntr+":\n";
                    this.penj+=a+"\n\n";
                    cnt+=a;
                }
                this.penj+="Setelah dijumlahkan semua menjadi:\n";
                this.out="";
                this.out+=cnt;
                this.penj+=cnt+"\n";
            }
        }
    }
    public String getResult(){
        return this.out;
    }
    public String getPenj(){
        String tmp=this.penj.replaceAll("\\\\n","\n");
        return tmp;
    }
}
