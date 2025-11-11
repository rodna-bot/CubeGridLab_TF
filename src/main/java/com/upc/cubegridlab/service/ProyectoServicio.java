package com.upc.cubegridlab.service;
import com.upc.cubegridlab.dtos.*;
import com.upc.cubegridlab.entidades.*;
import com.upc.cubegridlab.interfaces.IProyecto;
import com.upc.cubegridlab.repositorios.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProyectoServicio implements IProyecto {
    @Autowired
    private ProyectoRepositorio proyectoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioCursoRepositorio usuarioCursoRepositorio;
    @Autowired
    private NanosateliteRepositorio nanosateliteRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Override
    public ProyectoDTO registrar(ProyectoDTO proyectoDTO) {
        if (proyectoDTO.getCodigo()==null && proyectoDTO.getNombre()!=null){
            if(proyectoDTO.getDescripcion()!=null && proyectoDTO.getFecha_creacion()!=null){
                if (proyectoDTO.getCod_usuario()!=null && proyectoDTO.getCod_curso()!=null){

                    Usuario usuario = usuarioRepositorio.findById(proyectoDTO.getCod_usuario().getCodigo()).orElse(null);
                    Curso curso = cursoRepositorio.findById(proyectoDTO.getCod_curso().getCodigo()).orElse(null);
                    if (usuario != null && curso != null) {
                        UsuarioCurso usuarioCurso = new UsuarioCurso();
                        UsuarioCursoId usuarioCursoId = new UsuarioCursoId(proyectoDTO.getCod_usuario().getCodigo(), proyectoDTO.getCod_curso().getCodigo());
                        usuarioCurso.setId(usuarioCursoId);
                        usuarioCurso.setUsuario(usuario);
                        usuarioCurso.setCurso(curso);

                        Nanosatelite nanosatelite = null;
                        if (proyectoDTO.getCod_nanosatelite() != null) {
                            nanosatelite = nanosateliteRepositorio.findById(proyectoDTO.getCod_nanosatelite().getCodigo())
                                    .orElse(null);
                            if(nanosatelite == null){
                                return null;
                            }
                        }

                        Proyecto proyecto = new Proyecto();
                        proyecto.setNombre(proyectoDTO.getNombre());
                        proyecto.setDescripcion(proyectoDTO.getDescripcion());
                        proyecto.setFecha_creacion(proyectoDTO.getFecha_creacion());
                        proyecto.setUsuarioCurso(usuarioCurso);
                        proyecto.setNanosatelite(nanosatelite);

                        Set<Componente> componentesSet = proyectoDTO.getComponentes().stream()
                                .map(componenteDTO -> {
                                    Componente componente = new Componente();
                                    componente.setCodigo(componenteDTO.getCodigo());
                                    componente.setNombre(componenteDTO.getNombre());
                                    componente.setDescripcion(componenteDTO.getDescripcion());
                                    componente.setTipo(componenteDTO.getTipo());
                                    componente.setPrecio(componenteDTO.getPrecio());
                                    componente.setPeso(componenteDTO.getPeso());
                                    componente.setConsumo(componenteDTO.getConsumo());
                                    return componente;
                                })
                                .collect(Collectors.toSet());
                        proyecto.setComponentes(componentesSet);

                        Proyecto savedProyecto = proyectoRepositorio.save(proyecto);
                        proyectoDTO.setCodigo(savedProyecto.getCodigo());
                        return proyectoDTO;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public ProyectoDTO actualizar(ProyectoDTO proyectoDTO) {
        if (proyectoDTO.getCodigo() != null && proyectoDTO.getNombre() != null) {
            if (proyectoDTO.getDescripcion() != null && proyectoDTO.getFecha_creacion() != null) {
                if (proyectoRepositorio.existsById(proyectoDTO.getCodigo())) {

                    Proyecto proyecto = proyectoRepositorio.findById(proyectoDTO.getCodigo()).orElse(null);

                    if (proyecto != null) {
                        proyecto.setNombre(proyectoDTO.getNombre());
                        proyecto.setDescripcion(proyectoDTO.getDescripcion());
                        proyecto.setFecha_creacion(proyectoDTO.getFecha_creacion());

                        Usuario usuario = usuarioRepositorio.findById(proyectoDTO.getCod_usuario().getCodigo()).orElse(null);
                        Curso curso = cursoRepositorio.findById(proyectoDTO.getCod_curso().getCodigo()).orElse(null);

                        if (usuario != null && curso != null) {
                            UsuarioCurso usuarioCurso = new UsuarioCurso();
                            UsuarioCursoId usuarioCursoId = new UsuarioCursoId(proyectoDTO.getCod_usuario().getCodigo(), proyectoDTO.getCod_curso().getCodigo());
                            usuarioCurso.setId(usuarioCursoId);
                            usuarioCurso.setUsuario(usuario);
                            usuarioCurso.setCurso(curso);
                            proyecto.setUsuarioCurso(usuarioCurso);
                        }

                        if (proyectoDTO.getCod_nanosatelite() != null) {
                            Nanosatelite nanosatelite = nanosateliteRepositorio.findById(proyectoDTO.getCod_nanosatelite().getCodigo()).orElse(null);
                            if (nanosatelite != null) {
                                proyecto.setNanosatelite(nanosatelite);
                            }
                        }

                        Set<Componente> componentesSet = proyectoDTO.getComponentes().stream()
                                .map(componenteDTO -> {
                                    Componente componente = new Componente();
                                    componente.setCodigo(componenteDTO.getCodigo());
                                    componente.setNombre(componenteDTO.getNombre());
                                    componente.setDescripcion(componenteDTO.getDescripcion());
                                    componente.setTipo(componenteDTO.getTipo());
                                    componente.setPrecio(componenteDTO.getPrecio());
                                    componente.setPeso(componenteDTO.getPeso());
                                    componente.setConsumo(componenteDTO.getConsumo());
                                    return componente;
                                })
                                .collect(Collectors.toSet());
                        proyecto.setComponentes(componentesSet);

                        Proyecto updatedProyecto = proyectoRepositorio.save(proyecto);
                        return proyectoDTO;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public void eliminar(Integer id) {
        if (id!=null){
            if(proyectoRepositorio.existsById(id)){
                proyectoRepositorio.deleteById(id);
            }
        }
    }
    @Override
    public List<ProyectoDTO> listar() {
        return proyectoRepositorio.findAll().stream()
                .map(proyecto -> {
                    ProyectoDTO proyectoDTO = new ProyectoDTO();

                    proyectoDTO.setCodigo(proyecto.getCodigo());
                    proyectoDTO.setNombre(proyecto.getNombre());
                    proyectoDTO.setDescripcion(proyecto.getDescripcion());
                    proyectoDTO.setFecha_creacion(proyecto.getFecha_creacion());

                    UsuarioCursoId usuarioCursoId = proyecto.getUsuarioCurso().getId();
                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    usuarioDTO.setCodigo(usuarioCursoId.getCodigoUsuario()); // código del usuario
                    proyectoDTO.setCod_usuario(usuarioDTO);

                    CursoDTO cursoDTO = new CursoDTO();
                    cursoDTO.setCodigo(usuarioCursoId.getCodigoCurso());
                    proyectoDTO.setCod_curso(cursoDTO);

                    NanosateliteDTO nanosateliteDTO = new NanosateliteDTO();
                    if (proyecto.getNanosatelite() != null) {
                        nanosateliteDTO.setCodigo(proyecto.getNanosatelite().getCodigo());
                        nanosateliteDTO.setTipo(proyecto.getNanosatelite().getTipo());
                        nanosateliteDTO.setPrecio(proyecto.getNanosatelite().getPrecio());
                        proyectoDTO.setCod_nanosatelite(nanosateliteDTO);
                    }

                    List<ComponenteDTO> componentesDTO = proyecto.getComponentes().stream()
                            .map(componente -> {
                                ComponenteDTO componenteDTO = new ComponenteDTO();
                                componenteDTO.setCodigo(componente.getCodigo());
                                componenteDTO.setNombre(componente.getNombre());
                                componenteDTO.setDescripcion(componente.getDescripcion());
                                componenteDTO.setTipo(componente.getTipo());
                                componenteDTO.setPrecio(componente.getPrecio());
                                componenteDTO.setPeso(componente.getPeso());
                                componenteDTO.setConsumo(componente.getConsumo());
                                return componenteDTO;
                            })
                            .collect(Collectors.toList());
                    proyectoDTO.setComponentes(componentesDTO);

                    return proyectoDTO;
                })
                .collect(Collectors.toList());
    }
}