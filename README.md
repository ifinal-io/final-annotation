![Final Annotation](LOGO.png)

# final-annotation

![Github CI](https://github.com/final-projects/final-annotation/workflows/ci/badge.svg)
[![LICENSE](https://img.shields.io/github/license/final-projects/final-annotation)](http://www.apache.org/licenses/LICENSE-2.0.html)
![Maven Central](https://img.shields.io/maven-central/v/org.ifinalframework.annotation/final-annotation?label=maven)
![Releases](https://img.shields.io/nexus/r/org.ifinalframework.annotation/final-annotation?server=https://s01.oss.sonatype.org&label=Releases)
![Snapshots](https://img.shields.io/nexus/s/org.ifinalframework.annotation/final-annotation?server=https://s01.oss.sonatype.org&label=Snapshots)
![CODECOV](https://codecov.io/gh/final-projects/final-annotation/branch/main/graph/badge.svg)

定义基础的注释与接口

## Final Annotation Query

`Final Annotation Query`提供了丰富的查询条件(`Criterion`)和更新操作(`Update`)。

### Query

**Final Annotation Query**提供**编码**和**注解**两种方式来构建查询条件。

如当需要构建以下查询条件时：

```sql
WHERE name = #{value} AND age BETWEEN #{min} AND #{max}
```

* 编码

```java
new Query().where(
	name.eq("name"),
    age.between(min,max)
);
```

* 注解

```java
public class MyQuery implements IQuery{
    @Equal
    private String name;
    @Between
    private BetweenValue<Integer> age;
    
    //setter and getter
    //...
}
```

**支持的`Criterion`对下表所示：**

|                     SQL                     |               方法               |        注解        |
| :-----------------------------------------: | :------------------------------: | :----------------: |
|              `column IS NULL`               |            `isNull()`            |     `@IsNull`      |
|            `column IS NOT NULL`             |          `isNotNull()`           |    `@IsNotNull`    |
|             `column = #{value}`             |           `eq(value)`            |      `@Equal`      |
|            `column != #{value}`             |           `neq(value)`           |    `@NotEqual`     |
|             `column < #{value`}             |           `lt(value)`            |    `@LessThan`     |
|            `column <= #{value}`             |           `lte(value)`           |  `@LessThanEqual`  |
|             `cloumn > #{value}`             |           `gt(value)`            |    `@GreatThan`    |
|            `cloumn >= #{value}`             |           `gte(value)`           | `@GreatThanEqual`  |
|           `column LIKE #{value}`            |          `like(value)`           |      `@Like`       |
|         `column NOT LIKE #{value}`          |         `notLike(value)`         |     `@NotLike`     |
|   `column LIKE CONCAT('%',#{value},'%') `   |        `contains(value)`         |    `@Contains`     |
| `column NOT LIKE CONCAT('%',#{value},'%') ` |       `notContains(value)`       |   `@NotContains`   |
|     `column LIKE CONCAT(#{value},'%') `     |       `startsWith(value)`        |   `@StartsWith`    |
|   `column NOT LIKE CONCAT(#{value},'%') `   |      `notStartsWith(value)`      |  `@NotStartsWith`  |
|     `column LIKE CONCAT('%',#{value}) `     |        `endsWith(value)`         |    `@EndsWith`     |
|   `column NOT LIKE CONCAT('%',#{value}) `   |       `notEndsWith(value)`       |   `@NotEndsWith`   |
|         `column IN (val[,val]...)`          |           `in(values)`           |       `@In`        |
|       `column NOT IN (val[,val]...)`        |          `nin(values)`           |      `@NotIn`      |
|     `column BETWEEN #{min} AND #{max}`      |        `between(min,max)`        |     `@Between`     |
|   `column NOT BETWEEN #{min} AND #{max}`    |      `notBetween(min,max)`       |   `@NotBetween`    |
|    `JSON_CONTAINS(column, value[,path])`    |   `jsonContains(value[,path])`   |  `@JsonContains`   |
|   `!JSON_CONTAINS(column, value[,path])`    | `notJsonContains(values[,path])` | `@NotJsonContains` |
|                                             |                                  |                    |
|                                             |                                  |                    |
|                                             |                                  |                    |
|                                             |                                  |                    |
|                                             |                                  |                    |
|                                             |                                  |                    |
|                                             |                                  |                    |

### Update

|                           SQL                            |                方法                |
| :------------------------------------------------------: | :--------------------------------: |
|                   `column = #{value}`                    |        `set(column,value)`         |
|               `column = column + #{value}`               |        `incr(column,value)`        |
|               `column = column - #{value}`               |        `decr(column,value)`        |
| `column = JSON_INSERT(column,path,val[,path1,val1]...)`  | `jsonInsert(column,<path,value>)`  |
| `column = JSON_REPLACE(column,path,val[,path1,val1]...)` | `jsonReplace(column,<path,value>)` |
|   `column = JSON_SET(column,path,val[,path1,val1]...)`   |   `jsonSet(column,<path,value>)`   |
|     `column = JSON_REMOVE(column,path,[,path1]...)`      |     `jsonRemove(column,paths)`     |
|                                                          |                                    |
|                                                          |                                    |

