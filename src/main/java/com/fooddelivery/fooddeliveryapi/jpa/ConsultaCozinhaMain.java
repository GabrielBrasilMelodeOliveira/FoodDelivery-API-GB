package com.fooddelivery.fooddeliveryapi.jpa;

import com.fooddelivery.fooddeliveryapi.FooddeliveryApiApplication;
import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;
import com.fooddelivery.fooddeliveryapi.domain.model.Restaurante;
import com.fooddelivery.fooddeliveryapi.domain.repository.CozinhaRepository;
import com.fooddelivery.fooddeliveryapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FooddeliveryApiApplication.class).web(WebApplicationType.NONE).run(args);

        Cozinha cozinha = new Cozinha("Brasileiraaaaaaa");



        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);



        Cozinha cozinhaSalva = cadastroCozinha.adicionar(cozinha);

        List<Cozinha> listaCozinha =  cadastroCozinha.listarTodasCozinhas();



        for(Cozinha cozinhaLista: listaCozinha){
            System.out.println(cozinhaLista.getNome());
        }
        System.out.println(cadastroCozinha.buscarPorId(2L).getNome() + "AQUIaaaaaaaaaaaaaaaaIIII");


        RestauranteRepository restauranteRepository = applicationContext.getBean((RestauranteRepository.class));

        List<Restaurante> lista = restauranteRepository.listar();

        for(Restaurante restaurante: lista){
            System.out.println(restaurante.getCozinha().getNome() + restaurante.getNome());
        }
        cadastroCozinha.remover(cozinhaSalva);
    }
}
