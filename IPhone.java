import java.applet.AudioClip;
import java.util.List;

public class IPhone {

    public ReprodutorMusical reprodutorMusical;
    public Navegador navegador;
    public AparelhoTelefonico aparelhoTelefonico;

}

public class ReprodutorMusical {

   private Musica musica;
   private List<Musica> playlist;
   
   public void tocar() {
        musica.setPlay(true);
   }
    public void pausar() {
        musica.setPlay(false);
    }

    public void selecionarMusica(Musica music) {
        for (int i=0; i<playlist.size(); i++) {
            if (playlist.get(i).equals(music)) {
                music.setPlay(true);
            } else {
                System.out.println("Música não encontrada");
            }
        }
    }
}

public class AparelhoTelefonico {

    private Call call; 
    private boolean turnOn;

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }
    public boolean getTurnOn() {
        return this.turnOn;
    } 
    public void atender() {
        call.setTurnOn(true);
    }

    public void iniciarCorreioVoz() {
        List<AudioClip> messages = call.getMailBox().getMessages();
        for (int i=0; i < messages.size(); i++) {
            messages.get(i).play();
        }
    }

}

public class Navegador {

   private Pagina paginaAtual;
   private List<Pagina> abas;

   public void exibirPagina(String page) {
        for (int i=0; i < abas.size(); i++) {
            if (abas.get(i).getName().equals(page)) {
                paginaAtual = abas.get(i);
            }
        }
    }

    public void atualizaPagina(Pagina page) {
        for (int i=0; i < abas.size(); i++) {
            if (abas.get(i).equals(page)) {
                abas.get(i).recarregar();
            }
        } 
    }

    public void adicionarNovaAba(Pagina page) {
        abas.add(page);
    }
   
}

public class Musica {

   private boolean play;

    public void setPlay(boolean play) {
        this.play = play;
    }
    public boolean getPlay() {
        return this.play;
    } 

}

public class Call {
    private boolean turnOn;
    private MailBox mailBox;

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }
    public boolean getTurnOn() {
        return this.turnOn;
    }

    public MailBox getMailBox() {
        return this.mailBox;
    } 
}

public class MailBox {

    private List<AudioClip> messages;
    private AudioClip message;
 
     public void setMessage(AudioClip audio) {
         this.message = audio;
         this.messages.add(message);
     }
     public AudioClip getMessage() {
         return this.message;
     }
     public List<AudioClip> getMessages() {
        return this.messages;
    }

}

public class Pagina {
    private boolean atualiza;
    private String name;

    public void recarregar () {
        this.atualiza = true;
    }
    public String getName () {
       return this.name;
    }
    public void setName(String nome) {
        this.name = nome;
    }
}