package com.wollcorp.gacela.converter;

public abstract class AbstractConverter<E,D> {

	public abstract E fromDto(D dto);
	
	public abstract D fromEntity(E Entity);
}
