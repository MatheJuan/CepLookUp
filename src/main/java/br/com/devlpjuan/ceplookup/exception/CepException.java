package br.com.devlpjuan.ceplookup.exception;

public final class CepException {
    private CepException() {}

     public static class CepInvalidoException extends RuntimeException {
        public CepInvalidoException(String message) {
            super(message);
        }
    }
    public static class CepNaoEncontradoException extends RuntimeException {
            public CepNaoEncontradoException(String message) {
                super(message);
            }
        }
    public static class ViaCepException extends RuntimeException {
        public ViaCepException(String message, Throwable cause){
            super(message, cause);
        }
    }
    public static class ViaCepTimeoutException extends RuntimeException {
        public ViaCepTimeoutException(String message, Throwable cause){
            super(message, cause);
        }
    }

/*

 */
}
