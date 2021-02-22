package com.pch.gateway.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.gateway.model.domain.GatewayRoutePo;
import com.pch.gateway.model.dto.GatewayRouteDto;

/**
 * <P> 路由接口 </P>
 *
 * @Author: pch
 * @Date: 2021/01/19 15:24
 */
public interface GatewayRouteService extends IService<GatewayRoutePo> {

    /**
     * 获取网关路由
     *
     * @param id
     * @return
     */
    GatewayRouteDto get(String id);

    /**
     * 新增网关路由
     *
     * @param gatewayRouteDto
     * @return
     */
    boolean saveOrUpdate(GatewayRouteDto gatewayRouteDto);

    /**
     * 查询网关路由
     *
     * @return
     */
//    List<RouteDefinitionPoVo> query(RouteDefinitionPoQueryParam RouteDefinitionPoQueryParam);

    /**
     * 根据id删除网关路由
     *
     * @param id
     */
    boolean delete(String id);

    /**
     * 重新加载网关路由配置到redis
     *
     * @return 成功返回true
     */
    boolean overload();

    /**
     * 显示所有路由信息
     *
     * @return
     */
    List<GatewayRouteDto> findAll();
}
