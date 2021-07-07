![Final Annotation](LOGO.png)

# final-annotation

![Github CI](https://github.com/final-projects/final-annotation/workflows/ci/badge.svg)
[![LICENSE](https://img.shields.io/github/license/final-projects/final-annotation)](http://www.apache.org/licenses/LICENSE-2.0.html)
![Maven Central](https://img.shields.io/maven-central/v/org.ifinalframework.annotation/final-annotation?label=maven)
![Releases](https://img.shields.io/nexus/r/org.ifinalframework.annotation/final-annotation?server=https://s01.oss.sonatype.org&label=Releases)
![Snapshots](https://img.shields.io/nexus/s/org.ifinalframework.annotation/final-annotation?server=https://s01.oss.sonatype.org&label=Snapshots)
![CODECOV](https://codecov.io/gh/final-projects/final-annotation/branch/main/graph/badge.svg)

定义基础的注释与接口

## Final Annotation Cache

`Final Annotation Cache`定义了切面缓存注释，使用`Redis`做为缓存存储，支持`Value`和`Hash`等数据结构。

可以为应用快速添加缓存功能，减少大量模板代码。

```java
public interface UserService {

    @Cacheable(key = "#{#id}")
    User findById(Long id);

}
```

## Final Annotation Query

`Final Annotation Query`提供了丰富的查询条件(`Criterion`)和更新操作(`Update`)。

### Query

**Final Annotation Query**提供**编码**和**注解**两种方式来构建查询条件。

如当需要构建以下查询条件时：

```sql
WHERE name =
#{value}
AND
age
BETWEEN
#{min}
AND
#{max}
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
public class MyQuery implements IQuery {

    @Equal
    private String name;

    @Between
    private BetweenValue<Integer> age;

    //setter and getter
    //...
}
```