package org.api.gateway.adapter.port.out;

import org.api.gateway.application.model.GatewayResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GatewayResponseMapperTest {

    @Test
    void removesHopByHopHeadersWhenMappingBetweenResponseTypes() {
        ResponseEntity<String> upstream = ResponseEntity.status(200)
                .header("Transfer-Encoding", "chunked")
                .header("X-Upstream", "core")
                .body("ok");

        GatewayResponse<String> gatewayResponse = GatewayResponseMapper.from(upstream);
        assertEquals("core", gatewayResponse.headers().get("X-Upstream").get(0));
        assertNull(gatewayResponse.headers().get("Transfer-Encoding"));

        ResponseEntity<String> downstream = GatewayResponseMapper.toResponseEntity(gatewayResponse);
        assertEquals("core", downstream.getHeaders().getFirst("X-Upstream"));
        assertNull(downstream.getHeaders().getFirst("Transfer-Encoding"));
    }
}
