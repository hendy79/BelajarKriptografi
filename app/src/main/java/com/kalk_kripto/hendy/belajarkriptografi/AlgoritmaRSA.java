package com.kalk_kripto.hendy.belajarkriptografi;

import java.math.*;

public class AlgoritmaRSA {
    private int n, z, d, e, i;
    private String penj,out;

    public AlgoritmaRSA() {

    }

    public AlgoritmaRSA(int N, int pk, String temp){
        this.penj="";
        try {
            int ix = 0;
            int cnt = 0, iy = 1;
            do {
                if (temp.charAt(cnt) == ',') {
                    iy++;
                }
                cnt++;
            } while (cnt < temp.length());
            double[] c = new double[iy];
            this.d = pk;
            this.n = N;
            for (String s : temp.split(",")) {
                c[ix] = Double.parseDouble(s);
                ix++;
            }
            this.penj+="Hasil Dekripsi didapat dari hasil setiap kode ascii karakter dipangkatkan dengan Private Key kemudian di Modulus dengan N\n\n";
            this.penj+="->Notasinya adalah C^d mod N=P; dimana C adalah Cipher Text, d adalah Private Key, N adalah hasil perkalian 2 Bilangan Ganjil, dan P adalah Plain Text<-\n";
            this.out = decrypt(c);
            this.penj+="\nHasil Dekripsi dalam bentuk Teks = " + this.out+"\n";
        }catch(NumberFormatException exc){
            System.out.println("FORMAT MASUKAN SALAH!");
            this.out="";
        }
    }

    public AlgoritmaRSA(String msg, int p1, int q1){
        this.out="";
        this.penj="";
        boolean status1=true;
        encryptionP(p1,q1);
        double[] c = encrypt(msg);
        for(double checkEnc : c){
            if(checkEnc>255.0){
                status1=false;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        if(status1){
            for(double encryptedCharacter1: c) {
                BigInteger enc = BigDecimal.valueOf(encryptedCharacter1).toBigInteger();
                builder.append(Character.toChars(enc.intValue()));
            }
        }
        String resEnc = builder.toString();

        this.penj+="\nHasil Enkripsi didapat dari hasil setiap kode ascii karakter dipangkatkan dengan Public Key kemudian di Modulus dengan N\n";
        this.penj+="->Notasinya adalah P^e mod N=C; dimana P adalah Plain Text, e adalah Public Key, N adalah hasil perkalian 2 Bilangan Ganjil, dan C adalah Cipher Text<-\n";
        this.penj+="\nHasil Enkripsi dalam Kode ASCII:\n";
        for(int xyz=0;xyz<c.length;xyz++){
            this.penj+=c[xyz];
            this.out+=c[xyz];
            if(xyz!=c.length-1){
                this.penj+=",";
                this.out+=",";
            }else{
                this.penj+="\n";
            }
        }
        if(status1){
            this.penj+="\nHasil Enkripsi dalam bentuk Teks = "+resEnc+"\n";
        }
    }

    public void encryptionP(int p,int q){
        this.n = p * q;
        this.penj+="Nilai N, didapat dari perkalian bilangan prima 1 dan bilangan prima 2 = " + this.n+"\n\n";

        z = (p - 1) * (q - 1);
        this.penj+="Nilai Totient, didapat dari perkalian bilangan prima 1 dikurangi 1 dan bilangan prima 2 dikurangi 1 = " + z+"\n\n";

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) // e is for public key exponent
            {
                break;
            }
        }
        //e should be in the range 1-z
        this.penj+="Public Key (e), didapat dari bilangan prima yang bukan merupakan faktor dari Totient ("+z+")\n";
        this.penj+="->Karena bilangan "+z+" tidak dapat dibagi habis dengan "+e+", maka "+e+" bukan faktor dari "+z+"<-\n";
        this.penj+="Nilai Public Key adalah "+e+"\n\n";
        // calculate d
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) //d is for private key exponent
            {
                this.d = x / e;
                break;
            }
        }
        this.penj+="Private Key (d), didapat dari nilai Public Key ("+e+") dikalikan Private Key yang dicari dan dimodulus dengan ("+z+") menghasilkan angka 1\n";
        this.penj+="->Notasinya adalah "+e+"*d mod "+z+" = 1 (d adalah variabel yang mengartikan Private Key)<-\n";
        this.penj+="Nilai Private Key adalah "+d+"\n\n";
    }
    public boolean CheckBesar(int check){
        if(check<100 && check>10){
            return true;
        }else{
            return false;
        }
    }

    public boolean CheckPrima(int check){
        int temp;
        for(int xy=2;xy<=check/2;xy++){
            temp=check%xy;
            if(temp==0){
                return false;
            }
        }
        return true;
    }

    private static int gcd(int e, int z) {
        if (e == 0) {
            return z;
        } else {
            return gcd(z % e, e);
        }
    }

//Encrypt Function Area
    double encrypt(int msg) {
        //Encrypting  C = msg ^e mod n
        return (Math.pow(msg, e)) % n;
    }

    double[] encrypt(String msg) {
        int[] charactersAsNumbers = new int[msg.length()];
        for(int i = 0; i < msg.length(); i++) {
            charactersAsNumbers[i] = msg.codePointAt(i);
        }
        this.penj+="Plain text dalam bentuk kode ASCII: \n";
        for(int xyz=0;xyz<charactersAsNumbers.length;xyz++){
            this.penj+=charactersAsNumbers[xyz];
            if(xyz!=charactersAsNumbers.length-1){
                this.penj+=",";
            }else{
                this.penj+="\n";
            }
        }

        double[] encryptedMsg = new double[msg.length()];
        for(int i = 0; i < charactersAsNumbers.length; i++) {
            encryptedMsg[i] = encrypt(charactersAsNumbers[i]);
        }
        return encryptedMsg;
    }

//Decrypt Function Area
    BigInteger decrypt(double encrypted) {
        //converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
        //converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(encrypted).toBigInteger();

        //Decrypt , P = Cˆd mod N , msgback = P
        return (C.pow(d)).mod(N);
    }

    String decrypt(double[] encrypted) {
        StringBuilder builder = new StringBuilder();
        int ix=0;
        this.penj+="\nHasil Dekripsi dalam Kode ASCII:\n";
        for(double encryptedCharacter: encrypted) {
            BigInteger decryptedCharacter = decrypt(encryptedCharacter);
            this.penj+=decryptedCharacter.intValue();
            builder.append(Character.toChars(decryptedCharacter.intValue()));
            ix++;
            if(ix!=encrypted.length){
                this.penj+=",";
            }else{
                this.penj+="\n";
            }
        }
        return builder.toString();
    }

    public String getN(){
        return Integer.toString(this.n);
    }
    public String getD(){
        return Integer.toString(this.d);
    }
    public String getResult(){
        return this.out;
    }
    public String getPenj(){
        String text=this.penj.replaceAll("\\\\n","\n");
        return text;
    }
}
