package com.own.base;

import java.util.List;

/**
 * 类功能说明: D: Dto E: 实体
 *  DTO 与 实体 相互转换
 * 类修改者	创建日期2020/7/25
 * 修改说明
 *
 * @author wzy
 * @version V1.0
 **/
public interface BaseMapper<D,E> {

    /**
     * DTO 转换为 实体entity
     * @param dto
     * @return
     */
    E toEntity(D dto);

    /**
     * entity实体 转化为 DTO
     * @param entity
     * @return
     */
    D toDto(E entity);


    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<E> toEntity(List<D> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <D> toDto(List<E> entityList);


}
