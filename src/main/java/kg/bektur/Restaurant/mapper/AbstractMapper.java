package kg.bektur.Restaurant.mapper;

import kg.bektur.Restaurant.dto.AbstractDto;
import kg.bektur.Restaurant.models.AbstractEntity;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public class AbstractMapper<E extends AbstractEntity, D extends AbstractDto> implements Mapper<E, D> {
    private final ModelMapper mapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    public AbstractMapper(ModelMapper mapper, Class<E> entityClass, Class<D> dtoClass) {
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, dtoClass);
    }

}
