package com.upc.cubegridlab.interfaces;


import com.upc.cubegridlab.dtos.NanosateliteDTO;

import java.util.List;

public interface INanosatelite {
public List<NanosateliteDTO> listar();
public NanosateliteDTO registrar(NanosateliteDTO dto);
public NanosateliteDTO actualizar(NanosateliteDTO dto);
public void eliminar(Integer codigo);
}
