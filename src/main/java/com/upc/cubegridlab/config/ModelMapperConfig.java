package com.upc.cubegridlab.config;

import com.upc.cubegridlab.repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public org.modelmapper.ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
