# 一、单个参数

List<XXBean> getXXBeanList(String xxId);

``<select id="getXXBeanList" parameterType="java.lang.String" resultType="XXBean的权限定类名">``

​	``select t.* from tableName t where t.id= #{xxId}``

``</select>``

# 二、多参数

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

# 三、多参数传递之注解方式

List<XXBean> getXXBeanList(@Param("xxId")String xxId, @Param("xxCode")String xxCode);

``<select id="getXXBeanList" resultType="XXBean的权限定类名" >``

​	``select t.* from tableName t where t.id=#{xxId} and t.code=#{xxCode}``

``</select>``

使用注解后，根据注解配置的变量名获取。

# 四、Map封装多参数

List<XXBean> getXXBeanList(HashMap map);

``<select id="getXXBeanList" parameterType="java.util.Map" resultType="XXBean的权限定类名">``

​	``select t.* from tableName t where id=#{xxId} and code=#{xxCode}``

``</select>``

其中map是mybatis自己配置好的直接使用就行。map中key的名字是那个在#{}使用的那个

# 五、List封装多参数

List<XXBean> getXXBeanList(List<String> list);

``<select id="getXXBeanList" resultType="XXBean的权限定类名">``

​	``select t.* from tableName t where id in``

​	``<foreach collection="list" item="item" index="index" open="(" separartor=",", close=")" >``

​		``#{item}``

​	``</foreach>``

``</select>``

foreach最后的效果是``select t.* from tableName where id in ('1','2','3')``

# 五、多参数传递之注解方式

List<XXBean> getXXBeanList(@Param("xxId")String xxId, @Param("xxCode")String xxCode);

List<XXBean> getXXBeanList(String xxId, String xxCode);

``<select id="getXXBeanList" resultType="XXBean的权限定类名" >``

​	``select t.* from tableName t where t.id=#{xxId} and t.code=#{xxCode}``

``</select>``

# 六、select List()只能传递一个参数，但实际所需参数既要包含String类型，又要包含List类型

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

