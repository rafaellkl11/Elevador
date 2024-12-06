
/**
 * Escreva uma descrição da classe Elevador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Elevador
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private boolean porta;
    private boolean direção;
    private Piso pisoAtual;
    private int totalAndares;
    private String marcador;
    private int andar;

    /**
     * Construtor para objetos da classe Elevador
     */
    public Elevador(Piso primeiroPiso, int total)
    {
        // inicializa variáveis de instância
        pisoAtual = primeiroPiso;
        porta = false;
        direção = true;
        totalAndares = total;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public void abrirPorta()
    {
        // escreva seu código aqui
        porta = true;
    }
    
    public void fecharPorta()
    {
        porta = false;
    }
    
    public boolean isPortaAberta()
    {        
        return porta;
    }
    
    public boolean isSubindo()
    {
        return direção;
    }
    
    public boolean isDescendo()
    {
        return !direção;
    }
    
    public Piso getPisoAtual()
    {
        return pisoAtual;
    }
    
    public void pararNoPiso(Piso piso)
    {
        piso.solicitarParada();
    }
    
    public void mostrarPainel()
    {
        System.out.println("** Painel do Elevador **");

        // Localizar o piso mais baixo (primeiro piso da cadeia)
        Piso pisoMaisBaixo = pisoAtual;
        while (pisoMaisBaixo.getPisoAnterior() != null) {
            pisoMaisBaixo = pisoMaisBaixo.getPisoAnterior();
        }
    
        // Percorrer os pisos do mais baixo ao mais alto
        Piso pisoAtualNaLista = pisoMaisBaixo;
        System.out.print("[");
        while (pisoAtualNaLista != null) {
            String marcador = "";
    
            // Marcar o andar atual ou paradas solicitadas
            if (pisoAtualNaLista == pisoAtual) {
                marcador = "E"; // Elevador está neste piso
            } else if (pisoAtualNaLista.isParadaSolicitada()) {
                marcador = "*"; // Parada solicitada neste piso
            }
    
            System.out.print(" " + pisoAtualNaLista.getAndar() + marcador + " ");
            pisoAtualNaLista = pisoAtualNaLista.getProximoPiso();
        }
        System.out.println("]");
    
        // Mostrar direção do elevador
        System.out.println(direção ? "Direção: Subindo ↑" : "Direção: Descendo ↓");

    }
    
    public void mover()
    {
        if (porta) {
            System.out.println("Feche a porta antes de mover o elevador!");
            return;
        }

        if (direção) {
            if (pisoAtual.getProximoPiso() != null) {
                pisoAtual = pisoAtual.getProximoPiso();
            } else {
                direção = false; // Muda a direção ao atingir o último andar
            }
        } else {
            if (pisoAtual.getPisoAnterior() != null) {
                pisoAtual = pisoAtual.getPisoAnterior();
            } else {
                direção = true; // Muda a direção ao atingir o térreo
            }
        }
    
        pisoAtual.receberElevador(this);
    }
}
