package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.AbstractDto;
import kg.bektur.Restaurant.models.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {
    E toEntity(D dto);
    D toDto(E entity);
}
