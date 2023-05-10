package com.hkemal.simpleinsuraceapp.service.service;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface SimpleCrudService<I, R> {
    R save(I inputDTO);

    R update(Long id, I inputDTO) throws Exception;
}
