package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.dtos.ReporteDTO;
import com.upc.cubegridlab.dtos.SimulacionDTO;
import com.upc.cubegridlab.dtos.SimulacionDTO2;
import com.upc.cubegridlab.entidades.Proyecto;
import com.upc.cubegridlab.entidades.Simulacion;
import com.upc.cubegridlab.interfaces.ISimulacion;
import com.upc.cubegridlab.repositorios.SimulacionRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service
public class SimulacionService implements ISimulacion {
    @Autowired
    private SimulacionRepositorio simulacionRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SimulacionDTO registrar(SimulacionDTO simulacionDTO) {
        if (simulacionDTO.getCodigo() == null && simulacionDTO.getNombre() !=null) {
            if (simulacionDTO.getProyecto()!=null) {

                simulacionDTO.setFechaCreacion(LocalDate.now());
                simulacionDTO.setCostoTotal(new BigDecimal("1.0"));
                simulacionDTO.setPesoTotal(new BigDecimal("1.0"));
                simulacionDTO.setConsumoTotal(new BigDecimal("1.0"));

                Simulacion simulacion = modelMapper.map(simulacionDTO, Simulacion.class);
                Simulacion save = simulacionRepositorio.save(simulacion);

                simulacionDTO.setCodigo(save.getCodigo());

                BigDecimal costoTotal = simulacionRepositorio.calcularCostoTotal(simulacionDTO.getCodigo());
                BigDecimal pesoTotal = simulacionRepositorio.calcularPesoTotal(simulacionDTO.getCodigo());
                BigDecimal consumoTotal = simulacionRepositorio.calcularConsumoTotal(simulacionDTO.getCodigo());

                simulacionDTO.setCostoTotal(costoTotal);
                simulacionDTO.setPesoTotal(pesoTotal);
                simulacionDTO.setConsumoTotal(consumoTotal);

                save.setCostoTotal(costoTotal);
                save.setPesoTotal(pesoTotal);
                save.setConsumoTotal(consumoTotal);

                simulacionRepositorio.save(save);

                return modelMapper.map(save, SimulacionDTO.class);
            }
        }
        return null;
    }

    @Override
    public SimulacionDTO actualizar(SimulacionDTO simulacionDTO) {
        if (simulacionDTO.getCodigo() != null && simulacionDTO.getNombre() !=null) {
            if (simulacionDTO.getProyecto()!=null) {
                if (simulacionRepositorio.existsById(simulacionDTO.getCodigo())) {
                    simulacionDTO.setFechaCreacion(LocalDate.now());
                    simulacionDTO.setCostoTotal(simulacionRepositorio.calcularCostoTotal(simulacionDTO.getCodigo()));
                    simulacionDTO.setPesoTotal(simulacionRepositorio.calcularPesoTotal(simulacionDTO.getCodigo()));
                    simulacionDTO.setConsumoTotal(simulacionRepositorio.calcularConsumoTotal(simulacionDTO.getCodigo()));

                    Simulacion simulacion = modelMapper.map(simulacionDTO, Simulacion.class);
                    Simulacion save = simulacionRepositorio.save(simulacion);
                    return modelMapper.map(save, SimulacionDTO.class);
                }
            }
        }
        return null;}
    @Override
    public void eliminar(Integer id) {
        if (simulacionRepositorio.existsById(id)) {
            simulacionRepositorio.deleteById(id);
        }}
    @Override
    public List<SimulacionDTO> listar() {
        return simulacionRepositorio.findAll().stream()
                .map(simulacion->modelMapper.map(simulacion, SimulacionDTO.class))
                .toList();
    }

    @Override
    public SimulacionDTO2 buscarSimulacionPorCodigoProyecto(Integer codigoProyecto) {
        return simulacionRepositorio.findSimulacionByProyectoCodigo(codigoProyecto);
    }

    @Override
    public ReporteDTO obtenerPromediosPorUsuario(Integer codigoUsuario) {
        return simulacionRepositorio.obtenerPromediosPorUsuario(codigoUsuario);
    }
}
