package br.com.tss.uniformefinaldeano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // Lê a linha de entrada

        int N = Integer.parseInt(st.nextToken());
        List<Uniforme> uniformes = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            String nome = br.readLine();

            String data = br.readLine();

            String[] detail = data.split(" ");

            String cor = detail[0];
            String tamanho = detail[1];

            Uniforme uniforme = new Uniforme();

            uniforme.setNome(nome);
            uniforme.setCor(cor);
            uniforme.setTamanho(tamanho);

            uniformes.add(uniforme);

        }

        MyComparator myComparator = new MyComparator();

        uniformes.stream()
                .sorted(myComparator)
                .forEach(System.out::println);
    }

    private static class MyComparator implements Comparator<Uniforme> {

        @Override
        public int compare(Uniforme o1, Uniforme o2) {
            int c;

            c = o1.getCor().compareTo(o2.getCor());

            if (c == 0)
               c = o2.getTamanho().compareTo(o1.getTamanho());

            if (c == 0)
               c = o1.getNome().compareTo(o2.getNome());

            return c;
       }
    }

    private static class Uniforme {
        private String cor;
        private String tamanho;
        private String nome;

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public String getTamanho() {
            return tamanho;
        }

        public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString(){

            return cor + " " + tamanho + " " + nome;
        }


    }

}
