package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.AbstractView;
import com.rsi.adaptive.calc.domain.AbstractDomain;

import java.util.List;

/**
 * Created by suryadevarap on 1/8/19.
 */
public interface DomainMapper {

  <V extends AbstractView, E extends AbstractDomain> V convert(E entity);

  <V extends AbstractView, E extends AbstractDomain> List<V> convert(List<E> entities);

  <V extends AbstractView, E extends AbstractDomain> E convert(V view);

  <V extends AbstractView, E extends AbstractDomain> V convert(E entity, Class<V> targetClazz);

  <V extends AbstractView, E extends AbstractDomain> List<V> convert(List<E> entities, Class<V> targetClazz);


}

