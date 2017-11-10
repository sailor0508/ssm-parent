package com.ssm.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ssm.model.base.BaseDO;


/**
 * BaseDao DAO层泛型接口，定义基本的DAO功能
 * @since 0.1
 * @param <T>    实体类
 * @param <PK>    主键类，必须实现Serializable接口
 * 
 */
public abstract interface BaseDao<T extends BaseDO, PK extends Serializable> {
    /**
     * 插入一个实体（在数据库INSERT一条记录）
     * @param entity 实体对象
     */
    public abstract int save(T entity);
    
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public abstract int update(T entity);
    
    /**
     * 修改符合条件的记录
     * @param param 用于产生SQL的参数值，包括WHERE条件、目标字段和新值等
     * @return 修改的记录个数，用于判断修改是否成功
     */
    public abstract int update(Map<String, Object> param);
    
    /**
     * 按主键删除记录
     * @param primaryKey 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    public abstract int delete(PK primaryKey);

    /**
     * 删除符合条件的记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param param 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    public abstract int delete(Map<String, Object> param);
    
    /**
     * 批量删除记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param ids 删除的目标对象的id数组
     * @return
     */
    public abstract int delete(String[] ids);
    /**
     * 查询整表总记录数
     * @return 整表总记录数
     */
    public abstract int count();
    
    /**
     * 查询符合条件的记录数
     * @param param 查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于count()
     * @return
     */
    public abstract int count(Map<String, Object> param);

    /**
     * 按主键取记录
     * @param primaryKey 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract T get(PK primaryKey);

    /**
     * 按param取记录
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return 记录实体对象，如果没有符合param条件的记录，则返回null
     */
    public abstract T get(Map<String, Object> param);
    
    /**
     * 取全部记录
     * @return 全部记录实体对象的List
     */
    public abstract List<T> select();
    
    /**
     * 按条件查询记录
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> select(Map<String, Object> param);
    


    

}


