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

package org.ifinalframework.core;


import jakarta.validation.groups.Default;

/**
 * The marked interface of {@code view}.
 *
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IView extends Default {

    interface List extends IView {
    }

    interface Detail extends List {

    }

    interface Count extends IView {
    }

    interface Create extends IView {

    }

    interface Update extends IView {

    }

    interface Patch extends IView{

    }

    interface Delete extends IView {

    }

    interface Import extends IView {
    }

    interface Export extends IView {
    }

}
