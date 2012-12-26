package com.movember.quizz.controller.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movember.quizz.controller.dto.EstadisticaDTO;
import com.movember.quizz.model.bean.Estadistica;
import com.movember.quizz.model.exception.AppException;
import com.movember.quizz.model.service.IEstadisticaService;

/**
 * 
 * Controlador de estadisticas
 * 
 * **/
@Controller
public class EstadisticaController {
	
	/**
	 * Servicio para manejos de estadisticas en BBDD
	 * */
	@Inject
	private IEstadisticaService estadisticaService;
	
	/**
	 * Recurso principal del controlador en la peticiones rest
	 * **/
	private static final String recurso = "estadistica";
	
	/**
	 * Petición REST que nos devuelve una sola estadistica por ID
	 * @param id es el id de la estadistica
	 * @return devuelve la estadistica con el id seleccionado
	 * **/
	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	EstadisticaDTO retrieve(@PathVariable("id") Integer id) {
		EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
		try {
			Estadistica estadistica = this.estadisticaService.retrieve(id);
			// Comversion a DTO
			estadisticaDTO.toRest(estadistica);
		}
		catch (AppException e) {

		}
		return estadisticaDTO;
	}
	
	/**
	 * Petición REST que nos devuelve en otra petición REST que operación vamos
	 * a realizar
	 * @param operación es el identificador para saber si vamos a listar
	 * @return devuelve la nueva petición REST
	 * **/
	@RequestMapping(value = "/" + recurso + "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion, final Model uiModel) {
		return recurso + "/form";
	}
}
