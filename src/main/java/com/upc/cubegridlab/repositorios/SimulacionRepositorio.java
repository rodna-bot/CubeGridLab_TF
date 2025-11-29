package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.dtos.SimulacionDTO2;
import com.upc.cubegridlab.entidades.Simulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface SimulacionRepositorio extends JpaRepository<Simulacion,Integer> {
    @Query(value = "SELECT (n.precio + COALESCE(SUM(c.precio), 0))" +
            "FROM proyectos p " +
            "INNER JOIN nanosatelites n ON n.codigo = p.codigo_nanosatelite " +
            "INNER JOIN proyectos_componentes pc ON p.codigo = pc.codigo_proyecto " +
            "INNER JOIN componentes c ON c.codigo = pc.codigo_componente " +
            "INNER JOIN simulaciones s ON s.codigo_proyecto = p.codigo " +
            "WHERE s.codigo = :codigoSimulacion " +
            "GROUP BY p.codigo, n.precio", nativeQuery = true)
    BigDecimal calcularCostoTotal(@Param("codigoSimulacion") Integer codigoSimulacion);

    @Query("SELECT SUM(c.peso) FROM Simulacion s " +
            "JOIN s.proyecto p " +
            "JOIN p.componentes c " +
            "WHERE s.codigo = :codigoSimulacion")
    BigDecimal calcularPesoTotal(@Param("codigoSimulacion") Integer codigoSimulacion);

    @Query("SELECT SUM(c.consumo) FROM Simulacion s " +
            "JOIN s.proyecto p " +
            "JOIN p.componentes c " +
            "WHERE s.codigo = :codigoSimulacion")
    BigDecimal calcularConsumoTotal(@Param("codigoSimulacion") Integer codigoSimulacion);

    @Query("SELECT new com.upc.cubegridlab.dtos.SimulacionDTO2(" +
            "s.codigo, s.nombre, s.fechaCreacion, s.costoTotal, s.pesoTotal, s.consumoTotal) " +
            "FROM Simulacion s " +
            "WHERE s.proyecto.codigo = :codigoProyecto")
    public SimulacionDTO2 findSimulacionByProyectoCodigo(@Param("codigoProyecto") Integer codigoProyecto);
}
