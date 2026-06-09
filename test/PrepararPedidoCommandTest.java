public class PrepararPedidoCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void deveEncaminharPedidoParaACozinhaQuandoInvokerForAcionado() {
        CozinhaReceiver cozinha = new CozinhaReceiver();
        Command comando = new PrepararPedidoCommand(cozinha, "Cheddar Duplo");
        TotemInvoker totem = new TotemInvoker();
        
        totem.definirComando(comando);

        totem.pressionarBotaoConfirmar();

        String resultadoConsole = outputStreamCaptor.toString().trim();
        
        assertTrue(resultadoConsole.contains("[COZINHA] Preparando na chapa: Cheddar Duplo"),
            "O comando deveria ter encapsulado a solicitação e disparado o método correto no Receiver.");
    }

    @Test
    public void naoDeveLancarExcecaoSeBotaoForPressionadoSemComandoDefinido() {
        TotemInvoker totem = new TotemInvoker();

        assertDoesNotThrow(() -> totem.pressionarBotaoConfirmar(),
            "O Invoker deve tratar de forma segura o caso de o comando estar nulo.");
    }
}