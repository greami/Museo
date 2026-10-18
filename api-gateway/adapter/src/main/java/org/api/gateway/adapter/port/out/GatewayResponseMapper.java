package org.api.gateway.adapter.port.out;

import org.api.gateway.application.model.GatewayResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Locale;

public final class GatewayResponseMapper {
    private static final Set<String> HOP_BY_HOP_HEADERS = Set.of(
            "connection",
            "keep-alive",
            "proxy-authenticate",
            "proxy-authorization",
            "te",
            "trailer",
            "transfer-encoding",
            "upgrade"
    );

    private GatewayResponseMapper() {
    }

    public static <T> GatewayResponse<T> from(ResponseEntity<T> response) {
        Map<String, List<String>> headers = copyHeaders(response.getHeaders());
        return new GatewayResponse<>(response.getStatusCode().value(), headers, response.getBody());
    }

    public static <T> ResponseEntity<T> toResponseEntity(GatewayResponse<T> response) {
        HttpHeaders headers = new HttpHeaders();
        copyHeaders(response.headers()).forEach(headers::put);
        return new ResponseEntity<>(response.body(), headers, HttpStatusCode.valueOf(response.statusCode()));
    }

    private static Map<String, List<String>> copyHeaders(Map<String, List<String>> source) {
        Map<String, List<String>> headers = new LinkedHashMap<>();
        source.forEach((name, values) -> {
            if (!isHopByHopHeader(name)) {
                headers.put(name, List.copyOf(values));
            }
        });
        return headers;
    }

    private static boolean isHopByHopHeader(String name) {
        return HOP_BY_HOP_HEADERS.contains(name.toLowerCase(Locale.ROOT));
    }
}
