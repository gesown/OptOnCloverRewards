/*
 * Copyright (C) 2019 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clover.sdk.extractors;

import com.clover.sdk.GenericClient;

import java.util.HashMap;

/**
 * For internal use only.
 */
public final class EnumListExtractionStrategy extends ExtractionStrategy {

  private final Class<? extends Enum> type;

  private EnumListExtractionStrategy(Class<? extends Enum> type) {
    this.type = type;
  }

  @Override
  public Object extractValue(GenericClient g, String name) {
    return g.extractListEnum(name, type);
  }

  private static final HashMap<Class<?>, EnumListExtractionStrategy> cache = new HashMap<>();

  public synchronized static EnumListExtractionStrategy instance(Class<? extends Enum> clazz) {
    EnumListExtractionStrategy instance = cache.get(clazz);
    if (instance == null) {
      instance = new EnumListExtractionStrategy(clazz);
      cache.put(clazz, instance);
    }

    return instance;
  }

}