import java.util.List;
import java.util.Scanner;

public class UI {

    ListaDuplamenteEncadeadaController Controller;

    public UI(){
        this.Controller =  new ListaDuplamenteEncadeadaController();
    }

    public boolean app(){
        return chooseOption();
    }

    public void showOptions(){
        System.out.print("[1] .Inserir um novo termo \n"
        + "[2] .Excluir um termo (em desensvolvimento) \n"
        + "[3] .Mostrar lista em ordem crescente (do primeiro ao ultimo termo) \n"
        + "[4] .Mostrar lista em ordem decrescente (do ultimo ao primeiro termo) \n"
        + "[5] .Sair \n"
        + ">>>"
        );
    }

    public void insert(){
        Scanner Teclado = new Scanner(System.in);
        try {
            System.out.print("Insira um numero para armazenar na lista duplamente encadeada: ");
            int informacao = Teclado.nextInt();
            Controller.inserir(informacao);
        }   catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo deu errado, tente novamente");
        }
    }

    public void showNormalRoll(){
        Controller.imprimeComecoFim();
    }

    public void showRollBack(){
        Controller.imprimeFimComeco();
    }

    public void delete(){
        Scanner Teclado = new Scanner(System.in);
        int posicao;
        try {
            showNormalRoll();
            System.out.print("Digite qual posicao deseja remover: ");
            posicao = Teclado.nextInt();
            Controller.remove(posicao);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo deu errado");
        }
        System.out.println("Esta em desenvolvimento ainda");
    }

    public void sair(){
        System.out.println("Adeus");
    }

    public boolean chooseOption(){
        int escolha = inputOption(1,5);
        switch (escolha){
            case 1:
                insert();
                return true;
            case 2:
                delete();
                return true;
            case 3:
                showNormalRoll();
                return true;
            case 4:
                showRollBack();
                return true;
            case 5:
                sair();
                return false;
            default:
                return true;
        }
    }

    public int inputOption(int begin, int end){
        int option;
        try {
            do {
                showOptions();
                Scanner teclado = new Scanner(System.in);
                option = teclado.nextInt();
            } while (!(option > begin || option < end));
            return option;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("insira um valor valido");
            return 6;
        }
    }

}
