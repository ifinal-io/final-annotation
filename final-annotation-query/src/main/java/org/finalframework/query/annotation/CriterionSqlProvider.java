/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.finalframework.query.annotation;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.lang.NonNull;

import org.finalframework.query.CriterionAttributes;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CriterionSqlProvider {

    void function(@NonNull AnnotationAttributes annotation, @NonNull CriterionAttributes metadata);

    String order(@NonNull AnnotationAttributes order, @NonNull CriterionAttributes metadata);

    String provide(@NonNull AnnotationAttributes criterion, @NonNull CriterionAttributes metadata);

}
