package com.movember.treasure.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.treasure.model.bean.HitoUsuario;
import com.movember.treasure.model.dao.IHitoUsuarioDAO;
import com.movember.treasure.model.exception.AppException;

@Service
class HitoUsuarioService implements IHitoUsuarioService {

	@Inject
	private IHitoUsuarioDAO hitoUsuarioDAO;

	public void insert(HitoUsuario hitoUsuario) throws AppException {
		try {
			hitoUsuarioDAO.insert(hitoUsuario);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al insertar un chequeo de hito");
		}
	}

	public void update(HitoUsuario hitoUsuario) throws AppException {
		try {
			hitoUsuarioDAO.update(hitoUsuario);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al actualizar un chequeo de hito");
		}
	}

	public void delete(HitoUsuario hitoUsuario) throws AppException {
		try {
			hitoUsuarioDAO.delete(hitoUsuario.getId());
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al borrar un chequeo de hito");
		}
	}

	public HitoUsuario retrieve(Integer id) throws AppException {
		try {
			return hitoUsuarioDAO.retrieve(id);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar un chequeo de hito");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.movember.quizz.model.service.IService#selectAll()
	 */
	public List<HitoUsuario> selectAll() throws AppException {
		try {
			return hitoUsuarioDAO.selectAll();
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar todos los chequeos de hitos");
		}
	}

	public void eliminarDeHito(Integer idHito) throws AppException {
		try {
			hitoUsuarioDAO.deleteByHito(idHito);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al eliminar todos los chequeos de un hito");
		}
	}
}