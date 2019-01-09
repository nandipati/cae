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
  public <V extends AbstractView, D extends AbstractDomain> V convert(D domain) {

    Class<? extends AbstractDomain> clazz = domain.getClass();
    Class<V> viewClazz = findViewClass(clazz);

    return createViewInstance(viewClazz, domain);
  }

  @Override
  public <V extends AbstractView, D extends AbstractDomain> List<V> convert(List<D> domains) {

    if (CollectionUtils.isEmpty(domains)) {
      return new ArrayList<>();
    }

    Class<? extends AbstractDomain> clazz = domains.get(0).getClass();
    Class<V> viewClazz = findViewClass(clazz);

    return domains.stream().map(e -> createViewInstance(viewClazz, e)).collect(Collectors.toList());
  }

  @Override
  public <V extends AbstractView, D extends AbstractDomain> D convert(V view) {

    Class<? extends AbstractView> clazz = view.getClass();
    Class<D> domainClazz = finddomainClass(clazz);

    return createDomainInstance(domainClazz, view);
  }

  public void addClassMapping(Class<? extends AbstractDomain> domainClazz, Class<? extends AbstractView> viewClazz) {
    domainToViewMapping.put(domainClazz, viewClazz);
    viewToDomainMapping.put(viewClazz, domainClazz);
  }

  @SuppressWarnings("unchecked")
  private <V extends AbstractView, D extends AbstractDomain> Class<V> findViewClass(Class<D> domainClazz) {

    Class<V> viewClazz = (Class<V>) domainToViewMapping.get(domainClazz);

    if (viewClazz == null) {
      throw new IllegalArgumentException("no mapping configuration was found for class " + domainClazz);
    }
    return viewClazz;
  }

  @SuppressWarnings("unchecked")
  private <V extends AbstractView, D extends AbstractDomain> Class<D> finddomainClass(Class<V> viewClazz) {

    Class<D> domainClazz = (Class<D>) viewToDomainMapping.get(viewClazz);

    if (domainClazz == null) {
      throw new IllegalArgumentException("no mapping configuration was found for class " + viewClazz);
    }
    return domainClazz;
  }

  @Override
  public <V extends AbstractView, D extends AbstractDomain> V convert(D domain, Class<V> targetClazz) {
    return createViewInstance(targetClazz, domain);
  }

  @Override
  public <V extends AbstractView, D extends AbstractDomain> List<V> convert(List<D> domains, Class<V> targetClazz) {
    return domains.stream().map(e -> createViewInstance(targetClazz, e)).collect(Collectors.toList());
  }

  private <V extends AbstractView, D extends AbstractDomain> V createViewInstance(Class<V> viewClazz, D domain) {
    V view = BeanUtils.instantiate(viewClazz);
    BeanUtils.copyProperties(domain, view);
    return view;
  }

  private <V extends AbstractView, D extends AbstractDomain> D createDomainInstance(Class<D> domainClazz, V view) {
    D domain = BeanUtils.instantiate(domainClazz);
    BeanUtils.copyProperties(view, domain);
    return domain;
  }
}