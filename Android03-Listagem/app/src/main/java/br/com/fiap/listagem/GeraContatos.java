package br.com.fiap.listagem;

import java.util.ArrayList;
import java.util.List;

public class GeraContatos {

    public static List<Contato> gerarContatos() {
        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato(
                "João",
                "(11) 1111-1111",
                "Disponível",
                R.drawable.p1
        );

        contatos.add(contato1);

        Contato contato2 = new Contato(
                "Maria",
                "(11) 2222-2222",
                "Sem status",
                R.drawable.p2
        );

        contatos.add(contato2);

        return contatos;
    }
}
