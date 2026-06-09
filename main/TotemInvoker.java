public class TotemInvoker {
    private Command comandoBotaoConfirmar;

    public void definirComando(Command comando) {
        this.comandoBotaoConfirmar = comando;
    }

    public void pressionarBotaoConfirmar() {
        if (comandoBotaoConfirmar != null) {
            comandoBotaoConfirmar.execute();
        }
    }
}