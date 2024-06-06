package br.com.alura.screenmatch.excecao;

public class ErroConvercaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroConvercaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
