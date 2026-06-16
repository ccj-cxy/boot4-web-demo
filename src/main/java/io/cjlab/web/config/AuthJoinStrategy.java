package io.cjlab.web.config;

import io.cjlab.mybatisplus.permission.core.JoinPermStrategy;
import net.sf.jsqlparser.schema.Table;
import org.springframework.stereotype.Component;

@Component
public class AuthJoinStrategy implements JoinPermStrategy {
    @Override
    public boolean ignore(Table table, String alias) {
        return "role".equals(table.getName());
    }
}
