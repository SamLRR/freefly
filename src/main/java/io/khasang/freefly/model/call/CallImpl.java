package io.khasang.freefly.model.call;

import org.springframework.stereotype.Component;

@Component
public class CallImpl implements Call {
    @Override
    public String getInfo() {
        return "Hello from Call";
    }
}
