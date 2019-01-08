package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.AbstractView;
import com.rsi.adaptive.calc.domain.AbstractDomain;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by suryadevarap on 1/8/19.
 */
public class GenericDomainMapperImpl  implements DomainMapper {

  private Map<Class<? extends AbstractDomain>, Class<? extends AbstractView>> domainToViewMapping = new HashMap<>();
  private Map<Class<? extends AbstractView>, Class<? extends AbstractDomain>> viewToDomainMapping = new HashMap<>();

  @Override
  public <V extends AbstractView, E extends AbstractDomain> V convert(E entity) {

    Class<? extends AbstractDomain> clazz = entity.getClass();
    Class<V> viewClazz = findViewClass(clazz);

    return createViewInstance(viewClazz, entity);
  }

  @Override
  public <V extends AbstractView, E extends AbstractDomain> List<V> convert(List<E> entities) {

    if (CollectionUtils.isEmpty(entities)) {
      return new ArrayList<>();
    }

    Class<? extends AbstractDomain> clazz = entities.get(0).getClass();
    Class<V> viewClazz = findViewClass(clazz);

    return entities.stream().map(e -> createViewInstance(viewClazz, e)).collect(Collectors.toList());
  }

  @Override
  public <V extends AbstractView, E extends AbstractDomain> E convert(V view) {

    Class<? extends AbstractView> clazz = view.getClass();
    Class<E> entityClazz = findEntityClass(clazz);

    return createEntityInstance(entityClazz, view);
  }

  public void addClassMapping(Class<? extends AbstractDomain> entityClazz, Class<? extends AbstractView> viewClazz) {
    domainToViewMapping.put(entityClazz, viewClazz);
    viewToDomainMapping.put(viewClazz, entityClazz);
  }

  @SuppressWarnings("unchecked")
  private <V extends AbstractView, E extends AbstractDomain> Class<V> findViewClass(Class<E> entityClazz) {

    Class<V> viewClazz = (Class<V>) domainToViewMapping.get(entityClazz);

    if (viewClazz == null) {
      throw new IllegalArgumentException("no mapping configuration was found for class " + entityClazz);
    }
    return viewClazz;
  }

  @SuppressWarnings("unchecked")
  private <V extends AbstractView, E extends AbstractDomain> Class<E> findEntityClass(Class<V> viewClazz) {

    Class<E> entityClazz = (Class<E>) viewToDomainMapping.get(viewClazz);

    if (entityClazz == null) {
      throw new IllegalArgumentException("no mapping configuration was found for class " + viewClazz);
    }
    return entityClazz;
  }

  @Override
  public <V extends AbstractView, E extends AbstractDomain> V convert(E entity, Class<V> targetClazz) {
    return createViewInstance(targetClazz, entity);
  }

  @Override
  public <V extends AbstractView, E extends AbstractDomain> List<V> convert(List<E> entities, Class<V> targetClazz) {
    return entities.stream().map(e -> createViewInstance(targetClazz, e)).collect(Collectors.toList());
  }

  private <V extends AbstractView, E extends AbstractDomain> V createViewInstance(Class<V> viewClazz, E entity) {
    V view = BeanUtils.instantiate(viewClazz);
    BeanUtils.copyProperties(entity, view);
    return view;
  }

  private <V extends AbstractView, E extends AbstractDomain> E createEntityInstance(Class<E> entityClazz, V view) {
    E entity = BeanUtils.instantiate(entityClazz);
    BeanUtils.copyProperties(view, entity);
    return entity;
  }
}