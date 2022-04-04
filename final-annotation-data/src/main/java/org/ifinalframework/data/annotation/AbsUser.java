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

package org.ifinalframework.data.annotation;

import lombok.Getter;
import lombok.Setter;

import org.ifinalframework.core.IUser;
import org.ifinalframework.core.lang.Transient;

/**
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Getter
@Transient
public class AbsUser implements IUser<Long> {


    @PrimaryKey
    @Column(
            insert = {
                    "<choose>",
                    "     <when test=\"${test}\">",
                    "         #{${value}#if($typeHandler)",
                    "             #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "             , typeHandler=$!{typeHandler.canonicalName}#end}",
                    "      </when>",
                    "     <when test=\"USER != null\">",
                    "         #{USER.id#if($typeHandler)",
                    "               #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "               , typeHandler=$!{typeHandler.canonicalName}#end}",
                    "     </when>",
                    "    <otherwise>null</otherwise>",
                    "</choose>"
            },
            update = {
                    "<choose>",
                    "   <when test=\"${selectiveTest}\">",
                    "       ${column} = #{${value}#if($typeHandler)",
                    "           #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "           , typeHandler=$!{typeHandler.canonicalName}#end},",
                    "   </when>",
                    "   <when test=\"selective and USER!= null and USER.id != null\">",
                    "       ${column} = #{USER.id},",
                    "   </when>",
                    "   <when test=\"${test}\">",
                    "       ${column} = #{${value}#if($typeHandler)",
                    "           #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "           , typeHandler=$!{typeHandler.canonicalName}#end},",
                    "   </when>",
                    "</choose>"
            }
    )
    private Long id;

    @Column(
            insert = {
                    "<choose>",
                    "     <when test=\"${test}\">",
                    "         #{${value}#if($typeHandler)",
                    "             #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "             , typeHandler=$!{typeHandler.canonicalName}#end}",
                    "      </when>",
                    "     <when test=\"USER != null\">",
                    "         #{USER.name#if($typeHandler)",
                    "               #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "               , typeHandler=$!{typeHandler.canonicalName}#end}",
                    "     </when>",
                    "    <otherwise>null</otherwise>",
                    "</choose>"
            },
            update =  {

                    "<choose>",
                    "   <when test=\"${selectiveTest}\">",
                    "       ${column} = #{${value}#if($typeHandler)",
                    "           #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "           , typeHandler=$!{typeHandler.canonicalName}#end},",
                    "   </when>",
                    "   <when test=\"selective and USER!= null and USER.name != null\">",
                    "       ${column} = #{USER.name},",
                    "   </when>",
                    "   <when test=\"${test}\">",
                    "       ${column} = #{${value}#if($typeHandler)",
                    "           #if($javaType), javaType=$!{javaType.canonicalName}#end",
                    "           , typeHandler=$!{typeHandler.canonicalName}#end},",
                    "   </when>",
                    "</choose>"
            })
    private String name;

}

