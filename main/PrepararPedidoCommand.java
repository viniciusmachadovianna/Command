public class PrepararPedidoCommand implements Command {
    private final CozinhaReceiver cozinha;
    private final String nomePrato;

    public PrepararPedidoCommand(CozinhaReceiver cozinha, String nomePrato) {
        this.cozinha = cozinha;
        this.nomePrato = nomePrato;
    }

    @Override
    public void execute() {
        cozinha.prepararHamburguer(nomePrato);
    }
}