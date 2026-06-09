public class CozinhaReceiver {
    
    public void prepararHamburguer(String nomePrato) {
        System.out.println("[COZINHA] Preparando na chapa: " + nomePrato);
    }

    public void cancelarPreparo(String nomePrato) {
        System.out.println("[COZINHA] Interrompendo e descartando preparo de: " + nomePrato);
    }
}