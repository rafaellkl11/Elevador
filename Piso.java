/**
 * Escreva uma descrição da classe Piso aqui.
 *
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class Piso
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int andar;
    private boolean subir;
    private boolean descer;
    private String painel;
    private Piso pisoAnterior;
    private Piso proximoPiso;
    private boolean parada;

    /**
     * Construtor para objetos da classe Piso
     */
    public Piso(int Andar)
    {
        // inicializa variáveis de instância
        this.andar = Andar;
        subir = false;
        descer = false;
        painel = "△▽";
        this.parada = false;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     *
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y
     */
    public int getAndar()
    {
        return andar;
    }
   
    public void queroSubir()
    {
        subir = true;
    }
   
    public void queroDescer()
    {
        descer = true;
    }
   
    public boolean isQueroSubir()
    {
        return subir;
    }
   
    public boolean isQueroDescer()
    {
        return descer;
    }
   
    public void mostrarPainel()
    {
        if(subir && descer){
            painel = "▲▼";
        }
        else if(subir){
            painel = "▲▽";
        }
        else if(descer){
            painel = "△▼";
        }
        
        System.out.println(painel);
    }
    
    public void setProximoPiso(Piso proximo)
    {
        this.proximoPiso = proximo;
        proximo.pisoAnterior = this;
    }
    
    public Piso getProximoPiso()
    {
        return proximoPiso;
    }
    
    public Piso getPisoAnterior()
    {
        return pisoAnterior;
    }
    
    public void solicitarParada()
    {
        this.parada = true;
    }
    
    public boolean isParadaSolicitada()
    {
        return parada;
    }
    
    public void receberElevador(Elevador elevador)
    {
        if (parada || (elevador.isSubindo() && subir) || (elevador.isDescendo() && descer)) {
        elevador.abrirPorta();
        parada = false;
        subir = false;
        descer = false;
        }
    }
}