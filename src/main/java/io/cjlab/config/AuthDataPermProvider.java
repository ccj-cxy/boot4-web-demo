package io.cjlab.config;

import io.cjlab.mybatisplus.permission.core.DataPermContext;
import io.cjlab.mybatisplus.permission.core.DataPermProvider;
import io.cjlab.mybatisplus.permission.core.DataPermType;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AuthDataPermProvider implements DataPermProvider {

    @Override
    public DataPermType dataPermType() {
        DataPermContext.Ctx ctx = DataPermContext.get();
        if (ctx == null) return DataPermType.ALL;   // 未登录场景
        Set<Integer> scope = ctx.scope();
        if (scope == null || scope.contains(1)) return DataPermType.ALL;
        if (scope.contains(2) || scope.contains(4)) return DataPermType.CUSTOM;
        if (scope.contains(3)) return DataPermType.DEPT;
        if (scope.contains(5)) return DataPermType.SELF;
        return DataPermType.ALL;
    }

    @Override
    public Set<String> deptIds() {
        DataPermContext.Ctx ctx = DataPermContext.get();
        return ctx == null ? null : ctx.deptIds();
    }

    @Override
    public Set<String> customDeptIds() {
        DataPermContext.Ctx ctx = DataPermContext.get();
        return ctx == null ? null : ctx.deptIds();
    }


    @Override
    public String userId() {
        DataPermContext.Ctx ctx = DataPermContext.get();
        return ctx == null ? "-1" : String.valueOf(ctx.userId());
    }
}
