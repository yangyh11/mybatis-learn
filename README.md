# 一、查询

### 1、单个参数

List<XXBean> getXXBeanList(String xxId);

``<select id="getXXBeanList" parameterType="java.lang.String" resultType="XXBean的权限定类名">``

​	``select t.* from tableName t where t.id= #{xxId}``

``</select>``

### 2、多参数

List<XXBean> getXXBeanList(String xxId, String xxCode);

``<select id="getXXBeanList" resultType="XXBean的权限定类名" >``

​	``select t.* from tableName t where t.id=#{param1} and t.code=#{param2}``

​	或

​	``select t.* from tableName t where t.id=#{xxId} and t.code=#{xxCode}``

``</select>``

由于是多参数那么就不能使用parameterType,改用以下方式：

* 与单个参数获取方式一样，根据形参名获取

  ​		``select t.* from tableName t where t.id=#{xxId} and t.code=#{xxCode}``

* springboot：采用参数占位符，#｛param1｝，#｛param2｝，#｛param…｝，这种方法不建议使用，sql层表达不直观，且一旦顺序调整容易出错。

  ​		``select t.* from tableName t where t.id=#{param1} and t.code=#{param2}``

### 3、多参数传递之注解方式

List<XXBean> getXXBeanList(@Param("xxId")String xxId, @Param("xxCode")String xxCode);

``<select id="getXXBeanList" resultType="XXBean的权限定类名" >``

​	``select t.* from tableName t where t.id=#{xxId} and t.code=#{xxCode}``

``</select>``

使用注解后，根据注解配置的变量名获取。

### 4、Map封装多参数

List<XXBean> getXXBeanList(HashMap map);

``<select id="getXXBeanList" parameterType="java.util.Map" resultType="XXBean的权限定类名">``

​	``select t.* from tableName t where id=#{xxId} and code=#{xxCode}``

``</select>``

其中map是mybatis自己配置好的直接使用就行。map中key的名字是那个在#{}使用的那个

### 5、List封装多参数

List<XXBean> getXXBeanList(List<String> list);

``<select id="getXXBeanList" resultType="XXBean的权限定类名">``

​	``select t.* from tableName t where id in``

​	``<foreach collection="list" item="item" index="index" open="(" separartor=",", close=")" >``

​		``#{item}``

​	``</foreach>``

``</select>``

foreach最后的效果是``select t.* from tableName where id in ('1','2','3')``

### 6、select List()只能传递一个参数，但实际所需参数既要包含String类型，又要包含List类型

参数既有String又有List

将参数放入Map，再取出Map中的List遍历

List<StudentEntity> getStudentListByMap(Map<String, Object> paramMap);

``<select id="getStudentListByMap" parameterType="java.util.Map" resultMap="RM_Student">``
        ``select``
       ``<include refid="Student_columns"/>``
        ``from student``
        where major = #{major}
        and id in
        ``<foreach collection="list" item="item" index="index" open="(" separator="," close=")">``
            ``#{item}``
        ``</foreach>``
``</select>``

# 二、新增

* 插入单条数据

  int save(StudentEntity entity);
  <insert id="save" parameterType="com.yangyh.mybatis.learn.entity.StudentEntity">
          insert into student (
              id,
              student_no,
              name,
              age,
              major
          )
          values (
              #{id},
              #{studentNo},
              #{name},
              #{age},
              #{major}
          )
  </insert>

* 批量插入

  int saveBatch(List<StudentEntity> list);
  <insert id="saveBatch" parameterType="java.util.List">
          insert into student (
              id,
              student_no,
              name,
              age,
              major
          ) values
          <foreach collection="list" item="item" index="index" separator=",">
              (
              #{item.id},
              #{item.studentNo},
              #{item.name},
              #{item.age},
              #{item.major}
              )
          </foreach>
      ``</insert>``

# 三、更新

int update(StudentEntity entity);
<update id="update" parameterType="com.yangyh.mybatis.learn.entity.StudentEntity" flushCache="true">
        update student
        <set>
            <if test="studentNo != null">
                student_no = #{studentNo},
            </if>
            <if test="name != null">
                name = #{name},
            </if>
            <if test="age != null">
                age = #{age},
            </if>
            <if test="major != null">
                major = #{major}
            </if>
        </set>
        where
        1 = 1
        and student_no = #{studentNo}
</update>

# 四、删除

int delete(StudentEntity entity);

```
<sql id="Student_where">
    <where>
        <if test="id != null">
            and id = #{id}
        </if>
        <if test="studentNo != null">
            and student_no = #{studentNo}
        </if>
        <if test="name != null">
            and name = #{name}
        </if>
        <if test="age != null">
            and age = #{age}
        </if>
        <if test="major != null">
            and major = #{major}
        </if>
    </where>
</sql>
```

<delete id="delete" parameterType="com.yangyh.mybatis.learn.entity.StudentEntity">
        delete from student
        <include refid="Student_where"/>
</delete>

```


```