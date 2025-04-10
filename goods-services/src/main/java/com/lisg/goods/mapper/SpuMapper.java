package com.lisg.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lisg.goods.model.entity.Spu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuMapper extends BaseMapper<Spu> {

    List<Spu> selectSpuList(@Param("offset") int offset, @Param("limit") int limit);
}
