package com.taihoang.robotstore.common.controller;

import com.taihoang.robotstore.common.response.ApiResponse;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public ApiResponse<Map<String, String>> health() {
        return ApiResponse.success(Map.of("status", "UP"), "Backend is running");
    }

    @GetMapping("/error-test")
    public void errorTest() {
        throw new RuntimeException("Test error");
    }
}
