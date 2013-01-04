package com.movember.treasure.model.service;

import com.movember.treasure.model.bean.HitoDispositivo;
import com.movember.treasure.model.exception.AppException;

public interface IHitoDispositivoService extends IService<HitoDispositivo> {

	void eliminarDeHito(Integer idHito) throws AppException;
}