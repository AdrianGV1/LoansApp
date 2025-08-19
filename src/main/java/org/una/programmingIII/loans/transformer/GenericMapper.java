package org.una.programmingIII.loans.transformer;

public interface GenericMapper<E, D> {
    D convertToDTO(E entity);

    E convertToEntity(D dto);
}
