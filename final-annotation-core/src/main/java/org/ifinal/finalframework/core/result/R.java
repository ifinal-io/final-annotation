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

package org.ifinal.finalframework.core.result;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public final class R {

    private static final Integer SUCCESS_CODE = 0;

    private static final String SUCCESS_MESSAGE = "success";

    private R() {
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(final T data) {

        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> success(final @NonNull String code,
        final @NonNull String message,
        final @Nullable T data) {

        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, code, message, data);
    }

    @SuppressWarnings("rawtypes")
    public static Result failure(final @NonNull Integer status, final @NonNull String description,
        final @NonNull String code, final @NonNull String message) {

        return new Result<>(status, description, code, message);
    }

    @SuppressWarnings("rawtypes")
    public static Result failure(final @NonNull Integer status, final @NonNull String message) {

        return new Result<>(status, message);
    }

}
