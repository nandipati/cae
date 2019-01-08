package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.AbstractView;
import com.rsi.adaptive.calc.domain.AbstractDomain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by suryadevarap on 1/8/19.
 */
public interface DomainViewMapper <D extends AbstractDomain, V extends AbstractView> {

  V convert(D domain);

  default List<V> convert(Collection<D> domains) {
    return domains.stream().map(this::convert).collect(Collectors.toList());
  }

  boolean supports(Class<? extends AbstractView> clazz);
}
