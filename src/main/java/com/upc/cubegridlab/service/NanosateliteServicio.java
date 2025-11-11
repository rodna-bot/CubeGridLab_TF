package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.NanosateliteDTO;
import com.upc.cubegridlab.entidades.Nanosatelite;
import com.upc.cubegridlab.interfaces.INanosatelite;
import com.upc.cubegridlab.repositorios.NanosateliteRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class NanosateliteServicio implements INanosatelite {
@Autowired
private NanosateliteRepositorio repositorio;
@Autowired
private ModelMapper mapper;

    @Override
    public NanosateliteDTO registrar(NanosateliteDTO dto) {
        if (dto.getCodigo() == null && dto.getTipo() != null ) {
            if (dto.getPrecio() != null ) {
                Nanosatelite nanosatelite = mapper.map(dto, Nanosatelite.class);
                return mapper.map(repositorio.save(nanosatelite), NanosateliteDTO.class);

            }

        }
        return null;
    }

    @Override
    public NanosateliteDTO actualizar(NanosateliteDTO dto) {
        if (dto.getCodigo() != null && dto.getPrecio() != null ) {
            if (dto.getTipo() != null ) {
                if (repositorio.existsById(dto.getCodigo())) {
                    Nanosatelite nanosatelite = mapper.map(dto, Nanosatelite.class);
                    return mapper.map(repositorio.save(nanosatelite), NanosateliteDTO.class);
                }

            }

        }
        return null;
    }

    @Override
    public void eliminar(Integer codigo) {
        if (codigo != null) {
            repositorio.deleteById(codigo);
        }
    }
    @Override
    public List<NanosateliteDTO> listar() {
        return repositorio.findAll().stream()
                .map(nanosatelite->mapper.map(nanosatelite, NanosateliteDTO.class))
                .toList();
    }
}
